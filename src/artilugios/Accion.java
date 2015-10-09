package artilugios;

/**
*Simplificaciones de acciones recurrentes
*write = System.out.println 
*@author Elihu Alejandro Cruz Albores
*@version 1.0
*/

public class Accion {
	boolean Go = true;
	//private int Entrada;
	Read lectura = new Read();

	public Accion(){
		Go = true;
	}

	public void MenuPrint(String Funciones){//Recibe como parametro un String con el nombre de las
											//opciones del menu separado por "/" MenuPrint("Opcion1/Opcion2");

		String Buffer[] = Funciones.split("/");
		
		write("---------------Menu---------------");
		write("Opciones//");

		for(int i = 1; i <=  Buffer.length; i++){
			System.out.println(i + ".- " + Buffer[i-1]);
		}
	}

	public void write(String Mensaje){System.out.println(Mensaje);}//Recibe una cadena "no se puede concatenar"

	public void Clear(){
		for(int i = 0; i < 37; i++)
			System.out.println();
	
	}

	public final static void clearConsole()	{//No es mia :c

	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
}
