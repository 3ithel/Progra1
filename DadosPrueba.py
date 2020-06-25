from tkinter import *
import random

import ctypes #Esto es para el About

def about():
    ctypes.windll.user32.MessageBoxW(0, "El Acerca de... puede ser así.", "About...", 64)

def help():
    ctypes.windll.user32.MessageBoxW(0, "La ayuda puede venir así", "Help...", 64)

def roll_dices():  # This function rolls the dices in case they are on/checked.
    if checkDado1.get() is True:  # Verifies if dice01 is on/checked. If so, it rolls.
        valorDado1.set(random.randint(1, 6))  # This assign a new value for Dice02.
    if checkDado2.get() is True:
        valorDado2.set(random.randint(1, 6))
    if checkDado3.get() is True:
        valorDado3.set(random.randint(1, 6))
    if checkDado4.get() is True:
        valorDado4.set(random.randint(1, 6))
    if checkDado5.get() is True:
        valorDado5.set(random.randint(1, 6))
    a = valorDado1.get()  # values a, b, c, d, and e are the "current state" of all the five dices.
    b = valorDado2.get()
    c = valorDado3.get()
    d = valorDado4.get()
    e = valorDado5.get()
    vector_estado = [a, b, c, d, e]  # This stores dices's values in a list
    ones_rules(vector_estado)  # This sends the list to the function onesRules
    twos_rules(vector_estado)  # This sends the list to the function twosRules
    threes_rules(vector_estado)  # This sends the list to the function threeRules
    fours_rules(vector_estado)  # This sends the list to the function foursRules
    fives_rules(vector_estado)  # This sends the list to the function fivesRules
    sixes_rules(vector_estado)  # This sends the list to the function sixesRules
    chance_rule(vector_estado)  # This line sends the list to the function chanceRules


def ones_rules(vector_estado):  # This function sums up all the Ones
    ones_sum = 0
    for i in range(0, len(vector_estado)):
        if vector_estado[i] == 1:
            ones_sum = ones_sum + 1
    print(f"la suma de los unos es: ", ones_sum)


def twos_rules(vector_estado):  # This function sums up all the Twos
    twos_sum = 0
    for i in range(0, len(vector_estado)):
        if vector_estado[i] == 2:
            twos_sum = twos_sum + 2
    print(f"la suma de los dos es: ", twos_sum)


def threes_rules(vector_estado):  # This function sums up all the Threes
    threes_sum = 0
    for i in range(0, len(vector_estado)):
        if vector_estado[i] == 3:
            threes_sum = threes_sum + 3
    print(f"la suma de los tres es: ", threes_sum)


def fours_rules(vector_estado):  # This function sums up all the Fours
    fours_sum = 0
    for i in range(0, len(vector_estado)):
        if vector_estado[i] == 4:
            fours_sum = fours_sum + 4
    print(f"la suma de los cuatros es: ", fours_sum)


def fives_rules(vector_estado):  # This function sums up all the Fives
    fives_sum = 0
    for i in range(0, len(vector_estado)):
        if vector_estado[i] == 5:
            fives_sum = fives_sum + 5
    print(f"la suma de los cincos es: ", fives_sum)


def sixes_rules(vector_estado):  # This function sums up all the Sixes
    sixes_sum = 0
    for i in range(0, len(vector_estado)):
        if vector_estado[i] == 6:
            sixes_sum = sixes_sum + 6
    print(f"la suma de los seises es: ", sixes_sum)


def chance_rule(vector_estado):
    sum_chance = 0
    for i in range(0, len(vector_estado)):
        sum_chance = sum_chance + vector_estado[i]
    print(f"la suma de todos los valores es: ", sum_chance)


window = Tk()
window.config(bd=15)  # borde exterior de 15 píxeles, queda mejor

checkDado1 = BooleanVar()  # This is the checkbox for dice01
checkDado1.set(True)  # Dices are set True for the first roll.
checkDado2 = BooleanVar()
checkDado2.set(True)
checkDado3 = BooleanVar()
checkDado3.set(True)
checkDado4 = BooleanVar()
checkDado4.set(True)
checkDado5 = BooleanVar()
checkDado5.set(True)

valorDado1 = IntVar()  # This is the value for dice01
valorDado2 = IntVar()
valorDado3 = IntVar()
valorDado4 = IntVar()
valorDado5 = IntVar()

Checkbutton(window, text="Dado1", variable=checkDado1).grid(row=0, column=0)
# Label(root,  text="Dado1").grid(row=0,column=1)
Entry(window, justify=CENTER, state=DISABLED, textvariable=valorDado1).grid(row=0, column=2)

Checkbutton(window, text="Dado2", variable=checkDado2).grid(row=1, column=0)
Entry(window, justify=CENTER, state=DISABLED, textvariable=valorDado2).grid(row=1, column=2)

Checkbutton(window, text="Dado3", variable=checkDado3).grid(row=2, column=0)
Entry(window, justify=CENTER, state=DISABLED, textvariable=valorDado3).grid(row=2, column=2)

Checkbutton(window, text="Dado4", variable=checkDado4).grid(row=3, column=0)
Entry(window, justify=CENTER, state=DISABLED, textvariable=valorDado4).grid(row=3, column=2)

Checkbutton(window, text="Dado5", variable=checkDado5).grid(row=4, column=0)
Entry(window, justify=CENTER, state=DISABLED, textvariable=valorDado5).grid(row=4, column=2)

Label(window).grid(row=5, column=0)  # Separador

Button(window, text="Tirar Dados", command=roll_dices).grid(row=6, column=0)
Button(window, text="About", command=about).grid(row=7, column=0)
Button(window, text="Help", command=help).grid(row=7, column=1)

window.mainloop()