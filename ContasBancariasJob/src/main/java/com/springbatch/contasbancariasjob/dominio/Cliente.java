package com.springbatch.contasbancariasjob.dominio;

public class Cliente {

    private String nome;
    private String email;
    private int idade;
    private Double faixaSalarial;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Double getFaixaSalarial() {
        return faixaSalarial;
    }

    public void setFaixaSalarial(Double faixaSalarial) {
        this.faixaSalarial = faixaSalarial;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", faixaSalarial=" + faixaSalarial +
                '}';
    }
}
