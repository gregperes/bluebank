# BlueBank

Projeto para testar meus conhecimentos de backend e frontend.

## Ferramentas utilizadas:

Django, Bootstrap, Heroku, Python3, SOLID, OOP, Testes unitarios (Criação dos models), Banco de Dados local para teste: SQLite, Banco de dados utilizado no heroku: PostgreSQL

- Link de acesso 

  - [Blue Bank Heroku](https://bluebankdaniel.herokuapp.com/)
  - [Blue Bank Heroku Index Alternative](https://bluebankdaniel.herokuapp.com/index/)

Esse segundo link é apenas uma tela home alternativa que eu criei

## Como rodar localmente (opcional):

- Instale [Python3](https://www.python.org/downloads/)
- Abra o projeto e instale as dependencias a partir do *requirements.txt*
- Abra a pasta BlueBank e rode -> *python3 manage.py makemigrations*
- Logo após rode -> *python3 manage.py migrate*
- Para rodar o servidor use -> *python3 manage.py runserver*
- Django usa a porta 8000 como padrão
- Caso queira usar outra porta faça -> *python3 manage.py runserver (outra porta)*

## Observações

- Toda conta criada tem como saldo padrão 650
- Uma conta não pode transferir para ela mesma
- Não posso transferir valores nulos ou negativos
- Código está comentado
- Talvez algumas das contas não estejam realmente com 650 por conta dos meus testes, mas você pode criar novas contas
- Modelo de valores:
  - CPF: 14 caracteres
  - Numero da conta: 10 caracteres
- Tentei simular a criação de conta como se fosse na vida real, a pessoa cria uma conta em uma agencia usando o nome da agencia, só depois recebe o cartão com o numero da agencia. Mas como é só para testes criei uma agencia padrão para criação de todas as contas.

## Dados no banco de dados: 

- Agencia 1 :
  - Nome: Frei Serafim
  - Numero da agencia: 1234

<br>

- Conta 1:
  - CPF: 111.111.111-11;
  - Numero da Agencia: 1234;
  - Numero da conta: 11111111-1

<br>

- Conta 2:
  - CPF: 222.222.222-22;
  - Numero da Agencia: 1234
  - Numero da conta: 22222222-2 

<br>

- Conta 3:
  - CPF: 123.456.789-12;
  - Numero da Agencia: 1234
  - Numero da conta: 12345678-9 





