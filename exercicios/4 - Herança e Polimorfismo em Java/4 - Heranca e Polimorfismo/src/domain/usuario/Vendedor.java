package domain.usuario;

public class Vendedor extends Usuario {

    private int quantVendas;

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha, false);
    }

    public int getQuantVendas(){
        return quantVendas;
    }

    public void realizarVenda(){
        quantVendas++;
        System.out.println("Venda realizada");
    }

    public void  consultarVendas(){
        System.out.println("Quantidade de vendas: " + quantVendas);
    }
}