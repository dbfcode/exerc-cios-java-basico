import domain.cinema.ingresso.*;

public class ExecucaoExec01 {

    public static void main(String[] args) {

        Ingresso ingressoInteiro =
                new Ingresso(40.0, "Interestelar", true);

        System.out.println("Ingresso inteiro: R$ " + ingressoInteiro.retornaValor());

        Ingresso meia =
                new MeiaEntrada("Interestelar", true, 40.0);

        System.out.println("Meia entrada: R$ " + meia.retornaValor());

        Ingresso familia3 =
                new IngressoFamilia(40.0, "Interestelar", true, 3);

        System.out.println("Família (3 pessoas): R$ " + familia3.retornaValor());

        Ingresso familia4 =
                new IngressoFamilia(40.0, "Interestelar", true, 4);

        System.out.println("Família (4 pessoas): R$ " + familia4.retornaValor());
    }
}
