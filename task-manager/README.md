# Exemplos de Requisições
Para executar via REST Client no VSCode, selecione individualmente cada comando abaixo então, no MacOS utilize as teclas de atalho Command + Shift + P, então pesquise por Rest Client: Send Request, então pressione a tecla Enter para enviar a requisição.

```
POST http://localhost:8080/tasks
Content-type:application/json

{
    "title":"T",
    "description":"A exploração espacial tem sido um dos maiores sonhos da humanidade ao longo de gerações, impulsionando avanços tecnológicos sem precedentes que transformaram profundamente o nosso cotidiano na Terra. Desde o lançamento do primeiro satélite artificial, o Sputnik 1, em 1957, até as missões tripuladas à Lua e os rovers avançados que atualmente exploram a superfície de Marte, a nossa compreensão do cosmos expandiu-se de maneira extraordinária. Telescópios espaciais modernos, como o James Webb, permitem-nos olhar para recantos distantes do universo, capturando a luz de galáxias primordiais formadas há bilhões de anos, o que nos aproxima cada vez mais de responder a perguntas fundamentais sobre a nossa própria origem, a existência de outros mundos habitáveis e a vastidão de um universo em constante expansão e mistério."
}

GET http://localhost:8080/tasks

GET http://localhost:8080/tasks/1550f311-ebc3-4298-8a47-af6367bd558c

DELETE http://localhost:8080/tasks/076add48-84c4-47e2-98da-fbf832d4f204

PATCH http://localhost:8080/tasks/1550f311-ebc3-4298-8a47-af6367bd558c
Content-type:application/json

{
    "status":"IN_PROGRESS"
}
```