package classes.mais.encapsulamento;

public class MaquinaBanhoPet {
    private Pet pet;
    private int nivelAguaLitros = 0;
    private int nivelShampooLitros = 0;
    private boolean limpo = true;

    private void validarUmPetPorVezNaMaquina(Pet pet) throws Exception {
        if (pet != null && temPet()) throw new Exception("Só é permitido um Pet por vez na máquina!");
    }

    public void incluirPet(Pet pet) throws Exception {
        validarNecessarioLimpar();
        validarUmPetPorVezNaMaquina(pet);
        this.pet = pet;
        this.pet.setLimpo(false);
    }

    private void validarNecessarioLimpar() throws Exception {
        if (!this.limpo) throw new Exception("Necessário limpar máquina antes de incluir um pet!");
    }

    public void retirarPet() {
        this.limpo = this.pet.getLimpo();
        this.pet = null;
    }

    public Pet getPet() {
        return this.pet;
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
        this.limpo = true;
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
        consumirAgua(10);
        consumirShampoo(2);
        this.pet.setLimpo(true);
    }

    public boolean temPet() {
        return pet != null;
    }
}
