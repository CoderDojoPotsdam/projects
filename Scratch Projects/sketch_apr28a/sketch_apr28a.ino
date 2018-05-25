// lcd-libary einbinden      
#include <LiquidCrystal.h>
LiquidCrystal lcd(11,10,2,3,4,5);

void setup()
{
  
analogWrite(9,150);

lcd.begin(16,2);
lcd.setCursor(0, 0);
lcd.print("**ARDUINO LCD**");
lcd.setCursor(0, 1);
lcd.print("CNT:");
}

void loop()
{
     lcd.setCursor(5, 1);
     lcd.print(millis() / 1000);
}
