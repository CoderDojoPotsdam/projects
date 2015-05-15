/*
  Blink
  Turns on an LED on for one second, then off for one second, repeatedly.
 
  This example code is in the public domain.
 */
 
// Pin 13 has an LED connected on most Arduino boards.
// give it a name:
int led = 13;
int led2 = 7;
int led3 = 4;
int button = 2;
int buttonState = 0;
// the setup routine runs once when you press reset:
void setup() {                
  // initialize the digital pin as an output.
  pinMode(led, OUTPUT); 
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT); 
  pinMode(button, INPUT);
}

// the loop routine runs over and over again forever:
void loop() {
  
  buttonState = digitalRead(button);
  
  if (buttonState != HIGH) {
        digitalWrite(led, HIGH);   // turn the LED on (HIGH is the voltage level)
        delay(1000);               // wait for a second
        digitalWrite(led, LOW);    // turn the LED off by making the voltage LOW
        delay(1000);
      
      digitalWrite(led2, HIGH);
        delay(1000);
        digitalWrite(led2, LOW);
        delay(1000);
       
       digitalWrite(led3, HIGH);
       delay(1000);
       digitalWrite(led3, LOW);
       delay(1000);
  }
}
