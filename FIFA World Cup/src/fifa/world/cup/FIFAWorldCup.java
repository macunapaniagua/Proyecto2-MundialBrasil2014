/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.world.cup;

import Codigo.ListaCalendario;
import Codigo.ListaEquipos;
import Codigo.ListaEstadios;
import Codigo.ListaGrupos;
import Codigo.ListaJugadores;
import Codigo.NodoCalendario;
import Codigo.NodoEquipo;
import Codigo.NodoEstadio;
import Codigo.NodoGrupo;
import Codigo.NodoJugador;
import Codigo.XMLReader;
import InterfazGrafica.PanelEstadio;
import InterfazGrafica.PanelSeleccion;
import InterfazGrafica.VentanaEquipos;
import InterfazGrafica.VentanaEstadios;
import InterfazGrafica.VentanaJugadores;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mario A
 */
public class FIFAWorldCup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//////////        // ESTO NO SE PUEDE ELIMINAR, ES MUY IMPORTANTE
//////////        // Formato que se va a establecer en la creacion de cada fecha
//////////        SimpleDateFormat formatoFecha = new SimpleDateFormat("d MMM yyyy h:mm a");
//////////        
//////////        System.out.println("Lista Calendario de Juegos");
//////////        
//////////        ListaCalendario cal = new ListaCalendario();
//////////        
//////////        String fecha, hora;
//////////        
//////////        fecha = "25 Jun 2014";
//////////        hora = "1:00 PM";
//////////        NodoCalendario enc = new NodoCalendario();
//////////        Date fechaYHora = formatoFecha.parse(fecha + " " + hora, new ParsePosition(0));
//////////        enc.setFechaYHoraDelPartido(fechaYHora);
//////////        cal.insertarOrdenadoPorFecha(enc);
//////////        
//////////        fecha = "13 Jun 2014";
//////////        hora = "3:00 PM";
//////////        NodoCalendario enc1 = new NodoCalendario();
//////////        Date fechaYHora1 = formatoFecha.parse(fecha + " " + hora, new ParsePosition(0));
//////////        enc1.setFechaYHoraDelPartido(fechaYHora1);
//////////        cal.insertarOrdenadoPorFecha(enc1);
//////////        
//////////        fecha = "25 Jun 2014";
//////////        hora = "2:00 PM";
//////////        NodoCalendario enc2 = new NodoCalendario();
//////////        Date fechaYHora2 = formatoFecha.parse(fecha + " " + hora, new ParsePosition(0));
//////////        enc2.setFechaYHoraDelPartido(fechaYHora2);
//////////        cal.insertarOrdenadoPorFecha(enc2);
//////////        
//////////        fecha = "29 Jun 2014";
//////////        hora = "10:00 AM";
//////////        NodoCalendario enc3 = new NodoCalendario();
//////////        Date fechaYHora3 = formatoFecha.parse(fecha + " " + hora, new ParsePosition(0));
//////////        enc3.setFechaYHoraDelPartido(fechaYHora3);
//////////        cal.insertarOrdenadoPorFecha(enc3);
//////////        
//////////        fecha = "13 Jul 2014";
//////////        hora = "1:00 PM";
//////////        NodoCalendario enc4 = new NodoCalendario();
//////////        Date fechaYHora4 = formatoFecha.parse(fecha + " " + hora, new ParsePosition(0));
//////////        enc4.setFechaYHoraDelPartido(fechaYHora4);
//////////        cal.insertarOrdenadoPorFecha(enc4);
//////////        
//////////        
//////////        cal.imprimirCalendario();
        // *********************** Lista de Jugadores **************************
