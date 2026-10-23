package br.com.dio.strings;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

public class Strings {
    public static void main(String[] args) {
        System.out.println("====String====");
        var v = "java;java;java;java";
        var values = v.split(";");
        for (var value : values) {
            System.out.println(value);
        }

        var json = """
            {
                "name": "Maria",
                "age": 36
            }
        """;
        System.out.println(json);
        Map<String, String> map = new HashMap<>();
        json = json.replace("{", "").replace("}", "").replace("\"", "").replace("\n","").replace(" ", "");
        var jsonFields = json.split(",");
        for (var v2: jsonFields) {
            var keyValue = v2.split(":");
            map.put(keyValue[0],keyValue[1]);
        }
        System.out.println(map);
        System.out.println("====String Builder Buffer====");
        var stringStart = OffsetDateTime.now();
        String stringConcat = "";
        for (int i = 0; i < 100000; i++) {
            stringConcat += i;
        }
        System.out.println(Duration.between(stringStart, OffsetDateTime.now()).toMillis());

        stringStart = OffsetDateTime.now();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            builder.append(i);
        }
        System.out.println(Duration.between(stringStart, OffsetDateTime.now()).toMillis());

        stringStart = OffsetDateTime.now();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            buffer.append(i);
        }
        System.out.println(Duration.between(stringStart, OffsetDateTime.now()).toMillis());
    }
}
