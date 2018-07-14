/*
 * https://coderdojo.com
 */

#include <Adafruit_NeoPixel.h>
#include <ledtable.h>

LEDTable ledtable = LEDTable(2, 12, 12, PIXELORDER<flip_xy, snake>);

void setup() {
  ledtable.begin();
}


void show(int brightness) {
  int diameter = min(ledtable.height(), ledtable.width()) / 2 * 2; // even
  ledtable.brightness(brightness);
  ledtable.fill(0, 0, diameter / 2, diameter / 2, color_blue);
  ledtable.fill(diameter / 2, 0, ledtable.width(), diameter / 2, color_green);
  ledtable.fill(diameter / 2, diameter / 2, ledtable.width(), ledtable.height(), color_red);
  ledtable.fill(0, diameter / 2, diameter / 2, ledtable.height(), color_yellow);

  // big black circle
  ledtable.ellipse(0,0, diameter, diameter, color_black);
  // make one half white
  for (int x = 0; x < diameter / 2; x++)
  {
    for (int y = 0; y < diameter; y++)
    {
      if (ledtable.at(x, y) == color_black)
      {
        ledtable.fill(x, y, color_white);
      }
    }
  }
  // white circle with black 0
  ledtable.ellipse(diameter / 4, 0, diameter - diameter / 4, diameter / 2, color_white);
  ledtable.ellipse(diameter / 4 + diameter / 6, diameter / 6, diameter - diameter / 4 - diameter / 6, diameter / 2 - diameter / 6, color_black);
  if (diameter / 6 >= 2)
  {
    ledtable.ellipse(diameter / 4 + diameter / 6 + 1, diameter / 6 + 1, diameter - diameter / 4 - diameter / 6 - 1, diameter / 2 - diameter / 6 - 1, color_white);
  }
  // black circle with white 1
  ledtable.ellipse(diameter / 4, diameter / 2, diameter - diameter / 4, diameter, color_black);
  ledtable.fill((diameter + 1) / 2, diameter - diameter / 6, (diameter + 1) / 2 + 1, diameter - (diameter / 2 - diameter / 6), color_white);
  ledtable.show();

}
void loop() {
  for (int i = 0; i < 256; i += 6) {
    show(i);
    delay(50);
  }
  for (int i = 255; i >0; i -= 10) {
    show(i);
    delay(50);
  }
}