//////////        System.out.println("\nLista de Jugadores");
//////////
//////////        ListaJugadores jugadores = new ListaJugadores();
//////////
//////////        NodoJugador jug = new NodoJugador();
//////////        jug.setNombre("Ronaldo");
//////////        jug.setEdad(29);
//////////        jug.setNumeroCamiseta(7);
//////////        jugadores.insertarOrdenadoPorEdad(jug);
//////////
//////////        NodoJugador jug1 = new NodoJugador();
//////////        jug1.setNombre("Veloso");
//////////        jug1.setEdad(28);
//////////        jug1.setNumeroCamiseta(8);
//////////        jugadores.insertarOrdenadoPorEdad(jug1);
//////////
//////////        NodoJugador jug2 = new NodoJugador();
//////////        jug2.setNombre("Pepe");
//////////        jug2.setEdad(31);
//////////        jug2.setNumeroCamiseta(3);
//////////        jugadores.insertarOrdenadoPorEdad(jug2);
//////////
//////////        NodoJugador jug3 = new NodoJugador();
//////////        jug3.setNombre("Nani");
//////////        jug3.setEdad(27);
//////////        jug3.setNumeroCamiseta(17);
//////////        jugadores.insertarOrdenadoPorEdad(jug3);
//////////
//////////        NodoJugador jug4 = new NodoJugador();
//////////        jug4.setNombre("Alves");
//////////        jug4.setEdad(32);
//////////        jug4.setNumeroCamiseta(2);
//////////        jugadores.insertarOrdenadoPorEdad(jug4);
//////////
//////////        jugadores.inicializarNodoActual();
//////////        do {
//////////            if (jugadores.getNodoActual() == null) {
//////////                break;
//////////            } else {
//////////                NodoJugador nodoActual = jugadores.getNodoActual();
//////////                System.out.println(nodoActual.getNombre() + ", " + nodoActual.getEdad() + " años, " + nodoActual.getPosicion()
//////////                        + ", numero: " + nodoActual.getNumeroCamiseta() + ", estatura en cm: " + nodoActual.getEstatura());
//////////                jugadores.moverNodoActual();
//////////            }
//////////        } while (true);
        
        
        XMLReader lector = new XMLReader();
        // Lista de estadios
        ListaEstadios estadiosMundial;
        // Lista de equipos
        ListaEquipos listaEquiposMundial;
        
        
        
        //********************* Ventana de Estadios ****************************
        
        
        // Se carga la informacion de los estadios en el XMLReader y se asigna a la lista
        estadiosMundial = lector.cargarListaDeEstadios();
                            
        // Se le cambia la ubicacion al Estadio Castelao
        estadiosMundial.modificarUbicacionDelEstadio("Estadio Castelao", "Valle Azul");
        
        // se crea una ventana de estadios
        VentanaEstadios v = new VentanaEstadios(); 
        
        estadiosMundial.inicializarNodoActal();        
        while(estadiosMundial.getNodoActual() != null){
            
            PanelEstadio estadio = new PanelEstadio();
            estadio.setDatos(estadiosMundial.getNodoActual().getNombreEstadio(), 
                    estadiosMundial.getNodoActual().getCiudad(), estadiosMundial.getNodoActual().getCapacidad());
            v.agregarEstadio(estadio);
            estadiosMundial.moverNodoActual();
        }               
        
        v.setLocationRelativeTo(null);
        v.setVisible(true);
        
        //*********************** Ventana de selecciones ***********************
        
        listaEquiposMundial = lector.cargarListaEquipos();
        
        VentanaEquipos ve = new VentanaEquipos();
        
        listaEquiposMundial.inicializarNodoActual();
        
        while(listaEquiposMundial.getNodoActual() != null){
            
            System.out.println(listaEquiposMundial.getNodoActual().getNombreEquipo().toUpperCase());
            
            PanelSeleccion panel = new PanelSeleccion();
            panel.setEquipo(listaEquiposMundial.getNodoActual().getNombreEquipo());
            ve.setSeleccion(panel);
            listaEquiposMundial.moverNodoActual();
        }
        
        ve.setLocationRelativeTo(null);
        ve.setVisible(true);
        
        

