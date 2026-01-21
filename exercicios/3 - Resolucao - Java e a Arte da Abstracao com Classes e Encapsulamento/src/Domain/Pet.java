package Domain;

public class Pet {

    private boolean limpo;

    public Pet (){
        limpo = false;
    }

    public boolean getLimpo(){
        return limpo;
    }

    public void setLimpo(boolean limpo){
        this.limpo = limpo;
    }
}
