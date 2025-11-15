# 📘 Documentação de Testes – ContaBancária

Documentação criada para demonstração e validação das regras de negócio da classe `ContaBancaria`.

---

## 1. Objetivo

Realizar testes para evidenciar bugs ou problemas que afetariam um caso real onde um cliente poderia ter dores com possíveis situações na conta bancária.

---

## 2. Escopo

Serão testados:
- Métodos da classe `ContaBancaria`.
- Funcionalidades como transferência, depósito e saque.
- Apenas testes unitários, incluindo happy path e alguns edge cases.

Não serão testados:
- Casos extremamente específicos.
- Testes de carga.
- Integrações externas.

---

## 3. O que Esperar (Aceite)

- Transferência correta entre contas.
- A criação de usuário deve ser funcional.
- A criação de usuário deve exigir um nome.
- Múltiplas transferências devem manter exatidão.
- Impedir transferências negativas.
- Impedir saques e depósitos negativos.
- Mensagens de erro claras e funcionais.

---

## 4. Critérios

### 4.1 Entrada
- Ambiente acessível e seguro.
- Ambiente funcional para testes.
- Dados usados apenas como exemplo.

### 4.2 Saída
- Testes categorizados por prioridade e risco.
- Todos os defeitos devem ser registrados.
- Relatório aprovado pelas partes interessadas.

---

## 5. Caso de Suspensão

- Se houver dano crítico impedindo testes, eles serão suspensos.
- Serão retomados assim que possível.

---

## 6. Ambiente de Teste

- **Hardware:** Notebook Lenovo  
- **SO:** Windows 10  
- **Software:** IntelliJ IDEA  
- **Framework:** JUnit 5 

---

## 7. Dados de Teste

- Dados criados apenas para uso demonstrativo.
- Valores aleatórios, como `100.7777777777` para validação decimal.
- Todos os objetos criados da classe `ContaBancaria`.

---

## 8. Riscos

- Transferências negativas.
- Depósitos negativos.
- Saques maiores que o saldo.
- Alteração incorreta de saldo.
- Transferência para a mesma conta.

---

## 9. Prioridades

- **P1:** Crítico  
- **P2:** Importante  
- **P3:** Secundário  

---

# Cenários de Teste

**Pré-condição:** —  

## CT-001 – Criar conta com nome válido
**Prioridade:** P1  
**Objetivo:** Verificar criação correta da conta  
**Passos:**  
1. Criar `ContaBancaria("João")`  
**Resultado Esperado:**  
- Titular = "João"  
- Saldo = 0  

---

## CT-002 – Depósito válido
**Prioridade:** P1  
**Objetivo:** Validar depósito simples  
**Passos:**  
1. Criar conta "Maria"  
2. Depositar 100.00  
**Resultado Esperado:**  
- Saldo = 100.00  

---

## CT-003 – Saque com saldo suficiente
**Prioridade:** P2
**Objetivo:** Verificar saque válido  
**Passos:**  
1. Criar conta "Pedro"  
2. Depositar 200.00  
3. Sacar 50.00  
**Resultado Esperado:**  
- Saldo = 150.00  

---

## CT-004 – Criar conta com titular inválido (string vazia)
**Prioridade:** P1  
**Objetivo:** Impedir criação de conta com nome vazio  
**Passos:**  
1. Tentar criar `ContaBancaria("")`  
**Resultado Esperado:**  
- Lançar `IllegalArgumentException`  

---

## CT-005 – Depósito adiciona corretamente o saldo
**Prioridade:** P2  
**Objetivo:** Garantir que saldo alto será validado. 
**Passos:**  
1. Criar conta "Eduardo Medeiros"  
2. Depositar 2006.00  
**Resultado Esperado:**  
- Saldo = 2006.00  

---

## CT-006 – Depósito negativo
**Prioridade:** P1  
**Objetivo:** Impedir depósito inválido  
**Passos:**  
1. Criar conta "Pedro"  
2. Depositar -17  
**Resultado Esperado:**  
- `IllegalArgumentException`

---

## CT-007 – Saque com saldo insuficiente
**Prioridade:** P1  
**Objetivo:** Impedir saque acima do saldo  
**Passos:**  
1. Criar conta "Eddy"  
2. Depositar 10  
3. Tentar sacar 20  
**Resultado Esperado:**  
- `IllegalStateException`  

---

## CT-008 – Transferência válida
**Prioridade:** P2  
**Objetivo:** Validar transferência entre contas  
**Passos:**  
1. Criar conta A "Eduardo"  
2. Criar conta B "Pedro"  
3. A deposita 1000  
4. A transfere 700 para B  
**Resultado Esperado:**  
- Conta A saldo = 300  
- Conta B saldo = 700  

---

## CT-009 – Transferência para a mesma conta
**Prioridade:** P1  
**Objetivo:** Impedir transferência para si mesmo  
**Passos:**  
1. Criar conta "João"  
2. Depositar 70  
3. Tentar transferir 60 para a própria conta  
**Resultado Esperado:**  
- `IllegalArgumentException`  

---

## CT-010 – Transferência inválida (valor maior que saldo)
**Prioridade:** P1  
**Objetivo:** Impedir transferência acima do saldo  
**Passos:**  
1. Criar Paulo  
2. Criar Pedro  
3. Paulo deposita 100  
4. Paulo tenta transferir 101  
**Resultado Esperado:**  
- `IllegalStateException`  

---

