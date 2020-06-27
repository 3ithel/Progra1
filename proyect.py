from tkinter import *
import random


def same_3(vector_estado):
    puntos = 0
    reps = 0
    for i in range(0, len(vector_estado)):
        for j in range(0, len(vector_estado)):
            if vector_estado[j] == vector_estado[i]:
                reps += 1

    if reps >= 11:
        puntos = vector_estado[0] + vector_estado[1] + vector_estado[2] + vector_estado[3] + vector_estado[4]

    print(f"La puntuacion de tres numeros iguales es: ", puntos)

def same_4(vector_estado):
    puntos = 0
    reps = 0
    for i in range(0, len(vector_estado)):
        for j in range(0, len(vector_estado)):
            if vector_estado[j] == vector_estado[i]:
                reps += 1

    if reps >= 17:
        puntos = vector_estado[0] + vector_estado[1] + vector_estado[2] + vector_estado[3] + vector_estado[4]

    print(f"La puntuacion de cuatro numeros iguales es: ", puntos)



def s_straight(vector_estado):
    puntos = 0
    reps = 0
    rep3 = 0
    rep4 = 0
    error = 0
    for i in range(0, len(vector_estado)):
        for j in range(0, len(vector_estado)):
            if vector_estado[j] == vector_estado[i]:
                reps += 1
            if vector_estado[j] == 3:
                rep3 += 1
    if vector_estado[i] == 4:
            rep4 += 1
    if (reps == 7 or reps == 5) and rep3 == 5 and (rep4 == 2 or rep4 == 1) and vector_estado[i] != 5:
        error += 1
    if (reps == 5 or reps == 7) and ((rep3 == 5 and rep4 == 1) or (rep3 == 10 and rep4 == 1) or \
        (rep3 == 5 and rep4 == 2)) and error == 0:
            puntos = 30
    print(f"La puntuacion de pocos seguidos es: ", puntos)
    print(reps)





def l_straight(vector_estado):
    puntos = 0
    reps = 0
    for i in range(0, len(vector_estado)):
        for j in range(0, len(vector_estado)):
            if vector_estado[j] == vector_estado[i]:
                reps += 1

    if reps == 5:
        puntos = 40

    print(f"La puntuacion de muchos seguidos es: ", puntos)

def yahtzee(vector_estado):
    puntos = 0
    reps = 0
    for i in range(0, len(vector_estado)):
        for j in range(0, len(vector_estado)):
            if vector_estado[j] == vector_estado[i]:
                reps += 1

    if reps == 25:
        puntos = 50

    print(f"La puntuacion de cuatro numeros iguales es: ", puntos)

def pares()
