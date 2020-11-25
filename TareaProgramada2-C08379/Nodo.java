
public class Nodo
{
    // instance variables - replace the example below with your own
    private int valor;
    private String incognita;
    private int potencia;
    private Nodo siguiente;

    /**
     * Constructor for objects of class Nodo
     */
    public void Nodo()
    {
        this.valor = 0;
        this.incognita = "";
        this.potencia = 0;
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
    
    public String getIncognita()
    {
        return incognita;
    }
    
    public void setIncognita(String incognita)
    {
        this.incognita = incognita;
    }
    
    public int getPotencia()
    {
        return potencia;
    }
    
    public void setPotencia(int potencia)
    {
        this.potencia = potencia;
    }

    public Nodo getSiguiente()
    {
        return siguiente;
    }
    
    public void setSiguiente(Nodo siguiente)
    {
        this.siguiente = siguiente;
    }
}
