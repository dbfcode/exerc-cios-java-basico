package Domain;

public class ContaBancaria {

    private double saldo;
    private double limiteChequeEspecial;
    private double chequeEspecialUsado;

    public ContaBancaria(double depositoInicial){
        this.saldo = depositoInicial;
        this.limiteChequeEspecial = depositoInicial <= 500
                ? 50
                : depositoInicial * 0.5;
    }

    public void depositar(double valor){
        saldo += valor;
        cobrarTaxaChequeEspecial();
    }

    public void sacar(double valor){
        if (saldo + limiteChequeEspecial >= valor){
            saldo -= valor;
            if(saldo < 0 ){
                chequeEspecialUsado = Math.abs(saldo);
            }
        }
    }

    public void pagarBoleto(double valor){
        sacar(valor);
    }

    private void cobrarTaxaChequeEspecial(){
        if(chequeEspecialUsado > 0 && saldo > 0){
            saldo -= chequeEspecialUsado * 0.2;
            chequeEspecialUsado = 0;
        }
    }

    public double getSaldo(){
        return saldo;
    }

    public double getLimiteChequeEspecial(){
        return limiteChequeEspecial;
    }

    public double getChequeEspecialUsado(){
        return chequeEspecialUsado;
    }

    public boolean estaUsandoChequeEspecial(){
        return saldo < 0;
    }
}
