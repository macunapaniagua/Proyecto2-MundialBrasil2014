/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Codigo;

/**
 *
 * @author Mario A
 */
public class ListaGrupos {
    
    private NodoGrupo raizGrupos;
    private NodoGrupo nodoAuxiliar;
    
    /**
     * Metodo constructor de la lista de grupos
     */
    public ListaGrupos(){
        raizGrupos = null;
        nodoAuxiliar = null;
    }
    
    /**
     * @return the nodoAuxiliar
     */
    public NodoGrupo getNodoActual() {
        return nodoAuxiliar;
    }
    
    /**
     * Metodo para mover el nodoAuxiliar
     */
    public void moverNodoActual(){
        nodoAuxiliar = nodoAuxiliar.getSiguiente();
    }
    
    /**
     * Metodo para cambiar el valor del nodo auxiliar al inicio de la lista
     */
    public void inicializarNodoActal() {
        nodoAuxiliar = raizGrupos;
    }
    
    /**
     * Metodo utilizado para insertar un grupo en la lista de grupos por ordena
     * ascendente, de acuerdo a la letra del grupo
     * @param pNuevoNodo 
     */
    public void insertarOrdenado(NodoGrupo pNuevoNodo){
        
        // No hay elementos en la lista. Se inserta y la raiz apunta al nuevo nodo
        if(raizGrupos == null){
            raizGrupos = pNuevoNodo;
        }
        // El elemento a insertar es el primero de la lista. Se inserta y se mueve la raiz
        else if(pNuevoNodo.getLetraGrupo() < raizGrupos.getLetraGrupo())
        {
            pNuevoNodo.setSiguiente(raizGrupos);
            raizGrupos = pNuevoNodo;
        }
        // Se busca la posicion donde ira el nodo.
        else{
            NodoGrupo nodoActual = raizGrupos;
            
            while(nodoActual.getSiguiente() != null &&
                    pNuevoNodo.getLetraGrupo() > nodoActual.getSiguiente().getLetraGrupo())
            {
                nodoActual = nodoActual.getSiguiente();
            }
            
            pNuevoNodo.setSiguiente(nodoActual.getSiguiente());
            nodoActual.setSiguiente(pNuevoNodo);
        }
    }
    
    /**
     * Metodo Auxiliar, para imprimir en consola el comportamiento de la lista y
     * el ordenamiento de los elementos al insertarse
     */
    public void imprimirGrupos(){
        
        NodoGrupo nodoActual = raizGrupos;
        
        while(nodoActual != null){
            System.out.println(nodoActual.getLetraGrupo());
            String[] equipos = nodoActual.getpaisesIntegrantes();
            System.out.print("\t");
            for (int i = 0; i < equipos.length; i++) {
                System.out.print(" - " + equipos[i]);                
            }
            System.out.println("");
            nodoActual = nodoActual.getSiguiente();
        }                
    }
    
}
