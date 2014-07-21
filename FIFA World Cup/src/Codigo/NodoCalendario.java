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
public class NodoCalendario {
    
    private Date fechaYHoraDelPartido;
    private int humedad;
    private int velocidadDelViento;
    private int temperatura;
    private NodoEstadio sedeDelEncuentro;
//    private NodoEquipo equipoCasa;
//    private NodoEquipo equipoVisita;
    private NodoPartido resultadoDelPartido; 
    
    private NodoCalendario siguiente;

    /**
     * Metodo constructor vacio
     */
    public NodoCalendario(){
        sedeDelEncuentro = null;
        resultadoDelPartido = null;
    }
    
    /**
     * Metodo constructor
     * @param pFechaYHoraDelPartido Fecha y hora del partido
     * @param pHumedad humedad de la ciudad
     * @param pVelocidadDelViento velocidad del viento
     * @param pTemperatura temperatura en el estadio
     * @param pSedeDelEncuentro sede del partido
     * @param pResultadoDelPartido Informacion del partido (equipos, goles y anotadores)
     */
    public NodoCalendario(Date pFechaYHoraDelPartido, int pHumedad, int pVelocidadDelViento, int pTemperatura, 
            NodoEstadio pSedeDelEncuentro, NodoPartido pResultadoDelPartido) 
    {
        fechaYHoraDelPartido = pFechaYHoraDelPartido;
        humedad = pHumedad;
        velocidadDelViento = pVelocidadDelViento;
        temperatura = pTemperatura;
        sedeDelEncuentro = pSedeDelEncuentro;
        resultadoDelPartido = pResultadoDelPartido;
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
    public int getHumedad() {
        return humedad;
    }

    /**
     * @param humedad the humedad to set
     */
    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    /**
     * @return the velocidadDelViento
     */
    public int getVelocidadDelViento() {
        return velocidadDelViento;
    }

    /**
     * @param velocidadDelViento the velocidadDelViento to set
     */
    public void setVelocidadDelViento(int velocidadDelViento) {
        this.velocidadDelViento = velocidadDelViento;
    }

    /**
     * @return the temperatura
     */
    public int getTemperatura() {
        return temperatura;
    }

    /**
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(int temperatura) {
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
     * @return the resultadoDelPartido
     */
    public NodoPartido getResultadoDelPartido() {
        return resultadoDelPartido;
    }

    /**
     * @param resultadoDelPartido the resultadoDelPartido to set
     */
    public void setResultadoDelPartido(NodoPartido resultadoDelPartido) {
        this.resultadoDelPartido = resultadoDelPartido;
    }         

    /**
     * @return the siguiente
     */
    public NodoCalendario getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoCalendario siguiente) {
        this.siguiente = siguiente;
    }
    
}
