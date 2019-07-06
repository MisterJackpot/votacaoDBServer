Sistema Almoço
==============

Requisitos de Ambiente
----------------------
### Compilar ###
* Apache Maven 3.6.1 ou maior
* Java jdk versão: 12.0.1 ou maior
* Apache Maven utilizando Java versão 12

### Executar ###
* Java versão 1.8.0_211 ou maior

Como Compilar
-------------

1. Executar o comando `mvn compile` dentro da pasta do projeto

Como Executar o Programa
------------------------

1. Executar o comando `mvn javafx:run` dentro da pasta do projeto

Como Executar os Teste
----------------------

1. Executar o comando `mvn test` dentro da pasta do projeto

Como Gerar os Executaveis
-------------------------

1. Executar o comando `mvn install` dentro da pasta do projeto

2. O Arquivo .jar e a pasta do Banco de Dados irão se encontrar na pasta "target/application"

Funcionamento
-------------

1. Ao executar o programa aparecerá uma tela com uma lista de usuarios.

2. Deve-se selecionar o usuário que ira votar e pressionar o botão de "Entrar"

3. A tela principal do sistema é carregada

4. No canto superior direito da tela pode se verificar o dia para que se está votando

5. Deve-se selecionar o restaurante na lista presente no centro da tela e pressionar o botão de "Votar"

6. Caso deseje-se verificar se a votação ja possui um resultado deve-se pressionaro o botão de "Resultados" no canto inferior direito da tela

7. Uma votação estará concluida assim que todos usuários cadastrados votem ou a data do sistema passe do 12:00

8. Para retornar para tela de entrada deve-se pressionar o botão de "Voltar" no canto superior esquerdo da tela

Destaques do Código
-------------------

* O sistema se utiliza de JavaFX FXML para realizar a parte de Front-end

* O projeto possui uma camada de vizualização, uma camada de negócio e uma camada de persistência

* O roteamento entre telas é realizado pela Classe "Roteador" para facilitar a adição de novas telas utilizando o Enum "Paginas"

* Ao entrar no sistema o usuario "Logado" fica salvo no Singleton "AuthSession" e ao voltar a tela inicial a sessão é invalidada

* Para realizar a formatação das datas utilizadas no programa foi criada a Classe "Formatador" com métodos estaticos

* Para simplificar a camada de controle do Front-end e separa-la da camada de negócios foi utilizado um Facade

* Para camada de persistência foi utilizado o Apache Derby (Banco Relacional) com seus arquivos salvos na pasta BD do projeto

O que pode se Melhorar
-----------------------

* Utilizar outra solução de SGDB mais escalavel e que não seja local

* Realizar uma estilização no Front-end para deixa-lo visualmente mais agradável

* Criar uma tela de cadastro de usuários e restaurantes

* Criação de algumas interfaces para modelar alguns padrões do sistema e diminuir o acoplamento do software

* Aumentar a coesão de algumas classes  