/**
 * Clase de ejemplo dada por el profe, con muchas modificaciones
 * las cuales se incluyen funciones para traer determinado grupo de elementos
 * en ciertas posiciones
 */
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
                if (auxiliar.getValor() < 0 || posicion == 0) {
                    System.out.print(auxiliar.getValor() + auxiliar.getIncognita() + "^" + auxiliar.getPotencia());
                } else {
                    System.out.print( "+" + auxiliar.getValor() + auxiliar.getIncognita() + "^" + auxiliar.getPotencia());
                }
                auxiliar = auxiliar.getSiguiente();
                posicion++;
            }
            if (auxiliar.getValor() < 0) {
                System.out.print(auxiliar.getValor() + auxiliar.getIncognita() + "^" + auxiliar.getPotencia());
            } else {
                System.out.print( "+" + auxiliar.getValor() + auxiliar.getIncognita() + "^" + auxiliar.getPotencia());
            }
        }
    }
    
    public int sacarValor(Lista lista, int posicion)
    {
        if(!esVacia())
        {
            Nodo auxiliar = inicio;
            
            if (posicion == 0) {
                return auxiliar.getValor();
            } else {
                for(int indice = 0; indice < (posicion); indice++)
                {
                    auxiliar = auxiliar.getSiguiente();
                }
                     
                return auxiliar.getValor();
            }
        }
        return 0;
    }
    
    public int sacarValorNegativo(Lista lista, int posicion)
    {
        if(!esVacia())
        {
            Nodo auxiliar = inicio;
            
            if (posicion == 0) {
                return auxiliar.getValor() * -1;
            } else {
                for(int indice = 0; indice < (posicion); indice++)
                {
                    auxiliar = auxiliar.getSiguiente();
                }
                     
                return auxiliar.getValor() * -1;
            }
        }
        return 0;
    }
    
    
    public int sacarPotencia(Lista lista, int posicion)
    {
        if(!esVacia())
        {
            Nodo auxiliar = inicio;
            
            if (posicion == 0) {
                return auxiliar.getPotencia();
            } else {
               for(int indice = 0; indice < (posicion); indice++)
               {
                    auxiliar = auxiliar.getSiguiente();
               }
                     
                return auxiliar.getPotencia();
            }
        }
        return 0;
    }
    
    public boolean existePotencia(int valorReferencia)
    {
        Nodo auxiliar = inicio;
        boolean encontrado = false;
        
        while(auxiliar != null && !encontrado)
        {
            encontrado = (auxiliar.getPotencia() == valorReferencia);
            auxiliar = auxiliar.getSiguiente();
        }
        
        return encontrado;
    }
    
    public void eliminarElementoPorPotencia(int valorReferencia)
    {
        if(existePotencia(valorReferencia))
        {
            Nodo auxiliar = inicio;
            
            if(auxiliar.getPotencia() == valorReferencia)
            {
                inicio = inicio.getSiguiente();
                auxiliar.setSiguiente(null);
            }
            else
            {
                while(auxiliar.getSiguiente().getPotencia() != valorReferencia)
                {
                    auxiliar = auxiliar.getSiguiente();
                }
                
                Nodo nodoSiguiente = auxiliar.getSiguiente().getSiguiente();
                auxiliar.getSiguiente().setSiguiente(null);
                auxiliar.setSiguiente(nodoSiguiente);
            }
            
            tamanio--;
        }
    }
    
    public void agregarAlInicio(int valor, int potencia)
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
            nuevoNodo.setSiguiente(inicio);
            inicio = nuevoNodo;
        }
        
        tamanio++;
    }
    
    
    public void insertarEnPosicion(int valor, int potencia, int posicion)
    {
        if(posicion >= 0 && posicion <= tamanio)
        {
            if(posicion == 0)
            {
                agregarAlInicio(valor, potencia);
            }
            else if(posicion == tamanio)
            {
                agregar(valor, potencia);
            }
            else
            {
                Nodo nuevoNodo = new Nodo();
                nuevoNodo.setValor(valor);
                nuevoNodo.setIncognita("x");
                nuevoNodo.setPotencia(potencia);
                
                Nodo auxiliar = inicio;
                
                for(int indice = 0; indice < (posicion - 1); indice++)
                {
                    auxiliar = auxiliar.getSiguiente();
                }
                
                nuevoNodo.setSiguiente(auxiliar.getSiguiente());
                auxiliar.setSiguiente(nuevoNodo);
                tamanio++;
            }
        }
    }
    
    public void eliminarElementoPorPosicion(int posicion)
    {
         if(posicion >= 0 && posicion <= tamanio)
        {
            Nodo auxiliar = inicio;
            
            if(posicion == 0)
            {
                inicio = inicio.getSiguiente();
                auxiliar.setSiguiente(null);
            }
            else
            {
                for(int indice = 0; indice < (posicion - 1); indice++)
                {
                    auxiliar = auxiliar.getSiguiente();
                }
                
                Nodo nodoSiguiente = auxiliar.getSiguiente().getSiguiente();
                auxiliar.getSiguiente().setSiguiente(null);
                auxiliar.setSiguiente(nodoSiguiente);
            }
            
            tamanio--;
        }
    }
}
