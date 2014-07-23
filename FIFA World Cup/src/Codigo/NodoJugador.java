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
public class NodoJugador {

    private String nombre;
    private String posicion;
    private int edad;
    private int estatura;
    private int cantidadGolesAnotados;
    private int numeroCamiseta;
    
    private NodoJugador siguiente;

    public NodoJugador() {

    }

    public NodoJugador(String pNombre, String pPosicion, int pEdad, int pEstatura, int pNumero, int pGoles) {
        nombre = pNombre;
        posicion = pPosicion;
        edad = pEdad;
        estatura = pEstatura;
        cantidadGolesAnotados = pGoles;
        numeroCamiseta = pNumero;
        
        siguiente = null;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the estatura
     */
    public int getEstatura() {
        return estatura;
    }

    /**
     * @param estatura the estatura to set
     */
    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    /**
     * @return the cantidadGolesAnotados
     */
    public int getCantidadGolesAnotados() {
        return cantidadGolesAnotados;
    }

    /**
     * @param cantidadGolesAnotados the cantidadGolesAnotados to set
     */
    public void setCantidadGolesAnotados(int cantidadGolesAnotados) {
        this.cantidadGolesAnotados = cantidadGolesAnotados;
    }

    /**
     * @return the numeroCamiseta
     */
    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    /**
     * @param numeroCamiseta the numeroCamiseta to set
     */
    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    /**
     * @return the posicion
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the siguiente
     */
    public NodoJugador getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoJugador siguiente) {
        this.siguiente = siguiente;
    }

}
