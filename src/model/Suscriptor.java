package model;


public class Suscriptor{

	private String cedula;
	private String fullName;
	private int consuptionHours;
	private int age;
	private State state;
	private int clientType; 
	// 0 = Normal 
	// 1 = Platino
	// 2 = Oro
	// 3 = Diamante

	
	/**
    * Descripción: Este metodo permite construir un objeto de tipo suscriptor</br>
    * @param <pos> <int>, este dato lo debio de haber digitado el usuario y sirven para crear el objeto
    * @param <cedula> <String>, este dato lo debio de haber digitado el usuario y sirven para crear el objeto
    * @param <fullName> <String>, este dato lo debio de haber digitado el usuario y sirven para crear el objeto
    * @param <consuptionHours> <int>, este dato lo debio de haber digitado el usuario y sirven para crear el objeto
    * @param <age> <int>, este dato lo debio de haber digitado el usuario y sirven para crear el objeto
    * @param <clyenType> <int>, este dato lo debio de haber digitado el usuario y sirven para crear el objeto
    */
	public Suscriptor(String cedula, String fullName, int consuptionHours, int age, int clientType){
		this.cedula = cedula;
		this.fullName = fullName;
		this.consuptionHours = consuptionHours;
		this.age = age;
		state = State.ACTIVE;
		this.clientType = clientType;
	}



	/**
    * Descripción: Los siguientes metodos permiten obtener unos atributos especificos de un objeto suscriptor</br>
    * @return <cedula> <String>, Si se utiliza el metodo getCedula() se obtiene el atributo cedula
    */
	public String getCedula(){
		return cedula;
	}

	/**
    * Descripción: Los siguientes metodos permiten obtener unos atributos especificos de un objeto suscriptor</br>
    * @return <fullName> <String>, Si se utiliza el metodo getFullName() se obtiene el atributo fullName
    */
	public String getFullName(){
		return fullName;
	}

	/**
    * Descripción: Los siguientes metodos permiten obtener unos atributos especificos de un objeto suscriptor</br>
    * @return <consuptionHours> <int>, Si se utiliza el metodo getConsuptionHours() se obtiene el atributo consuptionHours
    */
	public int getConsuptionHours(){
		return consuptionHours;
	}

	/**
    * Descripción: Los siguientes metodos permiten obtener unos atributos especificos de un objeto suscriptor</br>
    * @return <age> <int>, Si se utiliza el metodo getAge() se obtiene el atributo age
    */
	public int getAge(){
		return age;
	}

	/**
    * Descripción: Los siguientes metodos permiten obtener unos atributos especificos de un objeto suscriptor</br>
    * @return <state> <Enum>, Si se utiliza el metodo getState() se obtiene el atributo state
    */
	public State getState(){
		return state;
	}
	

	/**
    * Descripción: Los siguientes metodos permiten obtener unos atributos especificos de un objeto suscriptor</br>
    * @return <clyenType> <int>, Si se utiliza el metodo getClyenType() se obtiene el atributo clientType
    */
	public int getClyentType(){
		return clientType;
	}


	/**
    * Descripción: Este metodo permite modificar un atributo especifico de un objeto suscriptor</br>
    * @param <cedula> <String>, se cambia el atributo cedula
    */
	public void setCedula(String cedula){
		this.cedula = cedula;
	}


	/**
    * Descripción: Este metodo permite modificar un atributo especifico de un objeto suscriptor</br>
    * @param <fullName> <String>, se cambia el atributo fullName
    */
	public void setFullName(String fullName){
		this.fullName = fullName;
	}


	/**
    * Descripción: Este metodo permite modificar un atributo especifico de un objeto suscriptor</br>
    * @param <consuptionHours> <int>, se cambia el atributo consuptionHours
    */
	public void setConsuptionHours(int consuptionHours){
		this.consuptionHours = consuptionHours;
	}


	/**
    * Descripción: Este metodo permite modificar un atributo especifico de un objeto suscriptor</br>
    * @param <age> <int>, se cambia el atributo age
    */
	public void setAge(int age){
		this.age = age;
	}


	/**
    * Descripción: Este metodo permite modificar un atributo especifico de un objeto suscriptor</br>
    * @param <state> <Enum>, se cambia el atributo state
    */
	public void setState(State state){
		this.state = state;
	}



	/**
    * Descripción: Este metodo permite modificar un atributo especifico de un objeto suscriptor</br>
    * @param <clentType> <int>, se cambia el atributo clientType
    */
	public void setClyenType(int clientType){
		this.clientType = clientType;
	}


	/**
    * Descripción: Este metodo permite imprimir los datos(Atributos) de un objeto de tipo suscriptor </br>
    * @return <out> <String>, Retorna un string que contiene toda la informacion que se va a imprimir
    */
	public String toString(){
		String out = "";
		out += "Cedula: " + cedula + "\n";
		out += "Nombre: " + fullName  + "\n";
		out += "Horas de consumo: " +  consuptionHours + "\n";
		out += "Estado: " +  state + "\n";
		out += "Edad: " + age + "\n";
		switch (clientType){
			case 1:
			out += "Tipo de cliente: Normal";
			break;
			case 2:
			out += "Tipo de cliente: PLatino";
			break;
			case 3:
			out += "Tipo de cliente: Oro";
			break;
			case 4:
			out += "Tipo de cliente: Diamante";
			break;
		}
		return out;
	}
}