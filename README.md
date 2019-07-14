# Exemplo de Aplicação REST com Spring - H2 - Swagger
A aplicação é um exemplo de CRUD.

* Execute a classe WebApiApplication;
* Para exibir a documentação com Swagger, no navegador digite http://localhost:8080/swagger-ui.html
* Se estiver usando o banco H2 em modo console http://localhost:8080/h2-console (jdbc:h2:mem:testdb)

## Endpoins:

##### REST Endpoint `/places` HTTP Method `GET` Description `Returns the list of places`
##### REST Endpoint `/places/{id}` HTTP Method `GET` Description `Retorna o objeto plece do {id}`
##### REST Endpoint `/places` HTTP Method `POST` Description `Cria um novo objeto do tipo place`
##### REST Endpoint `/places/{id}` HTTP Method `PUT` Description `Atualiza o objeto de [id]`
##### REST Endpoint `/places/{id}` HTTP Method `DELETE` Description `Deleta o objeto do tipo place do {id}`

## testing environment:

* https://sample-crud-api.herokuapp.com/{Endpoint}
* https://sample-crud-api.herokuapp.com/swagger-ui.html

## JSON:

* ##### Place Object:

      `[
      		{
        		"city": "string",
        		"createdAt": "string",
    	 		"id": 0,
    	 		"name": "string",
    	 		"slug": 0,
    	 		"state": "string",
    	 		"updatedAt": "2019-07-14T22:20:08.962Z"
       		}
       ]`