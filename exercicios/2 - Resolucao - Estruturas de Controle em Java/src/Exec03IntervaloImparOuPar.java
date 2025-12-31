import java.util.Scanner;

public class Exec03IntervaloImparOuPar {

    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Intervalo entre números");

            int start = readInt(scanner, "Digite um número inteiro: ");
            int end = readIntGreaterThan(scanner, "Digite um número maior que o anterior: ", start);
            boolean isPair = readPairOrOdd(scanner);

            for(int i = start; i < end; i ++){
                if((i%2==0) == isPair){
                    System.out.println(i);
                }
            }
        }
    }

    private static int readInt(Scanner scanner, String prompt){
        while(true){
            System.out.print(prompt);
            String line = scanner.nextLine().trim();

            try{
                return Integer.parseInt(line);
            }catch(NumberFormatException e){
                System.out.println("Entrada inválida. Digite um número inteiro");
            }
        }
    }

    private static int readIntGreaterThan(Scanner scanner, String prompt, int min){
        while(true){
            int value = readInt(scanner, prompt);
            if(value>min) return value;
            System.out.println("Forneça um valor maior do que o primeiro.");
        }
    }

    private static boolean readPairOrOdd(Scanner scanner){
        while(true){
            System.out.println("Selecione uma opção");
            System.out.println("Par ou ímpar");
            System.out.println("Digite p (par) ou i (impar)");

            String choice = scanner.nextLine().trim().toLowerCase();

            if(choice.equals("p")) return true;
            if (choice.equals("i")) return false;

            System.out.println("Opção inválida.");
        }
    }
}

