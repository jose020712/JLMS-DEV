
package com.mycompany.ultimoupdate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author JosePC
 */
public class FuncionesExtra 
{
    public static void ShowMenu()
    {
        System.out.println("----Menu----");
        System.out.println("1.Insertar Vertice.");
        System.out.println("2.Eliminar Vertice.");
        System.out.println("3.Mostrar Vertices.");
        System.out.println("4.Insertar Arco.");
        System.out.println("5.Eliminar Arco.");
        System.out.println("6.Mostrar Arcos.");
        System.out.println("7.Obtener todo sobre los caminos minimos y las rutas equivalentes.");
        System.out.println("8.Salir.");
        
    }
 
    public static int ValidarOpcion(int min,int max,String msg,String msgCatch)
    {
            int opc = min - 1 ;
            
            
            
            while(opc < min || opc > max)
            {
            Scanner scanner = new Scanner(System.in);
            System.out.println(msg);
            try{
             opc = scanner.nextInt();
             
            }
            catch(InputMismatchException ex){
                System.out.println(msgCatch);
                opc = min - 1;
            }
          
            }
                  
        return opc;
    }
}
