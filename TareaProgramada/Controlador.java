import java.util.concurrent.ThreadLocalRandom;
/**
 * Controlador del programa, los procedimientos matematicos se hacen aqui.
 *
 * @author Eithel Jose Vega Robles
 * @version 8/10/20
 */
public class Controlador
{
    // instance variables - replace the example below with your own
    int filas;
    int columnas;
    int[][] tableroMtrz;
    int ganador;// cuando haya un ganador el valor sera de 1
    int empate;// solo es empate cuando no hay valores 0 en el tablero
    
    /**
     * Constructor for objects of class Controlador
     */
    public Controlador()
    {
        // no se toman las filas ni las columnas 0, ya que sirven como guia y el enunciado lo requiere
        filas = 7;
        columnas = 8;
        tableroMtrz = new int[filas][columnas];
        //toda la primera fila viene con 6 por defecto
        tableroMtrz[0][1] = 6;
        tableroMtrz[0][2] = 6;
        tableroMtrz[0][3] = 6;
        tableroMtrz[0][4] = 6;
        tableroMtrz[0][5] = 6;
        tableroMtrz[0][6] = 6;
        tableroMtrz[0][7] = 6;
        
        ganador = 0;
        empate = 0;
        
    }
    
    /**
     * Aisla completamente el juego contra la maquina y contra el usuario y corta el do while
     * cuando se le solicita
     */
    public int modoJuego(int[][] tablero, int seleccion) {
        int salir = 0;
        switch (seleccion) {
            
            case 1:
            contraUsuario(tableroMtrz);
            
            break;
        
            case 2:
            contraIA(tableroMtrz);
            
            break;
            
            case 3:
            salir = 1;
            
            break;
        }
        return salir;
    }

    /**
     * El bloque de codigo por si se esta jugando contra un usuario
     *
     * @param  tableroMtrz
     * @return    No retorna nada al ser void
     */
    static void contraUsuario(int[][] tablero)
    {
        
        
      TableroVista vista = new TableroVista();
      Modelo modelo = new Modelo();
      Controlador control = new Controlador();
       do {
           vista.turno1();
           int caidaFicha = modelo.pedirColumna(tablero);
           control.llenado(tablero, caidaFicha, 1);
           control.empate = control.mostrarTablero(tablero);
           control.ganador = control.motor(tablero, 1);
        
           if ( control.ganador == 0 ) {
            vista.turno2(1);
            caidaFicha = modelo.pedirColumna(tablero);
            control.llenado(tablero, caidaFicha, 2);
            control.empate = control.mostrarTablero(tablero);
            control.ganador = control.motor(tablero, 2);
         }
        
        
      }
        while(control.ganador == 0 && control.empate != 0 );
    }
    
    /**
     * El bloque de codigo que se ejecuta al jugar contra la compu
     */
    static void contraIA(int[][] tablero) {
        
        TableroVista vista = new TableroVista();
      Modelo modelo = new Modelo();
      Controlador control = new Controlador();
       do {
           vista.turno1();
           //al principio se basa en la posici[on de la ficha del jugador
           int caidaFicha = modelo.pedirColumna(tablero);
           control.llenado(tablero, caidaFicha, 1);
           control.empate = control.mostrarTablero(tablero);
           control.ganador = control.motor(tablero, 1);
        
           if ( control.ganador == 0 ) {
            vista.turno2(1);
            int fichaIA = control.seleccionIA(tablero);
            control.llenado(tablero, fichaIA, 2);
            control.empate = control.mostrarTablero(tablero);
            control.ganador = control.motor(tablero, 2);
         }
        
        
      }
        while(control.ganador == 0 && control.empate != 0 );
    }
    
    /**
     * Se modifica el tablero con las fichas que van cayendo
     */
    static void llenado( int[][] tablero, int columna, int numJugador ) {
        //se toma el tablero, la seleccion que se hizo previamente de ficha y el numero del jugador,
        //que esta ejecutando la ronda
        //
        
        if ( tablero[0][columna] != 0 ) {
            tablero[tablero[0][columna]][columna] = numJugador;
            tablero[0][columna]--;
        }
        for (int i = 1; i < 7; i++) {
            if (tablero[0][i] == 0) {
                System.out.println("La columna " + i + " ya esta llena");
            }
        }
    }
    
