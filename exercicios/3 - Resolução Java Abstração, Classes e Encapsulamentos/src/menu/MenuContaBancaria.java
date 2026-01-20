package menu;
import Domain.ContaBancaria;
public class MenuContaBancaria extends MenuBase {

    private ContaBancaria conta;

    public MenuContaBancaria(){
        System.out.print("Depósito inicial: ");
        double depositoInicial = scanner.nextDouble();
        this.conta = new ContaBancaria(depositoInicial);
    }

    @Override
    public Runnable mostrarOpcoes(){
        System.out.println("""
                \n
                1 - Consultar saldo
                2 - Depositar
                3 - Sacar
                4 - Pagar boleto
                5 - Verificar limite do cheque especial
                6 - Verificar cheque especial em uso
                """);
        return null;
    };

    @Override
    public void tratarOpcao(int opcao){
       switch(opcao){
           case 1:
               System.out.println("Saldo: " + conta.getSaldo());
               break;
           case 2:
               System.out.print("Digite o valor do depósito: ");
               conta.depositar(scanner.nextDouble());
               break;
           case 3:
               System.out.print("Digite o valor de saque: ");
               conta.sacar(scanner.nextDouble());
               break;
           case 4:
               System.out.print("Digite o valor do boleto: ");
               conta.pagarBoleto(scanner.nextDouble());
               break;
           case 5:
               System.out.println("Limite especial: " + conta.getLimiteChequeEspecial());
               break;
           case 6:
               System.out.println("Cheque especial em uso no momento: " + conta.getChequeEspecialUsado());
       }
    }
}
