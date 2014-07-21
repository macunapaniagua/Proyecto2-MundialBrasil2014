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

}
