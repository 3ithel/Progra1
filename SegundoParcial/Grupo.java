
/**
 * Write a description of class Grupo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Grupo
{
    // componentes de las listas
    private NodoLista inicio;
    private int tamanio;
    
    // componentes del arbol
    NodoArbol raiz;
    
    public void Grupo ()
    {
        //constructor de las listas
        inicio = null;
        tamanio = 0;
        
        //constructor del arbol
        raiz = null;
    }
    
    //funciones de las listas
    
    public boolean esVacia()
    {
        return inicio == null;
    }
    
    public int getTamanio()
    {
        return tamanio;
    }
    
    public void agregarEnLista(int valor)
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
    
    //funciones del arbol
    
    public NodoArbol getRaiz()
    {
        return raiz;
    }
    
    private NodoArbol agregarRecursivo(NodoArbol actual, Estudiante valor)
    {
        if(actual == null)
        {
            return new NodoArbol(valor);
        }
        else if( valor.getPromedio() < actual.getEstudiante().getPromedio() )
        {
            actual.setHijoIzquierdo(agregarRecursivo(actual.getHijoIzquierdo(), valor));
        }
        else if( valor.getPromedio() > actual.getEstudiante().getPromedio() )
        {
            actual.setHijoDerecho(agregarRecursivo(actual.getHijoDerecho(), valor));
        }
        else
        {
            return actual;
        }
        
        return actual;
    }
    
    public void agregarHijo(Estudiante valor)
    {
        raiz = agregarRecursivo(raiz, valor);
    }
    
    public void recorrerEnOrden(NodoArbol nodoActual)
    {
        if( nodoActual != null)
        {
            recorrerEnOrden(nodoActual.getHijoIzquierdo());
            System.out.print(" " + nodoActual.getEstudiante());//poner aqui el toString
            recorrerEnOrden(nodoActual.getHijoDerecho());
        }
    }
    
    public void recorrerPreOrden(NodoArbol nodoActual)
    {
        if( nodoActual != null)
        {
            System.out.print(" " + nodoActual.getEstudiante());//poner aqui el toString
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
            System.out.print(" " + nodoActual.getEstudiante());//poner aqui el toString
        }
    }
    
    public boolean buscarElemento(Estudiante valor)
    {
        return buscarElementoRecursivo(raiz, valor);
    }
    
    public boolean buscarElementoRecursivo(NodoArbol actual, Estudiante valor)
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
