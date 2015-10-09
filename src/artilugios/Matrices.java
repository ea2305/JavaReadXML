package artilugios;

/**
*Clase para manejo de acciones con matricez y vectores
*En construccion
*@author Elihu Alejandro Cruz Albores
*@version 1.0
*/

public class Matrices{
	Read lectura = new Read();
	int x = 0; //Filas
	int y = 0; //Columnas
	int x2 = 0;
	int y2 = 0;

	public Matrices(){}//Constructor por defecto

	public Matrices(int f, int c){//inicializacion de longitudes.
		this.x = f;
		this.y = c;
	}

/**
*@param Recive un arreglo bidimensional de tipo float
*		Los valores se pasan por referencia
*/
	public void inMatrix(float[][] A){//Carga una matriz bidimensional

		System.out.println("Introduzca los datos de la matriz:\n");

		for(int i = 0; i < A.length ; i++){//COLUMNAS
			for(int u = 0; u < A[0].length ; u++){//FILAS

				System.out.print("a" + (i+1) + (u+1));
				A[i][u] = lectura.getFloatf();
			}
			System.out.println();
		}
	}

/**
*@param No recive parametros de entrada
*/
	public void FilasYColumnas(boolean select){//Añade la informacion necesaria para la realizaion de procesos.

		if(select){
			System.out.print("Numero de Filas ");		
			this.x = lectura.getIntf();
			System.out.print("Numero de comlumnas ");
			this.y = lectura.getIntf();
			System.out.println();
		}

		else{
			System.out.print("Numero de Filas ");		
			this.x2 = lectura.getIntf();
			System.out.print("Numero de comlumnas ");
			this.y2 = lectura.getIntf();
			System.out.println();
		}
	}

	public void RestarSize(boolean select){

		if(select){
			this.x = 0;
			this.y = 0;
		}
		else{
			this.x2 = 0;
			this.y2 = 0;
		}
	}

/**
*@param Recive un arreglo bidimensional de tipo flotante
* 		Imprime los parametros recividos si decimal
*/
	public void PrintMatrixInt(float A[][]){//Impresion de matriz sin decimales

		for(int i = 0; i < A.length; i++){//COLUMNAS
			for(int u = 0; u < A[0].length ; u++){//FILAS
				System.out.printf("%.0f ",A[i][u]);
			}
			System.out.println();
		}
	}

/**
*@param Recive un arreglo bidimensional de tipo flotante
* 		Imprime los parametros recividos con decimales
*/
	public void PrintMatrixFloat(float A[][]){//Impresion de matriz sin decimales

		for(int i = 0; i < A.length ; i++){//COLUMNAS
			for(int u = 0; u < A[0].length ; u++){//FILAS
				System.out.printf("%.2f\t",A[i][u]);
			}
			System.out.println();
		}
	}

	public void PrintVectorFloat(float A[]){
		for(int i = 0; i < A.length; i++)
			System.out.print(" " + A[i] + " " );

		System.out.println("");
	}

	public void PrintVectorInt(float A[]){
		for(int i = 0; i < A.length; i++)
			System.out.printf(" %.2f ",A[i]);

		System.out.println("");
	}
/**
*@param Recive tres arreglos de tipo flotante
* 		Los parametros A y B para operaciones y C resultado
*@return valor booleano
*/
	public boolean MatrixAdd(float A[][], float B[][], float C[][]){//Suma de matrices

		if(A.length == B.length && A[0].length == B[0].length){
			for(int i = 0; i < A.length ; i++){//COLUMNAS
				for(int u = 0; u < A[0].length ; u++){//FILAS

					C[i][u] = A[i][u] + B[i][u];
				}
			}		
			return true;
		}
		else{
			System.out.println("EL tamaño de las matrices no coinciden");
			return false;
		}

	}

/**
*@param Recive tres arreglos de tipo flotante
* 		Los parametros A y B para operaciones y C resultado
*@return valor booleano
*/
	public boolean MatrixSub(float A[][], float B[][], float C[][]){//Resta de matrices

		if(A.length == B.length && A[0].length == B[0].length){
			for(int i = 0; i < A.length ; i++){//COLUMNAS
				for(int u = 0; u < A[0].length ; u++){//FILAS

					C[i][u] = A[i][u] - B[i][u];
				}
			}	
			return true;	
		}
		else{
			System.out.println("EL tamaño de las matrices no coinciden");
			return false;
		}

	}

/**
*@param Recive tres arreglos de tipo flotante
* 		Los parametros A y B para operaciones y C resultado
*@return valor booleano
*/
	public boolean MatrixMult(float A[][], float B[][], float C[][]){//Multiplicacion de Matrices

		if(A.length == B[0].length){
			for(int i = 0; i < A.length ; i++){//COLUMNAS
				for(int c = 0; c < A.length; c++){//Posicion Multiplicacion
					for(int u = 0; u < A[0].length ; u++){//FILAS

						C[i][c] = (A[i][u] * B[u][i]) + C[i][c];
					}
				}
			}
			return true;
		}
		else{
			System.out.println("El Numero de filas de A no coinciden con las Columnas de B no coinciden");
			return false;
		}
	}

/**
*@param Recive un arreglo de tipo flotante	 para ser limpiado 
*/
	public void CleanMatrix(float A[][]){//Elimina los datos de una matriz

		for(int i = 0; i < A.length ; i++){//COLUMNAS
			for(int u = 0; u < A[0].length ; u++){//FILAS
				A[i][u] = 0;
			}
		}
	}

/**
*@param Arreglo de datos flotantes
*@param Entero dando posicion de filas > 1
*@param Entero dando posicion de columnas > 1
*/
	public void Paso1Gauss(float A[][],int fila,int columna){

		float divGauss = 0;		//Buffer para divisores
		float div = A[columna][fila];

		for(int index = 0; index < A[0].length; index++){//Igualacion de Fila a 1
			A[columna][index] = A[columna][index] / div;
		}

		for(int count = 0; count < A.length ; count++){//Eliminacion de Columna dada
			
			divGauss = A[count][fila] * -1;

			for(int count2 = 0; count2 < A[0].length ; count2++){
				if(count != columna)
					A[count][count2] = (A[columna][count2] * divGauss) + A[count][count2];			
			}
			divGauss = 0;
		}
	}

	public void Paso2Gauss(float A[][],int fila,int columna){

		float divGauss = 0;		//Buffer para divisores

		for(int count = 0; count < A.length ; count++){//Eliminacion de Columna dada
			
			divGauss = A[count][fila] * -1;

			for(int count2 = 0; count2 < A[0].length ; count2++){
				if(count != columna)
					A[count][count2] = (A[columna][count2] * divGauss) + A[count][count2];			
			}
			divGauss = 0;
		}
	}

/**
*Resolucion de sistema Matricial con metodo de Gauss Jordan
*@param Arreglo de flotantes A
*/

	public void GaussJordan(float A[][]){

		inMatrix(A);
		int ySize = A.length;
		int xSize = A[0].length;

		System.out.println("x " + xSize + " y " +ySize);

		if(ySize >= xSize)
			System.out.println("Sistema inconsistente");
		else{
			for(int i = 0; i < ySize ; i++){//La cuenta empieza de 1 para PASO1GAUSS
				Paso1Gauss(A,i,i);
				Paso2Gauss(A,i,i);
			}
		}
	}
}