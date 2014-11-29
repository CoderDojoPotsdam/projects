/*
  Blink
  Turns on an LED on for one second, then off for one second, repeatedly.
 
  This example code is in the public domain.
 */
 
// Pin 5 // Pin 5 has an LED connected on most Arduino boards.
// give it a name:
int led = 5;
int led2 = 3;
int led3 = 7;
int led4 = 8;
int led4gnd = 9;

// the setup routine runs once when you press reset:
void setup() {                
  // initialize the digital pin as an output.
  pinMode(led, OUTPUT);     
                
  // initialize the digital pin as an output.
  pinMode(led2, OUTPUT);
  
  // initialize the digital pin as an output.
  pinMode(led3, OUTPUT); 
  
  // initialize the digital pin as an output.
  pinMode(led4, OUTPUT);
  pinMode(led4gnd, OUTPUT);  
}

// the loop routine runs over and over again forever:
void loop() {
  digitalWrite(led4gnd, LOW);
   digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1);               // wait for a second
  digitalWrite(led, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(5999);  
  delay(1);               // wait for a second
  digitalWrite(led, LOW);    // turn the LED off by making the voltage LOW
  delay(0) ;               // wait for a second
  digitalWrite(led2, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(5990); 
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(11);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(11);                        // wait for a second
  digitalWrite(led2, LOW);    // turn the LED off by making the voltage LOW
  delay(0);
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(11);       
  digitalWrite(led3, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(50);  
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               //                // wait for a second
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(80);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               // digitalWrite(led3, LOW);    // turn the LED off by making the voltage LOW
  delay(500);              // wait for a second
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               //                // wait for a second
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(80);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               // digitalWrite(led3, LOW);    // turn the LED off by making the voltage LOW
  delay(500);  
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               //                // wait for a second
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(80);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               // digitalWrite(led3, LOW);    // turn the LED off by making the voltage LOW
  delay(500);  
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               //                // wait for a second
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(80);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               // digitalWrite(led3, LOW);    // turn the LED off by making the voltage LOW
  delay(500);  
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               //                // wait for a second
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(80);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               // digitalWrite(led3, LOW);    // turn the LED off by making the voltage LOW
  delay(500);  
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(80);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               // digitalWrite(led3, LOW);    // turn the LED off by making the voltage LOW
  delay(500);  
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               //                // wait for a second
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(80);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               // digitalWrite(led3, LOW);    // turn the LED off by making the voltage LOW
  delay(500);  
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(80);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               // digitalWrite(led3, LOW);    // turn the LED off by making the voltage LOW
  delay(500);  
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               //                // wait for a second
  digitalWrite(led4, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(80);               // wait for a second
  digitalWrite(led4, LOW);    // turn the LED off by making the voltage LOW
  delay(0);               // digitalWrite(led3, LOW);    // turn the LED off by making the voltage LOW
  delay(500);  
  digitalWrite(led3, LOW);    // turn the LED off by making the voltage LOW
  delay(0);
  digitalWrite(led2, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(3000);               // wait for a second
  digitalWrite(led2, LOW);    // turn the LED off by making the voltage LOW
  delay(0);     // wait for a second
}
