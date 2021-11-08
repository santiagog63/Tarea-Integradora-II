package ui;

import java.util.Scanner;
import model.Controller;
import model.State;
import model.Category;
//import model.Date;




public class BlackSnail{

	//Scanner
	private Scanner sc;
	//Relacion con la clase Controller
	private Controller tv;


	/**
    * Descripción: Inicializa el Scanner
    * <b> pre:</b> El Scanner debio de ser declarado como variable global
    * <b> pos:</b> El Scanner se inicializa
    */
	public BlackSnail(){
		sc = new Scanner(System.in);
	}

	/**
    * Descripción: Este metodo creara el objeto BlackSnail y llamara al metodo addController para poder crear la relacion
    * y crear el objeto tv. Este metodo tambien se encargara de mostrarle el menu de opciones al usuario hasta que este
    * ya quiera dejar de usar la aplicacion
    */


	public static void main(String[]x){
		BlackSnail principal = new BlackSnail();
		principal.addController();
		//

		int opcion = 0;

		do {
		    opcion = principal.menuOption();
		    principal.respuesta(opcion);
		}while (opcion !=10);
	}

	/**
    * Descripción: Este metodo permite crear un objeto llamado tv</br>
    * <b> pre:</b> El objeto tv debio de ser declarado con anterioridad </br>
    * <b> pos:</b> El objetivo tv se inicializo
    */

	public void addController(){
		System.out.println("Digite el nit del canal de suscripcion");
		String nit = sc.nextLine();
		tv = new Controller(nit);

	}

	/**
    * Descripción: Este metodo le muestra al usuario las opciones que puede realizar con el software</br>
    * @return <imput> <int>, Este numero permitira llamar a otros metodos, dependiendo de lo que desee el usuario
    */
	public int menuOption(){
		int imput = 0;

		System.out.println("\n\nBienvenido al menu de BlackSnail\n" + 
							"(1) Crear un nuevo Suscriptor\n" + 
							"(2) Desactivar un Suscriptor\n" + 
							"(3) Despliegue de suscriptores activos por su tipo de cliente\n" + 
							"(4) Despliegue el menor de edad con mayor cantidad de horas a consumir \n" + 
							"(5) Registar un producto \n" +
							"(6) Desplegar la informacion de un producto \n" +
							"(7) Crear la siguiente temporada de una serie \n" +
							"(8) Listar peliculas por medio de una categoria \n" +
							"(9) Listar series con su ultima temporada \n" +
							"(10) Para salir"
		);
		imput = sc.nextInt();
		sc.nextLine();
		return imput;
	}

	/**
    * Descripción: Este metodo permite llamar a otros metodos para que cumplan las funciones que el usuario desea
    * utilizar</br>
    * @param <opcion> <int>, Es un numero entre 1 y 5, que el usuario debio de digitar con anterioridad dependiendo
    * de la accion que desea realizar.
    */
	public void respuesta(int opcion){
		switch (opcion) {
			case 1:
			registerSus();
			break;

			case 2:
			desactivarSus();
			break;

			case 3:
			showSus();
			break;

			case 4:
			menorEdad();
			break;

			case 5:
			registerProduct();
			break;

			case 6:
			showProduc();
			break;

			case 7:
			registerNewSeason();
			break;

			case 8:
			peliculaCategoria();
			break;

			case 9:
			showSeriesSeason();
			break;	
			
			case 10:
			System.out.println("Feliz dia");
			break;	
		}
	}

	/**
    * Descripción: Este metodo le solicita al usuario los datos de un suscriptor para luego registrarlo</br>
    * <b> pre:</b> El arreglo de suscriptores ya debio de ser declarado e inicializado. </br>
    * <b> pos:</b> Al ejecutar este metodo, una posicion del arreglo de suscriptores se llenara con un objeto de tipo suscriptor
    */
	public void registerSus(){
		int pos = tv.hasSpace();

		if (pos == -1){
			System.out.println("Ya se alcanzo el maximo de suscriptores");
		}
		else {
			System.out.println("Digite la cedula del nuevo suscriptor");
			String cedula = sc.nextLine();
			System.out.println("Digite el nombre completo del nuevo suscriptor");
			String fullName = sc.nextLine();
			System.out.println("Digite las horas de consumo del nuevo suscriptor");
			int consuptionHours = sc.nextInt();
			System.out.println("Digite la edad del nuevo suscriptor");
			int age = sc.nextInt();
			System.out.println("Digite el tipo del cliente del nuevo suscriptor");
			System.out.println("1: Normal  - 2: Platino  - 3: Oro  - 4: Diamante");
			int clientType = sc.nextInt();
			tv.addSuscrip(pos,cedula,fullName,consuptionHours,age,clientType);
		}
	}

