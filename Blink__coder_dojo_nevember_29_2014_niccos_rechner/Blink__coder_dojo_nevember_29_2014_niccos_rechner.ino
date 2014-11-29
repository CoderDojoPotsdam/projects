/*
  Blink
  Turns on an LED on for one second, then off for one second, repeatedly.
 
  This example code is in the public domain.
 */
 
// Pin 13 has an LED connected on most Arduino boards.
// give it a name:
int rot = A5;
int blau =A3 ;
int gruen=A0 ;

// the setup routine runs once when you press reset:
void setup() {                
  // initialize the digital pin as an output.
  pinMode(rot, OUTPUT);
  pinMode(gruen, OUTPUT);
 pinMode(blau, OUTPUT);   
   
}

// the loop routine runs over and over again forever:
void loop() {
  for(int i=0;i<=2555;i++)
{analogWrite(rot, 255);   // turn the LED on (HIGH is the voltage level)9
   analogWrite(blau,255);   // turn the LED on (HIGH is the voltage level)
    analogWrite(gruen,255);   // turn the LED on (HIGH is the voltage level)
    delayMicroseconds(i*3);
    analogWrite(rot, 0);   // turn the LED on (HIGH is the voltage level)9
   analogWrite(blau,i);   // turn the LED on (HIGH is the voltage level)
    analogWrite(gruen,i);
      delayMicroseconds(i*3);}
}
