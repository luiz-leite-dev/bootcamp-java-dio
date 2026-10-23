package br.com.dio.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercicio3 {

    private final static String SEPARADOR_CAMPOS = ";;";
    public static void main(String[] args) {
        /* Escreva um código que receba 3 valores separados por um caracter de sua escolha n vezes 
           ( n é o número de vezes que o usuário desejar informar) 
            ex.: nome;Lucas;Texto. 
           Quando o usuário parar de informar valores o código deve retornar todos esses campos 
           compondo um json, 
           um xml 
           e um yaml 
           (Json: https://pt.wikipedia.org/wiki/JSON, 
           XML: https://pt.wikipedia.org/wiki/XML, 
           yaml: https://www.treinaweb.com.br/blog/o-que-e-yaml) 
           as entradas devem seguir o seguinte padrão:
             NOME_CAMPO;VALOR;TIPO;
           Os tipos que devem ser aceitos são: texto, datas, data e hora, números inteiros, 
           números com pontos flutuantes, boleanos, array dos tipos anteriores 
           ( opcional, possibilitar definir arrays de objetos e objetos internos). */
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        StringBuilder campos = new StringBuilder();
        System.out.printf("Considerando que os tipos disponíveis são: %s\n\n",String.join(", ", Arrays.stream(TipoCampo.values()).map(Enum::name).toList()));
        System.out.println("Digite os campos a montar os arquivos no seguinte padrão: NomeDoCampo;Valor;Tipo");
        System.out.println("ou digite FIM para ver o resultado.");
        var campo = "";
        while (true) {
            campo = scanner.next();
            if (campo.equals("FIM")) break;
            campos.append(campo+SEPARADOR_CAMPOS);
        }
        List<Campo> campos2 = converter(campos.toString());
        System.out.println("JSON: \n" + TipoResultado.JSON.converter(campos2));
        System.out.println("XML: \n" + TipoResultado.XML.converter(campos2));
        System.out.println("YAML: \n" + TipoResultado.YAML.converter(campos2));
        scanner.close();
    }

    public static List<Campo> converter(String campos) {
        List<Campo> retorno = new ArrayList<>();
        var listaCampos = campos.split(SEPARADOR_CAMPOS);
        for (String campo : listaCampos) {
            var dados = campo.split(";");
            var campoRecord = new Campo(dados[0], dados[1], TipoCampo.valueOf(dados[2]));
            retorno.add(campoRecord);
        }
        return retorno;
    }
}
