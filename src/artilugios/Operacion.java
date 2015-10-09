package artilugios;

public class Operacion{

	Read Datos = new Read();
	int a;
	float b;

	public Operacion(){
		 a = 0;
		 b = 0;
	}

	public int  Suma_Entero(int x, int y){
		return (x + y);
	}

	public float Suma_Flotante(float x, float y){
		return (x + y);
	}

	public int Resta_Entero(int x, int y){//Resta el segundo valor del primero
		return (x - y);
	}

	public float Resta_Flotante(float x, float y){
		return (x - y);
	}

	public int Multiplicacion_int(int x, int y){
		return (x * y);
	}

	public float Multiplicacion_float(float x, float y){
		return (x * y);
	}

	public float Division_int(int x, int y){//Divide el primer elemento por el segundo, en caso de error retorna 0
		return a = (x > y) ? (x / y): 0;
	}

	public float Division_float(float x, float y){//Divide el primer elemento por el segundo, en caso de error retorna 0
		return b = (x > y) ? (x / y): 0;
	}

	public int Pontencia_int(int x, int y){ //Recibe un numero entero, y calcula su potencia hasta el segundo numero dado;
		if (x == 0 || x == 1) return x;
		else{
			for(int i = 0 ; i < y-1 ; i++ ){
				a = (x * x) + a;
			} 
		}
		return a;
	}

	public float Pontencia_int(float x, float y){//Recibe un numero floatante, y calcula su potencia hasta el segundo numero dado;
		if (x == 0 || x == 1) return x;
		else{
			for(int i = 0 ; i < y-1 ; i++ ){
				b = (x * x) + b;
			} 
		}
		return b;
	}


}