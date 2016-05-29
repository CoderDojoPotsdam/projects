import time

print("1 bis 99")

x = 1

for i in range(1,100):
        if i % 2 == 0:
                print("Gerade!")
        x = x * i
        print("Zahl: ",i,", x: ",x)
        time.sleep(0.1)
	
