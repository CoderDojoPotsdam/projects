#!/usr/bin/python3
from random import*
v={"1":"Papier",'2': 'Stein',"0":"schere\n"}
def Stein():
    Vg(2)
def Schere():
    Vg(0)
def Papier():
    Vg(1)

def ssp():
    #ssp=Schere, Stein, Papier
    ssp=tkinter.Tk()
    ssp.frame =tkinter.Frame(ssp, relief=RIDGE, borderwidth=30)
    ssp.frame.pack(fill=BOTH,expand=1)
    ssp.label =tkinter.Label(ssp.frame, text = "Schere, Stein, Papier Drücke Etwas!")
    ssp.label.pack(fill=X, expand=1)
    ssp.button = tkinter.Button(ssp.frame,text="Schere",command=Schere)
    ssp.button.pack(side=BOTTOM)
    ssp.button = tkinter.Button(ssp.frame,text="Stein",command=Stein)
    ssp.button.pack(side=BOTTOM)
    ssp.button = tkinter.Button(ssp.frame,text="Papier",command=Papier)
    ssp.button.pack(side=BOTTOM)
    ssp.button = tkinter.Button(ssp.frame,text="Exit",command=ssp.destroy)
    ssp.button.pack(side=BOTTOM)
    v={"1":"Papier",'2': 'Stein',"0":"schere\n"}
    
def Vg(Spieler):
    #vg=Vergleichen
    Computer=randint(0,2)
    c=(Computer-1)%3
    Vg =tkinter.Tk()
    Vg.frame = tkinter.Frame(Vg, relief=RIDGE, borderwidth=30)
    Vg.frame.pack(fill=BOTH,expand=1)
    
    if Spieler==c:
        Vg.label=tkinter.Label(Vg.frame, text="DU gwinnst")
        Vg.label.pack(fill=X,expand=1)
    elif Spieler==Computer:
        Vg.label=tkinter.Label(Vg.frame, text="KEINER gewinnt")
        Vg.label.pack(fill=X,expand=1)
    else:
        Vg.label=tkinter.Label(Vg.frame, text="GEGNER gewinnt")
        Vg.label.pack(fill=X,expand=1)
    Vg.label=tkinter.Label(Vg.frame, text="du hast {} genommen der gegner {} ".format(v[str(Spieler)],v[str(Computer)]))
    Vg.label.pack(fill=X,expand=1)

def Hel():
    #Hel=Hilfe
    Hel = tkinter.Tk()
    frame = tkinter.Frame(Hel, relief=RIDGE, borderwidth=30)
    frame.pack(fill=BOTH, expand=1)
    label=tkinter.Label(frame, text='''Hallo Dies ist das Hilfe Menü, hier können sie alles über das menü
          erfahren. Drücken sie Hilfe für Hilfe, drücken sie ssp um Stein,
          Schere, Papier zu spielen und Exit um Das Menü zu schließen. Wenn
          Sie nicht lesen können fragen sie um Hilfe.:-)''')
    label.pack(fill=X, expand=1)
    button = tkinter.Button(frame,text="zurück",command=Hel.destroy)
    button.pack(side=BOTTOM)

import tkinter
from tkinter.constants import *
tk = tkinter.Tk()
tk.frame = tkinter.Frame(tk, relief=RIDGE, borderwidth=30)
tk.frame.pack(fill=BOTH,expand=1)
tk.label = tkinter.Label(tk.frame, text="Menü(V0.5)")
tk.label.pack(fill=X, expand=1)
tk.button = tkinter.Button(tk.frame,text="Exit",command=tk.destroy)
tk.button.pack(side=RIGHT)
tk.button = tkinter.Button(tk.frame,text="ssp",command=ssp)
tk.button.pack(side=LEFT)
tk.button = tkinter.Button(tk.frame,text="Hilfe",command=Hel)
tk.button.pack(side=BOTTOM)
tk.mainloop()

