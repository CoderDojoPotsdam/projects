import turtle
x=5*5
y=6*32
turtle.forward(5*x)
turtle.left(y*x)
turtle.forward(5*x)
turtle.right(x*y)
turtle.forward(5*x)
for i in range(100):
    turtle.forward(i)
    turtle.left(i)
