import java.util.Scanner;
/**
 * Write a description of class Metodos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Metodos
{
    public void agregarElemento ( Lista lista, int valor, int potencia ) {
        lista.agregar( valor, potencia );
    }
    
    public void menu ( Lista lista1, Lista lista2 ) {
        System.out.println("Bienvenido a la calculadora de ecuaciones, seleccione el metodo de");
        System.out.println("obtencion de las ecuaciones para posteriormente aplicarles una operacion");
        System.out.println("----------------------------------------------------------------");
        System.out.println("1. Digitar manualmente las ecuaciones para simplificarlas");
        System.out.println("2. Extraer las ecuaciones desde un archivo de texto externo");
        System.out.println("");
        
        Scanner entrada = new Scanner( System.in );
        int seleccion = 0;
        
        seleccion = menuNumero(seleccion, 1, 2);
        
        if ( seleccion == 1 ) {
            System.out.println("IMPORTANTE: si lo que se va a llevar a cabo son divisiones, por favor");
            System.out.println("solo inserte un elemento (un monomio), de lo contrario el programa no lo");
            System.out.println("aceptara despues");
            System.out.println("");
            digitar(lista1, lista2);
        } else {
            extraer(lista1, lista2);
        }
    }
    
    public void digitar ( Lista lista1, Lista lista2 ) {
        int valor = 0;
        int potencia = 0;
        Scanner entrada = new Scanner( System.in );
        
        System.out.println("A continuacion usted tiene que digitar uno por uno los elementos de la PRIMERA");
        System.out.println("ecuacion que serian el valor y la potencia de la incognita, solo se admiten");
        System.out.println("numeros enteros, cuando desee detenerse escriba el numero 9999 al momento");
        System.out.println("en el que se le solicite escribir el valor");
        System.out.println("");
        
        while ( valor != 9999 ) {
            System.out.println("Digite el valor que multiplicara a la incognita en este elemento");
            System.out.println("recuerde que mientras se le pide el valor puede escribir 9999 para parar");
            System.out.println("");
            
            valor = entrada.nextInt();
            
            if (valor != 9999 ) {
                System.out.println("Digite el valor que sera la potencia de la incognita");
                System.out.println("");
            
                potencia = menuNumero(potencia, 0, 9);
                
                agregarElemento(lista1, valor, potencia);
            }
        }
        
        valor = 0;
        
        System.out.println("A continuacion usted tiene que digitar uno por uno los elementos de la SEGUNDA");
        System.out.println("ecuacion que serian el valor y la potencia de la incognita, solo se admiten");
        System.out.println("numeros enteros, cuando desee detenerse escriba el numero 9999 al momento");
        System.out.println("en el que se le solicite escribir el valor");
        System.out.println("");
        
        while ( valor != 9999 ) {
            System.out.println("Digite el valor que multiplicara a la incognita en este elemento");
            System.out.println("recuerde que mientras se le pide el valor puede escribir 9999 para parar");
            System.out.println("");
            
            valor = entrada.nextInt();
            
            if (valor != 9999 ) {
                System.out.println("Digite el valor que sera la potencia de la incognita");
                System.out.println("");
            
                potencia = entrada.nextInt();
                
                agregarElemento(lista2, valor, potencia);
            }
        }
    }
    
    public void extraer ( Lista lista1, Lista lista2 ) {
        Scanner entrada = new Scanner( System.in );
        String leido = "";
        int i = 0;
        String valorStr = "";
        int posicion = 0;
        int valorInt = 0;
        int potenciaInt = 0;
        String signo = "";
        int lugarRaya = 0;
        String directorio = "";
        
        System.out.println("Por favor inserte el directorio de donde se extraera la ecuacion");
        System.out.println("");
        
        directorio = entrada.nextLine();
        
        Lector lector = new Lector(directorio);
        leido = lector.leerArchivo();
        
        lugarRaya = leido.indexOf("|", 0);
        
        //para la lectura de la primera lista
        do {
            posicion = leido.indexOf("x", i);
            valorStr = leido.substring(i,posicion);
            valorInt = Integer.parseInt(valorStr);
            
            posicion = posicion + 2;
            
            valorStr = leido.substring(posicion,posicion + 1);
            potenciaInt = Integer.parseInt(valorStr);
            
            lista1.agregar(valorInt, potenciaInt);
            
            posicion = posicion + 1;
            i = posicion;
            
            signo = leido.substring(posicion, posicion + 1);
            
        } while ( i < lugarRaya ); 
    }
    
    public int menuNumero ( int seleccion, int primOpc, int ultimOpc ) {
        Scanner entrada = new Scanner( System.in );
        
        do {
            try {
                seleccion = entrada.nextInt();
                if ( seleccion < primOpc || seleccion > ultimOpc ) {
                    System.out.println("Por favor inserte un numero entre el " + primOpc +" y el " + ultimOpc);
                }
            } 
            catch ( java.util.InputMismatchException e ) {
                System.out.println("Por favor inserte un numero entre el " + primOpc +" y el " + ultimOpc);
            
                entrada.next();
                continue;
            }//Fin del TryCatch
            
        }
        while ( seleccion < primOpc || seleccion > ultimOpc );
        
        return seleccion;
    }
}