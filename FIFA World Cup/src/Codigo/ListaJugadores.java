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
public class ListaJugadores {

    private NodoJugador nodoAuxiliar;
    private NodoJugador raizJugadores;

    /**
     * Metodo constructor que inicializa la variable raiz en null (lista vacia)
     */
    public ListaJugadores() {
        raizJugadores = null;
        nodoAuxiliar = null;
    }

    /**
     * @return the nodoAuxiliar
     */
    public NodoJugador getNodoActual() {
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
    public void inicializarNodoActual() {
        nodoAuxiliar = raizJugadores;
    }

    /**
     * Metodo que retorna la lista de jugadores
     *
     * @return La lista de jugadores
     */
    public NodoJugador getListaJugadores() {
        return raizJugadores;
    }

    /**
     * Metodo para cambiar la lista por una nueva
     *
     * @param raizJugadores nueva lista
     */
    public void setListaJugadores(NodoJugador raizJugadores) {
        this.raizJugadores = raizJugadores;
    }

    /**
     * Metodo para ingresar un nuevo jugador a la lista. La insercion se realiza
     * de forma ordenada ascendentemente, tomando como referencia el parametro
     * de la edad del jugador
     *
     * @param pNuevoNodo nuevo jugador
     */
    public void insertarOrdenadoPorEdad(NodoJugador pNuevoNodo) {
        // La lista esta vacia. La raiz apunta al nuevo elemento.
        if (getListaJugadores() == null) {
            setListaJugadores(pNuevoNodo);
        } // El jugador a insertar es de menor edad que el primer elemento de la lista
        // por lo que se procede a cambiar la referencia de la raiz.
        else if (pNuevoNodo.getEdad() < getListaJugadores().getEdad()) {
            pNuevoNodo.setSiguiente(getListaJugadores());
            setListaJugadores(pNuevoNodo);
        } // Se busca la posicion en la lista donde se debe insertar el jugador. Para
        // ello se recorre la lista desde el inicio.
        else {
            NodoJugador nodoActual = getListaJugadores();

            while (nodoActual.getSiguiente() != null && pNuevoNodo.getEdad() > nodoActual.getSiguiente().getEdad()) {
                nodoActual = nodoActual.getSiguiente();
            }
            pNuevoNodo.setSiguiente(nodoActual.getSiguiente());
            nodoActual.setSiguiente(pNuevoNodo);
        }
    }

    /**
     * Metodo que elimina un jugador de la lista mediante el nombre de este
     *
     * @param pNombreJugador nombre del jugador a eliminar
     * @return true si elimino al jugador o false si no existe el jugador
     */
    public boolean eliminarJugador(String pNombreJugador) {

        // Verifica si no hay elementos en la lista
        if (getListaJugadores() == null) {
            return false;
        } // El elemento a eliminar se encuentra en la raiz de la lista
        else if (getListaJugadores().getNombre().equalsIgnoreCase(pNombreJugador)) {
            setListaJugadores(getListaJugadores().getSiguiente());
            return true;
        } else {
            // Recorre la lista en busca del que el nodo siguiente al actual sea
            // igual al elemento que se desea eliminar.
            NodoJugador nodoActual = getListaJugadores();
            while (nodoActual.getSiguiente() != null && !nodoActual.getSiguiente().getNombre().equalsIgnoreCase(pNombreJugador)) {
                nodoActual = nodoActual.getSiguiente();
            }
            // Verifica si encontro el elemento a borrar o no
            if (nodoActual.getSiguiente() == null) {
                return false;
            } else {
                nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());
                return true;
            }
        }
    }

    /**
     * Metodo auxiliar para imprimir en consola, los jugadores de la lista.
     */
    public void imprimirListaJugadores() {
        NodoJugador nodoActual = getListaJugadores();
        while (nodoActual != null) {
            System.out.println(nodoActual.getNombre() + ", " + nodoActual.getEdad() + " años, " + nodoActual.getPosicion()
                    + ", numero: " + nodoActual.getNumeroCamiseta() + ", estatura en cm: " + nodoActual.getEstatura());
            nodoActual = nodoActual.getSiguiente();
        }
    }

