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

Cenários de Teste.
CT-001 – Criar conta com nome válido

Prioridade: P1

Objetivo: Verificar criação correta da conta
Pré-condição: —
Passos:

Criar ContaBancaria("João")

Resultado Esperado:

Titular = "João"

Saldo = 0

CT-002 – Depósito válido

Prioridade: P2

Objetivo: Validar depósito simples
Passos:

Criar conta "Maria"

Depositar 100.00

Resultado Esperado:

saldo = 100.00

CT-003 – Saque com saldo suficiente

Prioridade: P2

Objetivo: Verificar saque válido
Passos:

Criar conta "Pedro"

Depositar 200.00

Sacar 50.00

Resultado Esperado:

saldo = 150.00

CT-004 – Criar conta com titular inválido (string vazia)

Prioridade: P1

Objetivo: Impedir criação de conta com nome vazio
Passos:

Tentar criar ContaBancaria("")

Resultado Esperado:

Lançar IllegalArgumentException

CT-005 – Depósito adiciona corretamente o saldo

Prioridade: P2

Objetivo: Garantir operação matemática correta
Passos:

Criar conta "Eduardo Medeiros"

Depositar 2006.00

Resultado Esperado:

saldo = 2006.00

CT-006 – Depósito negativo

Prioridade: P1

Objetivo: Impedir depósito inválido
Passos:

Criar conta "Pedro"

Depositar -17

Resultado Esperado:

IllegalArgumentException

CT-007 – Saque com saldo insuficiente

Prioridade: P1

Objetivo: Impedir saque acima do saldo
Passos:

Criar conta "Eddy"

Depositar 10

Tentar sacar 20

Resultado Esperado:

IllegalStateException

CT-008 – Transferência válida

Prioridade: P2

Objetivo: Validar transferência entre contas
Passos:

Criar conta A "Eduardo"

Criar conta B "Pedro"

A deposita 1000

A transfere 700 para B

Resultado Esperado:

Conta A saldo = 300

Conta B saldo = 700

CT-009 – Transferência para a mesma conta

Prioridade: P1

Objetivo: Impedir transferência para si mesmo
Passos:

Criar conta "João"

Depositar 70

Tentar transferir 60 para a própria conta

Resultado Esperado:

IllegalArgumentException

CT-010 – Transferência inválida (valor maior que saldo)

Prioridade: P1

Objetivo: Impedir transferência acima do saldo
Passos:

Criar Paulo

Criar Pedro

Paulo deposita 100

Paulo tenta transferir 101

Resultado Esperado:

IllegalStateException

CT-011 – Transferência inválida 2 (ainda insuficiente)

Prioridade: P3

Objetivo: Teste redundante confirmando regra de saldo insuficiente
Passos:

Criar Paula

Criar Maurício

Paula deposita 100

Tentar transferir 200

Resultado Esperado:

IllegalStateException

CT-012 – Transferência com conta destino nula

Prioridade: P1

Objetivo: Impedir transferência sem conta destino
Passos:

Criar conta "Miranda"

Depositar 100

Transferir para null

Resultado Esperado:

IllegalArgumentException

CT-013 – Depósitos com escala decimal diferente

Prioridade: P3

Objetivo: Validar precisão decimal do BigDecimal
Passos:

Criar conta "Pedro"

Depositar 100.7777777777

Depositar 2.19

Resultado Esperado:

saldo = 102.9677777777

CT-014 – Transferências encadeadas

Prioridade: P2

Objetivo: Garantir consistência em transferências múltiplas
Passos:

Criar 4 contas: Pedro, Eduardo, Guilherme, Gustavo

Pedro deposita 100

Pedro → Eduardo (75)

Eduardo → Guilherme (50)

Guilherme → Gustavo (25)

Resultado Esperado:

Pedro = 25

Eduardo = 25

Guilherme = 25

Gustavo = 25

CT-015 – Validação de mensagens de erro

Prioridade: P3

Objetivo: Verificar se as exceções são lançadas corretamente em múltiplos casos
Casos incluídos:

Nome vazio → IllegalArgumentException ("Titular inválido")

Saque acima do saldo → IllegalStateException ("Saldo insuficiente")

Transferência destino null → IllegalArgumentException ("Conta de destino inválida")

Transferência negativa → IllegalArgumentException ("Valor deve ser positivo")

# Casos de Teste

## Casos de Teste – ContaBancaria

| ID  | O que está testando                               | Entrada                                                                 | Resultado Esperado                                   | Prioridade | Resultado Obtido | Status |
|-----|----------------------------------------------------|-------------------------------------------------------------------------|-------------------------------------------------------|------------|------------------|--------|
| CT01 | Criar conta com titular válido                    | titular = "Eduardo"                                                     | Conta criada com saldo = 0                            | Alta       |                  |        |
| CT02 | Criar conta com titular inválido                  | titular = ""                                                            | Lançar IllegalArgumentException                       | Alta       |                  |        |
| CT03 | Criar conta com titular nulo                      | titular = null                                                          | Lançar IllegalArgumentException                       | Alta       |                  |        |
| CT04 | Depositar valor válido                            | saldo=0, depósito=100                                                   | saldo final = 100                                      | Alta       |                  |        |
| CT05 | Depositar valor zero                              | depósito = 0                                                            | Lançar IllegalArgumentException                       | Alta       |                  |        |
| CT06 | Depositar valor negativo                          | depósito = -50                                                          | Lançar IllegalArgumentException                       | Alta       |                  |        |
| CT07 | Sacar valor com saldo suficiente                  | saldo=200, saque=50                                                     | saldo final = 150                                      | Alta       |                  |        |
| CT08 | Sacar valor maior que o saldo                     | saldo=20, saque=50                                                      | Lançar IllegalStateException                          | Alta       |                  |        |
| CT09 | Sacar valor zero                                  | saque=0                                                                 | Lançar IllegalArgumentException                       | Alta       |                  |        |
| CT10 | Sacar valor negativo                              | saque=-10                                                               | Lançar IllegalArgumentException                       | Alta       |                  |        |
| CT11 | Transferir com sucesso                            | origem=300, destino=0, valor=100                                        | origem=200, destino=100                                | Alta       |                  |        |
| CT12 | Transferir para conta destino nula                | destino=null                                                            | Lançar IllegalArgumentException                       | Média      |                  |        |
| CT13 | Transferir valor maior que o saldo                | origem=10, valor=100                                                    | Lançar IllegalStateException                          | Alta       |                  |        |
| CT14 | Transferir valor zero                             | valor=0                                                                 | Lançar IllegalArgumentException                       | Alta       |                  |        |
| CT15 | Transferir valor negativo                         | valor=-20                                                               | Lançar IllegalArgumentException                       | Alta       |                  |        |

# Relatório de Bugs

- Bug encontrado: Regra de negócio permite transferência para a mesma conta.
Caso relacionado: CT09
Severidade: Alta
Status: Aberto

# Sumário

Total de Testes: 15
Passaram: 14
Falharam: 1
Bugs: 1
Conclusão: estável, com um bug inesperado. Fraqueza na regra de negócio, se possível adicionar outra condição ou algum método, como possibilidade transferir para a conta corrente por exemplo, mas não para a exata mesma conta.


