#!/usr/bin/python2
import pygame
import math
import random
class Game(object):
    def __init__(self,hexalist,random):
        self.running = True
        self.score=0
        self.currentTime=0
        self.oldTime=0
        self.timeDifference=0
        screen = pygame.display.set_mode([540,630])
        pygame.display.set_caption('hexagon.py')
        self.firstdraw(screen,hexalist,random)
        self.update(screen,hexalist,random)
    def update(self,frame,hexalist,random):
        while self.running == True:
            self.oldTime=self.currentTime
            for i in range(25):
                hexalist[i].update(self.timeDifference,frame,random,self,hexalist)
                
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    self.running = False
            pygame.display.flip()
            self.currentTime=pygame.time.get_ticks()
            self.timeDifference=self.currentTime-self.oldTime
        pygame.quit()
    def over(self,frame,hexalist):
        self.running=False
        print("Game over!")
        print("Score: ")
        print(self.score)
        
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
        self.timeupd=50
        self.draw(frame,posX,posY)
        self.fl=0.0005
    def update(self,time,frame,random,game,hexalist):
        self.timeSpent=self.timeSpent+time
        if self.timeSpent>self.timeupd:
            self.timeSpent-=self.timeupd
            self.fl+=0.000006
            if self.fillStatus>0:
                self.hitbox(pygame.mouse.get_pos()[0],pygame.mouse.get_pos()[1],frame,game)
            if random.random()<self.fl:
                self.fill(frame,game,hexalist)
            
    def hitbox(self,x,y,frame,game):
        if y>self.ycoord and y<self.ycoord+self.size*math.sqrt(3):
            if abs(y-self.ycoord-self.size*math.sqrt(3)/2)/math.sqrt(3)+abs(x-self.xcoord-self.size)<self.size:
                self.clear(frame)
                game.score+=1
        
    def fill(self,frame,game,hexalist):
        self.fillStatus=self.fillStatus+1
        if self.fillStatus==6:
            game.over(frame,hexalist)
        else:
            self.draw(frame,self.xcoord,self.ycoord)
    def clear(self,frame):
        self.fillStatus-=1
        self.draw(frame,self.xcoord,self.ycoord)
    def draw(self,frame,x,y):
        self.color=[255-self.fillStatus*255/5,255-self.fillStatus*128/5,255]
        pygame.draw.polygon(frame,self.color,
                            [[self.size*0.5+x,y],
                            [self.size*1.5+x,y],
                            [self.size*2+x,math.sqrt(3)*self.size/2+y],
                            [self.size*1.5+x,math.sqrt(3)*self.size+y],
                            [self.size*0.5+x,math.sqrt(3)*self.size+y],
                            [x,math.sqrt(3)*self.size/2+y]])
if __name__ == "__main__":
    pygame.init()
    random.seed()
    hexagonList=[]
    game = Game(hexagonList,random)  
