# Exemplos de Requisições
Para executar via REST Client no VSCode, selecione individualmente cada comando abaixo então, no MacOS utilize as teclas de atalho Command + Shift + P, então pesquise por Rest Client: Send Request, então pressione a tecla Enter para enviar a requisição.

```
POST http://localhost:8080/task
Content-type:application/json

{
    "title":"Teste"
}

GET http://localhost:8080/task

GET http://localhost:8080/task/1550f311-ebc3-4298-8a47-af6367bd558c

DELETE http://localhost:8080/task/076add48-84c4-47e2-98da-fbf832d4f204

PATCH http://localhost:8080/task/1550f311-ebc3-4298-8a47-af6367bd558c
Content-type:application/json

{
    "status":"IN_PROGRESS"
}
```