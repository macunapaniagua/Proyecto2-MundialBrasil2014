/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;              // |
import org.jdom2.Document;          // |\ Librerías
import org.jdom2.Element;           // |/ JDOM
import org.jdom2.JDOMException;     // |
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Mario A
 */
public class XMLReader {

    /**
     * Metodo utilizado para cargar todos los estadios del mundial Brasil 2014
     * desde un documento XML que contiene informacion de cada uno de ellos
     * @return Lista con los estadios del mundial
     */
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

    /**
     * Metodo utilizado para cargar del XML la lisa de equipos que participan
     * en el mundial
     * @return Lista con los equipos participantes
     */
    public ListaEquipos cargarListaEquipos() {

        // Se crea la lista con los equipos que se va a retornar
        ListaEquipos listaEquipos = new ListaEquipos();
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();

        try {
            File xmlFile = new File(getClass().getResource("/XML/Equipos.xml").toURI());
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);
            //Se obtiene la raiz 'Equipos'
            Element raizXML = document.getRootElement();

            //Se obtiene la lista de hijos de la raiz 'Equipos' (Todos los equipos del mundial)
            List listEquipos = raizXML.getChildren("Equipo");

            //Se recorre la lista de hijos de 'Equipos'
            for (int i = 0; i < listEquipos.size(); i++) {
                //Se obtiene el elemento 'equipo'
                Element equipo = (Element) listEquipos.get(i);
                // Se obtienen los datos del equipo actual
                String nombreEquipo = equipo.getChildText("Nombre");
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
    
    /**
     * Metodo utilizado para crear los grupos del mundial con la informacion de todos
     * los encuentros por grupo
     * @param pEquipos equipos participantes del mundial
     * @param pEstadios estadio del mundial
     * @return lista de los grupos del mundial
     */
    public ListaGrupos cargarCalendarioYGrupos(ListaEquipos pEquipos, ListaEstadios pEstadios){
        
        // Formato que se va a establecer en la creacion de cada fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("d/M/yy h:mm a");
        // Se crea la lista de los Grupos del mundial, que se va a retornar
        ListaGrupos listaDeGrupos = new ListaGrupos();
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();

        try {
            File xmlFile = new File(getClass().getResource("/XML/CalendarioGrupos.xml").toURI());
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);
            //Se obtiene la raiz 'Grupos'
            Element raizXML = document.getRootElement();

            //Se obtiene la lista de hijos de la raiz 'Grupos' (Todos los grupos del mundial)
            List listaGruposXML = raizXML.getChildren("Grupo");

            // RECORRE LA LISTA DE GRUPOS DEL MUNDIAL
            for (int i = 0; i < listaGruposXML.size(); i++) {                
                //Se obtiene el elemento 'Grupo' en la posicion i de la lista
                Element grupo = (Element) listaGruposXML.get(i);
                
                // Obtengo el atributo con la letra del grupo
                char letraDelGrupo = grupo.getAttributeValue("letra").charAt(0);
                
                // Se obtine la lista de los equipos que conforma el grupo
                List selecciones = grupo.getChild("Equipos").getChildren("Equipo");
                // Se crea un arreglo que almacenara las selecciones integrantes
                String[] equiposDelGrupo = new String[selecciones.size()];                                               
                // RECORRE LA LISTA DE EQUIPOS PERTENECIENTES A ESTE GRUPO
                for (int j = 0; j < selecciones.size(); j++) {
                    Element equipo = (Element)selecciones.get(j);                    
                    // Obtiene el nombre del equipo 'j'
                    String nombreDelEquipo = equipo.getText();
                    // Inserta nombre del equipo, en el arreglo de equiposDelGrupo
                    equiposDelGrupo[j] = nombreDelEquipo;
                }
                                                
                // SE CREA LA LISTA QUE ALMACENARA LOS ENCUENTROS DEL GRUPO                
                ListaCalendario calendarioDelGrupo = new ListaCalendario(); 
                // Se obtiene la lista de todo los Encuentros correspondientes al grupo
                List listaDeEncuentros = grupo.getChild("Encuentros").getChildren("Partido");
                // RECORRE LA LISTA DE PARTIDOS CORRESPONDIENTES A LOS EQUIPOS DEL GRUPO ACTUAL
                for (int j = 0; j < listaDeEncuentros.size(); j++) {
                    Element partido = (Element)listaDeEncuentros.get(j);
                    
                    // Obtiene los datos de fecha y hora del encuentro
                    String fechaDelPartido = partido.getChildText("Fecha");
                    String horaDelPartido = partido.getChildText("Hora");
                    Date fechaYHora = formatoFecha.parse(fechaDelPartido + " " + horaDelPartido);
                    
                    // Obtiene los datos de condiciones climaticas del encuentro
                    String humedad = partido.getChildText("Humedad");
                    String velocidadViento = partido.getChildText("VelocidadViento");
                    String temperatura = partido.getChildText("Temperatura");
                    String condicionClimatica = partido.getChildText("CondicionClimatica");
                    
                    // Obtiene el estadio sede del encuentro
                    String nombreEstadioSede = partido.getChildText("Sede");
                    NodoEstadio estadioSede = pEstadios.getNodoEstadio(nombreEstadioSede);
                    
                    // Obtiene los equipos casa y visita que se enfrentan en el encuentro
                    String nombreEquipoCasa = partido.getChildText("EquipoCasa");
                    NodoEquipo equipoCasa = pEquipos.getNodoEquipo(nombreEquipoCasa);
                    String nombreEquipoVisita = partido.getChildText("EquipoVisita");
                    NodoEquipo equipoVisita = pEquipos.getNodoEquipo(nombreEquipoVisita);
                    
                    // Obtiene la cantidad de goles por equipo, en el encuentro
                    int golesCasa = Integer.parseInt(partido.getChild("GolesCasa").getAttributeValue("goles"));
                    String anotadoresCasa = "";
                    int golesVisita = Integer.parseInt(partido.getChild("GolesVisita").getAttributeValue("goles"));                    
                    String anotadoresVisita = "";
                    
                    // COMPRUEBA SI HUBIERON ANOTACIONES, DE LOS LOCALES, PARA OBTENER LOS ANOTADORES
                    if(golesCasa > 0){
                        List anotadores = partido.getChild("GolesCasa").getChild("Anotadores").getChildren("Anotador");
                        // RECORRE LA LISTA PARA OBTENER LOS ANOTADORES Y EL MINUTO DEL GOL
                        for (int k = 0; k < anotadores.size(); k++) {
                            Element anotador = (Element)anotadores.get(k);
                            // OBTENGO LOS DATOS DEL ANOTADOR 'k'
                            String nombre = anotador.getChildText("Nombre");
                            String minuto = anotador.getChildText("Minuto");
                            if(k < (anotadores.size()-1)){
                                anotadoresCasa += minuto + '\'' + "  " + nombre + '\n';
                            }else{
                                anotadoresCasa += minuto + '\'' + "  " + nombre;
                            }                                     
                        }
                    }
                    // COMPRUEBA SI HUBIERON ANOTACIONES, DE LA VISITA, PARA OBTENER LOS ANOTADORES
                    if(golesVisita > 0){
                        List anotadores = partido.getChild("GolesVisita").getChild("Anotadores").getChildren("Anotador");
                        // RECORRE LA LISTA PARA OBTENER LOS ANOTADORES Y EL MINUTO DEL GOL
                        for (int k = 0; k < anotadores.size(); k++) {
                            Element anotador = (Element)anotadores.get(k);
                            // OBTENGO LOS DATOS DEL ANOTADOR 'k'
                            String nombre = anotador.getChildText("Nombre");
                            String minuto = anotador.getChildText("Minuto");                            
                            if(k < (anotadores.size()-1)){
                                anotadoresVisita += minuto + '\'' + "  " + nombre + '\n';
                            }else{
                                anotadoresVisita += minuto + '\'' + "  " + nombre;
                            }
                        }
                    }                    
                    // Crea un nuevo nodo Encuentro y lo inserta en la lista de Calendario
                    NodoEncuentro encuentro = new NodoEncuentro(fechaYHora, humedad, velocidadViento, 
                            temperatura, estadioSede, equipoCasa, equipoVisita, golesCasa, golesVisita, 
                            anotadoresCasa, anotadoresVisita, condicionClimatica);
                    
                    // Inserta el nuevo nodo en la lista de Encuentros
                    calendarioDelGrupo.insertarOrdenadoPorFecha(encuentro);
                }
                // Crea un nodo Grupo con toda la informacion del grupo actual
                NodoGrupo grupoDelMundial = new NodoGrupo(letraDelGrupo, equiposDelGrupo, calendarioDelGrupo);
                // Inserta el grupo a la lista de grupos
                listaDeGrupos.insertarOrdenado(grupoDelMundial);
            }
            // Retorna la lista de todos los equipos
            return listaDeGrupos;
            
        } catch (IOException | JDOMException | URISyntaxException | ParseException io) {
            System.out.println(io.getMessage());
            return null;
        }
    }
}
