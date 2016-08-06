import pygame
import math
import random
import os
import decimal
directory = os.getcwd()
music_file = os.path.join(directory, 'Blop-Mark_DiAngelo-79054334.mp3')
class Game(object):
    def __init__(self,hexalist,random,h):
        self.running = True
        self.score=0
        self.currentTime=0
        self.oldTime=0
        self.timeDifference=0
        self.clock=pygame.time.Clock()
        self.done=0
        self.boost=0
        self.laser=0
        screen=pygame.display.set_mode([540,630])
        pygame.display.set_caption('hexagon.py-Move mouse to make stuff white again')
        self.ze_font=pygame.font.Font(None,40)
        self.blop=pygame.mixer.Sound(music_file)
        self.firstdraw(screen,hexalist,random)
        self.update(screen,hexalist,random,h,self.boost,self.laser)
    def update(self,frame,hexalist,random,h,boost,laser):#fcitucrzuxrui
        while self.running == True:
            self.clock.tick(50)
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    self.running = False
                elif event.type==pygame.KEYDOWN:
                    if self.boost >= 20:
                        laser=5
                        print("Laser")
                        self.boost -= 20
            if self.done==25:
                self.win(frame,hexalist)
            self.done=0
            frame.fill([20,20,20])
            pygame.draw.polygon(frame,[255,255,255],[[20*0.5+420,25],[20*1.5+420,25],[20*2+420,math.sqrt(3)*20/2+25],[20*1.5+420,math.sqrt(3)*20+25],[20*0.5+420,math.sqrt(3)*20+25],[420,math.sqrt(3)*20/2+25]])
            if h == 'oRb':
                ff = orb.update(frame)[0]
                fh = orb.update(frame)[1]
            else:
                ff = pygame.mouse.get_pos()[0]
                fh = pygame.mouse.get_pos()[1]
            fg=fh
            for i in range(25):
                hexalist[i].update(frame,random,self,hexalist,ff,fg,boost,laser)
                if hexalist[i].red == 20:
                    self.done += 1
            if laser == True:
                pygame.draw.line(frame,[255,128,0],[0,fh],[640,fh],3)
                laser -=1
            if h == "oRb":
                orb.draw(frame)
            self.a_number=self.ze_font.render(str(self.score),True,[0,128,255],[20,20,20])
            frame.blit(self.a_number,[465,25])
            pygame.display.flip()
        pygame.quit()
    def over(self,frame,hexalist):
        pygame.display.quit() 
        self.running=False
        print("Game over!")
        exit=raw_input("Restart?(yes/no)")
        if exit == "yes":
            pygame.quit()
            pygame.init()
            random.seed()
            hexagonList=[]
            inp = raw_input("Select input mode (mouse,orb)")
            if inp == 'orb':
                game = Game(hexagonList,random,'oRb')
            elif inp == 'mouse':
                game = Game(hexagonList,random,'mOuse')
        elif exit == "no":
            pygame.quit()
    def win(self,frame,hexalist):
        pygame.display.quit() 
        self.running=False
        print("You did it!")
        print("All tiles disappeared!")
        exit=raw_input("Restart(yes/no)?")
        if exit == "yes":
            pygame.quit()
            pygame.init()
            random.seed()
            hexagonList=[]
            inp=raw_input('Select input mode (mouse,orb)')
            if inp == 'orb':
                game = Game(hexagonList,random,'oRb')
            elif inp == 'mouse':
                game = Game(hexagonList,random,'mOuse')
        elif exit == "no":
            pygame.quit()
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
        pygame.draw.polygon(frame,[255,255,255],[[20*0.5+420,25],[20*1.5+420,25],[20*2+420,math.sqrt(3)*20/2+25],[20*1.5+420,math.sqrt(3)*20+25],[20*0.5+420,math.sqrt(3)*20+25],[420,math.sqrt(3)*20/2+25]])
        for i in range(sx):
            offsetPixel=offset*size*math.sqrt(3)/2
            for j in range(sy):
                hexalist.append(Hexagon(x+placeX,y+placeY+offsetPixel,frame,random,hexalist))
                placeY=placeY+size*math.sqrt(3)          
            if offset == 1:
                offset = 0
            else: 
                offset = 1
            placeY=0
            placeX=placeX+1.5*size
