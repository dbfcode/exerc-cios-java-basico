import menu.MenuContaBancaria;
import menu.MenuBase;

public class Exec01ContaBanco {
    public static void main (String[] args){
        MenuBase menu = new MenuContaBancaria();
        menu.executar();
    }
}