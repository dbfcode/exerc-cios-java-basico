import java.util.Scanner;

public class Exec04ExecuteEnquantoForPar {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int base = readInt(scanner,"Digite o número base: ");
        processNumbers(scanner, base);
    }

    private static int readInt(Scanner scanner, String prompt){
        while(true){
            System.out.print(prompt);
            String line = scanner.nextLine().trim();

            try{
                return Integer.parseInt(line);
            }catch(NumberFormatException e){
                System.out.println("Entrada inválida.");
            }
        }
    }

    private static void processNumbers(Scanner scanner, int base){
        while(true){

            int current = readInt(scanner, "Digite um número: ");

            if(shouldIgnore(current,base)){
                System.out.println("Ignorando número menor que o primeiro. Continuando execução...");
                continue;
            }

            if (shouldStop(current,base)){
                System.out.println("Encerrando execução.");
                break;
            }
        }
    }

    private static boolean shouldIgnore(int current, int base){
        return current < base;
    }

    private static boolean shouldStop(int current, int base){
        boolean shouldStop = current % base != 0;
        float result = current % base;
        System.out.printf("Resultado do resto da divisão: %.1f%n", result);
        return shouldStop;
    }
}