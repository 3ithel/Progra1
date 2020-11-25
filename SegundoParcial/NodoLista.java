
public class NodoLista
{
    // instance variables - replace the example below with your own
    private int valor;
    private Estudiante estudiante;
    private NodoLista siguiente;

    /**
     * Constructor for objects of class Nodo
     */
    public void NodoLista()
    {
        this.valor = 0;
        this.estudiante = null;
        this.siguiente = null;
    }
    
    public int getValor()
    {
        return valor;
    }
    
    public void setValor(int valor)
    {
        this.valor = valor;
    }
    
    public Estudiante getEstudiante()
    {
        return estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante)
    {
        this.estudiante = estudiante;
    }

    public NodoLista getSiguiente()
    {
        return siguiente;
    }
    
    public void setSiguiente(NodoLista siguiente)
    {
        this.siguiente = siguiente;
    }
}

