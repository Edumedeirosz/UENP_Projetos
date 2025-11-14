//Definição dos pinos de controle do motor
#define M1 9 // Pino_Velocidade 1º Motor (0 a 255) - Porta IN2 ponte H
#define M2 11 // Pino_Velocidade 2º Motor (0 a 255) - Porta IN4 ponte H
#define direcao1 8 // Pino_Direção do 1º Motor: Para frente / Para trás (HIGH ou LOW) - porta IN1 ponte H
#define direcao2 10 // Pino_Direção do 2º Motor: Para frente / Para trás (HIGH ou LOW) - porta IN3 ponte H

//Definição dos pinos dos sensores, baseando-se na placa do arduíno.
#define pin_S1 41
#define pin_S2 43
bool Sensor1 = 0;
bool Sensor2 = 0;

//Variável responsável por controlar a velocidade dos motores, podendo ser alterada de acordo com sua vontade.
int velocidade = 125;

void setup() {
  //Colocamos os pinos de controle dos motores como saída
  pinMode(M1, OUTPUT);
  pinMode(M2, OUTPUT);
  pinMode(direcao1, OUTPUT);
  pinMode(direcao2, OUTPUT);

  //Colocamos a direção inicial do motor como 0 (ambos os motores giram para frente)
  digitalWrite(direcao1, LOW);
  digitalWrite(direcao2, LOW);

  //Colocamos os pinos dos sensores como entrada
  pinMode(pin_S1, INPUT);
  pinMode(pin_S2, INPUT);
}

void loop() {
  //Colocamos o valor lido pelos sensores
  Sensor1 = digitalRead(pin_S1);
  Sensor2 = digitalRead(pin_S2);

  //Lógica de comportamento do carrinho.
  if((Sensor1 == 1) && (Sensor2 == 1)) { // Os 2 sensores detectam branco
    analogWrite(M1, velocidade);
    analogWrite(M2, velocidade);
  }
  else if((Sensor1 == 1) && (Sensor2 == 0)) { // Sensor1 preto, Sensor2 branco
    analogWrite(M1, 0);
    analogWrite(M2, velocidade);
  }
  else if((Sensor1 == 0) && (Sensor2 == 1)) { // Sensor1 branco, Sensor2 preto
    analogWrite(M1, velocidade);
    analogWrite(M2, 0);
  }
  else if ((Sensor1 == 0) && (Sensor1 == 0)) { // Ambos sensores detectam preto (opcional: parar, depende da escolha de lógica preferida).
    analogWrite(M1, velocidade);
    analogWrite(M2, velocidade);
  }
}