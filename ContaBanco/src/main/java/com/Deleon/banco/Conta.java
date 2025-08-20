package com.deleon.banco;

public abstract class Conta {
    private final int numero;
    private final String titular;
    protected double saldo;

    public Conta(int numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = Math.max(0.0, saldoInicial); // evita saldo inicial negativo
    }

    // Encapsulamento: getters
    public int getNumero() { return numero; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Depósito inválido (<= 0).");
        }
    }

    // Deixa o saque customizável por tipo de conta
    public abstract boolean sacar(double valor);

    public boolean transferir(Conta destino, double valor) {
        if (valor <= 0) {
            System.out.println("Transferência inválida (<= 0).");
            return false;
        }
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        System.out.println("Transferência não realizada: saldo insuficiente.");
        return false;
    }

    @Override
    public String toString() {
        return String.format("Conta #%d - Titular: %s - Saldo: R$%.2f", numero, titular, saldo);
    }
}
