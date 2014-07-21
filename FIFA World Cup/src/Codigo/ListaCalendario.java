/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Codigo;

import java.text.SimpleDateFormat;

/**
 *
 * @author Mario A
 */
public class ListaCalendario {
    
    private NodoCalendario raizCalendario;
    
    
    /**
     * Metodo constructor que inicializa la lista de Partidos en vacio
     */
    public ListaCalendario(){
        raizCalendario = null;
    }
    
    /**
     * Metodo para insertar un nuevo Partido en el calendario, ordenando este nodo
     * de forma ascendente, tomando como referencia, la fecha y hora del encuentro.
     * @param pNuevoNodo nuevo partido (NodoCalendario)
     */
    public void insertarOrdenadoPorFecha(NodoCalendario pNuevoNodo){
        
        // No hay elementos en la lista. Se inserta y la raiz apunta al nuevo nodo
        if(raizCalendario == null){
            raizCalendario = pNuevoNodo;
        }
        // El elemento es el primero de la lista. Se inserta y se mueve la raiz
        else if(pNuevoNodo.getFechaYHoraDelPartido().before(raizCalendario.getFechaYHoraDelPartido()))
        {
            pNuevoNodo.setSiguiente(raizCalendario);
            raizCalendario = pNuevoNodo;
        }
        // Se busca la posicion donde ira el nodo.
        else{
            NodoCalendario nodoActual = raizCalendario;
            
            while(nodoActual.getSiguiente() != null &&
                    pNuevoNodo.getFechaYHoraDelPartido().after(nodoActual.getSiguiente().getFechaYHoraDelPartido()))
            {
                nodoActual = nodoActual.getSiguiente();
            }
            
            pNuevoNodo.setSiguiente(nodoActual.getSiguiente());
            nodoActual.setSiguiente(pNuevoNodo);
        }
    }
    
    /**
     * Metodo para imprimir en consola el calendario del mundial. Se recorre toda
     * la lista con los encuentros, la cual esta ordenada de forma ascendente
     */
    public void imprimirCalendario(){
        NodoCalendario nodoActual = raizCalendario;
        
        SimpleDateFormat nuevoFormato = new SimpleDateFormat("d MMM yyyy h:mm a");
        while(nodoActual != null){
            String fecha = nuevoFormato.format(nodoActual.getFechaYHoraDelPartido());
            System.out.println("El encuentro se realiza el: " + fecha);
            nodoActual = nodoActual.getSiguiente();
        }
    }
    
}
