---
# Curso-Java-Exeperience

---
## Sobre
Curso realizado pela ***Treina Recife***, onde desenvolvemos uma aplicação do zero usando ***Java*** com ***Spring Framework*** ,
metodologias de desenvolvimento como ***Scrum, GitHub, Trello, metodologia XP***, utilizando a programação em pares, adaptada pela Treina Recife
simulando um ambiente real de desenvolvimento de Software.



![Modelo Relacional](https://user-images.githubusercontent.com/83607914/204623535-ebdb4cc3-b166-4d73-9840-ebd835dbd5d6.png)

---
## Tecnologias utilizadas

- [Java](https://www.java.com/pt-BR/)
- [Spring Framework](https://spring.io/)
- [Maven](https://maven.apache.org/)
- [Mysql](https://www.mysql.com/)

---
## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências sejam corretamente fixadas:
```bash
Java 8
Mysql 
Maven  
```

---
## Preparando ambiente

É necessário a criação da base de dados relacionados no Mysql
```bash
CREATE DATABASE "treinabd"
```

---
## Como baixar o projeto

```bash
# Clonar repositorio
$ git clone https://github.com/alecxandy/curso-treina-recife
```
## Feito isso, acesse o projeto:

```bash
$ cd curso-treina-recife
```

## É preciso compilar o código e baixar as dependências do projeto:

```bash
$ mvn clean package
```

## Finalizado esse passo, vamos iniciar a aplicação:

```bash
$ mvn spring-boot:run
```

## Pronto. A aplicação está disponível em http://localhost:8080

```bash
$ Tomcat started on port(s): 8080 (http)
$ Started AppConfig in xxxx seconds (JVM running for xxxx)
```
## Acesse a documentação da Api

```bash
$ http://localhost:8080/swagger-ui/index.html
```

---
## Autores

#### Alexandre Gomes de Souza   
https://www.linkedin.com/in/alecxandy
#### Leonardo Nascimento de Santana
https://www.linkedin.com/in/leonardo-nascimento-a26739223/

