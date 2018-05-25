from turtle import *
import math
a = 100
b = a/2

def Häuser():
    for i in range(2):
        forward(a)
        left(90)
        forward(a)
        left(45)
        forward(math.sqrt(2*b*b))
        left(90)
        forward(math.sqrt(2*b*b))
        left(45)
        forward(a)
        left(135)
        forward(math.sqrt(2*a*a))
        left(135)
        forward(a)
        left(135)
        forward(math.sqrt(2*a*a))
        left(45)
        penup()
        forward(20)
        pendown()

Häuser()
