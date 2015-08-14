/*
  Pong by Nicco Kunzmann
 */
#include <EEPROM.h>
#include <math.h>
#include <Servo.h> 
// https://www.arduino.cc/en/Hacking/BuildProcess
#include "EEPROM_Anything.h"
 
#define servo_left_pin 12
#define servo_right_pin 2

Servo servo_left;
Servo servo_right;

// all measurements in centimeters and degrees
// configuration of the ball_servos
const float l_l = 57.2;    // distance servo rotation center to hole for thread
const float l_r = 54.7;
const float r_l = 57.8;    // radius of the servo arm until 
const float r_r = 54.7;
const float z_l = 9;     // distance from servo arm to hole
const float z_r = 5.5;
const float alpha0_l = -5;  // TODO angle of the servo to reach the minimum z
const float alpha0_r = 0;  // TODO
const float t0_l = 15;     // minimum remaining thread at the ball side
const float t0_r = 16;
// configuration of ball
const float a0 = 85.2;     // distance between the two holes on the ball side
const float b = 1.3;       // distance between the two threads on the ball
const float a = a0 - b;
const float a_half = a / 2;

// some boundaries
const float min_y = 25;    // minimal y to not use too much force
#define squared(X) ((X)*(X))
const float max_y_l = sqrt(squared(r_l + r_l + t0_l) - a * a);
const float max_y_r = sqrt(squared(r_r + r_r + t0_r) - a * a);
const float max_y_computed = min(max_y_l, max_y_r);
const float max_y_manual = 65;
const float max_y = min(max_y_manual, max_y_computed);
const float max_x_computed = a_half;
const float max_x_manual = 30;
const float max_x = min(max_x_manual, max_x_computed);
const float min_x = -max_x;

// the position of the ball
#define position_eeprom_address 0
float x;
float y;


// computation
float servo_angle(const float t, const float l, const float r, const float z, 
                  const float alpha0, const float t0) {
  const float r_times_two = r + r;
  const float s = r_times_two - t + t0;
  const float alpha = acos((s * s - r * r - l * l - z * z) / (- r_times_two * l));
  return degrees(alpha) + alpha0;
}

void set_position() {
  // check bounds
  x = constrain(x, min_x, max_x);
  y = constrain(y, min_y, max_y);
    // write x and y
  const int y_eeprom_position = EEPROM_writeAnything(position_eeprom_address, x);
  EEPROM_writeAnything(y_eeprom_position, y);
  const float y_squared = y * y;
  float x_;
  float t;
  float angle;
  // right servo
  x_ = a_half - x;
  t = sqrt(x_ * x_ + y_squared);
  angle = servo_angle(t, l_r, r_r, z_r, alpha0_r, t0_r);
  Serial.print("a_r:"); Serial.print(angle);
  servo_right.write(angle);
  // left servo
  x_ = a_half + x;
  t = sqrt(x_ * x_ + y_squared);
  angle = servo_angle(t, l_l, r_l, z_l, alpha0_l, t0_l);
  Serial.print("a_l:"); Serial.print(angle);
  servo_left.write(180 - angle);

}

void set_position(float x_, float y_) {
  x = x_;
  y = y_;
  set_position();
}

// cm/second
float vx;
float vy;
// milliseconds
int last_step;
float dt;

void step_position(float dx, float dy) {
  x += dx;
  y += dy;
  if (x <= min_x) vx = abs(vx);
  if (x >= max_x) vx = -abs(vx);
  if (y <= min_y) vy = abs(vy);
  if (y >= max_y) vy = -abs(vy);
  set_position();
}

void setup() {
  // setup servos
  servo_left.attach(servo_left_pin);
  servo_right.attach(servo_right_pin);
  // load x and y
  const int y_eeprom_position = EEPROM_readAnything(position_eeprom_address, x);
  EEPROM_readAnything(y_eeprom_position, y);
  if (isnan(x) || isinf(x)) x = 0;
  if (isnan(y) || isinf(y)) y = 0;
  // initialize stepping
  vx = 10;
  vy = 1;
  last_step = millis();
  dt = 0;
  Serial.begin(9600);
}

int path_x[] = { 0, -100, -100, -100,   0, 100, 100, 100 };
int path_y[] = { 0,    0,   60,  100, 100, 100,  60,   0 };
int points_in_path = 8;
int current_point = 0;

void path_loop() {
  delay(8000);
  set_position(path_x[current_point], path_y[current_point]);
  current_point++;
  current_point %= points_in_path;
}

void bounce_loop() {

  step_position(vx * dt, vy * dt);
}

void loop() {
  // compute dt
  int current_step = millis();
  dt = (current_step - last_step) / 1000.;
  last_step = current_step;
  bounce_loop();
//  Serial.print("dt: "); Serial.print(dt); 
//  Serial.print(" min_x: "); Serial.print(min_x); 
  Serial.print(" x: "); Serial.print(x); 
//  Serial.print(" max_x: "); Serial.print(max_x); 
//  Serial.print(" vx: "); Serial.print(vx); 
//  Serial.print(" min_y: "); Serial.print(min_y); 
  Serial.print(" y: "); Serial.print(y); 
//  Serial.print(" max_y: "); Serial.print(max_y); 
//  Serial.print(" vy: "); Serial.print(vy); 
  Serial.println();
}
