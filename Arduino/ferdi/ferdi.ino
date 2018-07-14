int ledPin = 9;
int meinErgebnis;

void setup(){
  pinMode(ledPin,OUTPUT);
}

void loop(){
  meinErgebnis = 2 + 3;
  for (int zaehler=1; zaehler<=meinErgebnis; zaehler = zaehler+1){
    digitalWrite(ledPin, HIGH);
    delay(200);
    digitalWrite(ledPin, LOW);
    delay(200);
  }
  delay(2000);
}

