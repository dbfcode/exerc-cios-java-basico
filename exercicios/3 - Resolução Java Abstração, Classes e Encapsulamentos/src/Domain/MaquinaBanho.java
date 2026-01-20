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
    }

    public boolean temRecursosParabanho(){

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
        if(petAtual == null && maquinaLimpa == true){
            this.petAtual = pet;
            System.out.println("Pet colocado na máquina!");
        }else if(maquinaLimpa != true){
            System.out.println("Máquina suja! Necessário limpá-la antes!");
        }else if(petAtual != null){
            System.out.println("Já tem pet na máquina!");
        }
    }

    public void retirarPet(){
        if(petAtual != null){
            petAtual = null;
            System.out.println("Pet retirado da máquina!");
        }
    }

    public void banharPet() throws InterruptedException {
        if(!temRecursosParabanho()){
            return;
        }

        System.out.println("Banho iniciado...");

        for (int segundos = 1; segundos <= 5; segundos++) {
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
    }

    public void banharPetAsync(Runnable callback){
        CompletableFuture.runAsync(() -> {
            try {
                banharPet();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                if(callback != null){
                    System.out.println("rodando callback......");
                    callback.run();
                }
            }
        });
    }

    public void limparMaquina() throws InterruptedException {
        System.out.println("Limpando máquina...");

        for (int segundos = 1; segundos <= 5; segundos++) {
            Thread.sleep(1000);
            System.out.println("Limpando máquina: " + segundos + "s");
        }

        nivelAgua -= CONSUMO_AGUA_LIMPEZA_MAQUINA;
        nivelShampoo -= CONSUMO_SHAMPOO_LIMPEZA_MAQUINA;
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
        if(nivelShampoo == capacidadeShampoo){
            System.out.println("Quantia de shampoo na capacidade máxima.");
        }else{
            nivelShampoo += 1;
        }
    }

}