    /**
     * Detecta cuando hay 4 en raya por todos los angulos posibles
     */
    static int motor( int[][] tablero, int numJugador) {
        int ganador = 0;
        for ( int filas = 1; filas < tablero.length; filas++ ) {
            
            for ( int columnas = 1; columnas < 5; columnas++ ) {
                //recorre todo el tablero en busca de 4 en raya horizontales
                int suma1 = tablero[filas][columnas + 1];
                int suma2 = tablero[filas][columnas + 2];
                int suma3 = tablero[filas][columnas + 3];
                
                if ( tablero[filas][columnas] == numJugador) {
                    if ( tablero[filas][columnas] == suma1 && suma1 == suma2 && suma2 == suma3) {
                        System.out.println("ha ganado el jugador " + numJugador);
                        ganador = 1;
                    }
                }
                
            }
            
        }
        
        if ( ganador == 0 ) {
            for ( int columnas = 1; columnas < tablero[0].length; columnas++ ) {
            
                for ( int filas = 1; filas < 4; filas++ ) {
                    //recorre todo el tablero en busca de 4 en raya verticales
                    int suma1 = tablero[filas + 1][columnas];
                    int suma2 = tablero[filas + 2][columnas];
                    int suma3 = tablero[filas + 3][columnas];
                
                    if ( tablero[filas][columnas] == numJugador) {
                        if ( tablero[filas][columnas] == suma1 && suma1 == suma2 && suma2 == suma3) {
                        System.out.println("ha ganado el jugador " + numJugador);
                        ganador = 1;
                    }
                }
                
                
            }
            
          }
        }
       
        if ( ganador == 0 ) {
            
            int prueba = 1;
            for ( int columnas = 1; columnas < 8; columnas++ ) {
                
                for ( int filas = 6; filas > 0; filas-- ) {
                    //recorre todo el tablero en busca de 4 en diagonales de un lado.
                    int filaAnterior = filas - 3;
                    int columnaAnterior = columnas - 3;
                    int suma1 = 0;
                    int suma2 = 0;
                    int suma3 = 0;
                    if ( filaAnterior > 0 && columnaAnterior > 0 ) {
                        suma1 = tablero[filas - 1][columnas - 1];
                        suma2 = tablero[filas - 2][columnas - 2];
                        suma3 = tablero[filas - 3][columnas - 3];
                    }
                    
                    if ( tablero[filas][columnas] == numJugador) {
                        if ( tablero[filas][columnas] == suma1 && suma1 == suma2 && suma2 == suma3) {
                        System.out.println("ha ganado el jugador " + numJugador);
                        ganador = 1;
                    }
                   }
                }
                
                
            }
            
        }
        
        if ( ganador == 0 ) {
            
            int prueba = 1;
            for ( int columnas = 7; columnas > 0; columnas-- ) {
                
                for ( int filas = 6; filas > 0; filas-- ) {
                    //recorre todo el tablero en busca de 4 en diagonales del otro lado.
                    int filaSiguiente = filas - 3;
                    int columnaSiguiente = columnas + 3;
                    int suma1 = 0;
                    int suma2 = 0;
                    int suma3 = 0;
                    if ( filaSiguiente > 0 && columnaSiguiente < 8 ) {
                        suma1 = tablero[filas - 1][columnas + 1];
                        suma2 = tablero[filas - 2][columnas + 2];
                        suma3 = tablero[filas - 3][columnas + 3];
                    }
                    
                    if ( tablero[filas][columnas] == numJugador) {
                        if ( tablero[filas][columnas] == suma1 && suma1 == suma2 && suma2 == suma3) {
                        System.out.println("ha ganado el jugador " + numJugador);
                        ganador = 1;
                    }
                   }
                }
                
                
            }
            
        }
        
        return ganador;
    }
    
    /**
     * Muestra el tablero, controla cuando hay empate tambien
     */
    public int mostrarTablero(int[][] tablero)
    {
        int empate = 0;
        
        
        for ( int filas = 1; filas < tablero.length; filas++ ) {
            
            for ( int columnas = 1; columnas < tablero[0].length; columnas++ ) {
                
                System.out.print(tablero[filas][columnas]);
                System.out.print(" | ");
                
                if (tablero[filas][columnas] == 0) {
                    empate++;
                }
            }
            System.out.println("");
            
        }
        
        return empate;
    }
    
    /**
     * muestra las selecciones que puede hacer la compu.
     */
    public int seleccionIA(int[][] tablero) {
        int fichaIA = 0;
        int turno = 1;
        int opcion1 = ThreadLocalRandom.current().nextInt(1, 7 + 1);;
        int opcion2 = 0;
        int opcion3 = ThreadLocalRandom.current().nextInt(1, 7 + 1);;
        int opcionAleatoria = ThreadLocalRandom.current().nextInt(1, 7 + 1);;
        for ( int filas = 1; filas < tablero.length; filas++ ) {
            
            for ( int columnas = 1; columnas < tablero[0].length; columnas++ ) {
                if ( tablero[filas][columnas] == 1 ) {
                    if ( columnas != 1 ) {
                        opcion1 = columnas - 1;
                    }
                    opcion2 = columnas;
                    if ( columnas != 7 ) {
                        opcion3 = columnas + 1;
                    }
                }
                
            }
            
        }
        
        int eleccionAleatoria = ThreadLocalRandom.current().nextInt(1, 4 + 1);
        switch ( eleccionAleatoria ) {
            case 1:
            fichaIA = opcion1;
            break;
            
            case 2:
            fichaIA = opcion2;
            break;
            
            case 3:
            fichaIA = opcion3;
            break;
            
            case 4:
            fichaIA = opcionAleatoria;
            break;
        
        }
        
        return fichaIA;
    }
    
    /**
     * devuelve al tablero a su estado por defecto para poder jugar otra vez
     */
    public void vaciar ( int tablero[][] ) {
        for ( int filas = 1; filas < tablero.length; filas++ ) {
            for ( int columnas = 1; columnas < tablero[0].length; columnas++ ) {
               tablero[filas][columnas] = 0; 
                
            }
        }
        
        for ( int columnas = 0; columnas < tablero[0].length; columnas++ ) {
            tablero[0][columnas] = 6;
        }
    }
}
