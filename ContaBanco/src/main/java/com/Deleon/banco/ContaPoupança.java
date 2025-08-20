package com.deleon.banco;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) return false;
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    // Opcional: método para simular rendimento
    public void render(double percentual) {
        if (percentual > 0) {
            saldo += saldo * (percentual / 100.0);
        }
    }
}
