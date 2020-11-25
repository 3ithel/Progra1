
public class NodoArbol
{
    // instance variables - replace the example below with your own
    Estudiante estudiante;
    NodoArbol hijoIzquierdo;
    NodoArbol hijoDerecho;

    public NodoArbol(Estudiante estudiante)
    {
        this.estudiante = estudiante;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }
    
    public Estudiante getEstudiante()
    {
        return estudiante;
    }
    
    public NodoArbol getHijoIzquierdo()
    {
        return hijoIzquierdo;
    }

    public NodoArbol getHijoDerecho()
    {
        return hijoDerecho;
    }
    
    public void setEstudiante(Estudiante estudiante)
    {
        this.estudiante = estudiante;
    }
    
    public void setHijoIzquierdo(NodoArbol nuevoNodo)
    {
        hijoIzquierdo = nuevoNodo;
    }

    public void setHijoDerecho(NodoArbol nuevoNodo)
    {
        hijoDerecho = nuevoNodo;
    }
}
