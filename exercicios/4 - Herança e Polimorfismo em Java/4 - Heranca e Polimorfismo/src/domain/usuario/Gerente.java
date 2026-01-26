package domain.usuario;

public class Gerente extends Usuario {

    private int quantVendas;

    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha, true);
    }

    public int getQuantVendas(){
        return quantVendas;
    }

    public void gerarRelatorioFinanceiro(){
         System.out.println("Relatório financeiro gerado com sucesso.");
    }

    public void  consultarVendas(){
        System.out.println("Quantidade de vendas: " + quantVendas);
    }
}
