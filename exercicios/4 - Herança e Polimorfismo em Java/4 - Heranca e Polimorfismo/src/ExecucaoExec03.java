package domain.Relogio;

public class ExecucaoExec03 {

    public static void main(String[] args) {

        // Relógio base (24h) que é exatamente o Relogio brasileiro que o exercício pede
        Relogio relogioBR = new Relogio(18, 30, 45) {
            // classe anônima para instanciar o abstract
        };

        Relogio relogioUS = new RelogioAmericano(18, 30, 45);

        System.out.println("Relógio Brasileiro:");
        System.out.println(relogioBR.formatarHorario());

        System.out.println("\nRelógio Americano:");
        System.out.println(relogioUS.formatarHorario());

        System.out.println("\nAjustando horário do relógio americano com base no brasileiro...");
        relogioUS.ajustarHorario(relogioBR);

        System.out.println("\nRelógio Americano após ajuste:");
        System.out.println(relogioUS.formatarHorario());
    }
}
