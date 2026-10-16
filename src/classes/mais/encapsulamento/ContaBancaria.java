package classes.mais.encapsulamento;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContaBancaria {
    private float saldo;
    private float limiteChequeEspecial;
    private LocalDate inicioUsoLimiteChequeEspecial;

    public ContaBancaria(float depositoInicial){
        if (depositoInicial <= 0) throw new Error("Depósito inicial precisa ser maior que zero");

        this.saldo = depositoInicial;

        if (depositoInicial <= 500f) limiteChequeEspecial = 50f;
        else limiteChequeEspecial = depositoInicial / 2;
    }

    public float getSaldo(){
        return saldo;
    }

    public float getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    private void cobrarLimiteCredito() {
        if (getDiasUsandoChequeEspecial() >= 30) {
            this.saldo -= 0.2 * Math.abs(this.saldo);
            this.inicioUsoLimiteChequeEspecial = null;
        }
    }

    private void aumentarSaldo(float valor){
        cobrarLimiteCredito();
        this.saldo += valor;
    }

    private void diminuirSaldo(float valor) throws Exception{
        if (this.saldo + this.limiteChequeEspecial < valor) throw new Exception("Saldo insuficiente");
        cobrarLimiteCredito();

        this.saldo -= valor;
        if (this.saldo < 0 && inicioUsoLimiteChequeEspecial == null) inicioUsoLimiteChequeEspecial = LocalDate.now();
    }

    public void depositarDinheiro(float valor) {
        aumentarSaldo(valor);
    }

    public void sacarDinheiro(float valor) throws Exception {
        diminuirSaldo(valor);
    }

    public void pagarBoleto(float valor) throws Exception {
        diminuirSaldo(valor);
    }

    public boolean usandoChequeEspecial() {
        return this.saldo < 0;
    }

    public long getDiasUsandoChequeEspecial(){
        return inicioUsoLimiteChequeEspecial == null ? 0 : ChronoUnit.DAYS.between(inicioUsoLimiteChequeEspecial, LocalDate.now());
    }
}
