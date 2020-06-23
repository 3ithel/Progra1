from tkinter import *
import random

def sumar():
    #r.set( float( n1.get() ) + float(n2.get() ) )
    r1.set(random.randint(1,6))
    r2.set(random.randint(1,6))
    r3.set(random.randint(1,6))
    r4.set(random.randint(1,6))
    r5.set(random.randint(1,6))

# Estructura del formulario
root = Tk()
root.config(bd=15)  # borde exterior de 15 píxeles, queda mejor

# Tres StringVar para manejar los números y el resultado
r1 = StringVar()
r2 = StringVar()
r3 = StringVar()
r4 = StringVar()
r5 = StringVar()

Label(root, text="\nDado1").pack()
Entry(root, justify=CENTER, state=DISABLED, textvariable=r1).pack()

Label(root, text="\nDado2").pack()
Entry(root, justify=CENTER, state=DISABLED, textvariable=r2).pack()

Label(root, text="\nDado3").pack()
Entry(root, justify=CENTER, state=DISABLED, textvariable=r3).pack()

Label(root, text="\nDado4").pack()
Entry(root, justify=CENTER, state=DISABLED, textvariable=r4).pack()

Label(root, text="\nDado5").pack()
Entry(root, justify=CENTER, state=DISABLED, textvariable=r5).pack()

Label(root).pack() # Separador

Button(root, text="Tirar Dados", command=sumar).pack()

root.mainloop()