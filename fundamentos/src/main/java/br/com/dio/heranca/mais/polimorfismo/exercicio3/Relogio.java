package br.com.dio.heranca.mais.polimorfismo.exercicio3;

public sealed abstract class Relogio permits RelogioAmericano, RelogioBrasileiro {

    private int hora;

    private int minuto;

    private int segundo;

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) throws Exception {
        validarHora(hora);
        this.hora = hora;
    }

    public void validarHora(int hora) throws Exception {
        if (hora < 0) throw new Exception("Hora precisa ser um valor positivo!");
        if (hora > 24) throw new Exception("Hora não pode ser maior que 24!");
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) throws Exception {
        validarMinuto(minuto);
        this.minuto = minuto;
    }

    private void validarMinuto(int minuto) throws Exception {
        if (minuto < 0) throw new Exception("Minuto precisa ser um valor positivo!");
        if (minuto > 59) throw new Exception("Minuto não pode ser maior que 59!");
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) throws Exception {
        validarSegundo(segundo);
        this.segundo = segundo;
    }

    private void validarSegundo(int segundo) throws Exception {
        if (segundo < 0) throw new Exception("Segundo precisa ser um valor positivo!");
        if (segundo > 59) throw new Exception("Segundo não pode ser maior que 59!");
    }

    public String getHorarioHHMMSS() {
        return String.format("%02d:%02d:%02d", this.hora, this.minuto, this.segundo);
    }

    public abstract Relogio converter(Relogio relogio) throws Exception;
}
