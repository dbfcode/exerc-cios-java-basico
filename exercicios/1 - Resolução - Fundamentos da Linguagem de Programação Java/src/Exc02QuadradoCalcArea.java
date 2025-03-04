import java.util.Scanner;

public class Exc02QuadradoCalcArea {

    static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe a área do quadrado:");
        var squareSide = scanner.nextFloat();
        var area = squareSide * squareSide;
        System.out.printf("A área do quadrado é %s", area);
    }
}
