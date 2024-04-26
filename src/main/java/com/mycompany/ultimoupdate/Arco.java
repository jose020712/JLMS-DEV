
package com.mycompany.ultimoupdate;

/**
 *
 * @author JosePC
 */
public class Arco 
{
    private Vertice destino;
    private int peso; 

    public Arco(Vertice destino, int peso)
    {
        this.destino = destino;
        this.peso = peso;
    }
    
    public int getPeso()
    {
        return peso;
    }
    
    public void setPeso(int peso)
    {
        this.peso = peso;
    }
    
    public Vertice getDestino()
    {
        return destino;
    }
}
