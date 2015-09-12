__author__ = 'coderdojo'
import turtle
distance = 0
while turtle.distance(0,0) < 100:
    turtle.setheading(turtle.towards(0,0))
    turtle.forward(150)
turtle.exitonclick()
