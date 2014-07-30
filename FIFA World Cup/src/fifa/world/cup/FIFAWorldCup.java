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
import InterfazGrafica.PanelGoleador;
import InterfazGrafica.PanelJugador;
import InterfazGrafica.PanelPosiciones;
import InterfazGrafica.PanelResultadoPartido;
import InterfazGrafica.PanelResultadosGrupo;
import InterfazGrafica.PanelSeleccion;
import InterfazGrafica.VentanaEncuentros;
import InterfazGrafica.VentanaEquipos;
import InterfazGrafica.VentanaEstadios;
import InterfazGrafica.VentanaGoleadores;
import InterfazGrafica.VentanaJugadores;
import InterfazGrafica.VentanaPosiciones;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;

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
        SimpleDateFormat formatoFecha = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy,   h:mm a");

        // *** OJO: ES IMPORTANTE CARGAR PRIMERO TODOS LOS ESTADIOS, EQUIPOS Y GRUPOS
        // *** ANTES DE MODIFICAR ALGUNA CARACTERISTICA, SINO ME VA A RETORNAR NULL
        XMLReader lector = new XMLReader();
        // Lista de estadios
        ListaEstadios estadiosMundial;
        // Lista de equipos
        ListaEquipos listaEquiposMundial;
        // Lista de jugadores de una seleccion
        ListaJugadores listaDeJugadores;
        // Lista de grupos del mundial
        ListaGrupos listaDeGrupos;

        // Se carga la informacion de los estadios en el XMLReader y se asigna a la lista
        estadiosMundial = lector.cargarListaDeEstadios();
        listaEquiposMundial = lector.cargarListaEquipos();
        listaDeGrupos = lector.cargarCalendarioYGrupos(listaEquiposMundial, estadiosMundial);

        //********************* Ventana de Estadios ****************************                        
        // Se le cambia la ubicacion al Estadio Castelao
        estadiosMundial.modificarUbicacionDelEstadio("Estadio Castelao", "Ciudad Quesada");
        // Se cambia el nombre del Estadio Castelao
        estadiosMundial.modificarNombreDeEstadio("Estadio Castelao", "Nazareth");
        estadiosMundial.modificarCapacidadEstadio("Nazareth", 2);

        // se crea una ventana de estadios
        VentanaEstadios v = new VentanaEstadios();

        estadiosMundial.inicializarNodoActal();
        while (estadiosMundial.getNodoActual() != null) {

            PanelEstadio estadio = new PanelEstadio();
            estadio.setDatos(estadiosMundial.getNodoActual().getNombreEstadio(),
                    estadiosMundial.getNodoActual().getCiudad(), estadiosMundial.getNodoActual().getCapacidad());
            v.agregarEstadio(estadio);
            estadiosMundial.moverNodoActual();
        }

        v.setLocationRelativeTo(null);
        v.setVisible(true);

        //*********************** Ventana de selecciones ***********************                
        VentanaEquipos ve = new VentanaEquipos();

        listaEquiposMundial.inicializarNodoActual();

        while (listaEquiposMundial.getNodoActual() != null) {
            PanelSeleccion panel = new PanelSeleccion();
            panel.setEquipo(listaEquiposMundial.getNodoActual().getNombreEquipo());
            ve.setSeleccion(panel);
            listaEquiposMundial.moverNodoActual();
        }

        ve.setLocationRelativeTo(null);
        ve.setVisible(true);
//////////////        
        // *********************** Lista de Jugadores **************************

        VentanaJugadores vj = new VentanaJugadores();

        String seleccion = "Costa Rica";

        listaDeJugadores = listaEquiposMundial.getNodoEquipo(seleccion).getJugadores();
        // ESTO ES PARA QUE EL NOMBRE DEL EQUIPO LO MUESTRE COMO ESTA EN EL XML, NO EN MINUSCULA
        vj.agregarBanderaYLogo(listaEquiposMundial.getNodoEquipo(seleccion).getNombreEquipo());

