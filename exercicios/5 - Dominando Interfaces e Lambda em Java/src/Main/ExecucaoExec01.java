package Main;

import Mensagem.ServicoDeMensagem;
import Servicos.Mensagem.SmsService;

public class ExecucaoExec01 {
    public static void main(String[] args){
        //Fiz sem lambda primeiro + polimorfismo
        ServicoDeMensagem sms = new SmsService();

        //Aqui deixei com lambda implementando a interface funcional
        ServicoDeMensagem email = msg -> System.out.println("Email: " + msg);
        ServicoDeMensagem redesSociais = msg -> System.out.println("Redes sociais: " + msg);
        ServicoDeMensagem whatsapp = msg -> System.out.println("WhatsApp: " + msg);


        sms.enviar("SMS: Enviando mensagem ");

        email.enviar("Enviando mensagem nova de e-mail!");
        redesSociais.enviar("Mensagem nova!");
        whatsapp.enviar("Enviando mensagem!");

    }
}
