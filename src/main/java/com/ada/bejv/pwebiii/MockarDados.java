package com.ada.bejv.pwebiii;

import java.util.LinkedList;
import java.util.List;

public class MockarDados {

    public static List<Pedido> pedidosMockados() {
        List pedidos = new LinkedList();
        pedidos.add(new Pedido(1L, "Zona Sul"));
        pedidos.add(new Pedido(2L, "Zona Norte"));
        pedidos.add(new Pedido(3L, "Zona Leste"));
        pedidos.add(new Pedido(4L, "Zona Oeste"));
        pedidos.add(new Pedido(5L, "Zona Sul"));
        pedidos.add(new Pedido(6L, "Zona Norte"));
        pedidos.add(new Pedido(7L, "Zona Leste"));
        pedidos.add(new Pedido(8L, "Zona Oeste"));
        pedidos.add(new Pedido(9L, "Zona Sul"));
        pedidos.add(new Pedido(10L, "Zona Norte"));
        return pedidos;
    }
}
