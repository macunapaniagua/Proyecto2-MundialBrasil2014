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
public class ListaEstadios {

    private NodoEstadio raizEstadios;
    private NodoEstadio nodoAuxiliar;

    /**
     * Metodo constructor que inicializa la raiz de la lista en null
     */
    public ListaEstadios() {
        raizEstadios = null;
        nodoAuxiliar = null;
    }

    /**
     * @return the nodoAuxiliar
     */
    public NodoEstadio getNodoActual() {
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
        nodoAuxiliar = raizEstadios;
    }

    /**
     * Metodo utilizado para obtener la lista de estadio (se retorna la raiz)
     *
     * @return Lista de estadios (lista de NodoEstadio)
     */
    public NodoEstadio getListaDeEstadios() {
        return raizEstadios;
    }

    /**
     * Metodo utilizado para establecer una nueva lista de estadios
     *
     * @param pRaizNuevaLista Objeto NodoEstadio raiz de la nueva lista
     */
    public void setListaDeEstadios(NodoEstadio pRaizNuevaLista) {
        raizEstadios = pRaizNuevaLista;
    }

    /**
     * Metodo utilizado para agregar un nuevo estadio a la lista insertandolo al
     * final de esta
     *
     * @param pNuevoNodo estadio a insertar en la lista
     */
    public void insertarAlFinal(NodoEstadio pNuevoNodo) {
        // No hay nodos, por lo tanto la raiz apunta al nuevo nodo
        if (raizEstadios == null) {
            raizEstadios = pNuevoNodo;
        } // Se busca el ultimo nodo, para insertar el nuevo nodo, despues de este
        else {
            NodoEstadio nodoActual = raizEstadios;

            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            // inserta el nuevo nodo al final
            nodoActual.setSiguiente(pNuevoNodo);
        }
    }

    /**
     * Metodo que retorna un estadio buscado en la lista
     *
     * @param pNombreDelEstadio nombre del estadio a buscar
     * @return NodoEstadio del estadio buscado o null en caso que no exista en
     * la lista
     */
    public NodoEstadio getNodoEstadio(String pNombreDelEstadio) {
        // Verifica que la lista no esta vacia
        if (raizEstadios != null) {
            // Se recorre la lista en busca del estadio
            NodoEstadio nodoActual = raizEstadios;
            while (nodoActual.getSiguiente() != null && !nodoActual.getNombreEstadio().equalsIgnoreCase(pNombreDelEstadio)) {
                nodoActual = nodoActual.getSiguiente();
            }
            // verifica si encontro el equipo, en caso contrario retorna null
            if (nodoActual.getNombreEstadio().equalsIgnoreCase(pNombreDelEstadio)) {
                return nodoActual;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Metodo utilizado para cambiar la capacidad de aficionados de un estadio
     *
     * @param pNombreEstadio nombre del estadio al que se desea cambiar la
     * capacidad
     * @param pCapacidad nueva capacidad de aficionados del estadio
     * @return true si cambio la capacidad de aficionados o false en caso
     * contrario
     */
    public boolean modificarCapacidadEstadio(String pNombreEstadio, int pCapacidad) {
        // Verifica si hay estadios en la lista para cambiar el dato
        if (raizEstadios == null) {
            return false;
        } else {
            // Se recorre la lista en busca del estadio al que se le desea cambiar la capacidad
            NodoEstadio nodoActual = raizEstadios;
            while (nodoActual.getSiguiente() != null && !nodoActual.getNombreEstadio().equalsIgnoreCase(pNombreEstadio)) {
                nodoActual = nodoActual.getSiguiente();
            }
            // Verifica si encontro el estadio y le cambia la capacidad y retorna true
            // o retorna false en caso que el estadio con dicho nombre no exista
            if (nodoActual.getNombreEstadio().equalsIgnoreCase(pNombreEstadio)) {
                nodoActual.setCapacidad(pCapacidad);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Metodo utilizado para cambiar la ciudad donde se ubica un estadio
     *
     * @param pNombreEstadio nombre del estadio al que se desea cambiar la
     * capacidad
     * @param pCiudad nueva ubicacion del estadio
     * @return true si cambio la ciudad o false en caso contrario
     */
    public boolean modificarUbicacionDelEstadio(String pNombreEstadio, String pCiudad) {
        // Verifica si hay estadios en la lista para cambiar el dato
        if (raizEstadios == null) {
            return false;
        } else {
            // Se recorre la lista en busca del estadio al que se le desea cambiar la ciudad
            NodoEstadio nodoActual = raizEstadios;
            while (nodoActual.getSiguiente() != null && !nodoActual.getNombreEstadio().equalsIgnoreCase(pNombreEstadio)) {
                nodoActual = nodoActual.getSiguiente();
            }
            // Verifica si encontro el estadio y le cambia la ciudad y retorna true
            // o retorna false en caso que el estadio con dicho nombre no exista
            if (nodoActual.getNombreEstadio().equalsIgnoreCase(pNombreEstadio)) {
                nodoActual.setCiudad(pCiudad);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Metodo utilizado para cambiar el nombre de un estadio
     *
     * @param pNombreEstadio nombre actual del estadio al que se desea cambiar
     * el nombre
     * @param pNuevoNombreEstadio nuevo nombre del estadio
     * @return true si cambio el nombre al estadio o false en caso contrario
     */
    public boolean modificarNombreDeEstadio(String pNombreEstadio, String pNuevoNombreEstadio) {
        // Verifica si hay estadios en la lista para cambiar el dato
        if (raizEstadios == null) {
            return false;
        } else {
            // Se recorre la lista en busca del estadio al que se le desea cambiar el nombre
            NodoEstadio nodoActual = raizEstadios;
            while (nodoActual.getSiguiente() != null && !nodoActual.getNombreEstadio().equalsIgnoreCase(pNombreEstadio)) {
                nodoActual = nodoActual.getSiguiente();
            }
            // Verifica si encontro el estadio, le cambia el nombre y retorna true
            // o retorna false en caso que el estadio con dicho nombre no exista
            if (nodoActual.getNombreEstadio().equalsIgnoreCase(pNombreEstadio)) {
                nodoActual.setNombreEstadio(pNuevoNombreEstadio);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Metodo auxiliar para verificar la insercion al final de los estadios
     */
    public void imprimirEstadios() {
        NodoEstadio nodoActual = raizEstadios;

        while (nodoActual != null) {
            System.out.println(nodoActual.getNombreEstadio());
            nodoActual = nodoActual.getSiguiente();
        }
    }

}
