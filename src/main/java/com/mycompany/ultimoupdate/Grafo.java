
package com.mycompany.ultimoupdate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author JosePC
 */
public class Grafo 
{
    
    private Map<String, Vertice> vertices;

    public Grafo() 
    {
        this.vertices = new HashMap<>();
    }
    
    public Map<String, Vertice> getVertices(){
        return vertices;
    }

    public void agregarVertice(String nombre) 
    {
        vertices.put(nombre, new Vertice(nombre));
    }

    public void agregarArco(String origen, String destino, int peso) 
    {
        Vertice vOrigen = vertices.get(origen);
        Vertice vDestino = vertices.get(destino);

        vOrigen.arcos.add(new Arco(vDestino, peso));
    }

    public void mostrarArcos()
    {
        for (Vertice v : vertices.values()) 
        {
            System.out.print("Arcos desde el vértice " + v.nombre + ":");
            for (Arco arco : v.arcos) 
            {
                System.out.print("  Hacia " + arco.getDestino().nombre + ", Peso: " + arco.getPeso());
            }
            System.out.println();
        }
    }

    public int eliminarArco(String origen, String destino) 
    {
        Vertice vOrigen = vertices.get(origen);
        Vertice vDestino = vertices.get(destino);
        int peso;
        for (Arco arco : vOrigen.arcos) 
        {
            if (arco.getDestino() == vDestino) 
            {
                peso = arco.getPeso();

                vOrigen.arcos.remove(arco);
                return peso;
            }
        }
        return -1;
    }

    public boolean existeVertice(String nombre) 
    {
        return vertices.containsKey(nombre);
    }

    public boolean isEmpty() 
    {
        return vertices.isEmpty();
    }

    public void MostrarVertices() 
    {
        for (String nombre : vertices.keySet()) 
        {
            System.out.println(nombre);
        }
    }

    public void eliminarVertice(String nombre) 
    {
        if (vertices.containsKey(nombre)) 
        {
            vertices.remove(nombre);
            for (Vertice v : vertices.values()) 
            {
                v.arcos.removeIf(arco -> arco.getDestino().nombre.equals(nombre));
            }
        }
    }

    public List<String> caminoMinimoDijkstra(String origen, String destino) 
    {
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> predecesores = new HashMap<>();
        
      

        for (Vertice v : vertices.values()) 
        {
            distancias.put(v.nombre, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        
        PriorityQueue<Vertice> cola = new PriorityQueue<>(Comparator.comparingInt(v -> distancias.getOrDefault(v.nombre, Integer.MAX_VALUE)));
        
        cola.add(vertices.get(origen));

        while (!cola.isEmpty()) 
        {
            Vertice actual = cola.poll();
            for (Arco arco : actual.arcos)
            {
                int nuevaDistancia = distancias.get(actual.nombre) + arco.getPeso();
                if (nuevaDistancia < distancias.get(arco.getDestino().nombre)) 
                {
                    distancias.put(arco.getDestino().nombre, nuevaDistancia);
                    predecesores.put(arco.getDestino().nombre, actual.nombre);
                    
                    Vertice arc = arco.getDestino();
                    
                    cola.add(arco.getDestino());
                }
            }
        }

        List<String> camino = new ArrayList<>();
        for (String v = destino; v != null; v = predecesores.get(v)) 
        {
            camino.add(v);
        } 
        Collections.reverse(camino);

        return camino;
    }
    
    public int pesoWay(List<String> camino) {
        int pesoTotal = 0;
        for (int i = 0; i < camino.size() - 1; i++) {
            String origen = camino.get(i);
            String destino = camino.get(i + 1);
            for (Arco arco : vertices.get(origen).arcos) {
                if (arco.getDestino().nombre.equals(destino)) {
                    pesoTotal += arco.getPeso();
                    break;
                }
            }
        }
        return pesoTotal;
    }
    
    public void encontrarRutasEquivalentes(String origen, String destino) {
        List<String> ruta = new ArrayList<>();
        Set<String> isVisited = new HashSet<>();
        ruta.add(origen);
        encontrarTodasLasRutasUtil(origen, destino, isVisited, ruta);
    }
    
    private void encontrarTodasLasRutasUtil(String fuente, String destino, Set<String> isVisited, List<String> localPathList) 
    {
        // Mark the current node
        isVisited.add(fuente);
       
        if (fuente.equals(destino)) {
            System.out.println(localPathList);
        }

        // Recur for all the vertices adjacent to current vertex
        for (Arco i : vertices.get(fuente).arcos) {
            if (!isVisited.contains(i.getDestino().nombre)) {
                // Store current node in path[]
                localPathList.add(i.getDestino().nombre);
                encontrarTodasLasRutasUtil(i.getDestino().nombre, destino, isVisited, localPathList);

                // Remove current vertex in path[]
                localPathList.remove(i.getDestino().nombre);
            }
        }

        // Mark the current node
        isVisited.remove(fuente);
    }

}
