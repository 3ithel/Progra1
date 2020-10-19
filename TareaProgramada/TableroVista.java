
/**
 * Vista del programa.
 *
 * @author Eithel Jose Vega Robles
 * @version 8/10/20
 */
public class TableroVista
{
   
    
    
    /**
     * Constructor for objects of class Tablero
     */
    public TableroVista()
    {
       
    }

    /**
     * anuncia que es el turno del jugador 1
     */
    
    public void turno1() {
        System.out.println("Es el turno del jugador 1");
        System.out.println("Seleccione una columna para tirar la ficha");
    }
    
    /**
     * anuncia que es el turno de la maquina
     */
    public void turno2( int seleccion ) {
        if ( seleccion == 1 ) {
            System.out.println("Es el turno del jugador 2");
            System.out.println("Seleccione una columna para tirar la ficha");
        }  //fin del if 
            
        if ( seleccion == 2 ) {
            System.out.println("Es el turno de la maquina");
        }//fin del if
    }
    
}
