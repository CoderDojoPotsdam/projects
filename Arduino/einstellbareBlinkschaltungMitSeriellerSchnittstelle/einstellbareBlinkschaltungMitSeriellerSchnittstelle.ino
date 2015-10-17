/*
  Blink
  Turns on an LED on for one second, then off for one second, repeatedly.
 
  This example code is in the public domain.
 */
 
// Pin 13 has an LED connected on most Arduino boards.
// give it a name:
int led = 13;
int wieoftschon = 1;
int led2 = 12;
int sensorValue = 0;
// the setup routine runs once when you press reset:
void setup() {                
  // initialize the digital pin as an output.
  pinMode(led, OUTPUT);
  pinMode(led2, OUTPUT);
Serial.begin(9600);
Serial.println("hallo welt!!!!!");
}

// the loop routine runs over and over again forever:
void loop() {
  sensorValue = 0;
  for(int z = 0;z < 10;z++){
  sensorValue += analogRead(A0);
  }
  
  sensorValue /= 10;
  digitalWrite(led2, HIGH);   // turn the LED on (HIGH is the voltage level)
  //delay(5);               // wait for a second
  digitalWrite(led, LOW);    // turn the LED off by making the voltage LOW
  delay(sensorValue);S
  digitalWrite(led, HIGH);   // turn the LED on (HIGH is the voltage level)
 // delay(5);               // wait for a second
  digitalWrite(led2, LOW);    // turn the LED off by making the voltage LOW
  delay(sensorValue);
wieoftschon=wieoftschon+1; 
Serial.print("hallo welt!!!!!"); 
Serial.println(sensorValue);// wait for a second
}
