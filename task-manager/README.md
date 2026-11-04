# Exemplos de Requisições
Para executar via REST Client no VSCode, selecione individualmente cada comando abaixo então, no MacOS utilize as teclas de atalho Command + Shift + P, então pesquisa por Rest Client: Send Request, pressione Enter para enviar a requisição.

```
POST http://localhost:8080/task
Content-type:application/json

{
    "title":"Teste"
}

GET http://localhost:8080/task

GET http://localhost:8080/task/e654b910-0843-45a7-8935-4e5089cf9d50

DELETE http://localhost:8080/task/076add48-84c4-47e2-98da-fbf832d4f204
```