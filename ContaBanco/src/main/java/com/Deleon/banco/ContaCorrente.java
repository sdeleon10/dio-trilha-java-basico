package com.Deleon.banco;

public class ContaCorrente extends Conta {
    private final double limite;   // cheque especial
    private final double taxaSaque; // taxa fixa por saque (opcional)

    public ContaCorrente(int numero, String titular, double saldoInicial, double limite, double taxaSaque) {
        super(numero, titular, saldoInicial);
        this.limite = Math.max(0.0, limite);
        this.taxaSaque = Math.max(0.0, taxaSaque);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) return false;
        double total = valor + taxaSaque;
        if (saldo + limite >= total) {
            saldo -= total;
            return true;
        }
        return false;
    }
}
