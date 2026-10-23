package heranca.mais.polimorfismo.exercicio3;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public non-sealed class RelogioBrasileiro extends Relogio {

    public RelogioBrasileiro() throws Exception {
        ZonedDateTime brasilia = ZonedDateTime.now(
            ZoneId.of("America/Sao_Paulo")
        );
        setHora(brasilia.getHour());
        setMinuto(brasilia.getMinute());
        setSegundo(brasilia.getSecond());
    }

    @Override
    public Relogio converter(Relogio relogio) throws Exception {
        setSegundo(relogio.getSegundo());
        setMinuto(relogio.getMinuto());
        switch (relogio) {
            case RelogioAmericano relogioAmericano -> setHora(relogioAmericano.getHora() + (relogioAmericano.isAntesDoMeioDia() ? 0 : 12));
            case RelogioBrasileiro relogioBrasileiro -> setHora(relogioBrasileiro.getHora());
        }
        return this;
    }

}