	/**
    * Descripción: Permite cambiar el atriburo del estado de un suscriptor, de activo a inactivo</br>
    * <b> pre:</b> El arreglo de suscriptores ya debio de ser declarado e inicializado y debe de existir el suscriptor
    * que se desea modificar </br>
    * <b> pos:</b> No cambia el arreglo pero si un atributo del objeto
    */
	public void desactivarSus(){
		System.out.println("Digite el numero del suscriptor que desea desactivar");
		int numSusDesactivar = sc.nextInt();


		if (tv.verifySus(numSusDesactivar)){
			System.out.println("Este suscriptor no existe");
		}
		else{
			tv.deactiveSus(numSusDesactivar);
			System.out.println("El suscriptor: " + numSusDesactivar + " ha sido desactivado");
		}
	}
	/**
    * Descripción: Este metodo permite mostrar la cantidad de suscriptores divididos por su tipo de cliente</br>
    * <b> pre:</b> El arreglo de suscriptores ya debio de ser declarado e inicializado y debe de tener objetos en el</br>
    * <b> pos:</b> No tiene ningun cambio el arreglo
    */
	public void showSus(){
		tv.restablecerContar();
		tv.contar();
		System.out.println(tv.toString());
	}

	/**
    * Descripción: Este metodo permite mostrar al suscriptor que es menor de edad pero que tiene la mayor
    * cantidad de horas a consumir </br>
    * <b> pre:</b> El arreglo de suscriptores ya debio de ser declarado e inicializado y debe de tener objetos en el</br>
    * <b> pos:</b> No tiene ningun cambio el arreglo
    */
	public void menorEdad(){
		int pos = tv.menorEdad();
		if (pos == -1){
			System.out.println("No hay un menor de edad");
		}
		else {

			System.out.println(tv.getSuscriptores()[pos].toString());
		}
	}


