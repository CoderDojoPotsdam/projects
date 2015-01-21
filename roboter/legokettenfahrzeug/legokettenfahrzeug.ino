
void loop() {
  digitalWrite(13, HIGH); // LED anschalten
  fahre(0,0);
  delay(1000);
  digitalWrite(13, LOW); // LED ausschalten
  fahre(1000, 0);
  delay(1000);
  fahre(1000, 1000);
  delay(1000);
  fahre(0, 1000);
  delay(1000);
}


void setup() {
  starte_motoren();
  pinMode(13, OUTPUT);
}


const int motor_rechts_pin_weiss = 5;
const int motor_rechts_pin_braun = 6;

const int motor_links_pin_weiss = 10;
const int motor_links_pin_braun = 9;

void starte_motoren() {
  pinMode(motor_rechts_pin_weiss, OUTPUT);
  pinMode(motor_rechts_pin_braun, OUTPUT);
  pinMode(motor_links_pin_weiss, OUTPUT);
  pinMode(motor_links_pin_braun, OUTPUT);
  fahre(0, 0);
}


void fahre(int links, int rechts) {
  int staerke;
  if (links < 0) {
    staerke = -links;
    analogWrite(motor_links_pin_weiss, staerke);
    digitalWrite(motor_links_pin_braun, LOW);
  } else {
    staerke = links;
    digitalWrite(motor_links_pin_weiss, LOW);
    analogWrite(motor_links_pin_braun, staerke);
  }
  if (rechts < 0) {
    staerke = -rechts;
    analogWrite(motor_rechts_pin_weiss, staerke);
    digitalWrite(motor_rechts_pin_braun, LOW);
  } else {
    staerke = rechts;
    digitalWrite(motor_rechts_pin_weiss, LOW);
    analogWrite(motor_rechts_pin_braun, staerke);
  }
}


