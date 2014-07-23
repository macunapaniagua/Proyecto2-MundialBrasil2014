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
public class ListaEquipos {

    private NodoEquipo raizEquipos;
    private NodoEquipo nodoAuxiliar;

    /**
     * Metodo constructor de la lista de equipos
     */
    public ListaEquipos() {
        raizEquipos = null;
        nodoAuxiliar = null;
    }

    /**
     * Metodo utilizado para retornar el elemento en el que se posiciona actualmente
     * el nodo Auxiliar
     * @return el nodo auxiliar, que es el que recorre la lista
     */
    public NodoEquipo getNodoActual() {
        return nodoAuxiliar;
    }

    /**
     * Metodo para inicializar el nodo que recorre la lista, es decir, colocarlo
     * en la raiz de la lista
     */
    public void inicializarNodoActual() {
        nodoAuxiliar = raizEquipos;
    }
    
    /**
     * Metodo utilizado para mover el nodo que recorre la lista completa
     */
    public void moverNodoActual(){
        nodoAuxiliar = nodoAuxiliar.getSiguiente();
    }

    /**
     * Metodo para insetar los equipos participantes del mundial, en una lista
     * ordenado alfabeticamente ascendente, tomando en cuanta el nombre del
     * equipo
     *
     * @param pNuevoNodo nuevo NodoEquipo a insertar en la lista
     */
    public void insertarOrdenado(NodoEquipo pNuevoNodo) {

        // No hay elementos en la lista. Se inserta y la raiz apunta al nuevo nodo
        if (raizEquipos == null) {
            raizEquipos = pNuevoNodo;
        } // El elemento es el primero de la lista. Se inserta y se mueve la raiz
        else if (pNuevoNodo.getNombreEquipo().compareToIgnoreCase(raizEquipos.getNombreEquipo()) < 0) {
            pNuevoNodo.setSiguiente(raizEquipos);
            raizEquipos = pNuevoNodo;
        } // Se busca la posicion donde ira el nodo.
        else {
            NodoEquipo nodoActual = raizEquipos;

            while (nodoActual.getSiguiente() != null
                    && pNuevoNodo.getNombreEquipo().compareToIgnoreCase(nodoActual.getSiguiente().getNombreEquipo()) > 0) {
                nodoActual = nodoActual.getSiguiente();
            }

            pNuevoNodo.setSiguiente(nodoActual.getSiguiente());
            nodoActual.setSiguiente(pNuevoNodo);
        }
    }

    /**
     * Metodo que retorna un equipo buscado en la lista
     * @param pNombreDelEquipo equipo a buscar
     * @return NodoEquipo del equipo buscado o null en caso que no exista en la lista
     */
    public NodoEquipo getNodoEquipo(String pNombreDelEquipo) {
        // Verifica que la lista no esta vacia
        if (raizEquipos != null) {
            // Se recorre la lista en busca del equipo
            NodoEquipo nodoActual = raizEquipos;
            while (nodoActual.getSiguiente() != null && !nodoActual.getNombreEquipo().equalsIgnoreCase(pNombreDelEquipo)) {
                nodoActual = nodoActual.getSiguiente();
            }
            // verifica si encontro el equipo, en caso contrario retorna null
            if (nodoActual.getNombreEquipo().equalsIgnoreCase(pNombreDelEquipo)) {
                return nodoActual;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Metodo Auxiliar, para imprimir en consola el comportamiento de la lista y
     * el ordenamiento de los elementos al insertarse
     */
    public void imprimirEquipos() {

        NodoEquipo nodoActual = raizEquipos;

        while (nodoActual != null) {
            System.out.println(nodoActual.getNombreEquipo());
            nodoActual = nodoActual.getSiguiente();
        }
    }

}
