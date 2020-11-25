
public class Main
{
    public static void main(String[] args)
    {
        //ec se refiere de manera resuminda a ecuacion
        Lista ec1 = new Lista();
        Lista ec2 = new Lista();
        Lista resultado = new Lista();
        Metodos metodo = new Metodos();
        
        metodo.menu(ec1, ec2);
        
        ec1.imprimirLista();
        System.out.println("");
        ec2.imprimirLista();
        
        
    }
}