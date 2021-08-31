# Digital Innovation: Desafio Code Anywhere



#### Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot

[![Java CI with Maven](https://github.com/alexwedsday/api-rest-heroku/actions/workflows/maven.yml/badge.svg)](https://github.com/alexwedsday/api-rest-heroku/actions/workflows/maven.yml)


- Utilizei o projeto para fazer deploy no Heroku
- Utilizer o github action para validar o deploy
- Praticando o conceito REST



Para executar o projeto, digite o comando abaixo no terminal/cmd:

```
mvn spring-boot:run 
```



Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/people
```

  

Para testar os endpoints utilize o swagger:

```
 http://localhost:8080/swagger-ui.html
```



Links para teste no Heroku:

```
https://manager-people.herokuapp.com/api/v1/person
```

```
https://manager-people.herokuapp.com/swagger-ui.html
```



**Observações:**

Para fazer um post utilize um gerador de CPF, neste estudo testei a annotations **@Cpf** , link do gerador de cpf nas referências.



**Requisitos necessários:**

- [JDK 11](https://adoptopenjdk.net/)
- [GIT](https://git-scm.com/)



**Referências**

Para referências futuras, veja essa seção:

* [Oficial Documentação Apache Maven](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Guia de Referência do Plugin](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Springdoc OpenApi](https://springdoc.org/)
* [Gerador Cpf]([Gerador de CPF - 4Devs](https://www.4devs.com.br/gerador_de_cpf))









