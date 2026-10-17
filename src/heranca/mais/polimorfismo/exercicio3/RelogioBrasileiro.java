package heranca.mais.polimorfismo.exercicio3;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class RelogioBrasileiro extends Relogio {

    public RelogioBrasileiro() throws Exception {
        ZonedDateTime brasilia = ZonedDateTime.now(
            ZoneId.of("America/Sao_Paulo")
        );
        setHora(brasilia.getHour());
        setMinuto(brasilia.getMinute());
        setSegundo(brasilia.getSecond());
    }

    @Override
    public void setRelogio(Relogio relogio) throws Exception {
        setHora(relogio.getHora());
        setMinuto(relogio.getMinuto());
        setSegundo(relogio.getSegundo());
    }

}
