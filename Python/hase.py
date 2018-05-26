from tkinter import *

Fenster = Tk()
Fenster.title("Hase")
Fenster.geometry("150x150")
hase1 = Label(Fenster, text="\ /")
hase2 = Label(Fenster, text="<..>")
hase3 = Label(Fenster, text="||")
hase1.place(x=65, y=65)
hase2.place(x=58, y=75)
hase3.place(x=67, y=90)
p=0

def Hüpfen(e):
    hase1.place(x=65, y=40)
    hase2.place(x=58, y=50)
    hase3.place(x=657, y=65)
    Fenster.after(600, runter) 
def runter():
    hase1.place(x=65, y=65)
    hase2.place(x=58, y=75)
    hase3.place(x=67, y=90)
def pacours():
    global p
    hindernis.place(x=p, y=100)
    p=p-3
    hindernis.after(49, pacours) 
hindernis=Label(Fenster,anchor=W,justify=LEFT, text="################################  #############  ###########################  #################  ################  ##########  #######  ########  ################  ############  ##########################################  ###############   #############   ###############  ###########  #######Möhre")
hindernis.place(x=0, y=100)
pacours()
Fenster.bind("<space>", Hüpfen)
Fenster.mainloop()

"""  \  /
     <..>
      || """
