
public class Arbol
{
    // instance variables - replace the example below with your own
    NodoArbol raiz;

    public Arbol()
    {
        raiz = null;
    }
    
    public NodoArbol getRaiz()
    {
        return raiz;
    }
    
    private NodoArbol agregarRecursivo(NodoArbol actual, int valor)
    {
        if(actual == null)
        {
            return new NodoArbol(valor);
        }
        else if( valor < actual.getValor() )
        {
            actual.setHijoIzquierdo(agregarRecursivo(actual.getHijoIzquierdo(), valor));
        }
        else if( valor > actual.getValor() )
        {
            actual.setHijoDerecho(agregarRecursivo(actual.getHijoDerecho(), valor));
        }
        else
        {
            return actual;
        }
        
        return actual;
    }
    
    public void agregarHijo(int valor)
    {
        raiz = agregarRecursivo(raiz, valor);
    }
    
    public void recorrerEnOrden(NodoArbol nodoActual)
    {
        if( nodoActual != null)
        {
            recorrerEnOrden(nodoActual.getHijoIzquierdo());
            System.out.print(" " + nodoActual.getValor());
            recorrerEnOrden(nodoActual.getHijoDerecho());
        }
    }
    
    public void recorrerPreOrden(NodoArbol nodoActual)
    {
        if( nodoActual != null)
        {
            System.out.print(" " + nodoActual.getValor());
            recorrerEnOrden(nodoActual.getHijoIzquierdo());
            recorrerEnOrden(nodoActual.getHijoDerecho());
        }
    }
    
    public void recorrerPostOrden(NodoArbol nodoActual)
    {
        if( nodoActual != null)
        {
            recorrerEnOrden(nodoActual.getHijoIzquierdo());
            recorrerEnOrden(nodoActual.getHijoDerecho());
            System.out.print(" " + nodoActual.getValor());
        }
    }
    
    public boolean buscarElemento(int valor)
    {
        return buscarElementoRecursivo(raiz, valor);
    }
    
    public boolean buscarElementoRecursivo(NodoArbol actual, int valor)
    {
        if(actual == null)
        {
            return false;
        }
        else if( valor == actual.getValor() )
        {
            return true;
        }
        
        return valor < actual.getValor() ? buscarElementoRecursivo(actual.getHijoIzquierdo(), valor) : buscarElementoRecursivo(actual.getHijoDerecho(), valor);
    }
    
    public void eliminarNodo(int valor) 
    {
        raiz = eliminarRecursivo(raiz, valor);
    }
    
    public NodoArbol eliminarRecursivo(NodoArbol actual, int valor)
    {
        if (actual == null) 
        {
            return null;
        }
        else if (valor == actual.getValor()) 
        {
            // Si no tiene hijos solo elimino el nodo
            if (actual.getHijoIzquierdo() == null && actual.getHijoDerecho() == null) 
            {
                return null;
            }
            // Solo tiene un hijo
            else if(actual.getHijoIzquierdo() != null && actual.getHijoDerecho() == null)
            {
                return actual.getHijoIzquierdo();
            }
            else if(actual.getHijoIzquierdo() == null && actual.getHijoDerecho() != null)
            {
                return actual.getHijoDerecho();
            }
            // Tiene ambos hijos, buscamos el hijo menor a la derecha
            
            int menorNodo = buscarNodoMenor(actual.getHijoDerecho());
            actual.setValor(menorNodo);
            actual.setHijoDerecho(eliminarRecursivo(actual.getHijoDerecho(), menorNodo));
            return actual;
            
        } 
        else if (valor < actual.getValor()) 
        {
            actual.setHijoIzquierdo(eliminarRecursivo(actual.getHijoIzquierdo(), valor));
            return actual;
        }
        actual.setHijoDerecho(eliminarRecursivo(actual.getHijoDerecho(), valor));
        
        return actual;
    }
    
    private int buscarNodoMenor(NodoArbol actual) 
    {
        return actual.getHijoIzquierdo() == null ? actual.getValor() : buscarNodoMenor(actual.getHijoIzquierdo());
    }
}
