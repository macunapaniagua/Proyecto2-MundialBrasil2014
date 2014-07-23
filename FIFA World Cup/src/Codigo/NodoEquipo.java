/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Codigo;

import javax.swing.JLabel;

/**
 *
 * @author Mario A
 */
public class NodoEquipo {
    
    private String nombreEquipo;
    private String nombreEntrenador;
    private ListaJugadores jugadores;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesAFavor;
    private int golesEnContra;
    private int golDiferencia;
    private int puntos;
    
    private NodoEquipo siguiente;

    /**
     * Metodo constructor vacio
     */
    public NodoEquipo() {
        siguiente = null;
    }

    public NodoEquipo(String pNombreEquipo, String pNombreEntrenador, ListaJugadores pJugadores,
            int pPartidosJugados, int pPartidosGanados, int pPartidosEmpatados, int pPartidosPerdidos, int pGolesAFavor,
            int pGolesEnContra, int pGolDiferencia, int pPuntos) 
    {
        nombreEquipo = pNombreEquipo;
        nombreEntrenador = pNombreEntrenador;
        jugadores = pJugadores;
        partidosJugados = pPartidosJugados;
        partidosGanados = pPartidosGanados;
        partidosEmpatados = pPartidosEmpatados;
        partidosPerdidos = pPartidosPerdidos;
        golesAFavor = pGolesAFavor;
        golesEnContra = pGolesEnContra;
        golDiferencia = pGolDiferencia;
        puntos = pPuntos;
        
        siguiente = null;
    }              

    /**
     * @return the nombreEquipo
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * @param nombreEquipo the nombreEquipo to set
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * @return the nombreEntrenador
     */
    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    /**
     * @param nombreEntrenador the nombreEntrenador to set
     */
    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    /**
     * @return the jugadores
     */
    public ListaJugadores getJugadores() {
        return jugadores;
    }

    /**
     * @param jugadores the jugadores to set
     */
    public void setJugadores(ListaJugadores jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * @return the partidosJugados
     */
    public int getPartidosJugados() {
        return partidosJugados;
    }

    /**
     * @param partidosJugados the partidosJugados to set
     */
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    /**
     * @return the partidosGanados
     */
    public int getPartidosGanados() {
        return partidosGanados;
    }

    /**
     * @param partidosGanados the partidosGanados to set
     */
    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    /**
     * @return the partidosEmpatados
     */
    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    /**
     * @param partidosEmpatados the partidosEmpatados to set
     */
    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    /**
     * @return the partidosPerdidos
     */
    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    /**
     * @param partidosPerdidos the partidosPerdidos to set
     */
    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    /**
     * @return the golesAFavor
     */
    public int getGolesAFavor() {
        return golesAFavor;
    }

    /**
     * @param golesAFavor the golesAFavor to set
     */
    public void setGolesAFavor(int golesAFavor) {
        this.golesAFavor = golesAFavor;
    }

    /**
     * @return the golesEnContra
     */
    public int getGolesEnContra() {
        return golesEnContra;
    }

    /**
     * @param golesEnContra the golesEnContra to set
     */
    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the siguiente
     */
    public NodoEquipo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoEquipo siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the golDiferencia
     */
    public int getGolDiferencia() {
        return golDiferencia;
    }

    /**
     * @param golDiferencia the golDiferencia to set
     */
    public void setGolDiferencia(int golDiferencia) {
        this.golDiferencia = golDiferencia;
    }
    
}
