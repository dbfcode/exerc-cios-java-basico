package menu;
import java.util.Scanner;

public abstract class MenuBase {

    protected Scanner scanner = new Scanner(System.in);

    public void executar(){
        int opcao;
        do {
            mostrarOpcoes();
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
            if (opcao != 0) {
                tratarOpcao(opcao);
            }
        } while(opcao !=0);
    }

    protected abstract Runnable mostrarOpcoes();
    protected abstract void tratarOpcao(int opcao);
}
