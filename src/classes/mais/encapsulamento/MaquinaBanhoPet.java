package classes.mais.encapsulamento;

public class MaquinaBanhoPet {
    private String nomePet;
    private boolean banhoIniciado = false;
    private int nivelAguaLitros = 0;
    private int nivelShampooLitros = 0;
    private boolean necessarioLimpar = false;

    private void validarUmPetPorVezNaMaquina(String nome) throws Exception {
        if (nome != null && !nome.isBlank() && temPet()) throw new Exception("Só é permitido um Pet por vez na máquina!");
    }

    public void incluirPet(String nome) throws Exception {
        validarNecessarioLimpar();
        validarNomeObrigatorio(nome);
        validarUmPetPorVezNaMaquina(nome);
        this.nomePet = nome;
        this.banhoIniciado = false;
    }

    private void validarNomeObrigatorio(String nome) throws Exception {
        if (nome == null || nome.isBlank()) throw new Exception("Obrigatório informar o nome do pet!");
    }

    private void validarNecessarioLimpar() throws Exception {
        if (this.necessarioLimpar) throw new Exception("Necessário limpar antes de incluir um pet!");
    }

    public void retirarPet() {
        this.nomePet = null;
        if (!this.banhoIniciado) this.necessarioLimpar = true;
        this.banhoIniciado = false;
    }

    public String getNomePet() {
        return this.nomePet;
    }

    public void abastecerAgua() throws Exception {
        int litros = 2;
        validarCapacidadeAgua(litros);
        this.nivelAguaLitros += litros;
    }

    private void validarConsumoAgua(int litros) throws Exception {
        if (this.nivelAguaLitros - litros < 0) throw new Exception("Necessário abastecer água antes desta ação!");
    }

    private void validarCapacidadeAgua(int litros) throws Exception {
        if (this.nivelAguaLitros + litros > 30) throw new Exception("Não é possível abastecer água acima de 30L!");
    }

    private void consumirAgua(int litros) throws Exception {
        validarConsumoAgua(litros);
        this.nivelAguaLitros -= litros;
    }

    private void consumirShampoo(int litros) throws Exception {
        validarConsumoShampoo(litros);
        this.nivelShampooLitros -= litros;
    }

    private void validarConsumoShampoo(int litros) throws Exception {
        if (this.nivelShampooLitros - litros < 0) throw new Exception("Necessário abastecer shampoo antes desta ação!");
    }

    private void validarPodeLimpar() throws Exception {
        if (temPet()) throw new Exception("Antes de limpar é necessário remover o pet da máquina!");
    }

    public void limpar() throws Exception {
        validarPodeLimpar();
        consumirAgua(3);
        consumirShampoo(1);
        this.necessarioLimpar = false;
    }

    public int getNivelAguaLitros() {
        return this.nivelAguaLitros;
    }

    public void abastecerShampoo() throws Exception {
        int litros = 2;
        validarCapacidadeShampoo(litros);
        this.nivelShampooLitros += litros;
    }

    private void validarCapacidadeShampoo(int litros) throws Exception {
        if (this.nivelShampooLitros + litros > 10) throw new Exception("Não é permitido abastecer shampoo acima de 10L!");
    }

    public int getNivelShampooLitros() {
        return this.nivelShampooLitros;
    }

    private void validarPodeDarBanho() throws Exception {
        if (!temPet()) throw new Exception("Primeiro é necessário colocar um pet na máquina!");
    }

    public void darBanho() throws Exception {
        validarPodeDarBanho();
        this.banhoIniciado = true;
        consumirAgua(10);
        consumirShampoo(2);
    }

    public boolean banhoIniciado() {
        return this.banhoIniciado;
    }

    public boolean temPet() {
        return this.nomePet != null && !this.nomePet.isBlank();
    }
}
