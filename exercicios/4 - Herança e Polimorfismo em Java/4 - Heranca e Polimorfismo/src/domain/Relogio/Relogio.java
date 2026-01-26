package domain.Relogio;

//Base: 24h;
public abstract class Relogio {

    private int hora;
    private int minuto;
    private int segundo;

    public Relogio(int hora, int minuto, int segundo){
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("Hora inválida");
        }
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException("Minuto inválido");
        }
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (segundo < 0 || segundo > 59) {
            throw new IllegalArgumentException("Segundo inválido");
        }
        this.segundo = segundo;
    }

    public String formatarHorario() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    public void ajustarHorario(Relogio outro){
        setHora(outro.getHora());
        setMinuto(outro.getMinuto());
        setSegundo(outro.getSegundo());
    }
}
