
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main ( String args []) {
        Grupo listaNotas = new Grupo();
        Grupo listaEstudiantes = new Grupo();
        Grupo arbol = new Grupo();
        Motor motor = new Motor();
        
        motor.obtenerDatos(listaNotas, listaEstudiantes);
        
    }
}
