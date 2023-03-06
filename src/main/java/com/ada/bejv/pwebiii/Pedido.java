package com.ada.bejv.pwebiii;

public class Pedido{
    private Long numero;
    private String regiao;

    public Pedido(Long numero, String regiao) {
        this.numero = numero;
        this.regiao = regiao;
    }

    public Long getNumero() { return this.numero; }

    public String getRegiao() { return this.regiao; }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", regiao='" + regiao + '\'' +
                '}';
    }
}