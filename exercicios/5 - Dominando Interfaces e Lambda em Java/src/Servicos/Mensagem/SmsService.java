package Servicos.Mensagem;
import Mensagem.ServicoDeMensagem;

public class SmsService implements ServicoDeMensagem {
    public void enviar(String mensagem){
        System.out.println(mensagem);
    };
}
