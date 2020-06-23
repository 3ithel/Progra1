#Aqui arriba iran las funciones
#Hola soy Edwin
#funcion para "Acerca de", jaj creo que es una obviedad
acercaDe = "\n---Acerca de---\nNombre del programa: Yahtzee modificado\n" \
           "Version: aun por definir (recordar las tildes)\n" \
           "Programadores: Edwin Urbina y Eithel Vega\n"
#aqui se ejecuta el menu
print("Bienvenido al juego de Yahtzee")
eleccion = 1
while eleccion<5 and eleccion>0:
      print("\n1 Jugar\n2 Mostrar estadisticas\n3 Ayuda\n4 Acerca de...\n5 Salir\n")
      eleccion = int(input("Para seleccionar una opcion inserte el numero correspondiente: "))
      if eleccion == 4:
            print(acercaDe)