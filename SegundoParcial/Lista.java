
public class Lista
{
    // instance variables - replace the example below with your own
    private NodoLista inicio;
    private int tamanio;

    public void Lista()
    {
        inicio = null;
        tamanio = 0;
    }

    public boolean esVacia()
    {
        return inicio == null;
    }
    
    public int getTamanio()
    {
        return tamanio;
    }
    
    public void agregarAlFinal(int valor)
    {
        NodoLista nuevoNodo = new NodoLista();
        nuevoNodo.setValor(valor);
        
        if(esVacia())
        {
            inicio = nuevoNodo;
        }
        else
        {
            NodoLista auxiliar = inicio;
            
            while(auxiliar.getSiguiente() != null)
            {
                auxiliar = auxiliar.getSiguiente();
            }
            
            auxiliar.setSiguiente(nuevoNodo);
        }
        
        tamanio++;
    }
    
    public void agregarAlInicio(int valor)
    {
        NodoLista nuevoNodo = new NodoLista();
        nuevoNodo.setValor(valor);
        
        if(esVacia())
        {
            inicio = nuevoNodo;
        }
        else
        {
            nuevoNodo.setSiguiente(inicio);
            inicio = nuevoNodo;
        }
        
        tamanio++;
    }
    
    
    public void imprimirLista()
    {
        if(!esVacia())
        {
            NodoLista auxiliar = inicio;
            int posicion = 0;
            
            while(auxiliar.getSiguiente() != null)
            {
                System.out.println("Posicion: " + posicion + " Valor: " + auxiliar.getValor());
                auxiliar = auxiliar.getSiguiente();
                posicion++;
            }
            
            System.out.println("Posicion: " + posicion + " Valor: " + auxiliar.getValor());
        }
    }
    
}