## CT-011 – Transferência inválida 2 (ainda insuficiente)
**Prioridade:** P3  
**Objetivo:** Teste redundante confirmando regra de saldo insuficiente  
**Passos:**  
1. Criar Paula  
2. Criar Maurício  
3. Paula deposita 100  
4. Tentar transferir 200  
**Resultado Esperado:**  
- `IllegalStateException`  

---

## CT-012 – Transferência com conta destino nula
**Prioridade:** P1  
**Objetivo:** Impedir transferência sem conta destino  
**Passos:**  
1. Criar conta "Miranda"  
2. Depositar 100  
3. Transferir para null  
**Resultado Esperado:**  
- `IllegalArgumentException`  

---

## CT-013 – Depósitos com escala decimal diferente
**Prioridade:** P3  
**Objetivo:** Validar precisão decimal do BigDecimal  
**Passos:**  
1. Criar conta "Pedro"  
2. Depositar 100.7777777777  
3. Depositar 2.19  
**Resultado Esperado:**  
- Saldo = 102.9677777777  

---

## CT-014 – Transferências encadeadas
**Prioridade:** P2  
**Objetivo:** Garantir consistência em transferências múltiplas  
**Passos:**  
1. Criar 4 contas: Pedro, Eduardo, Guilherme, Gustavo  
2. Pedro deposita 100  
3. Pedro → Eduardo (75)  
4. Eduardo → Guilherme (50)  
5. Guilherme → Gustavo (25)  
**Resultado Esperado:**  
- Pedro = 25  
- Eduardo = 25  
- Guilherme = 25  
- Gustavo = 25  

---

## CT-015 – Validação de mensagens de erro
**Prioridade:** P3  
**Objetivo:** Verificar exceções corretas em múltiplos casos  
**Casos Incluídos:**  
- Nome vazio → `IllegalArgumentException("Titular inválido")`  
- Saque acima do saldo → `IllegalStateException("Saldo insuficiente")`  
- Transferência destino null → `IllegalArgumentException("Conta de destino inválida")`  
- Transferência negativa → `IllegalArgumentException("Valor deve ser positivo")`  

---

## 📄 Casos de Teste – ContaBancaria

| ID   | Descrição                                      | Entrada                                                                 | Resultado Esperado                                       | Prioridade | Obtido                                               | Status     |
|------|------------------------------------------------|-------------------------------------------------------------------------|-----------------------------------------------------------|------------|-------------------------------------------------------|------------|
| CT01 | Criar conta com titular válido                 | titular="João"                                                          | Conta criada, saldo=0                                     | P1         | Conta criada, saldo=0                                 | Aprovado   |
| CT02 | Criar conta com titular inválido               | titular=""                                                              | IllegalArgumentException                                  | P1         | IllegalArgumentException                              | Aprovado   |
| CT03 | Depósito válido                                | titular="Maria", depósito=100.00                                        | saldo=100.00                                              | P1         | saldo=100.00                                          | Aprovado   |
| CT04 | Saque com saldo suficiente                     | saldo inicial=200, saque=50                                             | saldo=150                                                 | P1         | saldo=150                                             | Aprovado   |
| CT05 | Depósito válido (valor alto)                   | titular="Eduardo Medeiros", depósito=2006.00                            | saldo=2006.00                                             | P1         | saldo=2006.00                                         | Aprovado   |
| CT06 | Depósito negativo                              | depósito=-17                                                            | IllegalArgumentException                                  | P1         | IllegalArgumentException                              | Aprovado   |
| CT07 | Saque acima do saldo                           | saldo=10, saque=20                                                      | IllegalStateException                                     | P1         | IllegalStateException                                 | Aprovado   |
| CT08 | Transferência válida                           | origem=1000 → 700 destino                                               | origem=300, destino=700                                   | P1         | origem=300, destino=700                               | Aprovado   |
| CT09 | Transferência para mesma conta (erro)          | conta.transferir(conta, 60)                                             | IllegalArgumentException                                  | P1         | IllegalArgumentException                              | Reprovado   |
| CT10 | Transferência com saldo insuficiente           | origem=100, valor=101                                                   | IllegalStateException                                     | P1         | IllegalStateException                                 | Aprovado   |
| CT11 | Transferência com saldo insuficiente (caso 2)  | origem=100, valor=200                                                   | IllegalStateException                                     | P1         | IllegalStateException                                 | Aprovado   |
| CT12 | Transferência com destino nulo                 | destino=null, valor=100                                                 | IllegalArgumentException                                  | P1         | IllegalArgumentException                              | Aprovado   |
| CT13 | Depósitos com escalas decimais diferentes      | 100.7777777777 + 2.19                                                   | saldo=102.9677777777                                      | P1         | saldo=102.9677777777                                  | Aprovado   |
| CT14 | Transferências encadeadas                      | 100 → 75 → 50 → 25                                                      | 25 em todas as contas ao final                            | P1         | Todas as contas com saldo=25                          | Aprovado   |
| CT15 | Mensagens de erro agrupadas                    | vários cenários de exceção                                              | Todas devem lançar exceções corretas                     | P1         | Todas exceções lançadas corretamente                  | Aprovado   |

---

# Relatório de Bugs

- **Bug encontrado:** Sistema permite transferência para a mesma conta  
- **Caso:** CT09  
- **Severidade:** Alta  
- **Status:** Aberto  

---

# 📊 Sumário Final

- **Total de Testes:** 15  
- **Passaram:** 14  
- **Falharam:** 1  
- **Bugs:** 1  

**Conclusão:** Sistema estável, porém com uma vulnerabilidade importante (transferência para a própria conta). Recomenda-se adicionar validação extra na lógica.

