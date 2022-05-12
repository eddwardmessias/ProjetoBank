package com.projetobank.api.models;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Conta {

    private Long numero;
    private Double saldo;

    public Conta() {
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
