#Aqui arriba iran las funciones
#funcion para "Acerca de", jaj creo que es una obviedad
def acercaDe():
    x = "---Acerca de---\nNombre del programa: Yahtzee modificado\n" \
           "Version: aun por definir (recordar las tildes)\n" \
           "Programadores: Edwin Urbina y Eithel Vega\n"
    print(x)
#las ayudas viene aca, el texto queda junto entre si
def ayuda():
    x = "\naqui van a ir las instrucciones, no se que vamos a poner todavia\npero lo podemos hacer en una carrera"
    print(x)
#aqui se ejecuta el menu
print("Bienvenido al juego de Yahtzee")
eleccion = 1
while eleccion<5 and eleccion>0:
      print("\n1 Jugar\n2 Mostrar estadisticas\n3 Ayuda\n4 Acerca de...\n5 Salir\n")
      eleccion = int(input("Para seleccionar una opcion inserte el numero correspondiente: "))
      if eleccion == 3:
         ayuda()
      if eleccion == 4:
            acercaDe()

