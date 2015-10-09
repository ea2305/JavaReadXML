package artilugios;

public class Redimensiona {

	/**
	 * Redimensiona un arreglo tipo Byte
	 *
	 * @param Arreglo a redimencionar 
	 *
	 * @param Tamaño a asignar
	 * 
	 * @return aux Referencia a nueva posición
	 */
	public byte [] reallocByteArray(byte [] byteArray, int newSize) {

		byte aux[] = new byte[newSize];
		int len = byteArray.length;

		if (newSize < len)
			len = newSize;

		for (int index = 0; index < len; index++)
			aux[index] = byteArray[index];

		return aux;
	}

	/**
	 * Redimensiona un arreglo tipo Short
	 *
	 * @param Arreglo a redimencionar 
	 *
	 * @param Tamaño a asignar
	 * 
	 * @return aux Referencia a nueva posición
	 */
	public short [] reallocShortArray(short [] shortArray, int newSize) {

		short aux[] = new short[newSize];
		int len = shortArray.length;

		if (newSize < len)
			len = newSize;

		for (int index = 0; index < len; index++)
			aux[index] = shortArray[index];

		return aux;
	}

	/**
	 * Redimensiona un arreglo tipo Int
	 *
	 * @param Arreglo a redimencionar 
	 *
	 * @param Tamaño a asignar
	 * 
	 * @return aux Referencia a nueva posición
	 */
	public int [] reallocIntArray(int [] intArray, int newSize) {

		int aux[] = new int[newSize];
		int len = intArray.length;

		if (newSize < len)
			len = newSize;

		for (int index = 0; index < len; index++)
			aux[index] = intArray[index];

		return aux;
	}

	/**
	 * Redimensiona un arreglo tipo Long
	 *
	 * @param Arreglo a redimencionar 
	 *
	 * @param Tamaño a asignar
	 * 
	 * @return aux Referencia a nueva posición
	 */
	public long [] reallocLongArray(long [] longArray, int newSize) {

		long aux[] = new long[newSize];
		int len = longArray.length;

		if (newSize < len)
			len = newSize;

		for (int index = 0; index < len; index++)
			aux[index] = longArray[index];

		return aux;
	}

	/**
	 * Redimensiona un arreglo tipo Float
	 *
	 * @param Arreglo a redimencionar 
	 *
	 * @param Tamaño a asignar
	 * 
	 * @return aux Referencia a nueva posición
	 */
	public float [] reallocFloatArray(float [] floatArray, int newSize) {

		float aux[] = new float[newSize];
		int len = floatArray.length;

		if (newSize < len)
			len = newSize;

		for (int index = 0; index < len; index++)
			aux[index] = floatArray[index];

		return aux;
	}

	/**
	 * Redimensiona un arreglo tipo Float
	 *
	 * @param Arreglo a redimencionar 
	 *
	 * @param Tamaño a asignar
	 * 
	 * @return aux Referencia a nueva posición
	 */
	public float [][] reallocFloatBidimentionArray(float [][] floatArray, int newSizex,int newSizey) {

		float aux[][] = new float[newSizex][newSizey];
		int lenx = floatArray.length;
		int leny = floatArray[0].length;

		if (newSizex < lenx)
			lenx = newSizex;

		if (newSizey < leny)
			leny = newSizey;

		for(int i = 0; i < lenx; i++){
			for (int index = 0; index < leny; index++)
				aux[i][index] = floatArray[i][index];
		}

		return aux;
	}

	/**
	 * Redimensiona un arreglo tipo Double
	 *
	 * @param Arreglo a redimencionar 
	 *
	 * @param Tamaño a asignar
	 * 
	 * @return aux Referencia a nueva posición
	 */
	public double [] reallocDoubleArray(double [] doubleArray, int newSize) {

		double aux[] = new double[newSize];
		int len = doubleArray.length;

		if (newSize < len)
			len = newSize;

		for (int index = 0; index < len; index++)
			aux[index] = doubleArray[index];

		return aux;
	}

