
/**
 * Write a description of class Estudiante here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Estudiante
{
    // instance variables - replace the example below with your own
    private String nombre;
    private int carnet;
    Grupo notas;
    private int promedio;

    /**
     * Constructor for objects of class Estudiante
     */
    public Estudiante()
    {
        // initialise instance variables
        nombre = "";
        carnet = 0;
        notas = null;
        promedio = 0;
    }

    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public int getCarnet()
    {
        return carnet;
    }
    
    public void setCarnet(int carnet)
    {
        this.carnet = carnet;
    }
    
    public Grupo getNotas()
    {
        return notas;
    }
    
    public void setNotas(Grupo notas)
    {
        this.notas = notas;
    }
    
    public int getPromedio()
    {
        return promedio;
    }
    
    public void setPromedio(int promedio)
    {
        this.promedio = promedio;
    }
    
    public String toString(Estudiante obj) {
        
        
        return "(" + obj.nombre + " - " + obj.carnet + " - " + obj.promedio + ")";
    }
    
    public void promedio(NodoLista reco, int acumulado, int contador)
    {
        
        if(reco!=null)
        {
            NodoLista auxiliar = reco;
            
            
            if(auxiliar.getSiguiente() != null)
            {
                promedio(reco.getSiguiente(), acumulado, contador);
                acumulado = acumulado + auxiliar.getValor();
                contador++;
                auxiliar = auxiliar.getSiguiente();
                
            }
            else
            {
                acumulado = acumulado + auxiliar.getValor();
                contador++;
            }
            
            //System.out.println("Posicion: " + posicion + " Valor: " + auxiliar.getValor());
        }
    }
}
