package com.ada.bejv.pwebiii;

import java.util.LinkedList;
import java.util.List;

public class Entregador{
    private List<Pedido> pedidos;

    public Entregador() {
        this.pedidos = new LinkedList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void adicionarPedido(List<Pedido> pedidos) {
        pedidos.forEach(p->this.adicionarPedido(p));
    }

    public List<Pedido> getPedidos() {return this.pedidos;}
}
