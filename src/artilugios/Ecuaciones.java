package artilugios;

/**
* Clase para el manejo de datos en una ecuacion
* @author Elihu Alejandro Cruz Albores
* @version 1.0
*/

public class Ecuaciones{
	
	int Variable = 0;	//Indica el numero de variables a utilizar en todo el algoritmo
	int Rtr      = 0; 	//Indica el numero de restricciones a utiizar para el algoritmo
	
	public int cSize = 0;	//Buffer del numero de columnas para las restricciones
	public int fSize = 0;	//Buffer del numero de filas para las restriccions
	
	float [] Var = new float[1];//Array Z
	float [] b   = new float[1];//Array b
	float [][] VarRestric = new float[1][1];//Array restricciones

	Read read = new Read();						//Entrada de datos
	Redimensiona sizeUp = new Redimensiona();	//Modificar Arrays
	Matrices M = new Matrices();				//Metodos con matrices y vectores

	public Ecuaciones(){}//Constructor

	/**
	 * @param No recive parametros
	 */
	public void Variables(){
		boolean Type = true;
		
		System.out.println("||	Variables:                      ||");
		System.out.println("||  Cantidad de variables:              ||");
		while(Type){
			this.Variable = read.getInt();
			
			if(this.Variable >= 0)
				Type = false;
			else
				System.out.println("Intruduzca un valor positivo mayor a 1");
		}
	}
	
	public void variableRestart(){
		this.Variable = 0;
		this.Rtr      = 0;
		this.cSize = 0;
		this.fSize = 0;
		
		sizeUp.reallocFloatArray(Var, 1);
			Var[0] = 0;
			
		sizeUp.reallocFloatArray(b, 1);
			b[0] = 0;
			
		sizeUp.reallocFloatBidimentionArray(VarRestric, 1, 1);
			VarRestric[0][0] = 0;
	}

	/**
	 * @param No recive parametros
	 */
	public void Restricciones(){
		boolean Type = true;
		
		System.out.println("||  Restricciones:                      ||");
		System.out.println("||  Cantidad de restricciones:          ||");
		while(Type){
			this.Rtr = read.getInt();
			
			if(this.Rtr >= 0)
				Type = false;
			else
				System.out.println("Intruduzca un valor positivo");
		}
	}

	/**
	 * @param Recibe un booleano para determinar si el numero de variables ya fue establecido
	 */
	public void getZEquation(boolean Access){
		
		System.out.println("|| Funcion Objetivo (Z)                 ||");
		if(!Access)
			Variables();
		Var = sizeUp.reallocFloatArray(Var,Variable);
		for(int i = 0; i < Var.length; i++){
			System.out.print("X" + (i + 1));
			Var[i] = read.getIntf();
		}
	}
	
	/**
	 * @param Recibe un booleano para determinar si el numero de restricciones ya fue establecido
	 */
	public void getbEquation(boolean ok){
		System.out.println("|| Vector b (Resultado restricciones) (b)||");
		if(!ok)
			Variables();
		
		b = sizeUp.reallocFloatArray(b,this.Rtr);//Redimension para Arreglo bidimencional
		
		for(int i = 0; i < b.length; i++){
			System.out.print("S" + (i + 1));
			b[i] = read.getIntf();
		}
			
	}
	
	/**
	 * @param Recibe dos datos booleanos para determinar si el numero de variables y restricciones fue establecido
	 */
	public void Restric(boolean Access,boolean RAccess){
		
		if(!RAccess)
			Restricciones();
		
		if(!Access)
			Variables();

		VarRestric = sizeUp.reallocFloatBidimentionArray(VarRestric,Rtr,Variable);

		for(int i = 0; i < Rtr; i++){

			System.out.println("---------------Restriccion  numero: " + (i+1));
			for(int u = 0; u < Variable; u++){
				System.out.print("X" + (u+1));
				VarRestric[i][u] = read.getFloatf();
			}
		}
	}
	
	/**
	 * Construccion de Simplex Tableu
	 * @param Recibe Arreglo bidimensional de flotantes
	 * @return Devuelve un Arreglo bidimensional para redimension de el arreglo recibido
	 */
	public float[][] ArraySimplex(float ObjectA[][]){
		
		this.cSize = VarRestric.length;
		this.fSize = VarRestric[0].length;
		
		//Redimension de array a guardar
		ObjectA = sizeUp.reallocFloatBidimentionArray(ObjectA,(cSize + 1),(cSize + fSize + 1));
		
		for(int y = 0; y < ObjectA.length; y++){	//Inicializacion de Array a cero.
			for(int x = 0; x < ObjectA[0].length; x++)
				ObjectA[y][x] = 0;
		}
		
		for(int i = 0; i < cSize; i++){				//Copiado de restricciones con su resultado
			for(int j = 0; j < fSize; j++){
				
				ObjectA[i][j] = VarRestric[i][j];
			}
			ObjectA[i][ObjectA[0].length - 1] = b[i];
		}
		
		for(int z = 0; z < cSize; z++){				//Introducir la expansion de restricciones
			for(int k = fSize; k < ObjectA[0].length; k++){
			if(k == (fSize + z))
				ObjectA[z][k] = 1;
			}
		}
		
		for(int p = 0; p < Var.length; p++){		//Introduce la funcion objetivo
			ObjectA[ObjectA.length - 1][p] = Var[p];
		}
		
		return ObjectA;
	}
	
	public void viewRestric(){
		System.out.println("Datos ingresados: ");
		M.PrintMatrixFloat(VarRestric);
		System.out.println("");
	}
	
	public void viewZ(){
		System.out.println("Datos ingresados: ");
		M.PrintVectorFloat(Var);
		System.out.println("");
	}
	
	public void viewb(){
		System.out.println("Datos ingresados: ");
		M.PrintVectorFloat(b);
		System.out.println("");
	}
	
}
