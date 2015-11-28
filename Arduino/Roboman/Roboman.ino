/*
 Programmiert von Jesse 
 Quelltext des Robomans Beta
*/

#include <Servo.h>

Servo myservo;  // create servo object to control a servo
Servo myservo2;

int potpin = 0;  // analog pin used to connect the potentiometer
int potpin2 = A2;
int val;    // variable to read the value from the analog pin
int val2;

void setup() {
  myservo.attach(9);  // attaches the servo on pin 9 to the servo object
  myservo2.attach(6);
}

void loop() {
  val = analogRead(potpin);           
  val = map(val, 0, 1023, 0, 180);     
  myservo.write(val);                  
  val2 = analogRead(potpin2);            
  val2 = map(val2, 0, 1023, 0, 180);    
  myservo2.write(val2);   
  delay(15);                           
}

