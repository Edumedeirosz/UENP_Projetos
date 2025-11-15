# Testes JUnit - ContaBancaria

Este projeto contém **testes unitários em Java usando JUnit 5** para a classe `ContaBancaria`. O foco é demonstrar boas práticas de testes automatizados em um projeto fictício.

## Estrutura do Projeto

src/
main/java/br/edu/exemplo/ContaBancaria.java
-
test/java/br/edu/exemplo/ContaBancariaTest.java
-

`ContaBancaria.java`: Classe com operações de conta bancária (depósito, saque, transferência).  
`ContaBancariaTest.java`: Testes unitários cobrindo os principais comportamentos da classe, podendo testar erros possíveis.

## Pré-requisitos

- Java JDK 11+  
- IntelliJ IDEA ou outra IDE compatível  
- Maven (opcional, para rodar via terminal)

## Caso queira usá-lo

# clonar o projeto
```git clone https://github.com/Edumedeirosz/UENP_Projetos.git```

# entrar na pasta
```cd TesteUnitario2```

# se estiver usando Maven, rodar os testes
```mvn test```

## Rodando os Testes

### No IntelliJ

1. Abra o projeto no IntelliJ.  
2. Clique com o botão direito em `ContaBancariaTest.java` e selecione **Run 'ContaBancariaTest'**.

### Via Linha de Comando (Maven)

mvn test

Os testes serão executados e o resultado aparecerá no terminal.

## Tecnologias

Java 11+  
JUnit 5
