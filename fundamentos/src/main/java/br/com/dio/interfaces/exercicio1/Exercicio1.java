package br.com.dio.interfaces.exercicio1;

public class Exercicio1 {
    public static void main(String[] args) {
        /* Escreva um código para enviar mensagens de marketing, 
           para isso você deve ter a possibilidade de enviar a mesma mensagem para serviços diferentes, 
           esses serviços devem ter um método para receber a mensagem como parâmetro, 
           os serviços que devem estar disponíveis são:
           - SMS;
           - E-mail;
           - Redes Sociais;
           - WhatsApp; */
        Message mensagem = new Message("Netflix grátis", "Você ganhou um mês grátis de Netflix!");
        enviarMensagemMarketing(mensagem);
    }

    private static void enviarMensagemMarketing(Message mensagem) {
        SMSService smsService = new SMSService();
        smsService.sendMessage(mensagem);
        MailService mailService = new MailService();
        mailService.sendMessage(mensagem);
        SocialService socialService = new SocialService();
        socialService.sendMessage(mensagem);
        WhatsappService whatsappService = new WhatsappService();
        whatsappService.sendMessage(mensagem);
    }
}
