Python 3.4.0 (default, Apr 11 2014, 13:05:11) 
[GCC 4.8.2] on linux
Type "copyright", "credits" or "license()" for more information.
>>> print("Hello World")
Hello World
>>> (1 + 4) * 2
10
>>> help()

Welcome to Python 3.4!  This is the interactive help utility.

If this is your first time using Python, you should definitely check out
the tutorial on the Internet at http://docs.python.org/3.4/tutorial/.

Enter the name of any module, keyword, or topic to get help on writing
Python programs and using Python modules.  To quit this help utility and
return to the interpreter, just type "quit".

To get a list of available modules, keywords, symbols, or topics, type
"modules", "keywords", "symbols", or "topics".  Each module also comes
with a one-line summary of what it does; to list the modules whose name
or summary contain a given string such as "spam", type "modules spam".

help> 

You are now leaving help and returning to the Python interpreter.
If you want to ask for help on a particular object directly from the
interpreter, you can type "help(object)".  Executing "help('string')"
has the same effect as typing a particular string at the help> prompt.
>>> import turtle
>>> turtle.forward(0)
>>> turtle.forward(25)
>>> turtle.left(30)
>>> turtle.shape("turtle")
>>> turtle.forward(24)
>>> turtle.exitonclick
<function exitonclick at 0x7fd74cd00620>
>>> turtle.exitonclick()
>>> turtle.reset()

>>> turtle.import
SyntaxError: invalid syntax
>>> import.turtal
SyntaxError: invalid syntax
>>> import turtle
>>> turtle.forward
<function forward at 0x7fd74cd0fe18>
>>> turtal.forward(25)
Traceback (most recent call last):
  File "<pyshell#15>", line 1, in <module>
    turtal.forward(25)
NameError: name 'turtal' is not defined
>>> turtle.forward(25)
>>> turtle.left(90)
>>> turtle.forward(25)
>>> turtal.left(90)
Traceback (most recent call last):
  File "<pyshell#19>", line 1, in <module>
    turtal.left(90)
NameError: name 'turtal' is not defined
>>> turtle.left(25)
>>> tutle.right(25)
Traceback (most recent call last):
  File "<pyshell#21>", line 1, in <module>
    tutle.right(25)
NameError: name 'tutle' is not defined
>>> turtle.right(25)
>>> turtle.left(90)
>>> turtle.forward(25)
>>> turtle.left(90)
>>> turtle.forward(25)
>>> turtle.left(90)
>>> turtle.color(blue)
Traceback (most recent call last):
  File "<pyshell#28>", line 1, in <module>
    turtle.color(blue)
NameError: name 'blue' is not defined
>>> tutle.color(3)
Traceback (most recent call last):
  File "<pyshell#29>", line 1, in <module>
    tutle.color(3)
NameError: name 'tutle' is not defined
>>> turtle.color(3)
Traceback (most recent call last):
  File "<pyshell#30>", line 1, in <module>
    turtle.color(3)
  File "<string>", line 1, in color
  File "/usr/lib/python3.4/turtle.py", line 2208, in color
    pcolor = self._colorstr(pcolor)
  File "/usr/lib/python3.4/turtle.py", line 2688, in _colorstr
    return self.screen._colorstr(args)
  File "/usr/lib/python3.4/turtle.py", line 1144, in _colorstr
    if len(color) == 1:
TypeError: object of type 'int' has no len()
>>> timmy=haha
Traceback (most recent call last):
  File "<pyshell#31>", line 1, in <module>
    timmy=haha
NameError: name 'haha' is not defined
>>> timmy = haha
Traceback (most recent call last):
  File "<pyshell#32>", line 1, in <module>
    timmy = haha
NameError: name 'haha' is not defined
>>> haha = turtle
>>> haha.reset()
>>> angle = 20
>>> hihi = turtle.left(angle)

turtle.forward(50)
turtle.left(90)
turtle.forward(50)
turtle.left(90)
turtle.forward(50)
turtle.left(90)
turtle.forward(50)
turtle.left(90)

turtle.left(angle)

SyntaxError: multiple statements found while compiling a single statement
>>> hihi = turtle.forward(50)
>>> hoho = turtle.left(90)
>>> turtle.left(angle)
>>> turtle.reset()
>>> turtle.left(angle)
>>> hihi
>>> hoho
>>> hihi
>>> hoho
>>> angle = 20

turtle.left(angle)

turtle.forward(50)
turtle.left(90)
turtle.forward(50)
turtle.left(90)
turtle.forward(50)
turtle.left(90)
turtle.forward(50)
turtle.left(90)

turtle.left(angle)
SyntaxError: multiple statements found while compiling a single statement
>>> turtle.left(angle)

turtle.forward(50)
turtle.left(90)
turtle.forward(50)
turtle.left(90)
turtle.forward(50)
turtle.left(90)
turtle.forward(50)
turtle.left(90)

turtle.left(angle)
SyntaxError: multiple statements found while compiling a single statement

SyntaxError: multiple statements found while compiling a single statement
>>> turtle.reset()
>>> turtle.left(angle)
>>> turtle.forward
<function forward at 0x7fd74cd0fe18>
>>> turtle.forward(50)
>>> turtle.left(90)
>>> hihi = 50
>>> hoho = 90
>>> turtle.forward(hihi)
>>> turtle.left(hoho)
>>> turtle.forward(50)
>>> turtle.left(90)
>>> turtle.forward(50)
>>> turtle.left(90)
>>> turtle.left(angle)

>>> print("angle")
angle
>>> import math
>>> math.sqrt()
Traceback (most recent call last):
  File "<pyshell#64>", line 1, in <module>
    math.sqrt()
TypeError: sqrt() takes exactly one argument (0 given)
>>> turtle.reset()
>>> turtle.shape("turtle)
	     
SyntaxError: EOL while scanning string literal
>>> turtle.shape("turtle")
>>> for name in "John", "Sam", "Jill":
    print("Hello " + name)


Hello John
Hello Sam
Hello Jill
>>> 
