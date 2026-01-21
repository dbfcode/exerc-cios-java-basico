package Domain;
import Domain.Pet;

import java.util.concurrent.CompletableFuture;

public class MaquinaBanho {

    private final int capacidadeAgua;
    private final int capacidadeShampoo;
    private final int capacidadePet;
    private int nivelAgua;
    private int nivelShampoo;
    private Pet petAtual;
    private boolean maquinaOcupada;
    private boolean maquinaLimpa;
    private static final int CONSUMO_AGUA_BANHO = 10;
    private static final int CONSUMO_SHAMPOO_BANHO = 2;
    private static final int CONSUMO_AGUA_LIMPEZA_MAQUINA = 3;
    private static final int CONSUMO_SHAMPOO_LIMPEZA_MAQUINA = 1;

    public MaquinaBanho(){
        capacidadeAgua = 30;
        capacidadeShampoo = 10;
        capacidadePet = 1;
        nivelAgua = 30;
        nivelShampoo = 10;
        maquinaLimpa = true;
        petAtual = null;
        maquinaOcupada = false;
    }

    public boolean temRecursosParabanho(){

        if (maquinaOcupada) {
            System.out.println("\n Máquina em uso no momento. \n");
            return false;
        }

        if (petAtual == null) {
            System.out.println("Não há pet na máquina. Coloque um pet antes.");
            return false;
        }

        if (nivelAgua < 10) {
            System.out.println("Água insuficiente. Necessário abastecer.");
            return false;
        }

        if (nivelShampoo < 2) {
            System.out.println("Shampoo insuficiente. Necessário abastecer.");
            return false;
        }

        return true;
    }

    public void colocarPet(Pet pet){

        if (maquinaOcupada) {
            System.out.println("\n Máquina em uso no momento. \n");
            return;
        }

        if(petAtual == null && maquinaLimpa == true){
            this.petAtual = pet;
            System.out.println("Pet colocado na máquina!");
        }else if(maquinaLimpa != true){
            System.out.println("Máquina suja! Necessário limpá-la antes!");
        }

    }

    public void retirarPet(){

        if (maquinaOcupada) {
            System.out.println("\n Máquina em uso no momento. \n");
            return;
        }

        if(petAtual != null){
            petAtual = null;
            System.out.println("Pet retirado da máquina!");
        }else{
            System.out.println("Não há nenhum pet na máquina.");
        }
    }

    public void banharPet() throws InterruptedException {

        if(!temRecursosParabanho()){
            return;
        }

        System.out.println("Banho iniciado...");
        maquinaOcupada = true;

        for (int segundos = 1; segundos <= 10; segundos++) {
            Thread.sleep(1000);
            System.out.println("Banhando pet: " + segundos + "s");
        }

        nivelAgua -= CONSUMO_AGUA_BANHO;
        nivelShampoo -= CONSUMO_SHAMPOO_BANHO;
        System.out.println("Gastos 10L de água. Nível atual da água: " + nivelAgua);
        System.out.println("Gastos 2L de shampoo. Nível atual do shampoo: " + nivelShampoo);

        boolean ficouLimpo = Math.random() < 0.7;
        petAtual.setLimpo(ficouLimpo);

        if(ficouLimpo){
            System.out.println("O pet saiu limpo.");
        } else {
            System.out.println("O pet não ficou limpo.");
            System.out.println("Será necessário limpar a máquina antes do próximo banho;");
            maquinaLimpa = false;
        }

        petAtual = null;
        maquinaOcupada = false;

    }

    public void banharPetAsync(Runnable callback){
        CompletableFuture.runAsync(() -> {
            try {
                System.out.println("\n --> Rodando método em thread separada (Async) <--" +
                        "\n Você pode continuar utilizando o menu enquanto isso\n");
                banharPet();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                if(callback != null){
                    callback.run();
                }
            }
        });
    }

    public void limparMaquina() throws InterruptedException {

        if (maquinaOcupada) {
            System.out.println("\n Máquina em uso no momento. \n");
            return;
        }

        if(petAtual != null){
            System.out.println("Há um pet na máquina. Necessário retirá-lo antes.");
            return;
        }

        System.out.println("Limpando máquina...");
        maquinaOcupada = true;

        for (int segundos = 1; segundos <= 5; segundos++) {
            Thread.sleep(1000);
            System.out.println("Limpando máquina: " + segundos + "s");
        }

        nivelAgua -= CONSUMO_AGUA_LIMPEZA_MAQUINA;
        nivelShampoo -= CONSUMO_SHAMPOO_LIMPEZA_MAQUINA;

        maquinaOcupada = false;
    }

    public void limparMaquinaAsync(){
        CompletableFuture.runAsync(() -> {
            try{
                limparMaquina();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public int getNivelAgua(){
        return nivelAgua;
    }

    public int getNivelShampoo(){
        return nivelShampoo;
    }

    public boolean temPetAtual(){
        return petAtual != null;
    }

    public void abastecerAgua(){

        if (maquinaOcupada) {
            System.out.println("\n Máquina em uso no momento. \n");
            return;
        }

        if(nivelAgua == capacidadeAgua - 1){
            nivelAgua += 1;
        } else if(nivelAgua == capacidadeAgua){
            System.out.println("Quantia de água na capacidade máxima.");
        }
        else{
            nivelAgua += 2;
        }
    }

    public void abastecerShampoo(){
        if (maquinaOcupada) {
            System.out.println("\n Máquina em uso no momento. \n");
            return;
        }

        if(nivelShampoo == capacidadeShampoo){
            System.out.println("Quantia de shampoo na capacidade máxima.");
        }else{
            nivelShampoo += 1;
        }
    }

}
