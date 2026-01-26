package domain.cinema.ingresso;

public sealed class Ingresso permits MeiaEntrada, IngressoFamilia {

    private String nomeFilme;
    private boolean dublado;
    private double valor;

    public Ingresso(double valor, String nomeFilme, boolean dublado){
        this.valor = valor;
        this.nomeFilme = nomeFilme;
        this.dublado = dublado;
    }

    public double retornaValor(){
        return valor;
    }
}
