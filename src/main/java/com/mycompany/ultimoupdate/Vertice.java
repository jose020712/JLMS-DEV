
package com.mycompany.ultimoupdate;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JosePC
 */
public class Vertice 
{
    String nombre; 
    List<Arco> arcos; 

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.arcos = new ArrayList<>();
    }   
}
