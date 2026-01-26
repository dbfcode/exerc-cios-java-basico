package domain.cinema.ingresso;

public final class IngressoFamilia extends Ingresso {

    private int numeroPessoas;

    public IngressoFamilia(double valor, String nomeFilme, boolean dublado, int numeroPessoas){
        super(valor, nomeFilme, dublado);
        this.numeroPessoas = numeroPessoas;
    }

    public double retornaValor() {
        double total = super.retornaValor() * numeroPessoas;

        if (numeroPessoas > 3) {
            return total * 0.95;
        }
        return total;
    }

}
