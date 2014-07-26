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
public class NodoGrupo {
    
    private char letraGrupo;
    private String[] paisesIntegrantes;
    private ListaCalendario listaDeEnfrentamientos;    
    
    private NodoGrupo siguiente;
    
    /** 
     * Metodo constructor vacio
     */
    public NodoGrupo(){        
        siguiente = null;
    }
    
    /**
     * Metodo constructor para inicializar las variables
     * @param pLetra letra del grupo
     * @param pSelecciones lista de equipos en el grupo
     * @param pEncuentros lista de partidos del grupo
     */
    public NodoGrupo(char pLetra, String[] pSelecciones, ListaCalendario pEncuentros){
        letraGrupo = pLetra;
        paisesIntegrantes = pSelecciones;
        listaDeEnfrentamientos = pEncuentros;
        siguiente = null;
    }

    /**
     * @return the letraGrupo
     */
    public char getLetraGrupo() {
        return letraGrupo;
    }

    /**
     * @param letraGrupo the letraGrupo to set
     */
    public void setLetraGrupo(char letraGrupo) {
        this.letraGrupo = letraGrupo;
    }

    /**
     * @return the listaPaisesIntegrantes
     */
    public String[] getpaisesIntegrantes() {
        return paisesIntegrantes;
    }

    /**
     * @param pPaisesIntegrantes the pPaisesIntegrantes to set
     */
    public void setListaPaisesIntegrantes(String[] pPaisesIntegrantes) {
        this.paisesIntegrantes = pPaisesIntegrantes;
    }

    /**
     * @return the listaDeEnfrentamientos
     */
    public ListaCalendario getListaDeEnfrentamientos() {
        return listaDeEnfrentamientos;
    }

    /**
     * @param listaDeEnfrentamientos the listaDeEnfrentamientos to set
     */
    public void setListaDeEnfrentamientos(ListaCalendario listaDeEnfrentamientos) {
        this.listaDeEnfrentamientos = listaDeEnfrentamientos;
    }

    /**
     * @return the siguiente
     */
    public NodoGrupo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoGrupo siguiente) {
        this.siguiente = siguiente;
    }
    
}
