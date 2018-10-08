#include <LiquidCrystal.h>

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
int load= 0;
int percent= 0;
int pos= 7;

void setup() 
{
lcd.begin(16, 2);
}

void loop() 
{
lcd.setCursor(8, 1);
lcd.print ("%");
lcd.setCursor(pos, 1);
lcd.print(load);
/*
lcd.setCursor(6, 1);
lcd.print("000%");
delay(1500);
lcd.clear();
lcd.setCursor(0, 0);
lcd.print("#");
lcd.setCursor(6, 1);
lcd.print("010%");
lcd.setCursor(1, 0);
lcd.print("#");*/
load = (load + 1);
if (load >= 10) {
  lcd.setCursor(0, 0);
  lcd.print ("#");
  pos == 4;

}
if (load >= 20) {
  lcd.setCursor(1, 0);
  lcd.print ("#");

}
if (load >= 30) {
  lcd.setCursor(2, 0);
  lcd.print ("#");

}
if (load >= 40) {
  lcd.setCursor(3, 0);
  lcd.print ("#");

}
if (load >= 50) {
  lcd.setCursor(4, 0);
  lcd.print ("#");

}
if (load >= 60) {
  lcd.setCursor(5, 0);
  lcd.print ("#");

}
if (load >= 70) {
  lcd.setCursor(6, 0);
  lcd.print ("#");

}
if (load >= 80) {
  lcd.setCursor(7, 0);
  lcd.print ("#");

}
if (load >= 90) {
  lcd.setCursor(8, 0);
  lcd.print ("#");

}
if (load == 101) {
  lcd.setCursor(9, 0);
  lcd.print ("#");
  delay(100000);
}
delay(200);
}

