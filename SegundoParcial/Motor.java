import java.util.Scanner;
/**
 * Write a description of class Motor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Motor
{
    
    /**
     * Constructor for objects of class Motor
     */
    public Motor()
    {
        // initialise instance variables
        
    }

    
    public void obtenerDatos(Grupo notas, Grupo estudiantes) {
        int acumulado = 0;
        int contador = 1;
        String nombre = "";
        int carnet = 0;
        int nota = 0;
        int promedio = 0;
        Scanner entrada = new Scanner( System.in );
        
        System.out.println("Por favor ingrese los datos que se le solicitan del estudiante");
        System.out.println("puede ingresar cuantos estudiantes quiera y cuantas notas quiera");
        System.out.println("por estudiante, cuando se quiera detener escriba 0000 cuando se le");
        System.out.println("pida el nombre y -1 cuando quiera dejar de ingresar notas");
        System.out.println("");
        
        while ( nombre != "0000") {
            System.out.println("Por favor escriba el NOMBRE del estudiante, recuerde ingresar");
            System.out.println("0000 para dejar de ingresar los datos");
            System.out.println("");
            nombre = entrada.nextLine();
            
            if ( nombre != "0000" ) {
                System.out.println("Por favor ingrese el CARNET del estudiante");
                System.out.println("");
                carnet = menuNumero(carnet, 0, 999999999);
            
            
                while ( nota != -1) {
                    System.out.println("Ingrese solo una nota, cada vez que vea esto, para detenerse");
                    System.out.println("presione -1");
                    System.out.println("");
                    nota = menuNumero(carnet, -1, 100);
                    
                    if (nota != -1) {
                        notas.agregarEnNotas(nota);
                    }
                }
                
                notas.getInicio().getEstudiante().promedio(notas.getInicio(), acumulado, contador);
                
                promedio = acumulado / contador;
                
                System.out.println("promedio " + promedio);
                
                estudiantes.agregarEnLista(nombre, carnet, notas, promedio);
                
                notas = null;
            }      
        }
    }
    
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
}
