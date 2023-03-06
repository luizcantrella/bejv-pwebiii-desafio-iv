package com.ada.bejv.pwebiii;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    static List<Pedido> pedidos = MockarDados.pedidosMockados();
    static Integer limiteEntrega = 2;
    public static void main(String[] args) throws InterruptedException {
        String regiao = "Zona Sul"; // Zona Norte, Zona Leste, Zona Oeste

        Observable<Pedido> pedidosZonaSul = filtrarPorRegiao(regiao);

        System.out.println(String.format("Pedidos para %s", regiao));
        pedidosZonaSul.subscribe(pedido -> {
            System.out.println(pedido);
        });
        Thread.sleep(1000);

        regioesComPedido().subscribe(regioes -> {
            System.out.println("\nRegioes com entregas na fila:");
            regioes.forEach(r -> System.out.println(r));
        });

        AtomicReference<Entregador> entregadorZonaSul = new AtomicReference<>();
        pegarParaViagem(pedidosZonaSul)
                .subscribe(items -> {
                    Entregador entregador = new Entregador();
                    entregador.adicionarPedido(items);
                    entregadorZonaSul.set(entregador);
                    items.forEach(pedido -> pedidos.remove(pedido));
                });
        Thread.sleep(1000);

        System.out.println(String
                .format("\nPedidos que seram entregues agora na %s", regiao));
        entregadorZonaSul.get().getPedidos().forEach(pedido -> System.out.println(pedido));

        Thread.sleep(5000);
    }

    public static Observable<Pedido> filtrarPorRegiao(String regiao) {
        return Observable.fromArray(pedidos)
                .flatMapStream( lista -> lista.stream())
                .filter(pedido -> pedido.getRegiao() == regiao);
    }

    public static Single<List<String>> regioesComPedido() {
        return Observable.fromArray(pedidos)
                .flatMapStream(lista -> lista.stream())
                .distinct(pedido -> pedido.getRegiao())
                .map(pedido -> pedido.getRegiao())
                .toList();
    }

    /**
     * Este metodo retorna a capacidade máxima de pedidos que o entregador consegue levar em
     * uma única viagem.
     * @param pedidoObservable
     * @return
     */
    public static Single<List<Pedido>> pegarParaViagem(Observable<Pedido> pedidoObservable) {
        return pedidoObservable.take(limiteEntrega).toList();
    }

}