Documentação - Objetivo (Documentação feita apenas para demonstração)

1. Objetivo
   Teste sendo feito para evidenciar bugs ou problemas que afetariam um caso real onde um cliente poderia acabar tendo uma dor com possíveis situações na conta bancária.

2. Escopo
   
Testar a classe ContaBancária e afins.
- serão testados os métodos da classe ContaBancária, com o objetivo de evidenciar falhas ou regras de negócios faltantes para que o projeto funcione com mais segurança, como por exemplo, a funcionalidade de transferência, de depósito e saque.
- não serão testados casos extremamente específicos da classe, resultando em casos improváveis ou testes de carga e também integrações, já que não é possível no momento.
- serão realizados apenas testes unitários, com happy path e alguns casos de edge case.

3. O que esperar (aceite)
 - Que a transferência seja feita corretamente de uma conta para outra.
 - Que a criação de um usuário seja funcional.
 - Que a criação de um usuário exija um nome.
 - Que várias transferências mantenham a exatidão de valor.
 - Que não haja transferências negativas.
 - Que não haja saques ou depósitos negativos.
 - Que as mensagens de erros estejam funcionando corretamente e estejam claras.

4. Critérios
  4.1 - Entrada:
 - O ambiente deve estar acessível e seguro.
 - O ambiente está funcional para testes.
 - Dados usados para testes são apenas exemplos e não reais.
   4.2 - Saída:
 - Todos os testes estarão categorizados com prioridades e riscos.
 - Todos os defeitos encontrados devem ser registrados.
 - O relatório de testes deve ser aprovado pelas partes interessadas.

5. Caso de Suspensão
 - Se houver algum dano críico no sistema que impossibilite a criação/uso de testes, eles serão suspensos até que seja possível retomá-los.
 - Assim que que possível, serão retomados imediatamente.

6. Ambiente de Teste
 - Hardware: Notebook Lenovo, Windows 10.
 - Software: IDE Intellij Idea, Framework JUnit 5.

7. Dados de Teste
 - Serão utilizados dados criados apenas para uso demonstrativo, para investigação de falhas, criando diretamente da classe ContaBancária.
 - Valores aleatórios para quantidade monetária (apenas no caso específico de teste de arredondamento de valor quebrado de casas, que foi usado 100.7777777777)
 - Todos os objetos foram da classe ContaBancaria.

8. Riscos
 - Transferências negativas.
 - Depósitos negativos.
 - Saques maiores que a quantidade disponível de dinheiro.
 - Alteração de valor disponível na conta.
 - Transferência para a mesma conta.

9. Prioridades
 - P1: crítico.
 - P2: importante.
 - P3: secundário.


