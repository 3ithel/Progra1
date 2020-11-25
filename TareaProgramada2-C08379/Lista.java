
public class Lista
{
    // instance variables - replace the example below with your own
    private Nodo inicio;
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
    
    public void agregar(int valor, int potencia)
    {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setValor(valor);
        nuevoNodo.setIncognita("x");
        nuevoNodo.setPotencia(potencia);
        
        if(esVacia())
        {
            inicio = nuevoNodo;
        }
        else
        {
            Nodo auxiliar = inicio;
            
            while(auxiliar.getSiguiente() != null)
            {
                auxiliar = auxiliar.getSiguiente();
            }
            
            auxiliar.setSiguiente(nuevoNodo);
        }
        
        tamanio++;
    }
    
    public void imprimirLista()
    {
        if(!esVacia())
        {
            Nodo auxiliar = inicio;
            int posicion = 0;
            
            while(auxiliar.getSiguiente() != null)
            {
                System.out.println(auxiliar.getValor() + auxiliar.getIncognita() + "^" + auxiliar.getPotencia());
                auxiliar = auxiliar.getSiguiente();
                posicion++;
            }
            
            System.out.println(auxiliar.getValor() + auxiliar.getIncognita() + "^" + auxiliar.getPotencia());
        }
    }
    
    public boolean existeElemento(int valorReferencia)
    {
        Nodo auxiliar = inicio;
        boolean encontrado = false;
        
        while(auxiliar != null && !encontrado)
        {
            encontrado = (auxiliar.getValor() == valorReferencia);
            auxiliar = auxiliar.getSiguiente();
        }
        
        return encontrado;
    }
    
}
