# Treinamento-Java

## Descricao
Projeto desenvolvido para aprendizado e aplicacao dos conceitos de Arquitetura em Camadas e TDD (Test Driven Development).

#
## Stack

### IDE
<img alt="Java" src="https://cdn.icon-icons.com/icons2/1381/PNG/512/eclipse_94656.png" height="20" wight="20"/> Eclipse

### Framework
<img alt="Java" src="https://avatars.githubusercontent.com/u/874086?s=200&v=4" height="20" wight="20"/> JUnit

### Gerenciador de dependencias
<img alt="Apache maven" src="https://cdn.icon-icons.com/icons2/2107/PNG/512/file_type_maven_icon_130397.png" height="20" wight="20"/> Maven

### Linguagem de Programacao
<img alt="Java" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="20" wight="20"/> Java

#
## Diagrama UML de classes

<p align="center">
    <img src="imgs/Cont Model UML diagram.png"><br>
    figura 1 - diagrama UML de classes.
</p>

#
## Schema de validacao de dados
As validacoes aplicadas sob as classes de dominio (model) estao de acordo com o seguinte schema.

<p align="center">
    <img src="imgs/regras-validacao.png"><br>
    figura 2 - schema de validacoes.
</p>

- Validacoes Uteis: metodos generalizados para validacoes de um unico aspecto do dado fornecido, como exemplo a validacao da quantidade de caracteres em um dado fornecido.

- Validacoes especificadas: implementam as validacoes uteis para construir validacoes especializadas, exemplo para a validacao de cpf e necessario utilizar as seguintes validacoes genericas: validar se o dado nao e nulo, quantidade de caracteres, aplicar o algoritimo de modulo 11. deste modo a validacao especializada para cpf e construida a partir das validacoes genericas.

#
## Object Mother design pattern

[Object Mother](https://martinfowler.com/bliki/ObjectMother.html) e um padrao de projeto apresentado por Martin Fowler em [martinFowlder.com](https://martinfowler.com/) para aplicacao em testes unitarios, consiste em emcapsular os dados necessarios para os testes em classes que possuem a finalidade de distribuir os dados para os testes que os necessitam..

<p align="center">
    <img src="imgs/Contmatic Object Mother Relation Model Testes UML class.png"><br>
    figura 3 - Relacionamentos entre as classes Object Mother do projeto.
</p>

<p align="center">
    <img src="imgs/Contmatic Object Mother e classes de Testes Model Testes UML class.png"><br>
    figura 4 - Relacionamentos entre as classes Object Mother e Classes de teste do projeto.
</p>












