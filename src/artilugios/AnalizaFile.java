package artilugios;

/**
* Clase para la creacion de string con los datos de un archivo
* Obteniendolos con la clase "getLines" y almacenada en el string:
* BufferString, para su posterior uso.
* Creadores::
* @ Elihu Alejandro Cruz Albores
* @ Luis Fernando Herrera Pimentel
* @ Carlos Maximiliano Ortiz Escobark
* @Version 1.0
*/

import java.io.*;
/**
* Clase para la creacion de string con los datos de un archivo
* Obteniendolos con la clase "getLines" y almacenada en el string:
* BufferString, para su posterior uso.
* Creadores::
* @author Elihu Alejandro Cruz Albores
* @author Luis Fernando Herrera Pimentel
* @author Carlos Maximiliano Ortiz Escobar
* @version 1.2
*/

public class AnalizaFile{
	
	String NAME_FILE = "";

	int Number_lines = 0;//Obtine el numero de lineas del archivo,
						 // una vez llamada la funcion getLines.

	String Buffer = "";//Buffer de la lectura de el archivo Memoria Volatil :c
	String BufferString = "";// Cadena que contiene los datos del archivo, 
							 // en un String separado por saltos de linea '\n'
	//String BUfferAsunder [];//Aqui se almacenan los datos ya divididos 

	File Archivo = null;//Variable para la apertura del archivo
	FileReader Frd = null;

	public AnalizaFile(){}

	public AnalizaFile(String NAME_STR){//Contructor que recibe el nombre del archivo

		NAME_FILE = NAME_STR;
	}

/**
*@param Ningun valor
*@return un valor entero
*/
	public int getLines(){//Realiza la lectura de el archivo y obtiene una cadena de los datos 
						  //Separados por \n , es llamado para obtener los datos.
		
		OpenFile();
		return Number_lines ;
	}
/**
*@param Ningun valor
*/
	public void OpenFile(){//Apertura y cierre de archivo. Sub-funcion, brindar el numero de lineas

		try{
			Archivo = new File(NAME_FILE);
			Frd = new FileReader(Archivo);
			BufferedReader Brd = new BufferedReader(Frd);
			
			while(((Buffer = Brd.readLine()) != null)){

				BufferString = BufferString + Buffer + "\n";
				this.Number_lines++;
			}	

			
		}catch(IOException fnot){//En caso de un Error "El archivo no existe" 
			
			System.out.println("Error: archivo no encontrado");
			try{ Frd.close();}
			catch(Exception clse){}
			this.Number_lines = -1;
		}

		try{Frd.close();}
		catch(Exception clse1){}
	}

/**
*@param Ningun valor
*@return Cadena de caracters de la primer linea
*/
	public String getFirstLine(){//Obtiene la primer linea de un archivo

		Number_lines=getLines();

		if(Number_lines==-1) return "ERROR, especificar un nombre de archivo";
	
		String BUfferAsunder []=BufferString.split("\n");

		return BUfferAsunder[0];

	}
/**
*@param Ningun valor
*@return Cadena de caracters de la ultima linea
*/
	public String getLastLine(){//Obtiene la ultima linea de un archivo

		Number_lines=getLines();

		if(Number_lines==-1) return "ERROR, especificar un nombre de archivo";
	
		String BUfferAsunder []=BufferString.split("\n");

		return BUfferAsunder[Number_lines-1];

	}

/**
*@param Ningun valor
*@return Cadena con los nombres de los autores
*/
	public String creditos(){
		String datos = "Elihu Alejandro Cruz Albores #143405\nLuis Fernando Herrera Pimentel #1443402 \nCarlos Maximiliano Ortiz Escobar #143406 \nFecha 30/05/2015 \nAsignatura P.O.O\nProfesor Dr. Juan Carlos Lopez Pimentel\ncorte 1\nUniversidad Politecnica de Chiapas\n";
		return datos;
	}

/**
*@param Cadena de caracteres que contiene el nombre del archivo
*/
	public void setFileName(String nFile){//Contructor que recibe el nombre del archivo

		NAME_FILE = nFile;
	}
	
/**
* @param Dato entero indicando posicion
* @return String con datos 
*/
	public String getAnyLine(int N){//Obtiene la primer linea de un archivo

		Number_lines=getLines();

		if(Number_lines==-1) return "ERROR, especificar un nombre de archivo";
	
		String BUfferAsunder []=BufferString.split("\n");

		return BUfferAsunder[N];

	}

 
	
	    public void writeName(String put)
	    {
	        FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(NAME_FILE);
	            pw = new PrintWriter(fichero);
	 
	          
	                pw.println(put);
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	    }
	}
