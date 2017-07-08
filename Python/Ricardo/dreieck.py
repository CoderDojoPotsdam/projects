import turtle

def neck(l, n):
    if (n < 3):
        return
    for x in range(n):
        turtle.forward(l)
        turtle.left(360 / n)

def test(l):
    neck(l, 3)
    neck(l/2, 3)
    turtle.forward(l/2)
    neck(l/2, 3)
    turtle.left(120)
    turtle.forward(l/2)
    turtle.right(120)
    neck(l/2, 3)