////        System.out.println("Jugador mas joven " + jugadores.getJugadorMasJoven().getNombre());        
////        jugadores.imprimirListaJugadores();
////        
////        System.out.println("Jugador mas viejo " + jugadores.getJugadorMasViejo().getNombre());        
////        jugadores.imprimirListaJugadores();
////        System.out.println("Cambiar");
////        jugadores.cambiarPosicionJugador("Ronaldo", "Defensa");
////        jugadores.cambiarNumero("Nani", 5);
////        jugadores.imprimirListaJugadores();
////////        
////////        // ******************************** Lista De Equipos *******************
////////        
////////        System.out.println("\nEquipos");
////////        
////////        ListaEquipos equipos = new ListaEquipos();
////////        
////////        NodoEquipo equipo = new NodoEquipo();
////////        equipo.setNombreEquipo("Mexico");
////////        equipos.insertarOrdenado(equipo);
////////        
////////        NodoEquipo equipo2 = new NodoEquipo();
////////        equipo2.setNombreEquipo("Colombia");
////////        equipos.insertarOrdenado(equipo2);
////////        
////////        NodoEquipo equipo3 = new NodoEquipo();
////////        equipo3.setNombreEquipo("Holanda");
////////        equipos.insertarOrdenado(equipo3);
////////        
////////        NodoEquipo equipo4 = new NodoEquipo();
////////        equipo4.setNombreEquipo("Costa Rica");
////////        equipos.insertarOrdenado(equipo4);
////////        
////////        NodoEquipo equipo5 = new NodoEquipo();
////////        equipo5.setNombreEquipo("Alemania");
////////        equipos.insertarOrdenado(equipo5);
////////        
////////        NodoEquipo equipo6 = new NodoEquipo();
////////        equipo6.setNombreEquipo("Uruguay");
////////        equipos.insertarOrdenado(equipo6);
////////        
////////        NodoEquipo equipo7 = new NodoEquipo();
////////        equipo7.setNombreEquipo("Grecia");
////////        equipos.insertarOrdenado(equipo7);
////////        
////////        NodoEquipo equipo8 = new NodoEquipo();
////////        equipo8.setNombreEquipo("Brasil");
////////        equipos.insertarOrdenado(equipo8);
////////        
////////        NodoEquipo equipo9 = new NodoEquipo();
////////        equipo9.setNombreEquipo("Italia");
////////        equipos.insertarOrdenado(equipo9);
////////        
////////        equipos.imprimirEquipos();
////////        
////////        
////////        //************************ Lista de Grupos *****************************
////////        
////////        System.out.println("\nGrupos");
////////        
////////        ListaGrupos grupos = new ListaGrupos();
////////        
////////        NodoGrupo grupo = new NodoGrupo();
////////        grupo.setLetraGrupo('C');
////////        grupos.insertarOrdenado(grupo);
////////        
////////        NodoGrupo grupo1 = new NodoGrupo();
////////        grupo1.setLetraGrupo('A');
////////        grupos.insertarOrdenado(grupo1);
////////        
////////        NodoGrupo grupo2 = new NodoGrupo();
////////        grupo2.setLetraGrupo('B');
////////        grupos.insertarOrdenado(grupo2);
////////        
////////        NodoGrupo grupo3 = new NodoGrupo();
////////        grupo3.setLetraGrupo('H');
////////        grupos.insertarOrdenado(grupo3);
////////        
////////        NodoGrupo grupo4 = new NodoGrupo();
////////        grupo4.setLetraGrupo('E');
////////        grupos.insertarOrdenado(grupo4);
////////        
////////        NodoGrupo grupo5 = new NodoGrupo();
////////        grupo5.setLetraGrupo('F');
////////        grupos.insertarOrdenado(grupo5);
////////        
////////        NodoGrupo grupo6 = new NodoGrupo();
////////        grupo6.setLetraGrupo('D');
////////        grupos.insertarOrdenado(grupo6);
////////        
////////        NodoGrupo grupo7 = new NodoGrupo();
////////        grupo7.setLetraGrupo('I');
////////        grupos.insertarOrdenado(grupo7);
////////        
////////        grupos.imprimirGrupos();        
////////        
////////        //************************ Ventana de Selecciones **********************
////////        VentanaEquipos e = new VentanaEquipos();
////////        
////////        PanelSeleccion seleccion = new PanelSeleccion();
////////        seleccion.setEquipo("Costa Rica");       
////////        e.setSeleccion(seleccion);
////////        
////////        PanelSeleccion seleccion1 = new PanelSeleccion();
////////        seleccion1.setEquipo("Belgica");       
////////        e.setSeleccion(seleccion1);
////////        
////////        PanelSeleccion seleccion2 = new PanelSeleccion();
////////        seleccion2.setEquipo("España");       
////////        e.setSeleccion(seleccion2);
////////        
////////        PanelSeleccion seleccion3 = new PanelSeleccion();
////////        seleccion3.setEquipo("Argentina");       
////////        e.setSeleccion(seleccion3);
////////        
////////        PanelSeleccion seleccion4 = new PanelSeleccion();
////////        seleccion4.setEquipo("Alemania");       
////////        e.setSeleccion(seleccion4);
////////        
////////        PanelSeleccion seleccion5 = new PanelSeleccion();
////////        seleccion5.setEquipo("Holanda");       
////////        e.setSeleccion(seleccion5);
////////        
////////        PanelSeleccion seleccion6 = new PanelSeleccion();
////////        seleccion6.setEquipo("Mexico");       
////////        e.setSeleccion(seleccion6);
////////        
////////        PanelSeleccion seleccion7 = new PanelSeleccion();
////////        seleccion7.setEquipo("Brasil");       
////////        e.setSeleccion(seleccion7);
////////        
////////        PanelSeleccion seleccion8 = new PanelSeleccion();
////////        seleccion8.setEquipo("Estados Unidos");       
////////        e.setSeleccion(seleccion8);
////////        
////////        PanelSeleccion seleccion9 = new PanelSeleccion();
////////        seleccion9.setEquipo("Ghana");       
////////        e.setSeleccion(seleccion9);
////////        
////////        PanelSeleccion seleccion10 = new PanelSeleccion();
////////        seleccion10.setEquipo("Portugal");       
////////        e.setSeleccion(seleccion10);
////////        
////////        e.setLocationRelativeTo(null);
////////        e.setVisible(true);
////////        
       
        
        
        
        
        
        
        
        
        
        
        
        VentanaJugadores vj = new VentanaJugadores();
        vj.setLocationRelativeTo(null);
        vj.setVisible(true);
    }

}
