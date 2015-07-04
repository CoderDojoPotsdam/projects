#!/usr/bin/python2
import pygame
import math
import random
class Game(object):
    def __init__(self,hexalist,random):
        running = True
        advance = True
        
        self.currentTime=0
        self.oldTime=0
        self.timeDifference=0
        screen = pygame.display.set_mode([540,630])
        pygame.display.set_caption('hexagon.py')
        self.firstdraw(screen,hexalist,random)
        self.update(running,screen,hexalist,random)
    def update(self,status,frame,hexalist,random):
        while status == True:
            self.oldTime=self.currentTime
            for i in range(25):
                hexalist[i].update(self.timeDifference,frame,random,self,hexalist)
                hexalist[i].fl+=0.0000006
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    status = False
            pygame.display.flip()
            self.currentTime=pygame.time.get_ticks()
            self.timeDifference=self.currentTime-self.oldTime
        pygame.quit()
    def over(self,frame,hexalist):
        frame.fill([200,0,0])
        
        for i in range(25):
            hexalist[i].fillStatus=0
            hexalist[i].timeupd=800000
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
            #sy=sy-offset*2+1
            placeX=placeX+1.5*size
class Hexagon(object):
    def __init__(self,posX,posY,frame,random,hexalist):
        self.fillStatus=0
        self.size=60
        #self.color=[255-self.fillStatus*255/5,255-self.fillStatus*128/5,255]
        #self.draw(frame,posX,posY)
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
            if self.fillStatus>0:
                self.hitbox(pygame.mouse.get_pos()[0],pygame.mouse.get_pos()[1],frame)
            if random.random()<self.fl:
                self.fill(frame,game,hexalist)
    def hitbox(self,x,y,frame):
        if y>self.ycoord*self.size*math.sqrt(3)/4 and y<self.ycoord+self.size*math.sqrt(3)*3/4:
            if x>self.xcoord and x<self.xcoord+self.size*2:
                self.clear(frame)
                
        elif y>self.ycoord and y<self.ycoord+self.size*math.sqrt(3):
                if x>self.xcoord+self.size/2 and x<self.xcoord+self.size*3/2:
                    self.clear(frame)
                    
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
    
