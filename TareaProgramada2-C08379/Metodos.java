import java.util.Scanner;
/**
 * El corazon del trabajo, lo que lo hace funcionar de verdad, el motor
 *
 * @author (Eithel Jose Vega Robles)
 * @version (29/11/20)
 */
public class Metodos
{   
    int seleccion;
    String operacion;
    
    public Metodos () {
        seleccion = 0;
        operacion = "";
        
    }
    
    /**
     * Agrega el elemento especificando a que lista se quiere agregar
     */
    public void agregarElemento ( Lista lista, int valor, int potencia ) {
        lista.agregar( valor, potencia );
    }
    
    /**
     * Se encarga de colocarnos en la recoleccion de datos manual l la lectura de archivos
     */
    public void menu ( Lista lista1, Lista lista2) {
        System.out.println("Bienvenido a la calculadora de ecuaciones, seleccione el metodo de");
        System.out.println("obtencion de las ecuaciones para posteriormente aplicarles una operacion");
        System.out.println("----------------------------------------------------------------");
        System.out.println("1. Digitar manualmente las ecuaciones para simplificarlas");
        System.out.println("2. Extraer las ecuaciones desde un archivo de texto externo");
        System.out.println("");
        
        Scanner entrada = new Scanner( System.in );
        seleccion = 0;
        
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
    
    /**
     * Cumple funcion de Vista y Modelo al mismo tiempo, se encarga de toda la
     * recoleccion de datos para formar las dos listas 
     */
    public void digitar ( Lista lista1, Lista lista2) {
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
        
        do {
            System.out.println("Inserte lo que quiere hacer con las ecuaciones ingresadas");
            System.out.println("");
            System.out.println("1. Sumarlas");
            System.out.println("2. Restarlas");
            System.out.println("3. Dividirlas (si no son monomios no se procedera)");
            System.out.println("4. Multiplicarlas");
        
            seleccion = menuNumero(seleccion, 1, 4);
        
            if (seleccion == 3 && lista1.getTamanio() != 1 && lista2.getTamanio() != 1) {
                System.out.println("No se puede proceder con la division, elija otra opcion");
                System.out.println("");
                
            }
        } while (seleccion == 3 && lista1.getTamanio() != 1 && lista2.getTamanio() != 1);
        
        if (seleccion == 1) {
            operacion = "+";
        }
        
        if (seleccion == 2) {
            operacion = "-";
        }
        
        if (seleccion == 3) {
            operacion = "/";
        }
        
        if (seleccion == 4) {
            operacion = "*";
        }
    }
    
    /**
     * Si se llega a elegir sacar los datos por archivo, este se encargara de leer y recolectar
     */
    public void extraer ( Lista lista1, Lista lista2) {
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
        int lugarOperacion = 0; //cambio
        
        
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
        
        posicion++;
        
        lugarOperacion = posicion;
        
        operacion = String.valueOf(leido.charAt(lugarOperacion));
        
        i = leido.lastIndexOf("|") + 1;
        
        do {
            posicion = leido.indexOf("x", i);
            
            if (posicion != -1) {
                valorStr = leido.substring(i,posicion);
                valorInt = Integer.parseInt(valorStr);
            
                posicion = posicion + 2;
            
                valorStr = leido.substring(posicion,posicion + 1);
                potenciaInt = Integer.parseInt(valorStr);
            
                lista2.agregar(valorInt, potenciaInt);
            
                posicion = posicion + 1;
                i = posicion;
            
                signo = leido.substring(posicion, posicion + 1);
            }
        } while ( posicion != -1); 
        
    }
    
    /**
     * Posiciona los datos recolectados en una operacion segun esta haya sido elegida
     */
    public void calculo (Lista lista1, Lista lista2, String operacion, Lista resultado) {
        if ( operacion.equals("+") ) {
            System.out.println("su resultado se encuentra en el archivo de texto 'Resultado.txt'");
            suma(lista1, lista2, resultado);
        }
        
        if ( operacion.equals("-") ) {
            System.out.println("su resultado se encuentra en el archivo de texto 'Resultado.txt'");
            resta(lista1, lista2, resultado);
        }
        
        if ( operacion.equals("/") ) {
            System.out.println("su resultado se encuentra en el archivo de texto 'Resultado.txt'");
            division(lista1, lista2, resultado);
        }
        
        if ( operacion.equals("*") ) {
            System.out.println("su resultado se encuentra en el archivo de texto 'Resultado.txt'");
            multiplicacion(lista1, lista2, resultado);
        }
    }
    
    /**
     * Si la funcion se suma esta ejecuta 
     */
    public void suma (Lista lista1, Lista lista2, Lista resultado) {
        int limite1 = lista1.getTamanio();
        int limite2 = lista2.getTamanio();
        int confirma = 0;
        int suma = 0;
        
        for ( int i = 0; i < limite1; i++ ) {
            for ( int k = 0; k < limite2; k++ ) {
                if ( lista1.sacarPotencia(lista1, i) == lista2.sacarPotencia(lista2, k) && confirma == 0) {
                    suma = lista1.sacarValor(lista1, i) + lista2.sacarValor(lista2, k);
                    resultado.agregar(suma, lista1.sacarPotencia(lista1, i));
                    
                    confirma++;
                }
                
            }
            
            if ( confirma == 0 ) {
                resultado.agregar(lista1.sacarValor(lista1, i), lista1.sacarPotencia(lista1, i));
            }
            
            
            confirma = 0;
        }
        
        for ( int k = 0; k < limite2; k++ ) {
            for ( int i = 0; i < limite1; i++ ) {
                if ( lista1.sacarPotencia(lista1, i) == lista2.sacarPotencia(lista2, k) && confirma == 0) {
                    confirma++;
                }
                
            }
            
            if ( confirma == 0 ) {
                resultado.agregar(lista2.sacarValor(lista2, k), lista2.sacarPotencia(lista2, k));
            }
            
            
            confirma = 0;
        }
    }
    
    /**
     * si la funcion se resta esta se ejecuta
     */
    public void resta (Lista lista1, Lista lista2, Lista resultado) {
        int limite2 = lista2.getTamanio();
        Lista sustituto = new Lista();
        
        for ( int k = 0; k < limite2; k++ ) {
            sustituto.agregar(lista2.sacarValorNegativo(lista2, k), lista2.sacarPotencia(lista2, k));
        }
        
        suma(lista1, sustituto, resultado);
    }
    
    /**
     * si la funcion se divide esta se ejecuta
     */
    public void division (Lista lista1, Lista lista2, Lista resultado) {
        int valor = lista1.sacarValor(lista1, 0) / lista2.sacarValor(lista2, 0);
        int potencia = lista1.sacarPotencia(lista1, 0) - lista2.sacarPotencia(lista2, 0);
        
        resultado.agregar(valor, potencia);
    }
    
    /**
     * si la funcion se multiplica esta se ejecuta
     */
    public void multiplicacion (Lista lista1, Lista lista2, Lista resultado) {
        int limite1 = lista1.getTamanio();
        int limite2 = lista2.getTamanio();
        int valor = 0;
        int potencia = 0;
        Lista sustituto = new Lista();
        //Lista sustituto2 = new Lista();
        //Lista sustituto3 = new Lista();
        
        
        for ( int i = 0; i < limite1; i++ ) {
            for ( int k = 0; k < limite2; k++ ) {
                valor = lista1.sacarValor(lista1, i) * lista2.sacarValor(lista2, k);
                potencia = lista1.sacarPotencia(lista1, i) + lista2.sacarPotencia(lista2, k);
                sustituto.agregar(valor, potencia);
                
            }
           
        }
        
        ordenarYresumir(sustituto, resultado);
        
    }
    
    /**
     * ordena y resume todos los valores de las ecuaciones en un objeto lista y el resultado lo copia en otro
     * objeto lista
     */
    public void ordenarYresumir( Lista sustituto, Lista resultado) {
        int valor = 0;
        int potencia = 0;
        int valor1 = 0;
        int potencia1 = 0;
        
        for ( int i = 1; i < sustituto.getTamanio(); i++ ) {
            for ( int j = 0; j < sustituto.getTamanio() - i; j++) {
                if (sustituto.sacarPotencia(sustituto, j) < sustituto.sacarPotencia(sustituto, j + 1)) {
                    
                    
                    valor = sustituto.sacarValor(sustituto, j);
                    potencia = sustituto.sacarPotencia(sustituto, j);
                    
                    valor1 = sustituto.sacarValor(sustituto, j + 1);
                    potencia1 = sustituto.sacarPotencia(sustituto, j + 1);
                    
                    //primer paso
                    sustituto.eliminarElementoPorPosicion(j);
                    sustituto.insertarEnPosicion(valor1, potencia1, j);
                    
                    //segundo paso
                    sustituto.eliminarElementoPorPosicion(j + 1);
                    sustituto.insertarEnPosicion(valor, potencia, j + 1);
                }
            }
        }
        
        int acumulado = 0;
        
        for (int i = 0; i < sustituto.getTamanio() - 1; i++) {
            acumulado = acumulado + sustituto.sacarValor(sustituto, i);
            if ( sustituto.sacarPotencia(sustituto, i) != sustituto.sacarPotencia(sustituto, i + 1)) {
                resultado.agregar(acumulado, sustituto.sacarPotencia(sustituto, i));
                acumulado = 0;
            }
            
            if ( i == sustituto.getTamanio() - 2) {
                resultado.agregar(acumulado + sustituto.sacarValor(sustituto, i + 1), sustituto.sacarPotencia(sustituto, i + 1));
            }
            
        }
    }
    
    /**
     * escribe el resultado en un archivo de texto
     */
    public void escribir(Lista lista1, Lista lista2, Lista resultado, String simbolo) {
        Escritor escritor = new Escritor("Resultado.txt");
        
        escritor.escribir("\r\n");
        for (int i = 0; i < lista1.getTamanio(); i++) {
            if (lista1.sacarValor(lista1, i) < 0 || i == 0) {  
                escritor.escribir(lista1.sacarValor(lista1, i) + "x^" + lista1.sacarPotencia(lista1, i));
            } else {
                escritor.escribir("+" + lista1.sacarValor(lista1, i) + "x^" + lista1.sacarPotencia(lista1, i));
            }
        }
        
        escritor.escribir("|" + simbolo + "|");
        
        for (int i = 0; i < lista2.getTamanio(); i++) {
            if (lista2.sacarValor(lista2, i) < 0 || i == 0) {  
                escritor.escribir(lista2.sacarValor(lista2, i) + "x^" + lista2.sacarPotencia(lista2, i));
            } else {
                escritor.escribir("+" + lista2.sacarValor(lista2, i) + "x^" + lista2.sacarPotencia(lista2, i));
            }
        }
        
        escritor.escribir("|");
         
        for (int i = 0; i < resultado.getTamanio(); i++) {
            if (resultado.sacarValor(resultado, i) < 0 || i == 0) {  
                escritor.escribir(resultado.sacarValor(resultado, i) + "x^" + resultado.sacarPotencia(resultado, i));
            } else {
                escritor.escribir("+" + resultado.sacarValor(resultado, i) + "x^" + resultado.sacarPotencia(resultado, i));
            }
        }
        
        
        escritor.cerrar();
    }
    
    /**
     * necesario para pedir valores, como las selecciones de un menu
     */
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
