package xml;

/**
 * @author Elihu Alejandro Cruz Albores
 * @author Carlos Maximiliano Ortiz Escobar
 * @author Luis Fernando Herrera Pimentel
 * @Verision 1.1
 */

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom.Document;         // |
import org.jdom.Element;          // |\ Librerías
import org.jdom.JDOMException;    // |/ JDOM
import org.jdom.input.SAXBuilder; // |

import java.io.FileWriter;			// |
import org.jdom.Attribute;			// |\ Libreria Escritura
import org.jdom.output.Format;		// |/ JDOM
import org.jdom.output.XMLOutputter;// |

class XmlReadWrite {
	
	public static String FileName = "";
	
	//Constructor Principal
	public XmlReadWrite(){}
	
	//Constructor para la inicializacion del nombre de archivo
	public XmlReadWrite(String fileName){
		FileName = fileName;
	}
	
	/**
	 * Carga el nombre del archivo
	 * @param Name String con el nombre del archivo XML
	 */
	public void setFileName(String Name){
		FileName = Name;
	}
	/**
	 * Redimensiona el arreglo de objetos incrementandolo en uno
	 * @return Nuevo arreglo de objetos con los datos leidos y redimensionado
	 */
	public static Persona [] reallocPersona(int i){
		
		int nUsers = getUsers();
		Persona Send [] = new Persona[nUsers + i];
		startArray(Send);
		readXml(Send);
		return Send;
	} 
	
	/**
	 * Inicializa el arreglo de objetos que se redimensiono
	 * 
	 * @param Obj Arreglo que se esta redimensionando "Es automatico"
	 */
	private static void startArray(Persona [] Obj){
		
		for(int i = 0; i < Obj.length; i++)
			Obj[i] = new Persona();
	}
	
	/**
	 * 
	 * Funcion encargada de la lectura de los archivos Xml
	 * de maneja atraves del esquema
	 * 
	 * @param Data Arreglo de objetos en el cual se guardaran los datos obtenidos
	 * 		Los datos son de tipo Persona Clase unica
	 */
	public static int readXml(Persona[] Data){
		
	    //Se crea un SAXBuilder para poder parsear el archivo
	    SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File(FileName);
	    try{
	    	
	        //Se crea el documento a traves del archivo
	        Document document = (Document) builder.build( xmlFile );
	 
	        //Se obtiene la raiz 'tables'
	        Element rootNode = document.getRootElement();
	 
	        //Se obtiene la lista de hijos de la raiz 'tables'
	        List list = rootNode.getChildren( "tabla" );
	 
	        //Se recorre la lista de hijos de 'tables'
	        for ( int i = 0; i < list.size(); i++ ){
	        		
	            //Se obtiene el elemento 'tabla'
	            Element tabla = (Element) list.get(i);
	 
	            //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
	            String nombreTabla = tabla.getAttributeValue("nombre");
	 
	            //Se obtiene la lista de hijos del tag 'tabla'
	            List lista_campos = tabla.getChildren();
	 
	            //Se recorre la lista de campos
	            for ( int j = 0; j < lista_campos.size(); j++ ){
	            	
	                //Se obtiene el elemento 'campo'
	                Element usuario = (Element)lista_campos.get( j );
	              
	                Data[j].id = Integer.parseInt(usuario.getChildTextTrim("id").trim());
	                Data[j].Status = Integer.parseInt(usuario.getChildTextTrim("status").trim());
	                Data[j].Name = usuario.getChildTextTrim("nombre");
	                Data[j].Age = Integer.parseInt(usuario.getChildTextTrim("edad").trim());
	                Data[j].Sex = usuario.getChildTextTrim("sexo").charAt(0);
	                Data[j].Team = usuario.getChildTextTrim("equipo");
	                Data[j].Sport = usuario.getChildTextTrim("deporte");
	                Data[j].Training = Float.parseFloat(usuario.getChildTextTrim("entrenamiento").trim());
	              
	            }
	        }
	    }catch ( IOException io ) {
	        System.out.println("HOla" +  io.getMessage() );
	        return 1;
	    }catch ( JDOMException jdomex ) {
	        System.out.println( jdomex.getMessage() );
	        return 1;
	    }
		return 0;
	}