class Orb(object):
    def __init__(self):
        self.x=240
        self.y=315
        self.mom_x=6
        self.mom_y=0
    def draw(self,frame):
        pygame.draw.circle(frame,[255,200,0],[int(self.x),int(self.y)],5)
    def update(self,frame):
        self.tempx=self.x*0.998+pygame.mouse.get_pos()[0]*0.002+self.mom_x*0.96
        self.tempy=self.y*0.998+pygame.mouse.get_pos()[1]*0.002+self.mom_y*0.96
        self.mom_x=self.tempx-self.x
        self.mom_y=self.tempy-self.y
        self.x=self.tempx
        self.y=self.tempy
        return [self.x,self.y]

class Hexagon(object):
    def __init__(self,posX,posY,frame,random,hexalist):
        self.fillStatus=0
        self.size=60
        self.timeSpent=0
        self.xcoord=posX
        self.ycoord=posY
        self.red=0
        self.color=[255,255,255]
        self.draw(frame,posX,posY)
        self.fl=0.0005
        self.increase=0.0000014
        self.death=0
    def update(self,frame,random,game,hexalist,x,y,boost,laser):
        if self.fillStatus == 6:
            self.death += 1
        if self.death == 90:
            game.over(frame,hexalist)
        if self.fillStatus < 6:
            self.death = 0
        if self.fillStatus>0 and self.red<20:
            self.hitbox(x,y,frame,game,laser)
        if random.random()<self.fl and self.red<20:
            self.fill(frame,game,hexalist)
        self.determineColor()
        
        self.draw(frame,self.xcoord,self.ycoord)
        self.fl+=self.increase
    def determineColor(self):
        if self.death != 0:
            self.color = [255,255-((self.death+1)*255/91),255-((self.death+1)*255/91)]
        else:
            self.color = [255-self.fillStatus*255/6,255-self.fillStatus*(255*self.red/19)/6,255]
            if self.red==20:
                self.color=[20,20,20]
        print(self.color)   
    def hitbox(self,x,y,frame,game,laser):
        if y>self.ycoord and y<self.ycoord+self.size*math.sqrt(3):
            if abs(y-self.ycoord-self.size*math.sqrt(3)/2)/math.sqrt(3)+abs(x-self.xcoord-self.size)<self.size:
                self.clear(frame,game)
                game.score+=1
                game.boost +=1
                #print(game.boost)
        if laser==True and y>self.ycoord and y<self.ycoord+self.size*math.sqrt(3):
            if self.fillStatus<0:
                fillStatus=0
            self.clear(frame,game,True)
            game.score+=1
            game.boost+=1
            self.fl-=0.00006
    def fill(self,frame,game,hexalist):
        if self.fillStatus < 6:
            self.fillStatus=self.fillStatus+1
        #if self.fillStatus==6:
        #    game.over(frame,hexalist)
    def clear(self,frame,game,full=False):
        if self.red<20 and random.random()<0.5:
            self.red+=1
        game.blop.play()
        if full==True:
            self.fillStatus=0
        elif self.fillStatus>0:
            self.fillStatus-=1
        self.draw(frame,self.xcoord,self.ycoord)
    def draw(self,frame,x,y):
        #self.color = [255-self.fillStatus*255/6,255-self.fillStatus*(255*self.red/19)/6,255]
        #if self.red==20:
            #self.color=[20,20,20]
        pygame.draw.polygon(frame,self.color,[[self.size*0.5+x,y],[self.size*1.5+x,y],[self.size*2+x,math.sqrt(3)*self.size/2+y],[self.size*1.5+x,math.sqrt(3)*self.size+y],[self.size*0.5+x,math.sqrt(3)*self.size+y],[x,math.sqrt(3)*self.size/2+y]])
if __name__ == "__main__":
    pygame.init()
    random.seed()
    hexagonList=[]
    orb=Orb()
    inp=raw_input('Select input mode (mouse,orb)')
    if inp == 'orb':
        game = Game(hexagonList,random,'oRb')
    elif inp == 'mouse':
        game = Game(hexagonList,random,'mOuse')