    /**
     * Metodo para buscar y retornar el NodoJugador mas joven de un equipo
     *
     * @return NodoJugador mas joven
     */
    public NodoJugador getJugadorMasJoven() {
        // Se crea un nuevo nodo con la informacion del primer elmento de la lista 
        // (no se retorna la raiz xq se estaria pasando toda la lista de jugadores)
        NodoJugador jugadorJoven = new NodoJugador(raizJugadores.getNombre(),
                raizJugadores.getPosicion(), raizJugadores.getFoto(), raizJugadores.getEdad(),
                raizJugadores.getEstatura(), raizJugadores.getNumeroCamiseta());
        return jugadorJoven;
    }

    /**
     * Metodo para buscar el nombre del jugador mas joven de un equipo
     *
     * @return nombre del jugador mas joven
     */
    public String getNombreJugadorMasJoven() {
        // Captura y retorna el nombre del jugador mas joven (el primero de la lista)
        return getListaJugadores().getNombre();
    }

    /**
     * Metodo para buscar y retornar el nombre del jugador mas viejo de un
     * equipo
     *
     * @return nombre del jugador mas viejo
     */
    public String getNombreJugadorMasViejo() {
        // Se crea un nodo que recorrera toda la fila en busca del jugador mas 
        // viejo (elemento final de la lista)
        NodoJugador nodoActual = getListaJugadores();
        while (nodoActual.getSiguiente() != null) {
            nodoActual = nodoActual.getSiguiente();
        }
        // Captura y retorna el nombre del jugador mas viejo
        return nodoActual.getNombre();
    }

    /**
     * Metodo que busca y retorna el NodoJugador con mayor edad de un equipo
     *
     * @return NodoJugador mas viejo
     */
    public NodoJugador getJugadorMasViejo() {
        // Se crea un nodo que recorrera toda la fila en busca del jugador mas 
        // viejo (elemento final de la lista)
        NodoJugador nodoActual = getListaJugadores();
        while (nodoActual.getSiguiente() != null) {
            nodoActual = nodoActual.getSiguiente();
        }
        // Captura y retorna el nombre del jugador mas viejo
        return nodoActual;
    }