	/**
	 * Metodo que obtiene el tamagnio de los hijos de la tabla
	 * @return Valor entero positivo, Numero de usuarios registrados en el archivo Xml
	 */
	public static int getUsers(){
		
		int NumberOfUsers = -1;
	    SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File(FileName);//Cambiar por archivo propio :c
	    try
	    {
	        Document document = (Document) builder.build( xmlFile );
	        Element rootNode = document.getRootElement();
	        List list = rootNode.getChildren( "tabla" );
	
	        for ( int i = 0; i < list.size(); i++ )
	        {   		
	            Element tabla = (Element) list.get(i);
	            String nombreTabla = tabla.getAttributeValue("nombre");
	            List lista_campos = tabla.getChildren();
	 
	            NumberOfUsers = lista_campos.size();//Asigna el numero de Usuarios
	        }
	    }catch ( IOException io ) {
	        System.out.println( io.getMessage() );
	        System.out.println( "Archivo no encontrado, Se procedio a crear un nuevo archivo" );
	        makeXml();
	        return -1;
	    }catch ( JDOMException jdomex ) {
	        System.out.println( jdomex.getMessage() );
	        System.out.println( "Archivo no encontrado, Se procedio a crear un nuevo archivo" );
	        makeXml();
	        return -1;
	    }
	    return NumberOfUsers;
	}
	
	/**
	 * Metodo que realiza la escritura conel formato anteriormente especificado en Xml
	 * @param Data Arreglo de Personas, Recibe el arreglo a escribir
	 */
	 public static void writeXml(Persona [] Data) {
		 
	      try {
	 
	        Element tables = new Element("tables");
	        Document doc = new Document(tables);
	        doc.setRootElement(tables);
	 
	        Element tabla = new Element("tabla");
	        tabla.setAttribute(new Attribute("nombre", "Datos"));
	        	
	        	int Size = Data.length;
	        	System.out.println(Size);
		        for(int j = 0; j < Size; j++){
		        	
		        	Element usuarios = new Element("usuario");
		        	
		        	usuarios.addContent(new Element("id").setText(Integer.toString(Data[j].id)));
		        	usuarios.addContent(new Element("status").setText(Integer.toString(Data[j].Status)));
			        usuarios.addContent(new Element("nombre").setText(Data[j].Name));
			        usuarios.addContent(new Element("edad").setText(Integer.toString(Data[j].Age)));
			        String Buff = "";
			        usuarios.addContent(new Element("sexo").setText(Buff + Data[j].Sex));
			        usuarios.addContent(new Element("equipo").setText(Data[j].Team));
			        usuarios.addContent(new Element("deporte").setText(Data[j].Sport));
			        usuarios.addContent(new Element("entrenamiento").setText(Double.toHexString(Data[j].Training)));
			        
			        tabla.addContent(usuarios);
		        }
		    tables.addContent(tabla);	    
	        
	        // new XMLOutputter().output(doc, System.out);
	        XMLOutputter xmlOutput = new XMLOutputter();
	 
	        // display nice nice
	        xmlOutput.setFormat(Format.getPrettyFormat());
	        xmlOutput.output(doc, new FileWriter(FileName));
	 
	        System.out.println("File Saved!");
	      } catch (IOException io) {
	        System.out.println(io.getMessage());
	      }
	    }
	 
	 /**
	  * Crea el esquema para la lectrua del archiv desde Cero en caso de no existir :c
	  */
	 public static void makeXml() {
		 
	      try {
	 
	        Element tables = new Element("tables");
	        Document doc = new Document(tables);
	        doc.setRootElement(tables);
	 
	        Element tabla = new Element("tabla");
	        tabla.setAttribute(new Attribute("nombre", "Datos"));
		    tables.addContent(tabla);	    
	        
	        // new XMLOutputter().output(doc, System.out);
	        XMLOutputter xmlOutput = new XMLOutputter();
	 
	        // display nice nice
	        xmlOutput.setFormat(Format.getPrettyFormat());
	        xmlOutput.output(doc, new FileWriter(FileName));
	 
	        System.out.println("File Saved!");
	      } catch (IOException io) {
	        System.out.println(io.getMessage());
	      }
	    }
}
