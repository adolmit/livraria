# livraria
Api criada para o gerenciamento e listagem dos dados de um livro

# Pasos
Deve rodar o script.sql ubicado na pasta resources, o script cria o banco de dados as tabelas e os dados
o banco de dados usado é o mysql.

Caso nao ter o banco de dados mysql pode criar um container

# Tecnologias
Criação da api foi feita com Java JDK 17, Spring Boot 3, Lombok, Swagger, JPA Data

# Documentação api
A documentação é encontrada no link:
http://localhost:8082/v1/livraria/swagger-ui/index.html

# Teste endpoint
Usar o postman
curl --location 'http://localhost:8082/v1/livraria/livros/1'