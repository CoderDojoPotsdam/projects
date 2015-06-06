/* Sweep
 by BARRAGAN <http://barraganstudio.com> 
 This example code is in the public domain.

 modified 8 Nov 2013
 by Scott Fitzgerald
 http://arduino.cc/en/Tutorial/Sweep
*/ 

#include <Servo.h> 
 
Servo myservo;  // create servo object to control a servo 
                // twelve servo objects can be created on most boards
 
int pos = 0;    // variable to store the servo position 
 
const int analogInPin = A0; // Analog input pin that the potentiometer is attached to
const int analogInPin2 = A2; 

int sensorValue1 = 0;        // value read from the pot
int sensorValue2 = 0;
int outputValue1 = 0;        // value output to the PWM (analog out)
int outputValue2 = 0;

void setup() 
{ 
  myservo.attach(9);  // attaches the servo on pin 9 to the servo object
  pinMode(13, OUTPUT);
  pinMode(12, OUTPUT); 
} 
 
void loop() 
{ 
   sensorValue1 = analogRead(analogInPin);            
  // map it to the range of the analog out:
  sensorValue2 = analogRead(analogInPin2);
  digitalWrite(13, HIGH);   // turn the LED on (HIGH is the voltage leve1)
  digitalWrite(12, LOW);
  
  int offset = (sensorValue1>200) ? 30 : 0;
  offset = (sensorValue2>200) ? -30 : 0;
  offset = (sensorValue1==sensorValue2) ? 0 : offset;  
  for(pos = 50+offset; pos <= 100+offset; pos += 2) // goes from 0 degrees to 180 degrees 
  {                                  // in steps of 1 degree 
    myservo.write(pos);              // tell servo to go to position in variable 'pos' 
    delay(15);                       // waits 15ms for the servo to reach the position 
  }
  digitalWrite(13, LOW);    // turn the LED off by making the voltage LOW
  digitalWrite(12, HIGH);
  for(pos = 100+offset; pos>=50+offset; pos-=2)     // goes from 180 degrees to 0 degrees 
  {                                
    myservo.write(pos);              // tell servo to go to position in variable 'pos' 
    delay(15);                       // waits 15ms for the servo to reach the position 
  } 
} 
