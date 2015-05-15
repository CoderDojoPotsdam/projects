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
Servo myservo2;
Servo myservo3;
Servo myservo4;

 
int pos = 0;    // variable to store the servo position
int pos2 = 0;
int pos3 = 0;
int pos4 = 0;
const int analogInPin = A0; //zum messen
const int analogInPin2 = A1;//zum messen
const int analogInPin3 = A2;
const int analogInPin4 = A3;

int sensorValue = 0;
int sensorValue2 = 0;
int sensorValue3 = 0;
int sensorValue4 = 0;


void setup() 
{ 
  myservo.attach(9);  // attaches the servo on pin 9 to the servo object 
  myservo2.attach(10);
  myservo3.attach(11);
  myservo4.attach(12);
} 
 
void loop() 
{ 
    sensorValue = analogRead(analogInPin);            
    sensorValue2 = analogRead(analogInPin2);
    sensorValue3 =analogRead(analogInPin3);    
    sensorValue4 = analogRead(analogInPin4);
    
    // map it to the range of the analog out:
    pos = map(sensorValue, 0, 1023, 0, 150);  
    pos2 = map(sensorValue2, 0, 1023, 0, 150);  
    pos3 = map(sensorValue3, 0, 1023, 0, 150);
    pos4 = map(sensorValue4, 0, 1023, 0, 150);
    
    myservo2.write(pos2);
    myservo3.write(pos3);
    myservo4.write(pos4);
    myservo.write(pos);    // tell servo to go to position in variable 'pos' 
    delay(15);                       // waits 15ms for the servo to reach the position 
  
} 
