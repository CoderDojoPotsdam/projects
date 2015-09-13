import random
import math
import turtle

last=[0,0]
ddd=True
ca=True
turtle.speed(0)

possibilities=[[],[],[],[]]
for i in range(4):
	possibilities[i]=[[],[],[],[]]
	print('bleep')
	for j in range(4):
		possibilities[i][j]=[[],[],[],[]]
		for k in range(4):
			possibilities[i][j][k]=0.5

while ddd:
	while ca:
		turtle.speed(0)
		b=math.floor(random.random()*4)
		int_b=int(b)
		if(possibilities[last[0]][last[1]][int_b])>random.random():
			if b == 0:
				print('forward')
				possibilities[last[0]][last[1]][int_b]+=0.05
				for i in range(4):
					possibilities[last[0]][last[1]][i]-=0.0125
					if possibilities[last[0]][last[1]][i]<0:
						possibilities[last[0]][last[1]][i]=0
					if possibilities[last[0]][last[1]][i]>1:
						possibilities[last[0]][last[1]][i]=1
				turtle.setheading(90)
				turtle.color([0,1,0])
			elif b == 1:
				print('left')
				possibilities[last[0]][last[1]][int_b]+=0.05
				for i in range(4):
					possibilities[last[0]][last[1]][i]-=0.0125
					if possibilities[last[0]][last[1]][i]<0:
						possibilities[last[0]][last[1]][i]=0
					if possibilities[last[0]][last[1]][i]>1:
						possibilities[last[0]][last[1]][i]=1
				turtle.setheading(180)
				turtle.color([0,0,1])
			elif b == 2:
				print('back')
				possibilities[last[0]][last[1]][int_b]+=0.05
				for i in range(4):
					possibilities[last[0]][last[1]][i]-=0.0125
					if possibilities[last[0]][last[1]][i]<0:
						possibilities[last[0]][last[1]][i]=0
					if possibilities[last[0]][last[1]][i]>1:
						possibilities[last[0]][last[1]][i]=1
				turtle.setheading(270)
				turtle.color([0,0,0])
			elif b == 3:
				print('right')
				possibilities[last[0]][last[1]][int_b]+=0.05
				for i in range(4):
					possibilities[last[0]][last[1]][i]-=0.0125
					if possibilities[last[0]][last[1]][i]<0:
						possibilities[last[0]][last[1]][i]=0
					if possibilities[last[0]][last[1]][i]>1:
						possibilities[last[0]][last[1]][i]=1
				turtle.setheading(0)
				turtle.color([1,0,0])
			turtle.fd(4)
		last=[int_b,last[0]]







