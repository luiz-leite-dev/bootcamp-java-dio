package strings;

import java.util.List;

public enum TipoResultado {

    JSON,
    XML,
    YAML;

    public String converter(List<Campo> campos) {
        StringBuilder retorno = new StringBuilder();
        switch (this) {
            case JSON -> retorno.append("{\n");
            case XML -> retorno.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n<objeto>\n");
            case YAML -> retorno.append("");
        }
        campos.forEach(c -> {
            retorno.append(String.format(getFormatoCampo(c),formatarCampoValor(c)));
            retorno.append(TipoResultado.JSON.equals(this) ? ",\n": "\n");
        });
        switch (this) {
            case JSON -> retorno.append("}\n");
            case XML -> retorno.append("</objeto>\n");
            case YAML -> retorno.append("");
        }
        return retorno.toString();
    }

    public String formatarCampoValor(Campo campo) {
        switch (campo.tipo()) {
            case TEXTO -> {
                if (TipoResultado.JSON.equals(this)) return "'"+campo.valor()+"'";
                return campo.valor();
            }
            default -> {
                return campo.valor();
            }
        }
    }

    public String getFormatoCampo(Campo campo) {
        if (TipoResultado.JSON.equals(this)) return "'"+campo.nome()+"':%s";
        if (TipoResultado.XML.equals(this)) return "<"+campo.nome()+">%s</"+campo.nome()+">";
        return campo.nome()+":%s";
    }

}
