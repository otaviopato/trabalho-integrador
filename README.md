# Trabalho Integrador

Desenvolvimento de um software web para uma escola de artes marciais utilizando Spring.

## Informações do Projeto
-As informações detalhadas e os requisitos essenciais deste projeto podem ser encontrados [neste arquivo PDF](trabalho-integrador/PROJECT-DETAILS.pdf). 
-Recomendamos a leitura atenta do documento para compreender plenamente o escopo e os objetivos do projeto. 
-O PDF fornecerá todas as diretrizes necessárias para o desenvolvimento bem-sucedido deste projeto.

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


## Adicionando uma nova secretária

Para adicionar uma nova secretária, você pode usar o seguinte comando `curl`:

<code>curl --location --request POST 'localhost:8080/secretaria/'
--header 'Content-Type: application/json'
--data-raw '{
"name": "Jonna",
"email": "jonna@hotmail.com" ,
"cpf": "010019121929",
"phone": "9489291828",
"address": "Rua Terra, 365",
"birthDate": "21-09-1980",
"password": "dificilsenha321"
}'</code>
