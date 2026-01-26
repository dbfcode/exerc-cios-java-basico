package domain.usuario;

public class Atendente extends Usuario {

    private double valorEmCaixa;
    private boolean caixaAberto;

    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha, false);
    }

    public double getValorEmCaixa(){
        return valorEmCaixa;
    }

    public void setCaixaAberto(boolean caixaAberto){
        this.caixaAberto = caixaAberto;
    }

    public void  receberPagamento(double pagamento){
        valorEmCaixa += pagamento;
        System.out.println("Pagamento recebido!");
    }

    public void fecharCaixa(){
        caixaAberto = false;
        System.out.println("Caixa fechado!");
    }
}