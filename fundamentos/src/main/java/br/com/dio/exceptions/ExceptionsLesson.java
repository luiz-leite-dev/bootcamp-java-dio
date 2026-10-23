package br.com.dio.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionsLesson {
    public static void main(String[] args) {
        /* Sugestões do ChatGPT
            1. Não herdar de Error para representar erros da aplicação.
            2. Usar RuntimeException como base para exceções de negócio quando essa escolha fizer sentido para o contrato da aplicação.
            3. Criar exceções específicas para condições de negócio que exigem tratamentos diferentes.
            4. Usar Bean Validation para validar dados de entrada.
            5. Centralizar o tratamento de exceções nas camadas apropriadas, especialmente em APIs REST.
            6. Evitar capturar Exception indiscriminadamente.
            7. Não usar exceções para controlar fluxos normais e previsíveis quando um resultado explícito for mais adequado.
        */
        exemploErroChecked();
        exemploErroUnchecked();
    }

    public static void exemploErroChecked() {
        try {
            var stream = new FileInputStream("arquivo_inexistente");
            System.out.println("Não irá imprimir este texto!");
        } catch (FileNotFoundException e) {
            //FileNotFoundException herda de IOException
            //IOException herda de Exception
            //Exception herda de Throwable, pai também de Error
            System.out.println("Mensagem de erro:");
            System.out.println(e.getMessage());
        }
    }

    public static void exemploErroUnchecked() {
        System.out.println(10 / 0);
        System.out.println("Não irá imprimir este texto!");
    }
}
