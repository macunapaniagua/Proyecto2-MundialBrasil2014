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
import Codigo.NodoEncuentro;
import Codigo.NodoEquipo;
import Codigo.NodoEstadio;
import Codigo.NodoGrupo;
import Codigo.NodoJugador;
import Codigo.XMLReader;
import InterfazGrafica.PanelEstadio;
import InterfazGrafica.PanelJugador;
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

        // ESTO NO SE PUEDE ELIMINAR, ES MUY IMPORTANTE
        // Formato que se va a establecer en la creacion de cada fecha
//////////        SimpleDateFormat formatoFecha = new SimpleDateFormat("d/M/yy h:mm a");
//////////        
//////////        System.out.println("Lista Calendario de Juegos");
//////////        
//////////        ListaCalendario cal = new ListaCalendario();
//////////        
//////////        String fecha, hora;
//////////        
//////////        fecha = "25/6/14";
//////////        hora = "1:00 PM";
//////////        NodoEncuentro enc = new NodoEncuentro();
//////////        Date fechaYHora = formatoFecha.parse(fecha + " " + hora, new ParsePosition(0));
//////////        enc.setFechaYHoraDelPartido(fechaYHora);
//////////        cal.insertarOrdenadoPorFecha(enc);
//////////        
//////////        fecha = "13/6/14";
//////////        hora = "3:00 PM";
//////////        NodoEncuentro enc1 = new NodoEncuentro();
//////////        Date fechaYHora1 = formatoFecha.parse(fecha + " " + hora, new ParsePosition(0));
//////////        enc1.setFechaYHoraDelPartido(fechaYHora1);
//////////        cal.insertarOrdenadoPorFecha(enc1);
//////////        
//////////        fecha = "25/6/14";
//////////        hora = "2:00 PM";
//////////        NodoEncuentro enc2 = new NodoEncuentro();
//////////        Date fechaYHora2 = formatoFecha.parse(fecha + " " + hora, new ParsePosition(0));
//////////        enc2.setFechaYHoraDelPartido(fechaYHora2);
//////////        cal.insertarOrdenadoPorFecha(enc2);
//////////        
//////////        fecha = "29/6/14";
//////////        hora = "10:00 AM";
//////////        NodoEncuentro enc3 = new NodoEncuentro();
//////////        Date fechaYHora3 = formatoFecha.parse(fecha + " " + hora, new ParsePosition(0));
//////////        enc3.setFechaYHoraDelPartido(fechaYHora3);
//////////        cal.insertarOrdenadoPorFecha(enc3);
//////////        
//////////        fecha = "13/6/14";
//////////        hora = "1:00 PM";
//////////        NodoEncuentro enc4 = new NodoEncuentro();
//////////        Date fechaYHora4 = formatoFecha.parse(fecha + " " + hora, new ParsePosition(0));
//////////        enc4.setFechaYHoraDelPartido(fechaYHora4);
//////////        cal.insertarOrdenadoPorFecha(enc4);
//////////        
//////////        
//////////        cal.imprimirCalendario();
        
        // *********************************************************************
        
        XMLReader lector = new XMLReader();
        // Lista de estadios
        ListaEstadios estadiosMundial;
        // Lista de equipos
        ListaEquipos listaEquiposMundial;
        // Lista de jugadores de una seleccion
        ListaJugadores listaDeJugadores;
        // Lista de grupos del mundial
        ListaGrupos listaDeGrupos;
        
        
        
        //********************* Ventana de Estadios ****************************
        
        
        // Se carga la informacion de los estadios en el XMLReader y se asigna a la lista
        estadiosMundial = lector.cargarListaDeEstadios();
                            
        // Se le cambia la ubicacion al Estadio Castelao
        estadiosMundial.modificarUbicacionDelEstadio("Estadio Castelao", "Ciudad Quesada");
        
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
            
            //System.out.println(listaEquiposMundial.getNodoActual().getNombreEquipo().toUpperCase());
            
            PanelSeleccion panel = new PanelSeleccion();
            panel.setEquipo(listaEquiposMundial.getNodoActual().getNombreEquipo());
            ve.setSeleccion(panel);
            listaEquiposMundial.moverNodoActual();
        }
        
        ve.setLocationRelativeTo(null);
        ve.setVisible(true);
        
        // *********************** Lista de Jugadores **************************
        
        VentanaJugadores vj = new VentanaJugadores();
        
        String seleccion = "Belgica";
        
        vj.agregarBanderaYLogo(seleccion);
        
        listaDeJugadores = listaEquiposMundial.getNodoEquipo(seleccion).getJugadores();
        
        listaDeJugadores.inicializarNodoActual();
        
        while(listaDeJugadores.getNodoActual() != null){
            
            NodoJugador jugadorActual = listaDeJugadores.getNodoActual();
            
            //System.out.println(jugadorActual.getNombre().toUpperCase());
            
            PanelJugador player = new PanelJugador();
            
            player.setDatosJugador(seleccion, jugadorActual.getNombre(), jugadorActual.getPosicion(), 
                    jugadorActual.getNumeroCamiseta(), jugadorActual.getEdad(), jugadorActual.getEstatura());
            vj.AgregarJugador(player);
            listaDeJugadores.moverNodoActual();
        }
        
        PanelJugador entrenador = new PanelJugador();
        entrenador.setDatosEntrenador(listaEquiposMundial.getNodoEquipo(seleccion).getNombreEntrenador(), seleccion);
        vj.AgregarJugador(entrenador);
        
        vj.setLocationRelativeTo(null);
        vj.setVisible(true);
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        listaDeGrupos = lector.cargarCalendarioYGrupos(listaEquiposMundial, estadiosMundial);
        
        listaDeGrupos.imprimirGrupos();

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


     
////////        grupos.imprimirGrupos();            
    }

}
