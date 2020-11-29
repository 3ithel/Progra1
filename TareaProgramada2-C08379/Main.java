/**
 * El metodo Main, donde se ejecuta todo 
 */
public class Main
{
    public static void main(String[] args)
    {
        //ec se refiere de manera resuminda a ecuacion
        Lista ec1 = new Lista();
        Lista ec2 = new Lista();
        Lista resultado = new Lista();
        Metodos metodo = new Metodos();
        String operacion = "";
        
        try {
        metodo.menu(ec1, ec2);
        operacion = metodo.operacion;
        
        metodo.calculo(ec1, ec2, operacion, resultado);
        
        metodo.escribir(ec1, ec2, resultado, operacion);
        System.out.println("");
        
        
        ec1.imprimirLista();
        System.out.print("|");
        System.out.print(operacion);
        System.out.print("|");
        ec2.imprimirLista();
        System.out.print("|");
        resultado.imprimirLista();
    } catch (StringIndexOutOfBoundsException e) {
        System.out.print("");
        System.out.print("Por favor vuelva a ejecutar el programa e inserte un directorio valido");
        //la unica escepcion que se puede dar
    }
        
        
    }
}