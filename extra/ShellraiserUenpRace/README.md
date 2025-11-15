# Carrinho Controlado por Sensores - Arduino

## Descrição do Projeto
Este projeto consiste em um carrinho controlado com sensores de linha, desenvolvido com Arduino IDE. O carrinho utiliza dois motores controlados por ponte H e sensores que detectam linhas no percurso, permitindo que ele siga a rota corretamente, inclusive em cruzamentos.

O projeto foi realizado em equipe e conquistou **2º lugar em uma competição acadêmica**, o que demonstrou precisão na lógica de controle e implementação física.
- Por Eduardo, João Pedro, Marcos e Paulo.

## O objetivo foi
- Criar um carrinho que segue linhas automaticamente utilizando sensores.
- Implementar controle de motores com ponte H para velocidade (a direção dependia do motor parar ou não).
- Aprender a programar e integrar sensores e motores com Arduino sem experiência anterior. 

## Funcionamento
- O carrinho possui **dois sensores** que detectam o contraste (branco ou preto).  
- Com base na leitura dos sensores, os motores ajustam a velocidade:
  - **Os dois sensores no branco:** carrinho anda normalmente.  
  - **Sensor1 preto, Sensor2 branco:** o motor 1 para, motor 2 segue, virando o carrinho.  
  - **Sensor1 branco, Sensor2 preto:** o motor 1 segue, motor 2 para, virando o carrinho.  
  - **Ambos sensores no preto:** carrinho continua andando, útil para cruzamentos.  

## Pinos do Arduino
| Função                  | Pino Arduino | Observação |
|-------------------------|-------------|------------|
| Motor 1 - Velocidade     | 9           | Porta IN2 da ponte H |
| Motor 2 - Velocidade     | 11          | Porta IN4 da ponte H |
| Motor 1 - Direção        | 8           | Para frente/para trás (HIGH/LOW) |
| Motor 2 - Direção        | 10          | Para frente/para trás (HIGH/LOW) |
| Sensor 1                 | 41          | Leitura digital (0 ou 1) |
| Sensor 2                 | 43          | Leitura digital (0 ou 1) |

(AS PORTAS DEPENDEM DE ONDE VOCÊ COLOCA CADA PINO)

## Variáveis importantes
- `velocidade` → controla a velocidade dos motores (0 a 255).  
- `Sensor1`, `Sensor2` → armazenam o estado atual dos sensores (true/false).  

## Estrutura do Código
1. **Setup**
   - Define pinos como entrada ou saída.  
   - Inicializa direção dos motores.  
2. **Loop**
   - Lê os sensores.  
   - Aplica a lógica de movimento conforme os estados dos sensores.  

## Como Usar

1. Abra o **Arduino IDE**.  
2. Conecte a placa Arduino ao computador via cabo USB.  
3. Abra o arquivo `.ino` do projeto.  
4. Certifique-se de que os pinos do código estão iguais à sua montagem física, veja na placa do seu arduíno, os números de cada pino:
   - M1, M2 → velocidade dos motores  
   - direcao1, direcao2 → direção dos motores  
   - pin_S1, pin_S2 → sensores de linha  
5. Configure a velocidade desejada na variável `velocidade` (0 a 255).  
6. Clique em **Upload** no Arduino IDE para transferir o código para a placa.  
7. Coloque o carrinho na pista e teste os sensores.  

## Observações
- O código foi feito no **Arduino IDE** e transferido diretamente para a placa Arduino.  
- O comportamento do carrinho permite **seguir linhas e cruzamentos de forma confiável**, garantindo segundo lugar em uma competição acadêmica.

---

![Medalha](https://i.imgur.com/lxRXaV6.jpeg)