	/**
    * Descripción: Este metodo permite crear un producto, ya sea serie o pelicula, donde se le piden los datos
    * para que luego los mande a los otros metodos como parametros
    */
	public void registerProduct(){
		String reasonCensored = "No fue censurada";
		System.out.println("Si desea registrar una serie, digite el numero 1, si desea digitar una pelicual digite el numero 2");
		int opcionProduct = sc.nextInt();
		switch (opcionProduct) {
			case 1:
			int posCat = tv.hasSpaceProduct();
			if (posCat == -1){
				System.out.println("Ya no se puede registar mas series");
			} else{
				//Crear el objeto fecha
				System.out.println("Digite los datos de la fecha de estreno de la serie");
				System.out.println("Digite el dia");
				int day = sc.nextInt();
				System.out.println("Digite el mes");
				int month = sc.nextInt();
				System.out.println("Digite el año");
				int year = sc.nextInt();
				sc.nextLine();


				//Datos de la serie
				System.out.println("Digite el nombre de la serie");
				String name = sc.nextLine();
				System.out.println("Digite los nombres de los protagonistas y los separa por medio de guiones");
				String protagonistName = sc.nextLine();
				System.out.println("Digite el nombre del director");
				String directorName = sc.nextLine();
				System.out.println("Escriba la sipnosis de la serie");
				String sypnopsis = sc.nextLine();
				System.out.println("Si la serie fue censurada digite 1, si no fue censurada, digite 2");
				int opcionCensurada = sc.nextInt();
				sc.nextLine();
				boolean resultadoCensurada = censurada(opcionCensurada);

				// Para poder tener el string
				if (resultadoCensurada == true){
					System.out.println("Escriba la razon de por que la serie fue censurada");
					reasonCensored = sc.nextLine();
				}


				// Datos temporada	
				int number = 1;
				boolean trailer = true;
				System.out.println("Digite el numero de episodios programados");
				int programEpidodes = sc.nextInt();
				System.out.println("Digite el numero de cantidad de episodios publivados");
				int publishedEpisodes = sc.nextInt();
				System.out.println("Digite los datos de la fecha de estreno de la primera temporada");
				System.out.println("Digite el dia");
				int day2 = sc.nextInt();
				System.out.println("Digite el mes");
				int month2 = sc.nextInt();
				System.out.println("Digite el año");
				int year2 = sc.nextInt();
				tv.addSerie(posCat,day,month,year, name,protagonistName, directorName, sypnopsis,resultadoCensurada,reasonCensored,number,programEpidodes,publishedEpisodes,trailer,day2,month2,year2);
				}
			break;

			case 2:
			int posMovie = tv.hasSpaceProduct();
			if (posMovie == -1){
				System.out.println("Ya no se puede registar mas peliculas");
			} else {
				boolean trailerMovie = true;
				//datos fecha 
				System.out.println("Digite los datos de la fecha de estreno de la pelicula");
				System.out.println("Digite el dia");
				int dayMovie = sc.nextInt();
				System.out.println("Digite el mes");
				int monthMovie = sc.nextInt();
				System.out.println("Digite el año");
				int yearMovie = sc.nextInt();
				sc.nextLine();

				//Datos pelicula
				System.out.println("Digite el nombre de la pelicula");
				String nameMovie = sc.nextLine();
				System.out.println("Difite el nombre del director de la pelicula");
				String directorNameMovie = sc.nextLine();
				System.out.println("Digite el nombre del productor de la pelicula");
				String producerNameMovie = sc.nextLine();
				System.out.println("Digite la sypnosis de la pelicula");
				String sypnosisMovie = sc.nextLine();
				System.out.println("Digite la minima edad para ver la pelicula");
				int minAge = sc.nextInt();
				System.out.println("Si la pelicula es Romantica digite 1, si es de Accion digite 2, si es de Suspenso digite 3, si es de Terror digite 4 y si es de Comedia digite 5");
				int categoria = sc.nextInt();
				Enum resultadoCategoria = tv.searchCategory(categoria);
				tv.addMovie(dayMovie,monthMovie,yearMovie,nameMovie,directorNameMovie,producerNameMovie,sypnosisMovie,minAge,trailerMovie,resultadoCategoria,posMovie);
			}
			break;
		}
	}
	/**
    * Descripción: Este metodo permite convertir la opcion de un entero en boleano
    * @param <opcionCensurada> <int>, Tiene que haber sido digitada por el usuario
    * @return <flag> <boolean>
    */
	public boolean censurada(int opcionCensurada){
		
		boolean flag = false;
		switch (opcionCensurada) {
			case 1:
			flag = true;
			break;
		}
		return flag;
	}

	/**
    * Descripción: Este metodo permite mostrar las peliculas dependiendo de las categoria que desee el usuario
    */
	public void peliculaCategoria(){
		System.out.println("Ditie el numero del cual desea desplegar las pelicula asociada a la categoria");
		System.out.println("Si la pelicula es Romantica digite 1, si es de Accion digite 2, si es de Suspenso digite 3, si es de Terror digite 4 y si es de Comedia digite 5");
		int categoriaBuscar = sc.nextInt();
		tv.mostrarPeliculas(categoriaBuscar);
	}


	/**
    * Descripción: Este metodo permite mostrarle al usuario la informacion acerca de un producto en especifico
    */
	public void showProduc(){
		System.out.println("Digite el nombre del producto que desea visualizar");
		String nameProduct = sc.nextLine();
		tv.searchProduct(nameProduct);
	}

	/**
    * Descripción: Este metodo permite agregarle una nueva temporada a una serie
    */
	public void registerNewSeason(){

		System.out.println("Digite el nombre de la serie a al que le quiere agregar una nueva temporada");
		String nameSerieNewSeason = sc.nextLine();
		int number = 0;
		System.out.println("Digite el numero de la temporada");
		number = sc.nextInt();
		boolean trailer = true;
		System.out.println("Digite el numero de episodios programados");
		int programEpidodes = sc.nextInt();
		System.out.println("Digite el numero de cantidad de episodios publivados");
		int publishedEpisodes = sc.nextInt();
		System.out.println("Digite los datos de la fecha de estreno de la primera temporada");
		System.out.println("Digite el dia");
		int day2 = sc.nextInt();
		System.out.println("Digite el mes");
		int month2 = sc.nextInt();
		System.out.println("Digite el año");
		int year2 = sc.nextInt();
		tv.addRegisterNewSeason(nameSerieNewSeason,number,trailer,programEpidodes,publishedEpisodes,day2,month2,year2);
	}

	/**
    * Descripción: Este metodo permite mostrar las series que haya con su ultima temporada
    */
	public void showSeriesSeason(){
		tv.mostrarSeries();
	}
}