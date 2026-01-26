package domain.Relogio;

public class RelogioAmericano extends Relogio {

    public RelogioAmericano(int hora, int minuto, int segundo){
        super(hora, minuto, segundo);
    }

    @Override
    public String formatarHorario(){
        int h = getHora();
        String periodo = (h < 12 ) ? "AM" : "PM";

        int hora12 = (h == 0) ? 12 : (h > 12 ? h - 12 : h);

        return String.format("%02d:%02d:%02d %s", hora12, getMinuto(), getSegundo(), periodo);
    }
}
