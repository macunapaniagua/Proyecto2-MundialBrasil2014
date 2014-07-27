/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Codigo;

import java.util.Date;

/**
 *
 * @author Mario A
 */
public class NodoEncuentro {
    
    private Date fechaYHoraDelPartido;
    private String humedad;
    private String velocidadDelViento;
    private String temperatura;
    private String condicionClimatica;
    private NodoEstadio sedeDelEncuentro;
    private NodoEquipo equipoCasa;
    private NodoEquipo equipoVisita;
    private int cantidadGolesCasa;
    private int cantidadGolesVisita;
    private String anotadoresEquipoCasa;
    private String anotadoresEquipoVisita;
    
    private NodoEncuentro siguiente;

    /**
     * Metodo constructor vacio
     */
    public NodoEncuentro(){
        sedeDelEncuentro = null;
        equipoCasa = null;
        equipoVisita = null;
        siguiente = null;
    }
    
    /**
     * Metodo constructor
     * @param pFechaYHoraDelPartido Fecha y hora del partido
     * @param pHumedad humedad de la ciudad
     * @param pVelocidadDelViento velocidad del viento
     * @param pTemperatura temperatura en el estadio
     * @param pSedeDelEncuentro sede del partido
     * @param pCasa enlace al Nodo del equipo casa
     * @param pVisita enlace al Nodo del equipo visita
     * @param pGolesCasa cantidad de goles anotados en el partido por el equipo casa
     * @param anotadoresCasa anotadores del equipo casa en este encuentro
     * @param anotadoresVisita anotadores del equipo visita en el encuentro
     * @param pGolesVisita cantidad de goles anotados por el equipo visita
     * @param pCondicionClimatica condicion climatica del encuentro
     */
    public NodoEncuentro(Date pFechaYHoraDelPartido, String pHumedad, String pVelocidadDelViento, String pTemperatura, 
            NodoEstadio pSedeDelEncuentro, NodoEquipo pCasa, NodoEquipo pVisita, int pGolesCasa, int pGolesVisita, 
            String anotadoresCasa, String anotadoresVisita, String pCondicionClimatica) 
    {
        fechaYHoraDelPartido = pFechaYHoraDelPartido;
        humedad = pHumedad;
        velocidadDelViento = pVelocidadDelViento;
        temperatura = pTemperatura;
        sedeDelEncuentro = pSedeDelEncuentro;
        equipoCasa = pCasa;
        equipoVisita = pVisita;
        cantidadGolesCasa = pGolesCasa;
        cantidadGolesVisita = pGolesVisita;
        anotadoresEquipoCasa = anotadoresCasa;
        anotadoresEquipoVisita = anotadoresVisita;
        condicionClimatica = pCondicionClimatica;
        
        siguiente = null;
    }   

    /**
     * @return the fechaYHoraDelPartido
     */
    public Date getFechaYHoraDelPartido() {
        return fechaYHoraDelPartido;
    }

    /**
     * @param fechaYHoraDelPartido the fechaYHoraDelPartido to set
     */
    public void setFechaYHoraDelPartido(Date fechaYHoraDelPartido) {
        this.fechaYHoraDelPartido = fechaYHoraDelPartido;
    }

    /**
     * @return the humedad
     */
    public String getHumedad() {
        return humedad;
    }

    /**
     * @param humedad the humedad to set
     */
    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    /**
     * @return the velocidadDelViento
     */
    public String getVelocidadDelViento() {
        return velocidadDelViento;
    }

    /**
     * @param velocidadDelViento the velocidadDelViento to set
     */
    public void setVelocidadDelViento(String velocidadDelViento) {
        this.velocidadDelViento = velocidadDelViento;
    }

    /**
     * @return the temperatura
     */
    public String getTemperatura() {
        return temperatura;
    }

    /**
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * @return the sedeDelEncuentro
     */
    public NodoEstadio getSedeDelEncuentro() {
        return sedeDelEncuentro;
    }

    /**
     * @param sedeDelEncuentro the sedeDelEncuentro to set
     */
    public void setSedeDelEncuentro(NodoEstadio sedeDelEncuentro) {
        this.sedeDelEncuentro = sedeDelEncuentro;
    }

    /**
     * @return the siguiente
     */
    public NodoEncuentro getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoEncuentro siguiente) {
        this.siguiente = siguiente;
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
     * @return the cantidadGolesCasa
     */
    public int getCantidadGolesCasa() {
        return cantidadGolesCasa;
    }

    /**
     * @param cantidadGolesCasa the cantidadGolesCasa to set
     */
    public void setCantidadGolesCasa(int cantidadGolesCasa) {
        this.cantidadGolesCasa = cantidadGolesCasa;
    }

    /**
     * @return the cantidadGolesVisita
     */
    public int getCantidadGolesVisita() {
        return cantidadGolesVisita;
    }

    /**
     * @param cantidadGolesVisita the cantidadGolesVisita to set
     */
    public void setCantidadGolesVisita(int cantidadGolesVisita) {
        this.cantidadGolesVisita = cantidadGolesVisita;
    }

    /**
     * @return the anotadoresEquipoCasa
     */
    public String getAnotadoresEquipoCasa() {
        return anotadoresEquipoCasa;
    }

    /**
     * @param anotadoresEquipoCasa the anotadoresEquipoCasa to set
     */
    public void setAnotadoresEquipoCasa(String anotadoresEquipoCasa) {
        this.anotadoresEquipoCasa = anotadoresEquipoCasa;
    }

    /**
     * @return the anotadoresEquipoVisita
     */
    public String getAnotadoresEquipoVisita() {
        return anotadoresEquipoVisita;
    }

    /**
     * @param anotadoresEquipoVisita the anotadoresEquipoVisita to set
     */
    public void setAnotadoresEquipoVisita(String anotadoresEquipoVisita) {
        this.anotadoresEquipoVisita = anotadoresEquipoVisita;
    }

    /**
     * @return the condicionClimatica
     */
    public String getCondicionClimatica() {
        return condicionClimatica;
    }

    /**
     * @param condicionClimatica the condicionClimatica to set
     */
    public void setCondicionClimatica(String condicionClimatica) {
        this.condicionClimatica = condicionClimatica;
    }
    
}
