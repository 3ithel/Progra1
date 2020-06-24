from tkinter import *
import random

def rollDices(): #This function rolls the dices in case they are on/checked.
    if checkDado1.get()==True: #Verifies if dice01 is on/checked. If so, it rolls.
        valorDado1.set(random.randint(1,6)) #This assign a new value for Dice02.
    if checkDado2.get() == True:
        valorDado2.set(random.randint(1,6))
    if checkDado3.get()==True:
        valorDado3.set(random.randint(1,6))
    if checkDado4.get()==True:
        valorDado4.set(random.randint(1,6))
    if checkDado5.get()==True:
        valorDado5.set(random.randint(1,6))
    a = int(valorDado1.get())
    b = int(valorDado2.get())
    c = int(valorDado3.get())
    d = int(valorDado4.get())
    e = int(valorDado5.get())
    imprimirEstado(a,b,c,d,e)
    #print(a)
    #print(type(a))

def imprimirEstado(a,b,c,d,e):
    print(a+b+c+d+e)

window = Tk()
window.config(bd=15)  # borde exterior de 15 píxeles, queda mejor

checkDado1 = BooleanVar() #This is the checkbox for dice01
checkDado1.set(True) #Dices are set True for the first roll.
checkDado2 = BooleanVar()
checkDado2.set(True)
checkDado3 = BooleanVar()
checkDado3.set(True)
checkDado4 = BooleanVar()
checkDado4.set(True)
checkDado5 = BooleanVar()
checkDado5.set(True)

valorDado1 = StringVar() #This is the value for dice01
valorDado2 = StringVar()
valorDado3 = StringVar()
valorDado4 = StringVar()
valorDado5 = StringVar()

Checkbutton(window, text="Dado1",variable = checkDado1).grid(row=0,column=0)
#Label(root,  text="Dado1").grid(row=0,column=1)
Entry(window, justify=CENTER, state=DISABLED, textvariable=valorDado1).grid(row=0,column=2)

Checkbutton(window,text="Dado2", variable = checkDado2).grid(row=1,column=0)
Entry(window, justify=CENTER, state=DISABLED, textvariable=valorDado2).grid(row=1,column=2)

Checkbutton(window,text="Dado3", variable = checkDado3).grid(row=2,column=0)
Entry(window, justify=CENTER, state=DISABLED, textvariable=valorDado3).grid(row=2,column=2)

Checkbutton(window, text="Dado4", variable = checkDado4).grid(row=3,column=0)
Entry(window, justify=CENTER, state=DISABLED, textvariable=valorDado4).grid(row=3,column=2)

Checkbutton(window,text="Dado5", variable = checkDado5).grid(row=4,column=0)
Entry(window, justify=CENTER, state=DISABLED, textvariable=valorDado5).grid(row=4,column=2)

Label(window).grid(row=5,column=0) # Separador

Button(window, text="Tirar Dados", command=rollDices).grid(row=6,column=0)

window.mainloop()