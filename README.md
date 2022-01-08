# loan-api

## Sobre a aplicação

O código disponibilizado aqui neste repositório tem como objetivo cumprir o desafio proposto para o processo seletivo TQI Evolution.

Desenvolvi uma API REST capaz de cadastrar clientes, realizar login e fazer empréstimo, baseado nos critérios presentes no enunciado.

#### Cliente

Primeiramente, é necessário realizar o cadastro de um cliente informando: _nome, e-mail, CPF, RG, engereço completo, renda e a senha_.
<p>Além disso, é possível listar o cliente pelo id, bem como listar todos os clientes para conferir os que já estão cadastrados.

#### Login

Antes de poder acessar as funcionalidades de empréstimo, é preciso fazer o login. Mediante _e-mail e senha_ de usuário já cadastrado, o status pode ser alterado para logado ou não.

#### Empréstimos

Por fim, caso o cliente esteja logado, é possível fazer um empréstimo informando: _valor do empréstimo, data do primeiro pagamento e parcelas_. 
<p>O pagamento deve ser feito até três meses depois do dia do empréstimo e o número máximo de parcelas é 60.
<p>O cliente logado também pode listar todos os empréstimos e detalhar algum empréstimo em específico. 

## Funcionalidades

### Clientes:
- [X] Cadastrar cliente 
- [X] Recuperar cliente por id

### Login:
- [X] Login
- [X] Logoff

### Empréstimo:
- [X] Fazer empréstimo
- [X] Listar empréstimos de cliente
- [X] Detalhar empréstimo

## Tecnologias e ferramentas utilizadas

 - Java 11
 - IntelliJ
 - Maven
 - Lombok
 - H2 Database Engine
 - MapStruct
 - Spring Boot

## Autor
---

<img src="https://avatars.githubusercontent.com/u/88780343?v=4" width="150px;" alt=""/>
<br />

Feito por Pablo Souza.<br />
Entre em contato:

[![Linkedin Badge](https://img.shields.io/badge/@szpbl-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/szpbl/) 
[![Twitter Badge](https://img.shields.io/badge/@szbpl-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/szpbl)
[![Gmail Badge](https://img.shields.io/badge/oliveirasouzapablo@gmail.com-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:oliveirasouzapablo@gmail.com)
