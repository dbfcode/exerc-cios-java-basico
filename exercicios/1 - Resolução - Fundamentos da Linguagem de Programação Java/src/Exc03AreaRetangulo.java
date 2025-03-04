import java.util.Scanner;

public class Exc03AreaRetangulo {

    static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Cálculo de área do retângulo");
        System.out.println("Informe a altura:");
        var height = scanner.nextFloat();
        System.out.println("Informe a base:");
        var base = scanner.nextFloat();
        var area = height * base;
        System.out.printf("A área do retângulo é %s", area);
    }
}
