/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Codigo;

/**
 *
 * @author Noelia Urpi
 */
public class NodoEstadio {
    
    private String nombreEstadio;
    private String ciudad;
    private int capacidad;    
    private NodoEstadio siguiente;
    
    /**
     * Metodo constructo vacio
     */
    public NodoEstadio(){
        siguiente = null;
    }
    
    /**
     * Metodo constructor
     * @param pNombre nombre del estadio
     * @param pCiudad ciudad donde se ubica el estadio
     * @param pCapacidad capacidad de personas del estadio
     */
    public NodoEstadio(String pNombre, String pCiudad, int pCapacidad){
        nombreEstadio = pNombre;
        ciudad = pCiudad;
        capacidad = pCapacidad;        
        siguiente = null;
    }

    /**
     * @return the nombreEstadio
     */
    public String getNombreEstadio() {
        return nombreEstadio;
    }

    /**
     * @param nombreEstadio the nombreEstadio to set
     */
    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    /**
     * @return the siguiente
     */
    public NodoEstadio getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoEstadio siguiente) {
        this.siguiente = siguiente;
    }
}
