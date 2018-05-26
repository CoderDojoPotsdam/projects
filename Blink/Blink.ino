/*
  Blink
  Turns on an LED on for one second, then off for one second, repeatedly.
 
  This example code is in the public domain.
 */
 
// Pin 13 has an LED connected on most Arduino boards.
// give it a name:
int led1 = 9;
int led2 = 10;
int lichtnormal;
int buzzer = 8;
// the setup routine runs once when you press reset:
void setup() {                
  // initialize the digital pin as an output.
  pinMode(led1, OUTPUT);    
  pinMode(led2, OUTPUT); 
  pinMode(A0, INPUT);
  lichtnormal=analogRead(A0);
  Serial.begin(9600);
  pinMode(buzzer, OUTPUT);
}

// the loop routine runs over and over again forever:
void loop() {
  digitalWrite(led1, LOW);   // turn the LED on (HIGH is the voltage level)
  digitalWrite(led2, LOW);   // turn the LED on (HIGH is the voltage level)
  if(random(400)==1){
    digitalWrite(led1, HIGH);    // turn the LED off by making the voltage LOW
    digitalWrite(led2, HIGH);    // turn the LED off by making the voltage LOW
    delay(100); 
  }  

    Serial.println(analogRead(A0));
    if(lichtnormal-analogRead(A0)>20){
      Serial.println("streicheln");
       tone(buzzer, 200);
    }
      else{
        noTone(buzzer);
      }
    
  delay(10);  
 

}  