//////////        listaDeJugadores.cambiarNombreJugador("Nani", "Mario");
//////////        listaDeJugadores.cambiarNumero("Mario", 24);
//////////        listaDeJugadores.cambiarEstaturaJugador("Mario", 178);
//////////        listaDeJugadores.cambiarPosicionJugador("Mario", "Delantero");
//////////        listaDeJugadores.cambiarEdadJugador("Mario", 23);
        listaDeJugadores.inicializarNodoActual();

        while (listaDeJugadores.getNodoActual() != null) {

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

        // *********************** JUGADOR MAS JOVEN DE UN EQUIPO **************
        String EquipoDeJugadorAConsultar = "Costa Rica";

        NodoJugador jugadorMasJoven = listaEquiposMundial.getNodoEquipo(EquipoDeJugadorAConsultar).getJugadores().getJugadorMasJoven();
        NodoJugador jugadorMasViejo = listaEquiposMundial.getNodoEquipo(EquipoDeJugadorAConsultar).getJugadores().getJugadorMasViejo();

        JFrame joven = new JFrame("Jugador más Joven");
        JFrame viejo = new JFrame("Jugador más Viejo");

        PanelJugador jugaJoven = new PanelJugador();
        jugaJoven.setDatosJugador(EquipoDeJugadorAConsultar, jugadorMasJoven.getNombre(),
                jugadorMasJoven.getPosicion(), jugadorMasJoven.getNumeroCamiseta(), jugadorMasJoven.getEdad(),
                jugadorMasJoven.getEstatura());
        joven.add(jugaJoven);
        joven.setResizable(false);
        joven.pack();
        joven.repaint();
        joven.revalidate();
        joven.setLocationRelativeTo(null);
        joven.setVisible(true);

        PanelJugador jugaViejo = new PanelJugador();
        jugaViejo.setDatosJugador(EquipoDeJugadorAConsultar, jugadorMasViejo.getNombre(),
                jugadorMasViejo.getPosicion(), jugadorMasViejo.getNumeroCamiseta(), jugadorMasViejo.getEdad(),
                jugadorMasViejo.getEstatura());
        viejo.add(jugaViejo);
        viejo.setResizable(false);
        viejo.pack();
        viejo.setLocationRelativeTo(null);
        viejo.setVisible(true);

        //////////////// LISTA DE GRUPOS Y ENCUENTROS ENTRE SELECCIONES  /////////////////////               
        VentanaEncuentros en = new VentanaEncuentros();

        listaDeGrupos.inicializarNodoActal();

        while (listaDeGrupos.getNodoActual() != null) {

            PanelResultadosGrupo grupo = new PanelResultadosGrupo();
            grupo.setLetraGrupo(listaDeGrupos.getNodoActual().getLetraGrupo());

            // SE OBTIENE LA LISTA DE PARTIDOS Y SE RECORRE UNA A UNA
            ListaCalendario calendarioDelGrupo = listaDeGrupos.getNodoActual().getListaDeEnfrentamientos();

            calendarioDelGrupo.inicializarNodoActal();
            while (calendarioDelGrupo.getNodoActual() != null) {

                PanelResultadoPartido partido = new PanelResultadoPartido();

                String fechaEncuentro = formatoFecha.format(calendarioDelGrupo.getNodoActual().getFechaYHoraDelPartido());
                String casa = calendarioDelGrupo.getNodoActual().getEquipoCasa().getNombreEquipo();
                String visita = calendarioDelGrupo.getNodoActual().getEquipoVisita().getNombreEquipo();
                String marcador = calendarioDelGrupo.getNodoActual().getCantidadGolesCasa() + ":"
                        + calendarioDelGrupo.getNodoActual().getCantidadGolesVisita();
                String anotadoresCasa = calendarioDelGrupo.getNodoActual().getAnotadoresEquipoCasa();
                String anotadoresVisita = calendarioDelGrupo.getNodoActual().getAnotadoresEquipoVisita();
                String humedad = calendarioDelGrupo.getNodoActual().getHumedad();
                String temperatura = calendarioDelGrupo.getNodoActual().getTemperatura();
                String viento = calendarioDelGrupo.getNodoActual().getVelocidadDelViento();
                String estadio = calendarioDelGrupo.getNodoActual().getSedeDelEncuentro().getNombreEstadio();
                String condicionClimatica = calendarioDelGrupo.getNodoActual().getCondicionClimatica();

                partido.agregarEncuentro(fechaEncuentro, casa, visita, marcador, anotadoresCasa, anotadoresVisita,
                        humedad, temperatura, viento, estadio, condicionClimatica);
                grupo.agregarPanelResultado(partido);

                calendarioDelGrupo.moverNodoActual();
            }

            en.agregarGrupoYResultados(grupo);
            listaDeGrupos.moverNodoActual();
        }

        en.setLocationRelativeTo(null);
        en.setVisible(true);

        // *********************** Ventana de Posiciones ***********************
        // Se crea la ventana que contiene la informacion de la tabla de posiciones
        // por grupo
        VentanaPosiciones tabla = new VentanaPosiciones();

        listaDeGrupos.inicializarNodoActal();

        while (listaDeGrupos.getNodoActual() != null) {

            NodoEquipo[] selecciones = listaDeGrupos.getNodoActual().getpaisesIntegrantes();

            // Metodo insertion Sort creado por mi
            for (int i = 0; i < selecciones.length - 1; i++) {

                int mayor = i;

                for (int j = i + 1; j < selecciones.length; j++) {

                    if (selecciones[j].getPuntos() > selecciones[mayor].getPuntos() || (selecciones[j].getPuntos()
                            == selecciones[mayor].getPuntos() && selecciones[j].getGolDiferencia() > selecciones[mayor].getGolDiferencia())) {
                        mayor = j;
                    }
                }
                if (mayor != i) {
                    NodoEquipo nodoAuxiliar = selecciones[mayor];
                    selecciones[mayor] = selecciones[i];
                    selecciones[i] = nodoAuxiliar;
                }
            }

            PanelPosiciones pos = new PanelPosiciones();
            pos.setEquipos(listaDeGrupos.getNodoActual().getLetraGrupo(), selecciones);

            tabla.agregarTablaDeGrupo(pos);

            listaDeGrupos.moverNodoActual();

        }

        tabla.setLocationRelativeTo(null);
        tabla.setVisible(true);

        // *********************** Metodo Goleadores *******************************
        VentanaGoleadores goleo = new VentanaGoleadores();

        NodoJugador[] listaGoleadores = {null, null, null, null, null};
        String[] listaSelecciones = {"", "", "", "", ""};

        listaEquiposMundial.inicializarNodoActual();
        
        while(listaEquiposMundial.getNodoActual() != null){
            
            String seleccionActual = listaEquiposMundial.getNodoActual().getNombreEquipo();
            
            ListaJugadores jugadores = listaEquiposMundial.getNodoActual().getJugadores();
            
            jugadores.inicializarNodoActual();
            
            while(jugadores.getNodoActual() != null){
                
                NodoJugador jugadorAnalizado = jugadores.getNodoActual();
                
                String seleccionDelJugador = seleccionActual;
                
                for (int i = 0; i < listaGoleadores.length; i++) {
                    
                    if(listaGoleadores[i] == null){
                        listaGoleadores[i] = jugadorAnalizado;
                        listaSelecciones[i] = seleccionDelJugador;
                        break;
                    }
                    else if(listaGoleadores[i].getCantidadGolesAnotados() < jugadorAnalizado.getCantidadGolesAnotados())
                    {
                        NodoJugador jugadorAux = listaGoleadores[i];
                        listaGoleadores[i] = jugadorAnalizado;
                        jugadorAnalizado = jugadorAux;
                        
                        String seleccionAux = listaSelecciones[i];
                        listaSelecciones[i] = seleccionDelJugador;
                        seleccionDelJugador = seleccionAux;                        
                    }                    
                }                               
                jugadores.moverNodoActual();
            }                        
            listaEquiposMundial.moverNodoActual();                                                                        
        } 
        
        for (int i = 0; i < listaGoleadores.length; i++) {
            
            String seleccionDelGoleador = listaSelecciones[i];
            String nombreGoleador = listaGoleadores[i].getNombre();
            int cantidadGoles = listaGoleadores[i].getCantidadGolesAnotados();
            
            PanelGoleador goleadoresTorneo = new PanelGoleador();
            goleadoresTorneo.setGoleadores(seleccionDelGoleador, nombreGoleador, cantidadGoles);
            
            goleo.agregarGoleador(goleadoresTorneo);
        }
        
        goleo.setLocationRelativeTo(null);
        goleo.setVisible(true);
    }
}
