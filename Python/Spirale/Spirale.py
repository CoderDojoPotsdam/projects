__author__ = 'coderdojo'
import turtle
def spiral(radius):
    xcor = turtle.xcor()
    ycor = turtle.ycor()
    speed = 1
    while True:
        turtle.forward(speed)
        turtle.left(10)
        speed += 1 * 0.01
        if turtle.distance(xcor, ycor) > radius:
            break


spiral(100000)
turtle.exitonclick()