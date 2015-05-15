import random
import time
import os
position_x=0
position_y=0
geschwindigkeit_x=1
geschwindigkeit_y=1
def feld():
    os.system("clear")
    print("|"+"#"*30+"|")
    for zeilennummer in range(16):
       if zeilennummer==position_y:
           position_x
           print("|"+" "*(position_x-1)+"*"+" "*(30-position_x)+"|")
       else:
           print("|"+" "*30+"|")
   
def berechne_position():
    global position_x
    global position_y
    global geschwindigkeit_x
    global geschwindigkeit_y
    position_x=position_x+geschwindigkeit_x
    position_y=position_y+geschwindigkeit_y
    if position_y==0 or position_y==15:
        geschwindigkeit_y==geschwindigkeit_y*-1
    print(position_x,position_y,geschwindigkeit_x,geschwindigkeit_y)
while 0<=position_x<30 and 0<=position_y<15:
    berechne_position()
    feld()
    time.sleep(0.1)
    

   
