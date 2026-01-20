package menu;

import Domain.MaquinaBanho;
import Domain.Pet;

public class MenuMaquinaBanho extends MenuBase {

    private MaquinaBanho maquinaBanho;
    private Pet pet;

    public MenuMaquinaBanho(){
        this.pet = new Pet();
        this.maquinaBanho = new MaquinaBanho();
    }

    @Override
    public Runnable mostrarOpcoes(){
        System.out.println("""
               \n
               1 - Dar banho no pet;
               2 - Abastecer com água;
               3 - Abastecer com shampoo;
               4 - Verificar nivel de água;
               5 - Verificar nivel de shampoo;
               6 - Verificar se tem pet no banho;
               7 - Colocar pet na maquina;
               8 - Retirar pet da máquina;
               9 - Limpar maquina.
               """);
        return null;
    }

    @Override
    public void tratarOpcao(int opcao){
        switch(opcao){
            case 1:
                maquinaBanho.banharPetAsync(this::mostrarOpcoes);
                break;
            case 2:
                maquinaBanho.abastecerAgua();
                break;
            case 3:
                maquinaBanho.abastecerShampoo();
                break;
            case 4:
                System.out.println("Nível da água " + maquinaBanho.getNivelAgua());
                break;
            case 5:
                System.out.println("Nível do shampoo " + maquinaBanho.getNivelShampoo());
                break;
            case 6:
                System.out.println("Pet no banho(?): " + (maquinaBanho.temPetAtual() ? "Sim": "Não"));
                break;
            case 7:
                maquinaBanho.colocarPet(pet);
                break;
            case 8:
                maquinaBanho.retirarPet();
                break;
            case 9:
                maquinaBanho.limparMaquinaAsync();
                break;
        }
    }
}
