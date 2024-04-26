
package com.mycompany.ultimoupdate;


import static com.mycompany.ultimoupdate.FuncionesExtra.ValidarOpcion;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JosePC
 */
public class FuncionesSwitch 
{
     
      //Funciones Del Switch
    public static void AddVertice( Grafo grafo)
    {
        System.out.println("---Añadiendo Vertice---");
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce un nombre del vertice: ");   
        String nombre = scan.nextLine();
            if(!grafo.existeVertice(nombre))
            {
                grafo.agregarVertice(nombre);
                System.out.println("Vertice " +nombre+ " Agregado.");
            }
           else System.out.println("Ya existe un vertice " + nombre+".");
    }
    
    public static void RemoveVertice(Grafo grafo)
    {
       if(!grafo.isEmpty())
       {
         System.out.println("---Eliminando Vertice---");  
         Scanner scan = new Scanner(System.in);
         ShowVertices(grafo);
         System.out.println("Introduce nombre del vertice a eliminar: ");
         String nombre = scan.nextLine();
            if(grafo.existeVertice(nombre))
            {
                grafo.eliminarVertice(nombre);
                System.out.println("Vertice " +nombre+ " Eliminado.");
                ShowVertices(grafo);
            } 
            else System.out.println("No Existe vertice "+nombre+"");
       }
       else System.out.println("El Grafo esta vacio");
    }
    public static void ShowVertices(Grafo grafo)
    {
        if(!grafo.isEmpty())
        { 
          System.out.println("---Mostrando Vertices en el Grafo---");  
          grafo.MostrarVertices();
        }
        else System.out.println("El grafo esta vacio");
      }
      
    public static void AddArco(Grafo grafo)
    {
        if(!grafo.isEmpty())
        {
            System.out.println("---Añadiendo Arco---");
            Scanner scan = new Scanner(System.in);
            boolean again = true;
            while(again)
            {
                String VerticesO,VerticesD;
                int peso;
                ShowVertices(grafo);
                System.out.println("Introduce un nombre del vertice Origen: ");
                VerticesO = scan.nextLine();
                System.out.println("Introduce un nombre del vertice Destino: ");
                VerticesD = scan.nextLine();
                peso = ValidarOpcion(1 , 999999999,"Introduce Peso del Arco ( > 0): ","Introduce un numero positivo ( > 0).");               
                if( !grafo.existeVertice(VerticesO) || !grafo.existeVertice(VerticesD) )
                {
                    System.out.println("Escriba un nombre q aparezca en la Lista de Vertices");
                }
                else 
                {
                    grafo.agregarArco(VerticesO, VerticesD, peso);
                    System.out.println("Arco " + VerticesO + " -> " + VerticesD + " Peso(" + peso + ") Insertado.");
                    again = false;
                }
            }
        }
        else System.out.println("El grafo esta vacio");
    }
    
    public static void RemoveArco(Grafo grafo)
    {
        if(!grafo.isEmpty())
        {
            System.out.println("---Eliminando Arco---");
            ShowArcos(grafo);
            Scanner scan = new Scanner(System.in);
            boolean again = true;
            while(again)
            {
                String VerticesO,VerticesD;
                ShowArcos(grafo);
                System.out.println("Introduce un nombre del vertice Origen: ");
                VerticesO = scan.nextLine();
                System.out.println("Introduce un nombre del vertice Destino: ");
                VerticesD = scan.nextLine();
                if( !grafo.existeVertice(VerticesO) || !grafo.existeVertice(VerticesD) )
                {
                    System.out.println("Escriba un Arco q aparezca en la lista");
                }
                else 
                {
                    int peso = grafo.eliminarArco(VerticesO, VerticesD);
                    System.out.println("Arco " + VerticesO + " -> " + VerticesD + " Peso(" + peso + ") Eliminado.");
                    ShowArcos(grafo);
                    again = false;
                }
            }
        }
        else System.out.println("El grafo esta Vacio");
    }
    
    public static void ShowArcos(Grafo grafo)
    {
        if(!grafo.isEmpty())
        {
            System.out.println("---Mostrando Arcos en el Grafo---");
            grafo.mostrarArcos();
        }
        else System.out.println("EL Grafo esta Vacio.");
    }   
    
    public static void getShortWay(Grafo grafo)
    {
     if(!grafo.isEmpty())
       {
         String VerticesO,VerticesD;
         List<String> camino;
         System.out.println("-----Obteniendo camino minimo entre dos vertices-----");
         Scanner scan = new Scanner(System.in);
         ShowVertices(grafo);
            do
            {
                System.out.println("Introduce nombre del vertice de origen: ");
                VerticesO = scan.nextLine();
                System.out.println("Introduce nombre del vertice de destino: ");
                VerticesD = scan.nextLine();
                if(grafo.existeVertice(VerticesO) && grafo.existeVertice(VerticesD))
                {
                    camino = grafo.caminoMinimoDijkstra(VerticesO, VerticesD);
                    System.out.println("El camino minimo entre ( Vertice a Vertice ) " + VerticesO + " y " + VerticesD + " es: ");
                                      for (String vertice : camino) 
                                      {
                                        System.out.print("-> ");  
                                        System.out.print(vertice + " ");
                                      }
                    System.out.println();                  
                    System.out.println("La Longitud (Cantida de Vertices) del camino minimo entre " + VerticesO + " y " + VerticesD + " es: " + camino.size() +".");
                    System.out.println("La Longitud (Peso) del camino minimo entre " + VerticesO + " y " + VerticesD + " es: " + grafo.pesoWay(camino) +".");
                    grafo.encontrarRutasEquivalentes(VerticesO, VerticesD);
                } 
                else
                {
                    System.out.println("Introduzca Vertices q existan en el grafo.");
                } 
            }
            while(!grafo.existeVertice(VerticesO) || !grafo.existeVertice(VerticesD));
        }
        else System.out.println("El Grafo esta vacio");   
    } 

    public static boolean Exit()
    {
        System.out.println("Gracias. Vuelva Pronto.");
        return false;
    }
}