    /**
     * Metodo para verificar si la lista de jugadores cuenta con elementos o
     * esta vacia
     *
     * @return true si esta vacio o false si la lista contiene elementos
     */
    public boolean esVacia() {
        if (getListaJugadores() == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para cambiar el nombre a un determinado jugador
     *
     * @param pNombre Nombre del jugador
     * @param pNuevoNombre Nuevo nombre del jugador
     * @return
     */
    public boolean cambiarNombreJugador(String pNombre, String pNuevoNombre) {
        // No existen nodos en la lista para cambiar el nombre
        if (getListaJugadores() == null) {
            return false;
        } else {
            // Se recorre la lista en busca del jugador que se desea cambiar el nombre
            NodoJugador nodoActual = getListaJugadores();
            while (nodoActual.getSiguiente() != null && !nodoActual.getNombre().equalsIgnoreCase(pNombre)) {
                nodoActual = nodoActual.getSiguiente();
            }
            if (nodoActual.getNombre().equalsIgnoreCase(pNombre)) {
                nodoActual.setNombre(pNuevoNombre);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Metodo utilizado para cambiar la edad de un jugador especifico.
     *
     * @param pNombreJugador nombre del jugador al que desea cambiar la edad
     * @param pNuevaEdad nueva edad del jugador
     * @return true si cambia la edad o false en caso contrario
     */
    public boolean cambiarEdadJugador(String pNombreJugador, int pNuevaEdad) {

        // No hay elementos en la lista para cambiar el nombre
        if (getListaJugadores() == null) {
            return false;
        } else {
            // Busca el nodo con el nombre del jugador al que se le va a modificar la edad
            NodoJugador nodoActual = getListaJugadores();
            while (nodoActual.getSiguiente() != null && !nodoActual.getNombre().equalsIgnoreCase(pNombreJugador)) {
                nodoActual = nodoActual.getSiguiente();
            }
            // Verifica si encontro el elemento
            if (nodoActual.getNombre().equalsIgnoreCase(pNombreJugador)) {
                // Elimina el jugador de la lista porque debe estar ordenado por
                // la edad.
                this.eliminarJugador(pNombreJugador);
                // Cambia la edad al jugador y luego lo inserta en la posicion correcta.
                nodoActual.setEdad(pNuevaEdad);
                this.insertarOrdenadoPorEdad(nodoActual);
                return true;
            } else {
                // No se encontro el jugador, retorna false
                return false;
            }
        }
    }

    /**
     * Metodo para modificar el valor de la estatura para un jugador determinado
     *
     * @param pNombre nombre del jugador
     * @param pEstaturaNueva nueva estatura
     * @return true si cambio la estatura al jugador o false en caso que no
     * exista
     */
    public boolean cambiarEstaturaJugador(String pNombre, int pEstaturaNueva) {
        // Verifica si existen o no elementos en la lista
        if (getListaJugadores() == null) {
            return false;
        } else {
            // Recorre la lista en busca del jugador buscado
            NodoJugador nodoActual = getListaJugadores();
            while (nodoActual.getSiguiente() != null && !nodoActual.getNombre().equalsIgnoreCase(pNombre)) {
                nodoActual = nodoActual.getSiguiente();
            }
            // verifica si encontro el jugador o no
            if (nodoActual.getNombre().equalsIgnoreCase(pNombre)) {
                // Encontro el jugador. Cambia la estatura y retorna true
                nodoActual.setEstatura(pEstaturaNueva);
                System.out.println(pEstaturaNueva);
                return true;
            } else {
                // No encontro el jugador. Retorna false
                return false;
            }
        }
    }

    /**
     * Metodo para modificar el la posicion de jugador determinado
     *
     * @param pNombre nombre del jugador
     * @param pPosicion nueva posicion del jugador
     * @return true si cambio la posicion al jugador o false en caso que no
     * exista
     */
    public boolean cambiarPosicionJugador(String pNombre, String pPosicion) {
        // Verifica si existen o no elementos en la lista
        if (getListaJugadores() == null) {
            return false;
        } else {
            // Recorre la lista en busca del jugador buscado
            NodoJugador nodoActual = getListaJugadores();
            while (nodoActual.getSiguiente() != null && !nodoActual.getNombre().equalsIgnoreCase(pNombre)) {
                nodoActual = nodoActual.getSiguiente();
            }
            // verifica si encontro el jugador o no
            if (nodoActual.getNombre().equalsIgnoreCase(pNombre)) {
                // Encontro el jugador. Cambia la estatura y retorna true
                nodoActual.setPosicion(pPosicion);
                return true;
            } else {
                // No encontro el jugador. Retorna false
                return false;
            }
        }
    }

    /**
     * Metodo utilizado para cambiar el numero de camiseta a un jugador
     *
     * @param pNombreJugador nombre del jugador al que desea cambiarle el numero
     * @param pNumeroNuevo numero nuevo de camiseta
     * @return true si cambio el numero o false en caso contrario
     */
    public boolean cambiarNumero(String pNombreJugador, int pNumeroNuevo) {
        // Varifica si hay elementos en la lista o no (raiz = null)
        if (getListaJugadores() == null) {
            return false;
        } else {
            // Verifica si el numero solicitado ya lo posee un jugador o no
            if (existeNumeroEnLista(pNumeroNuevo)) {
                return false;
            } else {
                // Recorre la lista en busca del jugador buscado
                NodoJugador nodoActual = getListaJugadores();
                while (nodoActual.getSiguiente() != null && !nodoActual.getNombre().equalsIgnoreCase(pNombreJugador)) {
                    nodoActual = nodoActual.getSiguiente();
                }
                // verifica si encontro el jugador o no
                if (nodoActual.getNombre().equalsIgnoreCase(pNombreJugador)) {
                    // Encontro el jugador. Cambia el numero de camiseta y retorna true
                    nodoActual.setNumeroCamiseta(pNumeroNuevo);
                    return true;
                } else {
                    // No encontro el jugador. Retorna false
                    return false;
                }
            }
        }
    }

    /**
     * Metodo para verificar si existe un jugador con un numero especifico en el
     * equipo
     *
     * @param pNumero numero a buscar si lo posee un jugador
     * @return true en caso que un jugador lo tenga, false en caso contrario
     */
    private boolean existeNumeroEnLista(int pNumero) {
        // Recorre la lista en busca de un jugador con dicho numero
        NodoJugador nodoActual = getListaJugadores();
        while (nodoActual.getSiguiente() != null && nodoActual.getNumeroCamiseta() != pNumero) {
            nodoActual = nodoActual.getSiguiente();
        }
        // Si un jugador ya posee dicho numero, retorna true, sino retorna false
        if (nodoActual.getNumeroCamiseta() == pNumero) {
            return true;
        } else {
            return false;
        }
    }
}
