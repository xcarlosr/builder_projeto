# MVP Client com Angular + Spring Boot + MySql
O projeto utiliza o docker composer para subir as aplicações.

## sb-client: Aplicação que compõem o back-end da solução.
  - Utilizado o consceito de DDD (Domain-driven Design) ao implementar, separa o projeto em camadas (Controllers, Services, Models e Repositorys) de acordo com suas responsabilidades.
  - Possui um o aquivo **/collection/API - Client.postman_collection.json** onde pode ser importado no posmtman para facilitar os teste da API REST.
  - A pasta **mysql** é referenciada pelo docker compose para manter os do mysql quando precisar reiniciar a aplicação.
  - Ao inicianr a plicação é possivel acessar o Swagger: http://localhost:8080/sb-client/swagger-ui/ e validar a API REST.
  - Nos teste foi utilizado o **Junit** com o **Mockito**.

## ft-client: Aplicação que compõem o front-end da solução.
  - Possui uma tela com paginação do resultado e podemos pesquisar, adicionar, editar e deletar os clientes na aplicação.

## Docker compose
  - Ao baixar a aplicação localmente, no diretorio raiz tem o arquivo **docker-compose.yml**, executar no prompt de comando para realizar o build e subir as aplicações: 
  **docker compose up --build --force-recreate -d** e para stopar as aplicações: **docker compose stop**
  - Acessando a aplicação localmente: http://localhost/client/
  
## Heroku aplicação web Angular
  - Disponibilizado para teste no heroku para quem não tenha o docker instalado, pode acessar a aplicação em:
  https://app-client-web.herokuapp.com/client, lembrando que demoram um pouco para o heroku subir as instancias.


# Imags do proejto

## Swagger API REST

![Screenshot](/sb-client/imgs/swagger-api-rest)

## Postman API REST

![Screenshot](/sb-client/imgs/postman-api)

![Screenshot](/sb-client/imgs/postman-api-resposta)

## Heroku - Angular

![Screenshot](/sb-client/imgs/front-end-angular)
