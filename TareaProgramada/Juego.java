
/**
 * Metodo estatico del juego, se ejecuta todo aqui.
 *
 * @author Eithel Jose Vega Robles
 * @version 8/10/20
 */
public class Juego
{
    
    public static void main (String args [])
    {
        Modelo modelo = new Modelo();
        TableroVista vista = new TableroVista();
        Controlador control = new Controlador();
        int salir = 0;
        do{// por si el usuario quiere volver a jugar
            modelo.despliegueUsuario();
            salir = control.modoJuego(control.tableroMtrz, modelo.seleccion );
            control.vaciar(control.tableroMtrz);
            System.out.println("esto es " + salir);
            modelo.continuar();
            System.out.print('\u000c');//limpia toda la pantalla si se tiene la opcion en la terminal de bluej
        }
        while ( salir == 0 );
    }
}
