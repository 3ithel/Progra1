
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
    
    public void agregarEnLista(String nombre, int carnet, Grupo notas)
    {
        NodoLista nuevoNodo = new NodoLista();
        nuevoNodo.getEstudiante().setNombre(nombre);
        nuevoNodo.getEstudiante().setCarnet(carnet);
        nuevoNodo.getEstudiante().setNotas(notas);
        //nuevoNodo.getEstudiante().setNombre(nombre);
        
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
                System.out.println(auxiliar.getEstudiante().toString(auxiliar.getEstudiante()));
                auxiliar = auxiliar.getSiguiente();
                posicion++;
            }
            
            System.out.println(auxiliar.getEstudiante().toString(auxiliar.getEstudiante()));
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
        else if( valor.getPromedio() == actual.getEstudiante().getPromedio() )
        {
            return true;
        }
        
        return valor.getPromedio() < actual.getEstudiante().getPromedio() ? buscarElementoRecursivo(actual.getHijoIzquierdo(), valor) : buscarElementoRecursivo(actual.getHijoDerecho(), valor);
    }
    
    
}
