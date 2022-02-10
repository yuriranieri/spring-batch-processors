package com.springbatch.processadorvalidacao.dominio;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Cliente {

    @NotBlank
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "Nome deve ser alfabético")
    private String nome;

    @NotNull
    @Range(min = 18, max = 200)
    private Integer idade;

    @NotBlank
    @Email(message = "Email inválido")
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + "'" +
                ", idade='" + idade + "'" +
                ", email='" + email + "'" +
                '}';
    }

}
