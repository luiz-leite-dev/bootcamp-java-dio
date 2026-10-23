package br.com.dio.strings;

import java.util.List;

public enum TipoResultado {

    JSON,
    XML,
    YAML;

    public String getCampoValorFormatados(Campo campo) {
        return String.format(getFormatoCampo(campo),formatarCampoValor(campo)) + 
            (TipoResultado.JSON.equals(this) ? ",\n": "\n");
    }

    public String converter(List<Campo> campos) {
        StringBuilder retorno = new StringBuilder();
        switch (this) {
            case JSON -> retorno.append("{\n");
            case XML -> retorno.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n<objeto>\n");
            case YAML -> retorno.append("objeto:\n");
        }
        campos.forEach(c -> retorno.append(getCampoValorFormatados(c)));
        if (TipoResultado.JSON.equals(this)) retorno.deleteCharAt(retorno.lastIndexOf(","));
        switch (this) {
            case JSON -> retorno.append("}\n");
            case XML -> retorno.append("</objeto>\n");
            case YAML -> retorno.append("");
        }
        return retorno.toString();
    }

    public String formatarTexto(String valor) {
        if (TipoResultado.JSON.equals(this)) return "\""+valor+"\"";
        return valor;
    }

    public String formatarBoleano(String valor) {
        return valor.equals("true") || valor.equals("verdadeiro") || valor.equals("1") ? "true" : "false";
    }

    public String formatarDecimal(String valor) {
        return valor.replace(",",".");
    }

    public String removerUltimaVirgula(String texto) {
        int posicao = texto.lastIndexOf(",");
        if (posicao != -1) {
            return texto.substring(0, posicao) + texto.substring(posicao + 1);
        }
        return texto;
    }

    public String formatarCampoValor(Campo campo) {
        switch (campo.tipo()) {
            case TEXTO, DATA, DATA_E_HORA -> {
                return formatarTexto(campo.valor());
            }
            case BOLEANO -> {
                return formatarBoleano(campo.valor());
            }
            case DECIMAL -> {
                return formatarDecimal(campo.valor());
            }
            case ARRAY_DE_TEXTO, ARRAY_DE_DATA, ARRAY_DE_DATA_E_HORA, ARRAY_DE_INTEIRO, ARRAY_DE_DECIMAL, ARRAY_DE_BOLEANO -> {
                var valores = campo.valor().split(",");
                StringBuilder retorno = new StringBuilder();
                if (TipoResultado.JSON.equals(this)) retorno.append("[");
                for (String valor : valores) {
                    String formato = "%s";
                    if (TipoResultado.XML.equals(this)) formato = "\n        <item>%s</item>";
                    if (TipoResultado.YAML.equals(this)) formato = "\n        - %s";
                    if (TipoCampo.ARRAY_DE_INTEIRO.equals(campo.tipo())) {
                        retorno.append(String.format(formato, valor));
                    } else if (TipoCampo.ARRAY_DE_DECIMAL.equals(campo.tipo())) {
                        retorno.append(String.format(formato, formatarDecimal(valor)));
                    } else if (TipoCampo.ARRAY_DE_BOLEANO.equals(campo.tipo())) {
                        retorno.append(String.format(formato, formatarBoleano(valor)));
                    } else {
                        retorno.append(String.format(formato, formatarTexto(valor)));
                    }
                    if (TipoResultado.JSON.equals(this)) retorno.append(",");
                }
                if (TipoResultado.JSON.equals(this)) retorno.deleteCharAt(retorno.lastIndexOf(",")).append("]");
                return retorno.toString() + (TipoResultado.JSON.equals(this) ? "": "\n");
            }
            case ARRAY_DE_OBJETO -> {
                var camposObjeto = campo.valor().split(",");
                StringBuilder retorno = new StringBuilder();
                if (TipoResultado.JSON.equals(this)) retorno.append("[\n");
                if (TipoResultado.YAML.equals(this)) retorno.append("\n");
                for (String campoObjetoString : camposObjeto) {
                    String formato = "        {\n        %s        },\n";
                    if (TipoResultado.XML.equals(this)) formato = "\n        <item>\n            %s        </item>";
                    if (TipoResultado.YAML.equals(this)) formato = "        - %s";
                    var campoObjetoArray = campoObjetoString.split(":");
                    Campo novoCampo = new Campo(campoObjetoArray[0], campoObjetoArray[1], TipoCampo.valueOf(campoObjetoArray[2]));
                    retorno.append(String.format(formato,removerUltimaVirgula(getCampoValorFormatados(novoCampo))));
                }
                if (TipoResultado.JSON.equals(this)) retorno.deleteCharAt(retorno.lastIndexOf(",")).append("    ]");
                return retorno.toString() + (TipoResultado.JSON.equals(this) ? "": "\n");                
            }
            case OBJETO_INTERNO -> {
                var camposObjeto = campo.valor().split(",");
                StringBuilder retorno = new StringBuilder();
                if (TipoResultado.JSON.equals(this)) retorno.append("{\n");
                else retorno.append("\n");
                for (String campoObjetoString : camposObjeto) {
                    String formato = "    %s";
                    if (TipoResultado.XML.equals(this)) formato = "    %s";
                    if (TipoResultado.YAML.equals(this)) formato = "    %s";
                    var campoObjetoArray = campoObjetoString.split(":");
                    Campo novoCampo = new Campo(campoObjetoArray[0], campoObjetoArray[1], TipoCampo.valueOf(campoObjetoArray[2]));
                    retorno.append(String.format(formato,getCampoValorFormatados(novoCampo)));
                }
                if (TipoResultado.JSON.equals(this)) retorno.deleteCharAt(retorno.lastIndexOf(",")).append("    }");
                return retorno.toString() + (TipoResultado.JSON.equals(this) ? "": "\n"); 
            }
            default -> {
                return campo.valor();
            }
        }
    }

    public String getFormatoCampo(Campo campo) {
        if (TipoResultado.JSON.equals(this)) return "    \""+campo.nome()+"\":%s";
        if (TipoResultado.XML.equals(this)) return "    <"+campo.nome()+">%s</"+campo.nome()+">";
        return "   " + campo.nome()+":%s";
    }

}
