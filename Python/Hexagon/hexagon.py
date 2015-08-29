import pygame
import math
import random
import os

directory = os.getcwd()
music_file = os.path.join(directory, 'Blop-Mark_DiAngelo-79054334.mp3')

class Game(object):
    def __init__(self,hexalist,random):
        self.running = True
        self.score=0
        self.currentTime=0
        self.oldTime=0
        self.timeDifference=0
        self.clock=pygame.time.Clock()
        self.done=False
        screen=pygame.display.set_mode([540,630])
        pygame.display.set_caption('hexagon.py-Move mouse to make stuff white again')
        pygame.mixer.music.load(music_file)
        self.firstdraw(screen,hexalist,random)
        self.update(screen,hexalist,random)
    def update(self,frame,hexalist,random):
        while self.running == True:
            self.clock.tick(50)
            if self.done==True:
                self.win(frame,hexalist)
            self.done=True
            for i in range(25):
                hexalist[i].update(frame,random,self,hexalist)
                if hexalist[i].red<20:
                    self.done=False
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    self.running = False
            pygame.display.flip()    
        pygame.quit()
    def over(self,frame,hexalist):
        self.running=False
        print("Game over!")
        exit=raw_input("Restart?(yes/no)")
        if exit == "yes":
            pygame.quit()
            pygame.init()
            random.seed()
            hexagonList=[]
            game = Game(hexagonList,random)
        elif exit == "no":
            pass
    def win(self,frame,hexalist):
        self.running=False
        print("You did it!")
        print("All tiles disappeared!")
        exit=raw_input("Restart(yes/no)?")
        if exit == "yes":
            pygame.quit()
            pygame.init()
            random.seed()
            hexagonList=[]
            game = Game(hexagonList,random)
        elif exit == "no":
            pass
    def firstdraw(self,frame,hexalist,random):
        x=30
        y=30
        sx=5
        sy=5
        size=60
        color=[205,255,255]
        stroke=2
        placeX=0
        placeY=0
        offset=1
        offsetPixel=0
        frame.fill([20,20,20])
        for i in range(sx):
            offsetPixel=offset*size*math.sqrt(3)/2
            for j in range(sy):
                hexalist.append(Hexagon(x+placeX,y+placeY+offsetPixel,frame,random,hexalist))
                placeY=placeY+size*math.sqrt(3)          
            if offset == 1:
                offset = 0
            elif offset == 0:
                offset = 1
            placeY=0
            placeX=placeX+1.5*size
class Hexagon(object):
    def __init__(self,posX,posY,frame,random,hexalist):
        self.fillStatus=0
        self.size=60
        self.timeSpent=0
        self.xcoord=posX
        self.ycoord=posY
        self.red=0
        self.draw(frame,posX,posY,self.red)
        self.fl=0.0005
        self.increase=0.0000018
    def update(self,frame,random,game,hexalist):
        if self.fillStatus>0 and self.red<20:
            self.hitbox(pygame.mouse.get_pos()[0],pygame.mouse.get_pos()[1],frame,game)
        if random.random()<self.fl and self.red<20:
            self.fill(frame,game,hexalist)
        self.fl+=self.increase
    def hitbox(self,x,y,frame,game):
        if y>self.ycoord and y<self.ycoord+self.size*math.sqrt(3):
            if abs(y-self.ycoord-self.size*math.sqrt(3)/2)/math.sqrt(3)+abs(x-self.xcoord-self.size)<self.size:
                self.clear(frame)
                game.score+=1
    def fill(self,frame,game,hexalist):
        self.fillStatus=self.fillStatus+1
        self.draw(frame,self.xcoord,self.ycoord,self.red)
        if self.fillStatus==6:
            game.over(frame,hexalist)
    def clear(self,frame):
        if self.red<20 and random.random()<0.5:
            self.red+=1
        pygame.mixer.music.play(0,0.08)
        self.fillStatus-=1
        self.draw(frame,self.xcoord,self.ycoord,self.red)
    def draw(self,frame,x,y,red):
        self.color = [255-self.fillStatus*255/6,255-self.fillStatus*(255*self.red/19)/6,255]
        if self.red==20:
            self.color=[20,20,20]
        pygame.draw.polygon(frame,self.color,[[self.size*0.5+x,y],[self.size*1.5+x,y],[self.size*2+x,math.sqrt(3)*self.size/2+y],[self.size*1.5+x,math.sqrt(3)*self.size+y],[self.size*0.5+x,math.sqrt(3)*self.size+y],[x,math.sqrt(3)*self.size/2+y]])
if __name__ == "__main__":
    print(music_file)
    pygame.init()
    random.seed()
    hexagonList=[]
    game = Game(hexagonList,random)