package menu;
import Domain.Carro;

public class MenuCarro extends MenuBase {

    private Carro carro;

    public MenuCarro(){
        this.carro = new Carro();
    }


    @Override
    public Runnable mostrarOpcoes(){
        System.out.println("""
                \n
                1 - Ligar o carro;
                2 - Desligar o carro;
                3 - Acelerar;
                4 - Desacelerar;
                5 - Virar para esquerda;
                6 - Virar para direita;
                7 - Verificar velocidade;
                8 - Subir marcha;
                9 - Descer marcha;
                """);
        return null;
    }

    @Override
    public void tratarOpcao(int opcao){
        switch(opcao){
            case 1:
                carro.ligar();
                break;
            case 2:
                carro.desligar();
                break;
            case 3:
                carro.acelerar();
                break;
            case 4:
                carro.desacelerar();
                break;
            case 5:
                carro.virar(Carro.Direcao.esquerda);
                break;
            case 6:
                carro.virar(Carro.Direcao.direita);
                break;
            case 7:
                System.out.println("Velocidade: " + carro.getVelocidade());
                break;
            case 8:
                carro.subirMarcha();
                break;
            case 9:
                carro.descerMarcha();
                break;
        }
    }
}
