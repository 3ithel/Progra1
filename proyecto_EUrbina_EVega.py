from tkinter import *
import random

import ctypes #Esto es para el About

def about():
    ctypes.windll.user32.MessageBoxW(0, "El Acerca de... puede ser así.", "About...", 64)
    #Ref: https://stackoverflow.com/questions/2963263/how-can-i-create-a-simple-message-box-in-python

def help():
    ctypes.windll.user32.MessageBoxW(0, "La ayuda puede venir así", "Help...", 64)
    helpButton.config(state="disabled")

def close_window():
    window.destroy()
    #Ref:https://stackoverflow.com/questions/9987624/how-to-close-a-tkinter-window-by-pressing-a-button

cantidad_de_unos=0

def roll_dices():  # This function rolls the dices in case they are on/checked.
    if checkDado1.get() is True:  # Verifies if dice01 is on/checked. If so, it rolls.
        valorDado1.set(random.randint(1, 6))  # This assign a new value for Dice02.
        cantidad_de_unos=cantidad_deunos=+1
        print(cantidad_de_unos)
    if checkDado2.get() is True:
        valorDado2.set(random.randint(1, 6))
    if checkDado3.get() is True:
        valorDado3.set(random.randint(1, 6))
    if checkDado4.get() is True:
        valorDado4.set(random.randint(1, 6))
    if checkDado5.get() is True:
        valorDado5.set(random.randint(1, 6))
    a = valorDado1.get()  # values a, b, c, d, and e are the "current state" of all the five dices.
    b = valorDado2.get() # Ref: https://stackoverflow.com/questions/52867693/converting-intvar-value-to-int/52867752
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

vector_estado_j1=[]
def ones_rules(vector_estado):  # This function sums up all the Ones
    ones_sum = 0
    for i in range(0, len(vector_estado)): #Ref: https://wiki.python.org/moin/ForLoop
        if vector_estado[i] == 1:
            ones_sum = ones_sum + 1
    print(f"la suma de los unos es: ", ones_sum)
    return ones_sum



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
helpButton = Button(window, text="Help", state=NORMAL, command=help).grid(row=7, column=1)
exitButton = Button(window, text="Salir", command=close_window).grid(row=7, column=2)

Label(window, text="Unos").grid(row=0, column=4)
Label(window, text="Dos").grid(row=1, column=4)
Label(window, text="Tres").grid(row=2, column=4)
Label(window, text="Cuatros").grid(row=3, column=4)
Label(window, text="Cincos").grid(row=4, column=4)
Label(window, text="Seis").grid(row=5, column=4)
Label(window, text="Tres Iguales").grid(row=6, column=4)
Label(window, text="Cuatro Iguales").grid(row=7, column=4)
Label(window, text="Tres").grid(row=8, column=4)
Label(window, text="Cuatros").grid(row=9, column=4)
Label(window, text="Odds or Evens").grid(row=10, column=4)
Label(window, text="Pares o impares").grid(row=11, column=4)
Label(window, text="Escalera 4").grid(row=12, column=4)
Label(window, text="Escalera de 5").grid(row=13, column=4)
Label(window, text="Chance").grid(row=14, column=4)
Label(window, text="Yathzee").grid(row=15, column=4)
#Label(window, text="Cincos").grid(row=16, column=4)

def appear(index, letter):

    # Disable the button by index
    buttons[index].config(state="disabled")

estadoJugador1=[1,2,3,4,5,6]

# A collection (list) to hold the references to the buttons created below
buttons = []

for index in range(16):
    #n=estadoJugador1[index]

    button = Button(window, bg="White", text="1", width=5, height=1, relief=GROOVE,
                    command=lambda index=index: appear(index))

    # Add the button to the window
    button.grid(padx=2, pady=2, row=index, column=5)

    # Add a reference to the button to 'buttons'
    buttons.append(button)

    # A collection (list) to hold the references to the buttons created below
    buttons = []

    for index in range(16):
        # n=estadoJugador1[index]

        button = Button(window, bg="White", text="2", width=5, height=1, relief=GROOVE,
                        command=lambda index=index: appear(index))

        # Add the button to the window
        button.grid(padx=2, pady=2, row=index, column=6)

        # Add a reference to the button to 'buttons'
        buttons.append(button)

window.mainloop()