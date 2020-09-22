import pygame


pygame.init()


DISPLAY_WIDTH = 800
DISPLAY_HEIGHT = 600
FLOOR_HEIGHT = DISPLAY_HEIGHT * 0.9
GRAVITY = 1000
TARGET_FPS = 60
TIME_STEP = 1.0/60
JUMP_FORCE = 600
game_speed = 1

gameDisplay = pygame.display.set_mode((DISPLAY_WIDTH,DISPLAY_HEIGHT))
pygame.display.set_caption('A bit Racey')
dinoImg = pygame.image.load('dino.png')
dinoImg = pygame.transform.scale(dinoImg, (64,64))
DINO_HEIGHT = dinoImg.get_rect().bottom
cactusImg = pygame.image.load('cactus.png')

print(DINO_HEIGHT)
black = (0,0,0)
white = (255,255,255)

clock = pygame.time.Clock()
crashed = False
dinoImg = pygame.image.load('dino.png')
dinoImg = pygame.transform.scale(dinoImg, (64,64))

x =  (DISPLAY_WIDTH * 0.1)
y = (DISPLAY_HEIGHT * 0.5)
dino_position = (x,y)
dino_velocity = (0,0)
cacti = [400]

def apply_gravity(velocity):
    (x,y) = velocity
    y += GRAVITY * TIME_STEP
    return (x,y)

def move(position, velocity):
    (px,py) = position
    (dx,dy) = velocity
    new_px = px + dx * TIME_STEP
    new_py = py + dy * TIME_STEP
    return (new_px,new_py)

def collide_with_ground(position,height):
    (x,y) = position
    return (y+height)>FLOOR_HEIGHT

def jump(velocity):
    (dx,dy) = velocity
    return (dx,dy - JUMP_FORCE)

def dino_jump():
    global dino_velocity
    if not collide_with_ground(dino_position,DINO_HEIGHT + 1):
        return
    dino_velocity = jump(dino_velocity)

def move_cacti(cacti):
    new_cacti = []
    for cactus_x in cacti:
        cactus_x -= game_speed
        if cactus_x > -64:
            new_cacti.append(cactus_x)
    return new_cacti
        

def draw_dino(position):
    gameDisplay.blit(dinoImg, position)

def draw_floor():
    pygame.draw.line(gameDisplay,black,(0,FLOOR_HEIGHT),(DISPLAY_WIDTH,FLOOR_HEIGHT))

def draw_cacti():
    y = FLOOR_HEIGHT-64
    for cactus_x in cacti:
        gameDisplay.blit(cactusImg, (cactus_x,y))

def collide_with_cactus():



while not crashed:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            crashed = True
        elif event.type == pygame.KEYDOWN:
            if event.key == 32:
                # Key was space
                dino_jump()
    # Calculate everything
    dino_velocity = apply_gravity(dino_velocity)
    dino_position = move(dino_position,dino_velocity)
    if collide_with_ground(dino_position,DINO_HEIGHT):
        dino_velocity = (0,0)
        (px,py) = dino_position
        dino_position = (px, FLOOR_HEIGHT - DINO_HEIGHT)
    cacti = move_cacti(cacti)
    
    # Draw everything
    gameDisplay.fill(white)
    draw_dino(dino_position)
    draw_cacti()
    draw_floor()

        
    pygame.display.update()
    clock.tick(60)

pygame.quit()

