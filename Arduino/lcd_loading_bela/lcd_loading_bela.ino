#include <LiquidCrystal.h>

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
int load= 0;
int percent= 0;
int pos= 5;
int button= 7;
int buttonstat= 0;
int replay= 0;

byte wow[] = 
{
  B11111,
  B11111,
  B11111,
  B11111,
  B11111,
  B11111,
  B11111,
  B11111
};


void setup() 
{
  pinMode(button, INPUT);
  lcd.createChar(0, wow);
  lcd.begin(16, 2);  
}

void loop() 
{
  lcd.setCursor(6, 1);
  lcd.write ("%");
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
  if (load >= 9) 
  {
    lcd.setCursor(0, 0);
    lcd.write(byte(0));
    pos = 4;
  }

  if (load >= 20) 
  {
    lcd.setCursor(1, 0);
    lcd.write(byte(0));
  }

  if (load >= 30) 
  {
    lcd.setCursor(2, 0);
    lcd.write(byte(0));
  }

  if (load >= 40) {
    lcd.setCursor(3, 0);
    lcd.write(byte(0));
  }

  if (load >= 50) 
  {
    lcd.setCursor(4, 0);
    lcd.write(byte(0));
  }

  if (load >= 60) 
  {
    lcd.setCursor(5, 0);
    lcd.write(byte(0));
  }

  if (load >= 70) 
  {
    lcd.setCursor(6, 0);
    lcd.write(byte(0));
  }

  if (load >= 80) 
  {
    lcd.setCursor(7, 0);
    lcd.write(byte(0));
  }

  if (load >= 90) 
  {
    lcd.setCursor(8, 0);
    lcd.write(byte(0));
  }

  if (load == 99) 
  {
    pos = 3;
    delay(3000);
  }

  if (load == 100) 
  {
    lcd.setCursor(9, 0);
    lcd.write(byte(0));
    lcd.setCursor(11,0);
    lcd.print ("Ready");

    /*else
     {
     delay(10000000);
     }*/
  }
  if (load >= 100)
  {
    load = (load -1);
  }
  buttonstat=digitalRead(button);
  if (buttonstat == HIGH)
  {
    replay= 1;
  }
  if (replay == 1)
    {
      lcd.clear();
      buttonstat = 0;
      replay = 0;
      load = 0;
      pos = 5;
      percent = 0;
      lcd.clear();
      return;
    }
  delay(50);
  load = (load + 1);
}

