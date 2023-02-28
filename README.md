# Trabalho Integrador

Desenvolvimento de um software web para uma escola de artes marciais utilizando Spring.

## Tecnologias utilizadas

- Java 17
- Maven
- Postgres

## Configurando o banco de dados

- Configure suas informações de banco no arquivo application.properties, localizado em src/main/resources.
- Passe o nome do banco de dados e a senha no arquivo application.properties.

## Como rodar o projeto

### CLI

- Abra o terminal na pasta raiz do projeto.
- Rode o comando `mvn clean install`.
- Rode o comando `mvn spring-boot:run`.

### IDE

- Importe o projeto na sua IDE favorita.


## Adicionando um novo aluno

Para adicionar um novo aluno, você pode usar o seguinte comando `curl`:

<code>curl --location --request POST 'localhost:8080/aluno/'
--header 'Content-Type: application/json'
--data-raw '{
"name": "Berkley",
"email": "berkley@hotmail.com" ,
"cpf": "019291219010",
"phone": "4892829189",
"address": "Rua Quinta Sexta, 122",
"birthDate": "29-11-1980",
"matricula": "23233113"
}'</code>


## Adicionando um novo professor

Para adicionar um novo professor, você pode usar o seguinte comando `curl`:

<code>curl --location --request POST 'localhost:8080/professor/'
--header 'Content-Type: application/json'
--data-raw '{
"name": "Johnson",
"email": "johnson@hotmail.com" ,
"cpf": "121901001929",
"phone": "2918948928",
"address": "Rua Johnson & Johnson, 88",
"birthDate": "29-11-1980",
"password": "senhadificil321"
}'</code>

## Adicionando uma nova aula

Para adicionar uma nova aula, você pode usar o seguinte comando `curl`:

<code>curl --location --request POST 'localhost:8080/aulas/'
--header 'Content-Type: application/json'
--data-raw '{
"name": "Aula 18",
}'</code>

## Adicionando uma nova turma

Para adicionar uma nova turma, você pode usar o seguinte comando `curl`:

<code>curl --location --request POST 'localhost:8080/turma/'
--header 'Content-Type: application/json'
--data-raw '{
"name": "Johnson",
"data": "11/11/1980",
"horas": "2011-01-01 00:00:00",
"professor_id": 1,
"aula_id": 2
}'</code>