	/**
	 * Redimensiona un arreglo tipo Boolean
	 *
	 * @param Arreglo a redimencionar 
	 *
	 * @param Tamaño a asignar
	 * 
	 * @return aux Referencia a nueva posición
	 */
	public boolean [] reallocBooleanArray(boolean [] booleanArray, int newSize) {

		boolean aux[] = new boolean[newSize];
		int len = booleanArray.length;

		if (newSize < len)
			len = newSize;

		for (int index = 0; index < len; index++)
			aux[index] = booleanArray[index];

		return aux;
	}

	/**
	 * Redimensiona un arreglo tipo Char
	 *
	 * @param Arreglo a redimencionar 
	 *
	 * @param Tamaño a asignar
	 * 
	 * @return aux Referencia a nueva posición
	 */
	public char [] reallocCharArray(char [] charArray, int newSize) {

		char aux[] = new char[newSize];
		int len = charArray.length;

		if (newSize < len)
			len = newSize;

		for (int index = 0; index < len; index++)
			aux[index] = charArray[index];

		return aux;
	}

	/**
	 * Redimensiona un arreglo tipo String
	 *
	 * @param Arreglo a redimencionar 
	 *
	 * @param Tamaño a asignar
	 * 
	 * @return aux Referencia a nueva posición
	 */
	public String [] reallocStringArray(String [] stringArray, int newSize) {

		String aux[] = new String[newSize];
		int len = stringArray.length;

		if (newSize < len)
			len = newSize;

		for (int index = 0; index < len; index++)
			aux[index] = stringArray[index];

		return aux;
	}
	
	public String [][] reallocStringBidimentionArray(String [][] StringArray, int newSizex,int newSizey) {

		String aux[][] = new String[newSizex][newSizey];
		int lenx = StringArray.length;
		int leny = StringArray[0].length;

		if (newSizex < lenx)
			lenx = newSizex;

		if (newSizey < leny)
			leny = newSizey;

		for(int i = 0; i < lenx; i++){
			for (int index = 0; index < leny; index++)
				aux[i][index] = StringArray[i][index];
		}

		return aux;
	}

	public static void main(String[] args) {
		Redimensiona reallocate = new Redimensiona();
		System.out.println("-------------------------");
		byte [] arrayx = new byte[5];
		System.out.println(arrayx.length);
		arrayx = reallocate.reallocByteArray(arrayx, 2);
		System.out.println(arrayx.length);
		System.out.println("-------------------------");
		short [] arrayx0 = new short[5];
		System.out.println(arrayx0.length);
		arrayx0 = reallocate.reallocShortArray(arrayx0, 2);
		System.out.println(arrayx0.length);
		System.out.println("-------------------------");
		int [] arrayx1 = new int[5];
		System.out.println(arrayx1.length);
		arrayx1 = reallocate.reallocIntArray(arrayx1, 2);
		System.out.println(arrayx1.length);
		System.out.println("-------------------------");
		long [] arrayx2 = new long[5];
		System.out.println(arrayx2.length);
		arrayx2 = reallocate.reallocLongArray(arrayx2, 2);
		System.out.println(arrayx2.length);
		System.out.println("-------------------------");
		float [] arrayx3 = new float[5];
		System.out.println(arrayx3.length);
		arrayx3 = reallocate.reallocFloatArray(arrayx3, 2);
		System.out.println(arrayx3.length);
		System.out.println("-------------------------");
		double [] arrayx4 = new double[5];
		System.out.println(arrayx4.length);
		arrayx4 = reallocate.reallocDoubleArray(arrayx4, 2);
		System.out.println(arrayx4.length);
		System.out.println("-------------------------");
		boolean [] arrayx5 = new boolean[5];
		System.out.println(arrayx5.length);
		arrayx5 = reallocate.reallocBooleanArray(arrayx5, 2);
		System.out.println(arrayx5.length);
		System.out.println("-------------------------");
		char [] arrayx6 = new char[5];
		System.out.println(arrayx6.length);
		arrayx6 = reallocate.reallocCharArray(arrayx6, 2);
		System.out.println(arrayx6.length);
		System.out.println("-------------------------");
		String [] arrayx7 = new String[5];
		System.out.println(arrayx7.length);
		arrayx7 = reallocate.reallocStringArray(arrayx7, 2);
		System.out.println(arrayx7.length);
	}
}	