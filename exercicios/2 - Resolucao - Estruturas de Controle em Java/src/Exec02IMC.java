import java.util.Scanner;
public class Exec02IMC {
    public static void main (String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Olá! Vamos calcular seu IMC.");
        System.out.println("Forneça sua altura (em metros. ex: 1.70):");
        var altura = scanner.nextFloat();
        System.out.println("Forneça seu peso (em kg):");
        var peso = scanner.nextFloat();
        var imc = peso/(altura*altura);

        System.out.printf("\nIMC: %f \n", imc );
        if(imc < 18.5){
            System.out.println("Abaixo do peso");
        }else if(imc < 25.0){
            System.out.println("Levemente acima do peso");
        }else if(imc < 30.0){
            System.out.println("Sobrepeso");
        }else if(imc < 35.0){
            System.out.println("Obesidade Grau I");
        }else if(imc <40.0){
            System.out.println("Obesidade Grau II");
        }else {
            System.out.println("Obesidade Grau III (Mórbida)");
        }
    }
}
