package artilugios;

/**
*Lectuar y validacion de datos enteros y flotantes
*La lectura de datos proviene de la libreria Teclado
*Equivalente:: Scanner 
*@author Elihu Alejandro Cruz Albores
*@version 1.2
*/

public class Read{
	
	Teclado Aread;
	String type;
	int sendInt = 0;
	float sendFlt = 0;

	public Read(){//Constructor por Deafault 
		Aread  = new Teclado();
		type = null;
		sendInt = 0;
		sendFlt = 0;
	}

/**
*@param No recive Parametros
*@return Devuelve una cadena de caracteres TypeTo
*		 Despliega una leyenda "Introduzca un numero"
*/
	public String getString(){
		String typeTo = null;
		System.out.println("Introduzca un numero: \n");
		typeTo = Aread.getStr();
		return typeTo;
	}

/**
*@param No recive Parametros 
*@return Devuelve una cadena de caracteres TypeTo
*		 La impresion esta separada unica mente de :
*/
	public String getStrf(){
		String typeTo = null;
		System.out.print(": ");
		typeTo = Aread.getStr();
		return typeTo;
	}

/**
*@param No recive Parametros 
*@return Returna una cadena simple
*		 La cadena despliega un menu para datos
*/
	public String onlyString(){
		String typeTo = null;
		System.out.println("Insertar datos: \n");
		typeTo = Aread.getStr();
		return typeTo;
	}

/**
*@param No recive Parametros 
*@return Valor entero validado
*		 Impresion de leyenda 
*/
	public int getInt(){//Lectura validada para enteros //Integer
		String type = getString();
		return sendInt = (ScanNumber(type)) ? Integer.parseInt(type.trim()) : getInt();	
	}

/**
*@param No recive Parametros 
*@return Valor entero validado
*		 Despliega dos puntos, impresion simple
*/
	public int getIntf(){//Lectura validada para enteros //Integer
		String type = getStrf();
		return sendInt = (ScanNumber(type)) ? Integer.parseInt(type.trim()) : getIntf();	
	}

/**
*@param No recive Parametros 
*@return Un valor flotante 
*		 Despliega una leyenda 
*/
	public float getFloat(){//Lectura validada para enteros //Float
		String type = getString();
		return sendFlt = (ScanNumber(type)) ? Float.parseFloat(type.trim()) : getFloat();	
	}

/**
*@param No recive Parametros 
*@return Un valor flotante 
* 		 Despliega dos puntos, impresion simple, sin saltos de linea
*/
	public float getFloatf(){//Lectura validada para enteros //Float para matrices 

		String type = getStrf(); //Get String Formated
		return sendFlt = (ScanNumber(type)) ? Float.parseFloat(type.trim()) : getFloatf();	
	}

/**
*@param No recive Parametros 
*@return Un valor Booleano 
*		 Devueve un valor verdadero si la validacion es exitosa
*/
	public boolean ScanNumber(String cadena){
		try {
			if(cadena.trim().isEmpty())return false;
			
			Integer.parseInt(cadena.trim());
			return true;
		} catch (NumberFormatException e){
			boolean a = false;			
			return a = (rescueString(cadena))?true:false;
		}
	}

/**
*@param No recive Parametros 
*@return Valor booleano para validacion
*		 Devuelve un valor Positivo si es float
*		 Recata la cadena en caso de que incluya un punto
*		 Verifica que la cadena escaneada sea un dato float.
*/
	public boolean rescueString(String Solve){
		String rescue = Solve.trim();
		boolean simbols = false, correctD = false;

		for(int i = 0; i < rescue.length(); i++){

			if(((rescue.charAt(i) == '+') || (rescue.charAt(i) == '-')) && (i != 0)) return false;
				
			else{
				if((rescue.charAt(i) == '.') && (correctD == false)){correctD = true;}	

				else{
					if((rescue.charAt(i) == '.') && (correctD == true)){return false;}
							
					if(!(TypeCorrect(rescue.charAt(i)))){return false;}
						
				}
			}
		}
	
	return true;
}

/**
*@param No recive Parametros 
*@return Devuelve un valor booleano
*		 Retorna un valor positivo si se localiza el valor
*		 En el array.
*/
	public boolean TypeCorrect(char ok){
		String Check = "+-0123456789";
		boolean Go = false;
		for(int x=0;x<12;x++){

			if(ok == Check.charAt(x)){
				Go=true;
			}
				
		}
		return Go;
	}
}