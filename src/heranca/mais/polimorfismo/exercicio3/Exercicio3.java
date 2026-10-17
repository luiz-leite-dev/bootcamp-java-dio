package heranca.mais.polimorfismo.exercicio3;

public class Exercicio3 {
    public static void main(String[] args) {
        /* Escreve uma hierarquia de classes para criação de relógios para diferentes lugares do mundo. 
           Defina uma classe pai que tenha as propriedades Hora, minuto e segundo 
           com seus respectivos getters e setters (atendendo as regras do funcionamento de um relógio) 
           e um método que deverá retornar a hora no formato HH:MM:SS. 
           A partir dessa classe crie 2 implementações, uma chamada relógio Americano 
           e outra chamada relógio Brasileiro, lembrando que para o relógio americano 
           não existem as horas de 13 até 24. 
           Defina também na super classe um método que ficará por responsabilidade da classe 
           que extende-la definir seu funcionamemnto, esse método deve receber um relógio 
           ( independente da implementação) e deve-se extrair as informações dele 
           e usa-la no objeto que recebeu para setar as novas informações do relógio. */
        try {
            Relogio relogioAmericano = new RelogioAmericano();
            System.out.println("Relógio americano: "+relogioAmericano.getHorarioHHMMSS());
            Relogio relogioBrasileiro = new RelogioBrasileiro();
            System.out.println("Relógio brasileiro: "+relogioBrasileiro.getHorarioHHMMSS());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
