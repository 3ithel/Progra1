import java.util.Scanner;
/**
 * El modelo del programa, los datos se introducen aqui por el usuario.
 *
 * @author Eithel Jose Vega Robles
 * @version 8/10/20
 */
public class Modelo
{
    // instance variables - replace the example below with your own
    private int x;
    int seleccion;//la seleccion que se hizo
    int caidaFicha;//
    
    Scanner entrada = new Scanner( System.in );
    /**
     * Constructor for objects of class Modelo
     */
    public Modelo()
    {
        seleccion = 0;// la selecci[on que hace el usuario al presentarsele el menu
        caidaFicha = 0;// la columna donde caera la ficha, elegida por un usuario.
    }

    /**
     * El menu desplegable del juego, lo que elije el usuario se guarda aqui
     *
     * 
     */
    public void despliegueUsuario()
    {
        // put your code here
        System.out.println("A continuacion se presenta un juego de 4 en raya en un tablero de 7x6");
        System.out.println("puede elegir jugar contra otro jugador o contra la maquina");
        System.out.println("seleccione su modo de juego insertando el numero correspondiente");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("1. Jugar en turnos con otra persona");
        System.out.println("2. Jugar contra la maquina");
        System.out.println("3. Salir");
        
        Modelo menu = new Modelo();
        seleccion = menu.menuNumero(seleccion, 1, 3);
        
    }
    
    /**
     * pide el numero por el cual caera la ficha y avisa si la columna esta llena
     */
    public int pedirColumna(int matriz[][]) {
        
        do {
        caidaFicha = menuNumero( caidaFicha, 1, 7 );
        if ( matriz[0][caidaFicha] == 0) {
            System.out.println("Esta columna ya esta llena, puede elegir otra");
        } 
       } while ( matriz[0][caidaFicha] == 0 );
        
        return caidaFicha;
    }
    
    
    
    /**
     * pide la opcion del menu que se quiere
     */
    public int menuNumero ( int seleccion, int primOpc, int ultimOpc ) {
        Scanner entrada = new Scanner( System.in );
        
        do {
            try {
            seleccion = entrada.nextInt();
            if ( seleccion < primOpc || seleccion > ultimOpc ) {
                System.out.println("Por favor inserte un numero entre el " + primOpc +" y el " + ultimOpc);
            }
          } 
          catch ( java.util.InputMismatchException e ) {
            System.out.println("Por favor inserte un numero entre el " + primOpc +" y el " + ultimOpc);
            
              entrada.next();
              continue;
          }//Fin del TryCatch
            
        }
        while ( seleccion < primOpc || seleccion > ultimOpc );
        
        return seleccion;
    }
    
    /**
     * no hace gran cosa, permite que el usuario pueda leer lo ultimo antes de que se 
     * limpie la pantalla.
     */
    public void continuar () {
        Scanner entrada = new Scanner( System.in );
        System.out.println("presione cualquier cosa para continuar");
        String continuar = entrada.nextLine();
    }
}
