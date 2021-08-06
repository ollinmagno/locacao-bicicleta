## Sistema legado de locação de bicicletas desenvolvido em Java 🚀

![jdk](https://img.shields.io/badge/-JDK%201.8-green)
![jsf2.2](https://img.shields.io/badge/-JSF%202.2-green)
![primefaces-v8.0](https://img.shields.io/badge/-PRIMEFACES%208.0-blue)
![apachetomcat](https://img.shields.io/badge/-apache%20tomcat%20v8.0-yellowgreen)

<br>

### Projeto
Projeto desenvolvido com JAVA + JDBC + JSF + PRIMEFACES;

### Arquitetura do projeto
O padrão arquitetural adotado neste projeto é o **MVC (Model-View-Controller)**. 

### Requisitos de instalação
* JDK - versão 1.8 do Java
* Tomcat 8.0
* Mysql 8.0

### Banco de dados
O projeto foi configurado para trabalhar com o banco de dados **MySQL**. Utilize este arquivo para criar as tabelas e inserir os dados.

[locacao.sql](https://gist.github.com/ollinmagno/aa539516f97a839bcd4dbe0b46363f83)

*Atenção: A classe [ConnectionFactory](https://github.com/ollinmagno/locacao-bicicleta/blob/master/src/br/com/locacao/dao/ConnectionFactory.java) deve ser alterada conforme suas configurações.*


### Como usar
[Faça o download do projeto](https://github.com/ollinmagno/locacao-bicicleta/archive/refs/heads/master.zip) e importe na IDE de sua preferência;

Configure o projeto no apache Tomcat 8.0;

Acesso o endereço:

	http://localhost:8080/locacao-bicicleta/login.xhtml

### Bibliotecas utilizadas no projeto, link de referência 
* [all-themes-1.0.10](https://mvnrepository.com/artifact/org.primefaces.themes/all-themes/1.0.10)

* [mysql-connector-java-8.0.17](https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.17)

* [validation-api-1.0.0.GA](https://mvnrepository.com/artifact/javax.validation/validation-api/1.0.0.GA)

* [primefaces-8.0](https://mvnrepository.com/artifact/org.primefaces/primefaces/8.0)

* [dom4j-1.6.1](https://mvnrepository.com/artifact/dom4j/dom4j/1.6.1)

* [c3p0-0.9.5.4](https://mvnrepository.com/artifact/com.mchange/c3p0/0.9.5.4)

* [antlr-2.7.7](https://mvnrepository.com/artifact/antlr/antlr/2.7.7)

* [mchange-commons-java-0.2.16](https://mvnrepository.com/artifact/com.mchange/mchange-commons-java/0.2.16)

* [jboss-transaction-api_1.1_spec-1.0.0.Final](https://mvnrepository.com/artifact/org.jboss.spec.javax.transaction/jboss-transaction-api_1.1_spec/1.0.0.Final)

* [jboss-logging-3.1.0.GA](https://mvnrepository.com/artifact/org.jboss.logging/jboss-logging/3.1.0.GA)

* [javax.faces-2.2.13](https://mvnrepository.com/artifact/org.glassfish/javax.faces/2.2.13)

* [javassist-3.15.0-GA](https://mvnrepository.com/artifact/org.javassist/javassist/3.15.0-GA)
