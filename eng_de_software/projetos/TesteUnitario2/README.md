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

| ID     | Descrição                                                | Entrada                                                                 | Resultado Esperado                                  | Prioridade | Obtido | Status |
|--------|-----------------------------------------------------------|-------------------------------------------------------------------------|------------------------------------------------------|------------|--------|--------|
| CT-001 | Criar conta com titular válido                            | titular="Eduardo"                                                      | Conta criada, saldo = 0                              | P1         |        |        |
| CT-002 | Criar conta com titular inválido (string vazia)           | titular=""                                                             | IllegalArgumentException                             | P1         |        |        |
| CT-003 | Criar conta com titular nulo                              | titular = null                                                         | IllegalArgumentException                             | P1         |        |        |
| CT-004 | Depósito válido                                           | depósito = 100                                                         | saldo = 100                                          | P2         |        |        |
| CT-005 | Depósito zero                                             | depósito = 0                                                           | IllegalArgumentException                             | P1         |        |        |
| CT-006 | Depósito negativo                                         | depósito = -50                                                         | IllegalArgumentException                             | P1         |        |        |
| CT-007 | Saque válido                                              | saldo inicial 200, saque = 50                                         | saldo final = 150                                    | P2         |        |        |
| CT-008 | Saque acima do saldo                                      | saldo inicial 20, saque = 50                                          | IllegalStateException                                | P1         |        |        |
| CT-009 | Saque zero                                                | saque = 0                                                              | IllegalArgumentException                             | P1         |        |        |
| CT-010 | Saque negativo                                            | saque = -10                                                            | IllegalArgumentException                             | P1         |        |        |
| CT-011 | Transferência válida                                      | origem = 300, destino = 0, valor = 100                                | origem = 200, destino = 100                          | P2         |        |        |
| CT-012 | Transferência com destino nulo                            | contaDestino = null                                                    | IllegalArgumentException                             | P1         |        |        |
| CT-013 | Transferência maior que saldo                             | origem = 10, valor = 100                                               | IllegalStateException                                | P1         |        |        |
| CT-014 | Transferência zero                                        | valor = 0                                                              | IllegalArgumentException                             | P1         |        |        |
| CT-015 | Transferência negativa                                    | valor = -20                                                            | IllegalArgumentException                             | P1         |        |        |
| CT-016 | Transferência para a própria conta *(BUG encontrado)*     | destino = mesma conta                                                  | IllegalArgumentException (esperado — falha atual)    | P1         |        |        |
| CT-017 | Precisão decimal em depósitos                             | depósitos: 100.7777777777 e 2.19                                       | saldo = 102.9677777777                               | P3         |        |        |
| CT-018 | Transferências encadeadas                                 | 4 contas → transferências sucessivas                                  | saldo final = 25 em todas as contas                  | P2         |        |        |
| CT-019 | Mensagens de erro específicas                             | múltiplos erros propositalmente causados                              | exceções corretas para cada regra                    | P3         |        |        |

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

