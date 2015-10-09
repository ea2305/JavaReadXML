package xml;

/**
 * @author Elihu Alejandro Cruz Albores
 * @author Carlos Maximiliano Ortiz Escobar
 * @author Luis Fernando Herrera Pimentel
 * @Verision 1.1
 */

import artilugios.*;

public class MenuName{
	
	static Read read = new Read();
	
	public static void Configuraciones(){
		
		
		int salir = 0;
	    do{
	        System.out.println("---------------------------------");
		    System.out.println("     ¿Que Desea configurar?");
		    System.out.println("---------------------------------");
		    System.out.println("   1.- Ingresar nombre del archivo");
		    System.out.println("---------------------------------");
		    System.out.println("   2.- Mostrar el archivo actual");
		    System.out.println("---------------------------------");
		    System.out.println("   3.- retorna el nombre del archivo");
		    System.out.println("---------------------------------");
		    System.out.println("   4.- Salir");
		    System.out.println("---------------------------------");
		    System.out.println("   Ingrese la opcion deseada");
		    int p1 = read.getIntf();
		    switch (p1){
		        case 1 :
		           setName();
		           break;
		            
		        case 2:
		         	showName();
		          	break;
		         
		        case 3 :
		         	seeName();
		            break;
		             
		        case 4 :
		             salir = 4;
		             break;
		    }
	      
	   }while (salir != 4);
	    
	}
	public static void setName(){
		
		System.out.println("Introduzca el nuevo nombre del xml");
		String name = read.onlyString();
		AnalizaFile af=new AnalizaFile("name.txt");
		af.writeName(name);
	}

	public static void showName(){
		AnalizaFile af=new AnalizaFile("name.txt");
		String name=af.getFirstLine();
		System.out.println("El nombre que tiene para buscar el xml es : "+ name);
	}
	
	public static String seeName(){
		AnalizaFile af=new AnalizaFile("name.txt");
		String name=af.getFirstLine();
		if(name.equals("ERROR, especificar un nombre de archivo"))
			return "Archivo no Existe";
		return name;
	}
}