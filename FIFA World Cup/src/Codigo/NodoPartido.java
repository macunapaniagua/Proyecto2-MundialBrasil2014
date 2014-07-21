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
public class NodoPartido {
    
    private NodoEquipo equipoCasa;
    private NodoEquipo equipoVisita;
    private int golesCasa;
    private int golesVisita;
    private ListaJugadores anotadores;
    
    public NodoPartido(NodoEquipo pEquipoCasa, NodoEquipo pEquipoVisita,int pGolesCasa, 
            int pGolesVisita, ListaJugadores pAnotadores)
    {
        equipoCasa = pEquipoCasa;
        equipoVisita = pEquipoVisita;
        golesCasa = pGolesCasa;
        golesVisita = pGolesVisita;
        anotadores = pAnotadores;
    }

    /**
     * @return the equipoCasa
     */
    public NodoEquipo getEquipoCasa() {
        return equipoCasa;
    }

    /**
     * @param equipoCasa the equipoCasa to set
     */
    public void setEquipoCasa(NodoEquipo equipoCasa) {
        this.equipoCasa = equipoCasa;
    }

    /**
     * @return the equipoVisita
     */
    public NodoEquipo getEquipoVisita() {
        return equipoVisita;
    }

    /**
     * @param equipoVisita the equipoVisita to set
     */
    public void setEquipoVisita(NodoEquipo equipoVisita) {
        this.equipoVisita = equipoVisita;
    }

    /**
     * @return the golesCasa
     */
    public int getGolesCasa() {
        return golesCasa;
    }

    /**
     * @param golesCasa the golesCasa to set
     */
    public void setGolesCasa(int golesCasa) {
        this.golesCasa = golesCasa;
    }

    /**
     * @return the golesVisita
     */
    public int getGolesVisita() {
        return golesVisita;
    }

    /**
     * @param golesVisita the golesVisita to set
     */
    public void setGolesVisita(int golesVisita) {
        this.golesVisita = golesVisita;
    }

    /**
     * @return the anotadores
     */
    public ListaJugadores getAnotadores() {
        return anotadores;
    }

    /**
     * @param anotadores the anotadores to set
     */
    public void setAnotadores(ListaJugadores anotadores) {
        this.anotadores = anotadores;
    }
    
    
}
