package artilugios;

public class Numero{

	int A = 0;

	public Numero(){}

	public Numero(int n){
		this.A = n;
	}

/**
*@param Numero entero positivo
*@return valor boolean,
*/
	
	public boolean esPrimo(int n){

		if(esPositivo(n)){

			if(n%2 == 0 && n != 2 || n < 2) return false;
			if(n == 2) return true;

			for(int i = 2; i < Math.sqrt(n) + 1; i++){
				if(n%i == 0) return false;
			}
			return true;
		}else{
			return false;
		}
	}

	public boolean esPositivo(int n){
		boolean send;
		return send = (n >= 0) ? true:false;
	}
}