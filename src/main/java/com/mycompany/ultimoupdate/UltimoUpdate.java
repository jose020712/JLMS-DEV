package com.mycompany.ultimoupdate;
import static com.mycompany.ultimoupdate.FuncionesExtra.*;
import static com.mycompany.ultimoupdate.FuncionesSwitch.*;
/**
 * @author JosePC
 */
public class UltimoUpdate {
    public static void main(String[] args) 
    {
        Grafo grafo = new Grafo();
        grafo.agregarVertice("v1");
        grafo.agregarVertice("v2");
        grafo.agregarVertice("v3");
        grafo.agregarVertice("v4");
        grafo.agregarVertice("v5");
        grafo.agregarVertice("v6");
        grafo.agregarVertice("v7");
        
        grafo.agregarArco("v1", "v2", 1);
        grafo.agregarArco("v1", "v3", 2);
        grafo.agregarArco("v2", "v3", 1);
        grafo.agregarArco("v2", "v5", 3);
        grafo.agregarArco("v3", "v4", 1);
        grafo.agregarArco("v3", "v6", 3);
        grafo.agregarArco("v4", "v2", 3);
        grafo.agregarArco("v5", "v7", 3);
        grafo.agregarArco("v6", "v7", 1);
        grafo.agregarArco("v7", "v4", 1);
        
        boolean again = true;
        int opc;
         while(again)
        {    
            ShowMenu();
            opc = ValidarOpcion(1,8,"Introduce una Opcion del Menu","Introduce un valor Valido");
            switch(opc)
            { 
                case 1 -> AddVertice(grafo);
                case 2 -> RemoveVertice(grafo);
                case 3 -> ShowVertices(grafo);
                case 4 -> AddArco(grafo);
                case 5 -> RemoveArco(grafo);
                case 6 -> ShowArcos(grafo);
                case 7 -> getShortWay(grafo);
                case 8 -> again = Exit();
            }   
        }  
    }
}
