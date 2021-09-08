# MVP Client com Angular + Spring Boot + MySql
O projeto utiliza o docker composer para subir as aplicações.

## sb-client: Integra o back-end da solução.
  - Utilizado o consceito de DDD (Domain-driven Design) ao implementar, separa o projeto em camadas (Controllers, Services, Models e Repositorys) de acordo com suas responsabilidades.
  - Possui um o aquivo `/collection/API - Client.postman_collection.json` onde pode ser importado no posmtman para facilitar os teste da API REST.
  - A pasta *mysql* é referenciada pelo docker compose para manter os do mysql quando precisar reiniciar a aplicação.
  - Ao inicianr a plicação é possivel acessar o Swagger: http://localhost:8080/sb-client/swagger-ui/ e validar a API REST.
  - Nos teste foi utilizado o *Junit* com o *Mockito*.

## ft-client: Integra o front-end da solução.
  - Possui uma tela principal com paginação dos dados que podemos pesquisar (por nome, email e idade), adicionar, editar e deletar os clientes na aplicação.

## Docker compose
  - Fazer o clone ou baixar a aplicação, no diretorio raiz tem o arquivo *docker-compose.yml*, no prompt o comando, executar
  `docker compose up --build --force-recreate -d` para realizar o build e subir as aplicações e para stopar as aplicações `docker compose stop`.
  - Para acessar a aplicação localmente: http://localhost/client/
  
## Heroku aplicação web Angular
  - Disponibilizado para teste no heroku para quem não tenha o docker instalado, podendo acessar a aplicação para o front-end:
  https://app-client-web.herokuapp.com/client, back-end: https://client-back.herokuapp.com/api/v1/client
  - Lembrando que demoram um pouco para o heroku subir as instancias.

# Swagger API REST

![alt tag](https://github.com/xcarlosr/builder_projeto/blob/main/sb-client/imgs/swagger_api_rest.PNG?raw=true)

# Postman API REST

![alt tag](https://github.com/xcarlosr/builder_projeto/blob/main/sb-client/imgs/postman_api.PNG?raw=true)

![alt tag](https://github.com/xcarlosr/builder_projeto/blob/main/sb-client/imgs/postman_api_resposta.PNG?raw=true)

# Heroku - Angular

![alt tag](https://github.com/xcarlosr/builder_projeto/blob/main/sb-client/imgs/front_end_angular.PNG?raw=true)
