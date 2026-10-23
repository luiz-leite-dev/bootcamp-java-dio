package heranca.mais.polimorfismo.exercicio3;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public non-sealed class RelogioAmericano extends Relogio {

    private boolean antesDoMeioDia;
    
    public RelogioAmericano() throws Exception {
        ZonedDateTime newYork = ZonedDateTime.now(
            ZoneId.of("America/New_York")
        );
        if (newYork.getHour() > 12) {
            setHora(newYork.getHour() - 12);
            setAntesDoMeioDia(false);
        } else {
            setHora(newYork.getHour());
            setAntesDoMeioDia(true);
        }
        setMinuto(newYork.getMinute());
        setSegundo(newYork.getSecond());
    }

    @Override 
    public void validarHora(int hora) throws Exception {
        if (hora < 0) throw new Exception("Hora precisa ser um valor positivo!");
        if (hora > 12) throw new Exception("Hora não pode ser maior que 12!");
    }

    @Override
    public Relogio converter(Relogio relogio) throws Exception {
        setSegundo(relogio.getSegundo());
        setMinuto(relogio.getMinuto());
        switch (relogio) {
            case RelogioBrasileiro relogioBrasileiro -> {
                setAntesDoMeioDia(relogioBrasileiro.getHora() < 12);
                setHora(relogioBrasileiro.getHora() - (isAntesDoMeioDia() ? 0 : 12));
            }
            case RelogioAmericano relogioAmericano -> {
                setAntesDoMeioDia(relogioAmericano.isAntesDoMeioDia());
                setHora(relogioAmericano.getHora());
            }
        }
        return this;
    }

    public boolean isAntesDoMeioDia() {
        return antesDoMeioDia;
    }

    public void setAntesDoMeioDia(boolean antesDoMeioDia) {
        this.antesDoMeioDia = antesDoMeioDia;
    }    
    
    @Override 
    public String getHorarioHHMMSS() {
        return super.getHorarioHHMMSS() + (antesDoMeioDia ? " AM" : " PM");
    }
}
