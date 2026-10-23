package interfaces.exercicio1;

public class SocialService implements MessageService {

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mensagem enviada por Redes Sociais:");
        System.out.println("Título: "+message.getTitle());
        System.out.println("Conteúdo: "+message.getContent());
    }

}
