package xml;

/**
 * @author Elihu Alejandro Cruz Albores
 * @author Carlos Maximiliano Ortiz Escobar
 * @author Luis Fernando Herrera Pimentel
 * @Verision 1.1
 */
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import artilugios.*;

public class Menuedicion {
	
	String FileName = "";
	
	MenuName Archivo = new MenuName();
    Persona [] n = new Persona[1];
    Read read = new Read();
    XmlReadWrite k = new XmlReadWrite();
    
    /**
     * Menu Principal del programa
     * @param No recive parametros    
     */
    public void menu(){
    	
    	if(!(MenuName.seeName().equals("Archivo no Existe"))){
    		int salir = 0;
	            do{
	            	
	    	    	k.setFileName(MenuName.seeName());
	            	
	                System.out.println("---------------------------------");
	                System.out.println("     ¿Que Desea Usted Hacer?");
	                System.out.println("---------------------------------");
	                System.out.println("   1.- Ingresar un nuevo usuario");
	                System.out.println("---------------------------------");
	                System.out.println("   2.- Modificar un usuario");
	                System.out.println("---------------------------------");
	                System.out.println("   3.- Borrar un usuario");
	                System.out.println("---------------------------------");
	                System.out.println("   4.- Mostrar Creditos");
	                System.out.println("---------------------------------");
	                System.out.println("   5.- Menu Configuraciones");
	                System.out.println("---------------------------------");
	                System.out.println("   6.- Mostrar Listado de usuarios");
	                System.out.println("---------------------------------");
	                System.out.println("   7.- Salir");
	                System.out.println("---------------------------------");
	                System.out.println("   Ingrese la opcion deseada");
	                int p = read.getInt();
	            switch (p){
	            
	                case 1 :
	                    agregarUsuario();
	                    break;	                    
	                case 2:
	                    editaUsuario();
	                    break;
	                case 3 :
	                    borraUsuario();
	                    break;
	                case 4:
	                	creditos();
	                	break;
	                case 5:
	                	MenuName.Configuraciones();
	                	break;
	                case 6:
	                	Listado();
	                	break;
	                case 7 :
	                     salir = 4;
	                     break;
	                     
	            }
	        }while (salir != 4);
    	}
    }
    
    /**
     * Metodo que agrega a los usuarios usando los datos obtenidos del arreglo de Objetos
     * @param No recive valores
     */
    public void agregarUsuario(){
    	
    		
    		if(XmlReadWrite.getUsers() == 0){
    			n = XmlReadWrite.reallocPersona(1);
    			n[0] = ingresadatitos(0,0);
            	n[0].id = (XmlReadWrite.getUsers() + 1);
            	
    		}else{
    			n = XmlReadWrite.reallocPersona(1);
    			n[n.length -1] = ingresadatitos(0,0);
            	n[n.length -1].id = (XmlReadWrite.getUsers() + 1);	
    		}
        	XmlReadWrite.writeXml(n);
    }
    
    /**
     * Metodo para la recepcion de datos del usuario
     * @param i Valor entero positivo que indica la posicion para copiar la id de un usuario especifico
     * @param u Modalidad de entrada 1.- Activa la funcion de copiado de id, !1.- desactiva el copiado
     * @return Objeto de personas con datos cargados
     */
    private Persona ingresadatitos(int i,int u){
        Persona  l = new Persona();
        Scanner a = new Scanner(System.in);
        Teclado c = new Teclado();

        System.out.println("    Ingrese el Nombre del Nuevo Usuario: ");
        l.Name = read.onlyString();
        System.out.println("    Ingrese la edad               ");
        l.Age = read.getIntf();
        System.out.println("    Ingrese el sexo del usuario   ");
        System.out.println("    Ingrese un Caracter M = Masculino, F = Femenino:  ");
        l.Sex = c.LecturaChar();
        System.out.println("    Ingrese el Tiempo de Entrenamiento del usuario en horas:  ");
        l.Training = read.getFloatf();
        System.out.println("    Ingrese el Equipo del cual forma parte el usuario");
        l.Team = read.onlyString();
        System.out.println("    Ingrese el deporte el cual practica el usuario");
        l.Sport = read.onlyString();
        if(u == 1)
        	l.id = n[i].id;
        l.Status = 1;
        
        return l;   
    }
    
    /**
     * Metodo para la edicion de los datos del usuario 
     * @ No recive Parametros
     */
    public void editaUsuario(){

        n = XmlReadWrite.reallocPersona(0);
        System.out.println("    Ingrese el ID del usuario que desea editar");
        int busca = read.getIntf();
        if(busca > 0 && busca <= XmlReadWrite.getUsers()){
        	
        	for (int y = 0;y<n.length;y++){
            	
                if (n[y].id == busca){
                	
                	n[y] = ingresadatitos(y,1);
                }
            }
             XmlReadWrite.writeXml(n);
        }else{
        	System.out.println("Usuario no Registrado Verifique su Opcion");
        }
    }
    
    /**
     * Metodo para la modificacion de estatus del usuario, 1 =  Activo, 2 = Desactivo
     * @param No recive Valores
     */
    public void borraUsuario(){
        n = XmlReadWrite.reallocPersona(0);
        
        System.out.println("    Ingrese el ID del usuario que desea borrar");
        int busca = read.getIntf();
        
        if(busca > 0 && busca <= XmlReadWrite.getUsers()){
        	
            for (int y = 0;y<n.length;y++){
            	
                if (n[y].id == busca){
                	
                	n[y].Status = 0; 
                }
            }
             XmlReadWrite.writeXml(n);
        }
        
    }
    
    /**
     * Imprime los creditos de los integrantes en base a el archivo "creditos.txt"
     */
	public static void creditos() {

		try {

			String buffer = new String("");
	  		File file = new File("creditos.txt");
	  		FileReader fileReader = new FileReader(file);
	  		BufferedReader bufferReader = new BufferedReader(fileReader);
	  		
	  		while (bufferReader.ready())
	  			buffer = buffer + bufferReader.readLine() + "\n";

	  		System.out.println(buffer);

	  	} catch (IOException exception) {

	  		System.out.println("No se encontro el archivo");
	  	}
	}   
    
	/**
	 * Impirme el listado de Usuarios registrados
	 * @param NO recive valores
	 */
	private void Listado(){
		int t  = XmlReadWrite.getUsers();
		int index = 1;
		n = XmlReadWrite.reallocPersona(0);
		
		for (int i = 0 ; i < t; i++){
			if(n[i].Status != 0){
				
				System.out.println("Usuario " + (index)+ " Datos :");
				System.out.println("Nombre        : " + n[i].Name);
				System.out.println("Edad          : " + n[i].Age);
				System.out.println("Sexo          : " + n[i].Sex);
				System.out.println("Deporte       : " + n[i].Sport);
				System.out.println("Equipo        : " + n[i].Team);
				System.out.println("Entrenamiento : " + n[i].Training);
				System.out.println("ID            : " + n[i].id);
				System.out.println("Estado        : " + n[i].Status);
				System.out.println("\n-----------------------------------------------\n");
				index++;
			}
		}
	}
}

