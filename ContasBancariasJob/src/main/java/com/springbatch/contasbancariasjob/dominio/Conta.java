package com.springbatch.contasbancariasjob.dominio;

public class Conta {

    private String tipo;
    private Double limite;
    private final String cliente;

    public Conta(String tipo, Double limite, String cliente) {
        this.tipo = tipo;
        this.limite = limite;
        this.cliente = cliente;
    }

    public Conta(String cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getLimite() {
        return limite;
    }

    public String getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "tipo='" + tipo + '\'' +
                ", limite=" + limite +
                ", cliente='" + cliente + '\'' +
                '}';
    }
}
