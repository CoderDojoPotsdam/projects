
void loop () {
 digitalWrite(2,LOW);
 tone(8,440,1000);
 delay(1000);
 tone(8,3000,1000);
fahre_vor ();
delay(500);
digitalWrite(2,HIGH);
delay(500);
 } 
int pin_pwm_1 = 9;
int pin_pwm_2 = 10;
void setup( ){
pinMode(pin_pwm_1, OUTPUT);
pinMode(2,OUTPUT);
pinMode(pin_pwm_2, OUTPUT);
}
void anhalten() {
analogWrite(pin_pwm_1, 0);
analogWrite(pin_pwm_2, 0);
delay(300);
}
void fahre_vor() {

analogWrite(pin_pwm_1, 0);
analogWrite(pin_pwm_2, 255); // 0 <= geschwindigkeit <= 255
}
void fahre_zurueck() {
anhalten();
analogWrite(pin_pwm_1, 255); // 0 <= geschwindigkeit <= 255
analogWrite(pin_pwm_2, 0);
}

