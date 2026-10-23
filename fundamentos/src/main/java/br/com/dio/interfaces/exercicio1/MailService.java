package br.com.dio.interfaces.exercicio1;

public class MailService implements MessageService {

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mensagem enviada por E-mail:");
        System.out.println("Título: "+message.getTitle());
        System.out.println("Conteúdo: "+message.getContent());
    }

}
