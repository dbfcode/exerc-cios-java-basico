import java.util.InputMismatchException;
import java.util.Scanner;

public class Exec01TabuadaNum {
    //TODO: 1.	Escreva um código onde o usuário entra com um número e seja gerada a tabuada de 1 até 10 desse número;
    public static void main (String[] args){
        var scanner = new Scanner(System.in);
        try {
            System.out.println("Digite um Número:");
            int numero = scanner.nextInt();
            System.out.printf("1 x %d = %d%n", numero,numero);
            System.out.printf("2 x %d = %d%n", numero,2 * numero);
            System.out.printf("2 x %d = %d%n", numero,3 * numero);
            System.out.printf("2 x %d = %d%n", numero,4 * numero);
            System.out.printf("2 x %d = %d%n", numero,5 * numero);
            System.out.printf("2 x %d = %d%n", numero,6 * numero);
            System.out.printf("2 x %d = %d%n", numero,7 * numero);
            System.out.printf("2 x %d = %d%n", numero,8 * numero);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
        }
    }
}
