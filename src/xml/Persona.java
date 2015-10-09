package xml;

/**
 * @author Elihu Alejandro Cruz Albores
 * @author Carlos Maximiliano Ortiz Escobar
 * @author Luis Fernando Herrera Pimentel
 * @Verision 1.0
 */

class Persona {
	
	int id         = 0; // ID del usuario
	int Status     = 1;
	String  Name   = "";
	int      Age   = 0;
	char Sex       = 'M';// M = Masculino, F = Femenino
	float Training = 0;
	String Sport   = "";
	String Team    = "";
	
	//Constructor Principal
	public Persona(){}

	//Constructor Para la carga de datos
	public Persona(int i,int status,String n,int a,char s,float t,String sp,String te){
		
		this.id       = i;
		this.Status   = status;
		this.Name     = n;
		this.Age      = a;
		this.Sex      = s;
		this.Training = t;
		this.Sport    = sp;
		this.Team     = te;
	}
	
	/**
	 * Agrega Id
	 * @param a Valor Entero
	 */
	public void setId(int a){
		this.id = a;
	}
	
	/**
	 * Carga el estatus
	 * @param a Valor entero
	 */
	public void setStatus(int a){
		this.Status = a;
	}
	
	/**
	 * Carga el nombre del usuario
	 * @param n Cadena de caracteres
	 */
	public void setName(String n){
		this.Name = n;
	}
	
	/**
	 * Carga el equipo
	 * @param te String con datos del equipo
	 */
	public void setTeam(String te){
		this.Team = te;
	}
	
	/**
	 * Carga los datos del deporte
	 * @param sp String con los datos
	 */
	public void setSport(String sp){
		this.Sport = sp;
	}
	
	/**
	 * carga el timepo de entrenamiento
	 * @param tr Flotante para horas
	 */
	public void setTraining(float tr){
		this.Training = tr;
	}
	
	/**
	 * Carga la edad del usuario
	 * @param a valor entero positivo
	 */
	public void setAge(int a){
		this.Age = a;
	}
	
	/**
	 * Carga el sexo de la persona
	 * @param s Caracter
	 */
	public void setSex(char s){
		this.Sex = s;
	}
	
}
