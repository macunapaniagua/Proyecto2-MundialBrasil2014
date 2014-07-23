/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder; // |

/**
 *
 * @author Mario A
 */
public class XMLReader {

    public ListaEstadios cargarListaDeEstadios() {

        // Se crea la lista con los estadios que se va a retornar
        ListaEstadios listaEstadios = new ListaEstadios();
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();

        try {
            File xmlFile = new File(getClass().getResource("/XML/Estadios.xml").toURI());
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);
            //Se obtiene la raiz 'tables'
            Element raizXML = document.getRootElement();
            //Se obtiene la lista de hijos de la raiz 'Estadios'
            List list = raizXML.getChildren("Estadio");

            //Se recorre la lista de hijos de 'tables'
            for (int i = 0; i < list.size(); i++) {
                //Se obtiene el elemento 'Estadio'
                Element estadio = (Element) list.get(i);

                //Se obtiene el valor que esta entre los tags '<Nombre></Nombre>'
                String nombreEstadio = estadio.getChildText("Nombre");
                //Se obtiene el valor que esta entre los tags '<Ciudad></Ciudad>'
                String ciudadEstadio = estadio.getChildText("Ciudad");
                //Se obtiene el valor que esta entre los tags '<Capacidad></Capacidad>'
                int capacidadEstadio = Integer.parseInt(estadio.getChildTextTrim("Capacidad"));

                // Se crea un NodoEstadio con la informacion del estadio.
                NodoEstadio nuevoEstadio = new NodoEstadio(nombreEstadio, ciudadEstadio, capacidadEstadio);
                // Se inserta el nuevo estadio en la lista de estadios
                listaEstadios.insertarAlFinal(nuevoEstadio);
            }
            return listaEstadios;

        } catch (IOException | JDOMException | URISyntaxException io) {
            System.out.println(io.getMessage());
            return null;
        }
    }

    public ListaEquipos cargarListaEquipos() {

        // Se crea la lista con los equipos que se va a retornar
        ListaEquipos listaEquipos = new ListaEquipos();
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();

        try {
            File xmlFile = new File(getClass().getResource("/XML/Equipos.xml").toURI());
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);
            //Se obtiene la raiz 'tables'
            Element raizXML = document.getRootElement();

            //Se obtiene la lista de hijos de la raiz 'Equipos' (Todos los equipos del mundial)
            List listEquipos = raizXML.getChildren("Equipo");

            //Se recorre la lista de hijos de 'Equipos'
            for (int i = 0; i < listEquipos.size(); i++) {
                //Se obtiene el elemento 'equipo'
                Element equipo = (Element) listEquipos.get(i);
                // Se obtienen los datos del equipo actual
                String nombreEquipo = equipo.getChildText("Nombre");
                System.out.println(nombreEquipo.toUpperCase());
                String nombreEntrenador = equipo.getChildText("Entrenador");
                int partidosJugados = Integer.parseInt(equipo.getChildTextTrim("PartidosJugados"));
                int partidosGanados = Integer.parseInt(equipo.getChildTextTrim("PartidosGanados"));
                int partidosEmpatados = Integer.parseInt(equipo.getChildTextTrim("PartidosEmpatados"));
                int partidosPerdidos = Integer.parseInt(equipo.getChildTextTrim("PartidosPerdidos"));
                int golesAFavor = Integer.parseInt(equipo.getChildTextTrim("GolesAFavor"));
                int golesEnContra = Integer.parseInt(equipo.getChildTextTrim("GolesEnContra"));
                int golDiferencia = Integer.parseInt(equipo.getChildTextTrim("GolDiferencia"));
                int puntos = Integer.parseInt(equipo.getChildTextTrim("Puntos"));
                // Se obtiene la lista de jugadores con su informacion del XML
                List listJugadores = equipo.getChild("Jugadores").getChildren("Jugador");

                // Se crea la lista de jugadores que va a contener el equipo actual
                ListaJugadores jugadores = new ListaJugadores();

                // Se recorre la lista de jugadores
                for (int j = 0; j < listJugadores.size(); j++) {
                    // Se obtiene el jugador 'j' de la lista de Jugadores
                    Element jugador = (Element) listJugadores.get(j);
                    // Se obtienen los datos del jugador 'j'
                    String nombreJugador = jugador.getChildText("Nombre");
                    System.out.println('\t' + nombreJugador);
                    int numeroCamiseta = Integer.parseInt(jugador.getChildTextTrim("NumeroCamiseta"));
                    String posicion = jugador.getChildTextTrim("Posicion");
                    int edad = Integer.parseInt(jugador.getChildTextTrim("Edad"));
                    int estatura = Integer.parseInt(jugador.getChildTextTrim("Estatura"));
                    int goles = Integer.parseInt(jugador.getChildTextTrim("Goles"));

                    //Se crea un nuevo NodoJugador donde se va a almacenar el jugador
                    NodoJugador jugadorNuevo = new NodoJugador(nombreJugador, posicion, 
                            edad, estatura, numeroCamiseta, goles);

                    // Se inserta el nuevo NodoJugador en la lista de jugadores
                    jugadores.insertarOrdenadoPorEdad(jugadorNuevo);
                }

                // Se crea un nuevo NodoEquipo que almacena la informacion del equipo actual
                NodoEquipo equipoActual = new NodoEquipo(nombreEquipo, nombreEntrenador,
                        jugadores, partidosJugados, partidosGanados, partidosEmpatados,
                        partidosPerdidos, golesAFavor, golesEnContra,golDiferencia, puntos);

                // Se inserta el NodoEquipo actual en la lista de equipos
                listaEquipos.insertarOrdenado(equipoActual);
            }
            // Retorna la lista de todos los equipos
            return listaEquipos;
            
        } catch (IOException | JDOMException | URISyntaxException io) {
            System.out.println(io.getMessage());
            return null;
        }
    }

}
