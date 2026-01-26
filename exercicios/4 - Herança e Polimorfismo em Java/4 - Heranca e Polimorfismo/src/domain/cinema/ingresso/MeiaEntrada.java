package domain.cinema.ingresso;

public final class MeiaEntrada extends Ingresso {

    public MeiaEntrada(String nomeFilme, boolean dublado, double valor){
        super(valor, nomeFilme, dublado);
    }

    @Override
    public double retornaValor(){
        return super.retornaValor() / 2;
    }
}