/*
  Blink
  Turns on an LED on for one second, then off for one second, repeatedly.
 
  This example code is in the public domain.
 */
 
// Pin 13 has an LED connected on most Arduino boards.
// give it a name:
int led = 12;
int led2 = 11;
int led3 = 10;
int led4 = 9;
int led5 = 8;
int led6 = 7;
int led7 = 6;
int led8 = 5;
int sound = 4;

void ledset(bool l1, bool l2, bool l3, bool l4, bool l5, bool l6, bool l7, bool l8)
{ 
  if(l1){digitalWrite(led, LOW);}else{digitalWrite(led, HIGH);}
  if(l2){digitalWrite(led2, LOW);}else{digitalWrite(led2, HIGH);}
  if(l3){digitalWrite(led3, LOW);}else{digitalWrite(led3, HIGH);}
  if(l4){digitalWrite(led4, LOW);}else{digitalWrite(led4, HIGH);}
  if(l5){digitalWrite(led5, LOW);}else{digitalWrite(led5, HIGH);}
  if(l6){digitalWrite(led6, LOW);}else{digitalWrite(led6, HIGH);} 
  if(l7){digitalWrite(led7, LOW);}else{digitalWrite(led7, HIGH);} 
  if(l8){digitalWrite(led8, LOW);}else{digitalWrite(led8, HIGH);} 
}

void number(int z){
  ledset(0,0,0,0,0,0,0,0);
  if(z == 8){ledset(1,1,1,1,1,1,1,1);}
  if(z == 0){ledset(1,1,1,1,0,1,1,1);}
  if(z == 1){ledset(1,1,1,0,0,0,0,0);}
  if(z == 2){ledset(1,0,1,1,1,1,0,1);}
  if(z == 3){ledset(1,1,1,1,1,1,0,0);}
  if(z == 4){ledset(1,1,1,0,1,0,1,0);}
  if(z == 5){ledset(0,1,1,1,1,1,1,0);}
  if(z == 6){ledset(0,1,1,1,1,1,1,1);}
  if(z == 7){ledset(1,1,1,1,0,0,0,0);}
  if(z == 9){ledset(1,1,1,1,1,1,1,0);}
}
//the setup routine runs once when you press reset:
void setup() {                
  // initialize the digital pin as an output.
  pinMode(led, OUTPUT);     
  pinMode(led2, OUTPUT);     
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);
  pinMode(led5, OUTPUT);
  pinMode(led6, OUTPUT);
  pinMode(led7, OUTPUT);
  pinMode(led8, OUTPUT); 
  pinMode(sound, OUTPUT);
} 
// the loop routine runs over and over again forever:
void loop() {
  number(0);
  delay(1000);
  number(1);
  delay(1000);
  number(2);
  delay(1000);
  number(3);
  delay(1000);
  number(4);
  delay(1000);
  number(5);
  delay(1000);
  number(6);
  delay(1000);
  number(7);
  delay(1000);
  number(8);
  delay(1000);
  number(9);
  delay(1000);
  for(int i = 0; i < 100; i++){
    digitalWrite(sound, HIGH);
    delay(1);
    digitalWrite(sound, LOW);
    delay(1);
  }
  
  
  
  
  
}
