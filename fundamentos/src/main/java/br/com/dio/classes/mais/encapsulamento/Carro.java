package br.com.dio.classes.mais.encapsulamento;

public class Carro {

    public static enum Marcha {
        PONTO_MORTO(0,0),
        PRIMEIRA(0, 20),
        SEGUNDA(21, 40),
        TERCEIRA(41, 60),
        QUARTA(61, 80),
        QUINTA(81, 100),
        SEXTA(101,120);

        private int velocidadeMinima;
        private int velocidadeMaxima;

        Marcha(int velocidadeMinima, int velocidadeMaxima) {
            this.velocidadeMinima = velocidadeMinima;
            this.velocidadeMaxima = velocidadeMaxima;
        }

        public int getVelocidadeMinima() {
            return this.velocidadeMinima;
        }

        public int getVelocidadeMaxima() {
            return this.velocidadeMaxima;
        }
    };

    public static enum Direcao {
        EM_FRENTE,
        ESQUERDA,
        DIREITA
    }

    private boolean ligado = false;
    private Marcha marcha = Marcha.PONTO_MORTO;
    private int velocidade = 0;
    private Direcao direcao = Direcao.EM_FRENTE;

    public void ligar(){
        this.ligado = true;
    }

    private void validarSeDesligado() throws Exception {
        if (!this.ligado) throw new Exception("Carro está desligado!");
    }

    private void validarSePodeDesligar() throws Exception {
        if (!Marcha.PONTO_MORTO.equals(this.marcha) || this.velocidade != 0) throw new Exception("Carro não pode ser desligado!");
    }

    public void desligar() throws Exception {
        validarSeDesligado();
        validarSePodeDesligar();
        this.ligado = false;
    }

    public boolean ligado(){
        return this.ligado;
    }

    public void acelerar() throws Exception{
        validarSeDesligado();
        validarSePontoMortoPodeAcelerar();
        validarVelocidadeAcelerar();
        this.velocidade += 1;
    }

    private void validarSePontoMortoPodeAcelerar() throws Exception {
        if (Marcha.PONTO_MORTO.equals(marcha)) throw new Exception("Não é permitido acelerar em ponto morto!");
    }

    private void validarVelocidadeAcelerar() throws Exception {
        if (this.velocidade + 1 > marcha.getVelocidadeMaxima()) throw new Exception("Para acelerar mais, será necessário primeiro trocar de marcha!");
    }

    public void desacelerar() throws Exception{
        validarSeDesligado();
        if (this.velocidade > 0) {
            validarVelocidadeDesacelerar();
            this.velocidade -= 1;
        }
    }

    private void validarVelocidadeDesacelerar() throws Exception {
        if (this.velocidade - 1 < marcha.getVelocidadeMinima()) throw new Exception("Para desacelerar mais, será necessário primeiro trocar de marcha!");
    }

    public int getVelocidade(){
        return this.velocidade;
    }

    private void validarVelocidadeParaConversao() throws Exception{
        if (this.velocidade == 0 || this.velocidade > 40) throw new Exception("Conversão não permitida!");
    }

    public void virarAEsquerda() throws Exception{
        validarSeDesligado();
        validarVelocidadeParaConversao();
        this.direcao = Direcao.DIREITA;
    }

    public void virarADireita() throws Exception {
        validarSeDesligado();
        validarVelocidadeParaConversao();
        this.direcao = Direcao.ESQUERDA;
    }

    public void irEmFrente() throws Exception {
        validarSeDesligado();
        this.direcao = Direcao.EM_FRENTE;
    }

    private void validarTrocaMarca(Marcha marcha) throws Exception{
        if (Math.abs(marcha.ordinal() - this.marcha.ordinal()) > 1) throw new Exception("Troca de marcha impedida!");
    }

    public void trocarMarcha(Marcha marcha) throws Exception{
        validarSeDesligado();
        validarTrocaMarca(marcha);
        this.marcha = marcha;
    }

    public Direcao getDirecao(){
        return this.direcao;
    }

}
