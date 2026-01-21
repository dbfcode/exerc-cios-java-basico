package Domain;

public class Carro {

    public enum Marcha {
        N(0, 0),
        M1(0, 20),
        M2(21, 40),
        M3(41,60),
        M4(61, 80),
        M5(81, 100),
        M6(101,120);

        private final int velMin;
        private final int velMax;

        Marcha(int velMin, int velMax){
            this.velMin = velMin;
            this.velMax = velMax;
        }

        public int getVelMax(){
            return this.velMax;
        }

        public int getVelMin(){
            return this.velMin;
        }

        public boolean permiteVelocidade(float velocidade) {
            return velocidade >= velMin && velocidade <= velMax;
        }
    }

    public enum Direcao {
        esquerda, direita
    }

    private boolean ligado;
    private int velocidade;
    private Marcha marcha;

    public Carro (){
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = Marcha.N;
    }

    public boolean travaDesligado() {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return true;
        }
        return false;
    }

    public void ligar(){
        ligado = true;
        System.out.println("Carro ligado");
    }

    public void desligar(){
        if(velocidade <= 0 && marcha == Marcha.N){
            ligado = false;
            System.out.println("Carro desligado");
        }else{
            System.out.println("O carro precisa estar parado e com a marcha no neutro.");
        }
    }

    public void subirMarcha(){
        if (marcha == Marcha.M6) {
            throw new IllegalStateException("Já está na última marcha");
        }

        Marcha proxima = Marcha.values()[marcha.ordinal() + 1];

        if(velocidade > proxima.getVelMax()){
            System.out.println("Velocidade alta demais para a marcha atual (" + marcha + ").");
        }

        this.marcha = proxima;
    }

    public void descerMarcha(){
        Marcha anterior = Marcha.values()[marcha.ordinal()-1];

        if(velocidade < anterior.getVelMin()){
            System.out.println("Velocidade baixa demais para a marcha atual (" + marcha + ").");
        }

        this.marcha = anterior;
    }


    public void acelerar(){
        if(travaDesligado()) return;
        if(marcha.permiteVelocidade(velocidade+1)){
            velocidade++;
            System.out.println("Acelerando. Velocidade atual: " + velocidade);
        }else{
            System.out.println("Velocidade não permitida para esta marcha (" + marcha + "). Troque de marcha");
        }
    }

    public void desacelerar(){
        if(travaDesligado()) return;
        if(marcha.permiteVelocidade(velocidade+1)){
            velocidade--;
            System.out.println("Desacelerando. Velocidade atual: " + velocidade);
        }else{
            System.out.println("Velocidade não permitida para esta marcha (" + marcha + "). Troque de marcha");
        }
    }

    public void virar(Direcao direcao){
        if(travaDesligado()) return;
        String msg = velocidade >= 1 && velocidade <= 40 ? "Virou para a " + direcao
                   : "Não foi possível virar o carro, fora da velocidade permitida";
        System.out.println(msg);
    }

    public int getVelocidade(){
        return velocidade;
    }
}
