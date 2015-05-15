/*
  Blink
  Turns on an LED on for one second, then off for one second, repeatedly.

  Most Arduinos have an on-board LED you can control. On the Uno and
  Leonardo, it is attached to digital pin 13. If you're unsure what
  pin the on-board LED is connected to on your Arduino model, check
  the documentation at http://arduino.cc

  This example code is in the public domain.

  modified 8 May 2014
  by Scott Fitzgerald
 */


// the setup function runs once when you press reset or power the board
void setup() {
  // initialize digital pin 13 as an output.
  pinMode(4, OUTPUT);
}

// the loop function runs over and over again forever
void loop() {
  tone(4, 523.2);
  delay(500);
  delay(50);
  tone(4, 698.4);
  delay(775);delay(200);
  tone(4, 698.4);
  delay(500);delay(200);
  tone(4, 698.4);
  delay(1500);delay(300);
  tone(4, 783.9);
  delay(500);delay(300);
  tone(4, 440);
  delay(775);delay(300);
  tone(4, 440);
  delay(500);delay(300);
  tone(4, 440);
  delay(1500);delay(300);
  tone(4, 440);
  delay(500);delay(300);
  tone(4, 783.9);
  delay(500);delay(300);
  tone(4, 880);
  delay(500);delay(300);
  tone(4, 466.1);
  delay(1000);delay(300);
  tone(4, 659.2);
  delay(1000);delay(300);
  tone(4, 783.9);
  delay(1000);delay(300);
  tone(4, 698.4);
  delay(500);delay(300);
}
