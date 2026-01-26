import domain.usuario.*;
public class ExecucaoExec02 {

    public static void main(String[] args) {

        Gerente gerente = new Gerente("Alice", "alice@empresa.com", "1234");
        gerente.realizarLogin();
        gerente.gerarRelatorioFinanceiro();
        gerente.consultarVendas();
        gerente.alterarDados("Alice Silva", "alice.silva@empresa.com");
        gerente.alterarSenha("novaSenhaGerente");
        gerente.realizarLogoff();

        System.out.println("Gerente é admin? " + gerente.isAdmin());
        System.out.println("----");

        Vendedor vendedor = new Vendedor("Bruno", "bruno@empresa.com", "abcd");
        vendedor.realizarLogin();
        vendedor.realizarVenda();
        vendedor.realizarVenda();
        vendedor.consultarVendas();
        vendedor.alterarSenha("novaSenhaVendedor");
        vendedor.realizarLogoff();

        System.out.println("Vendedor é admin? " + vendedor.isAdmin());
        System.out.println("----");

        Atendente atendente = new Atendente("Carla", "carla@empresa.com", "xyz");
        atendente.realizarLogin();
        atendente.setCaixaAberto(true);
        atendente.receberPagamento(100.0);
        atendente.receberPagamento(50.0);
        System.out.println("Valor em caixa: " + atendente.getValorEmCaixa());
        atendente.fecharCaixa();
        atendente.realizarLogoff();

        System.out.println("Atendente é admin? " + atendente.isAdmin());
    }
}
