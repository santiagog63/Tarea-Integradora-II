package model;

public class Controller{
	private String nit;
	private Suscriptor [] suscriptores;
	private int [] contarTiposClientes; 
	private Product [] catalogo;
	private String [] peliculasCategoria;
	private Date dates;
	private Serie serie;
	
	/**
    * Descripción: Este metodo permite construir un objeto de tipo Controller</br>
    * @param <nit> <String>, El usuario debe de haber digitado el nit del canal
    */
	public Controller(String nit){
		this.nit = nit;
		suscriptores = new Suscriptor[50];
		contarTiposClientes = new int[4];
		catalogo = new Product[85];
		peliculasCategoria = new String[85];
		serie = new Serie(null,null,null,null,null,true,null,null);
	}
	/**
    * Descripción: Este metodo permite retornar el arreglos de suscriptores</br>
    * <b> pre:</b> El arreglo suscriptores debe de haber sido declarado e inicializado </br>
    * <b> pos:</b> No tiene ningun cambion el arreglo
    * @return <suscriptores> <Suscripor[]>, retorna un arreglo lleno de objetos de tipo suscriptor
    */
	public Suscriptor[] getSuscriptores(){
		return suscriptores;
	}



	/**
    * Descripción: Este metodo permite crear un objeto de tipo suscriptor</br>
    * <b> pre:</b> El arrelgo de suscriptores debe de haber sido inicializado y declarado </br>
    * <b> pos:</b> Se llena una posicion del arreglo
    * @param <pos> <int>, este dato lo debio de haber digitado el usuario y sirven para crear el objeto
    * @param <cedula> <String>, este dato lo debio de haber digitado el usuario y sirven para crear el objeto
    * @param <fullName> <String>, este dato lo debio de haber digitado el usuario y sirven para crear el objeto
    * @param <consuptionHours> <int>, este dato lo debio de haber digitado el usuario y sirven para crear el objeto
    * @param <age> <int>, este dato lo debio de haber digitado el usuario y sirven para crear el objeto
    * @param <clyenType> <int>, este dato lo debio de haber digitado el usuario y sirven para crear el objeto
    */
	public void addSuscrip(int pos,String cedula,String fullName,int consuptionHours,int age,int clientType){
		suscriptores[pos] = new Suscriptor(cedula, fullName, consuptionHours,age, clientType);
	}

	/**
    * Descripción: Este metodo permite verificar si hay espacio en el arreglo para poder crear un suscriptor </br>
    * <b> pre:</b> El arrelgo de suscriptores debe de haber sido inicializado y declarado </br>
    * <b> pos:</b> El arreglo no ocurre nada
    * @return <pos> <int>, Retorna la posicion vacia para poder llenarse
    */
	public int hasSpace(){
		boolean flag = false;
		int pos = -1;
		for (int i=0; i<suscriptores.length && !flag;i++){
			if (suscriptores[i] == null){
				pos = i;
				flag = true;
			}
		}
		return pos;
	}

	/**
    * Descripción: Este metodo permite cambiar un atributo (Estado) de un objeto de tipo Suscriptor</br>
    * @param <num> <int>, Este parametro indica el numero de suscriptor al cual se le desea cambiar el atributo
    */
	public void deactiveSus(int num){
		num = num -1;
		suscriptores[num].setState(State.INACTIVE);
		suscriptores[num].setClyenType(1);
	}

	/**
    * Descripción: Este metodo permite ver si una posicion del arreglo tiene un objeto </br>
    * <b> pre:</b> El arrelgo de suscriptores debe de haber sido inicializado y declarado </br>
    * <b> pos:</b> El arreglo no ocurre nada
    * @param <num> <int>, Es el numero del suscriptor que se desea saber si existe o no
    * @return <out> <boolean>, Retorna verdadero si el objeto esta vacio
    */
	public boolean verifySus(int num){
		boolean out = false;
		num = num -1;
		if (suscriptores[num]==null){
			out = true;
		}
		return out;
	}

    /**
    * Descripción: Este metodo permite llenar las posiciones del arrelgo con ceros</br>
    * <b> pre:</b> El arreglo contarTiposClientes debio de ser declarado e inicializado con anterioridad</br>
    * <b> pos:</b> En las posiciones del arreglos, todas se llenan con 0.
    */
    public void restablecerContar(){
    	contarTiposClientes[0] = 0;
    	contarTiposClientes[1] = 0;
    	contarTiposClientes[2] = 0;
    	contarTiposClientes[3] = 0;
    }

    /**
    * Descripción: Este metodo permite llevar la cuenta de los suscriptores que son activos, cual es su tipo de cliente</br>
    * <b> pre:</b> Los arreglos contarTipoClientes y sucriptores, debieron de ser inicializados y declarados con anterioridad </br>
    * <b> pos:</b> El arreglo contarTipoClientes se le van a ir sumando unidades si se llegan a cumplir con las condiciones del codigo.
    */
    public void contar(){
    	int clienteTipo = 0;
		for (int i=0; i<suscriptores.length;i++){
			if (suscriptores[i]!= null){
				if (suscriptores[i].getState() == State.ACTIVE){
					clienteTipo =suscriptores[i].getClyentType();
					switch(clienteTipo){
					case 1:
					contarTiposClientes[0] = contarTiposClientes[0] + 1;
					break;

					case 2:
					contarTiposClientes[1] = contarTiposClientes[1] + 1;
					break;

					case 3:
					contarTiposClientes[2] = contarTiposClientes[2] + 1;
					break;

					case 4:
					contarTiposClientes[3] = contarTiposClientes[3] + 1;
					break;
					}
				}
			}
		}
	}

	/**
    * Descripción: Este metodo permite recorrer el arreglo de los suscriptores y ver, entre los menores de edad, quien tiene la mayor
    * cantidad de horas de consumo </br>
    * <b> pre:</b> Haber inicializado y declarado el arreglo de suscriptores </br>
    * <b> pos:</b> El arreglo no tiene un cambio
    * @return <tempos> <int>, Retorna el numero que indica la posicion del objeto que representa el menor de edad que tiene la mayor
    	* cantidad de horas de consumo
    */
	public int menorEdad(){
		int comp1 = 0;
		//Resultado
		int tempHours = 0;
		int tempos = -1;

		for (int i=0; i<suscriptores.length;i++){

			if (suscriptores[i]!=null){
				if (suscriptores[i].getAge()<18){
				comp1 = suscriptores[i].getConsuptionHours();
					if (comp1 >tempHours){
					tempHours = comp1;
					tempos = i;
					}
				}
			}
		}
		return tempos;
	}



	/**
    * Descripción: Este metodo permite imprimir el arreglo de contarTiposClientes </br>
    * <b> pre:</b> El arreglo contarTipoClientes debio de ser declarado e inicializado con anterioridad </br>
    * <b> pos:</b> El arreglo no sugre ningun cambio
    * @return <out> <Strinh>, Este retorno es un conjunto de String que forman un mensaje
    */
	public String toString(){
		String out = "";
		out += "Nit: " + nit + "\n";
		out += "La cantidad de suscripotres activos por cada tipo de usuario:" + "\n";
		out += "Normal: " + contarTiposClientes[0] + "\n";
		out += "Platino: " + contarTiposClientes[1] + "\n";
		out += "Oro: " + contarTiposClientes[2] + "\n";
		out += "Diamante: " + contarTiposClientes[3] + "\n";
		return out;
	}





	/**
    * Descripción: Este metodo permite reccorer el arreglo de los productos para poder ver si hay espacio para registrar un producto
    * <b> pre:</b> El arreglo catalogo debe de haber sido inicializado y declarado
    * <b> pos:</b> Ninguno
    * @return <pos> <int >, Indica la posicion que esta libre en el arreglo
    */
	public int hasSpaceProduct(){
		boolean flag = false;
		int pos = -1;
		for (int i=0; i<catalogo.length && !flag;i++){
			if (catalogo[i] == null){
				pos = i;
				flag = true;
			}
		}
		return pos;
	}



	/**
    * Descripción: Este metodo permite agregar una serie al arreglo de productos
    * <b> pre:</b> El arreglo de productos debe haber sido declarado e inicializado
    * <b> pos:</b> En una posicion, se le agrega una serie
    * @param <posCat> <int> indica la posicion donde se agregara la serie
    * @param <day> <int> dia de una fecha
    * @param <month> <int> mes de una fecha
    * @param <year> <int> año de una fecha
    * @param <name> <String> nombre de la serie
    * @param <protagonistName> <String> nombre de los protagonistas
    * @param <DirectorName> <String> nombre del director
    * @param <sypnosis> <String> sypnosis de la serie
    * @param <resultadoCensurada> <boolean> Verificar si la serie ha sido censurada
    * @param <reasonCensored> <String> razon de por que fue censurada la serie
    * @param <number> <int> numero de la temporada
    * @param <programEpisodes> <int> episodios programados
    * @param <publishedEpisodes> <int> episodios publicados
    * @param <trailer> <boolean> existe un trailer
    * @param <day2> <int> dia de una fecha
    * @param <month2> <int> mes de una fecha
    * @param <year2> <int> año de una fecha
    */
	public void addSerie(int posCat, int day, int month, int year, String name, String protagonistName, String directorName, String sypnosis, boolean resultadoCensurada, String reasonCensored, int number, int programEpidodes, int publishedEpisodes, boolean trailer,int day2, int month2, int year2){
		Date firstBroadcast = addDate(day,month,year);
		Date premiere = addDate(day2,month2,year2);
		Season firstSeason = addFirstSeason(number,programEpidodes,publishedEpisodes,premiere,trailer);
		catalogo[posCat] = new Serie(firstBroadcast, name, protagonistName, directorName, sypnosis, resultadoCensurada, reasonCensored, firstSeason);
		System.out.println(catalogo[posCat].toString());
	}

		/**
    * Descripción: Este metodo permite crear una fecha
    * @param <day> <int> dia de una fecha
    * @param <month> <int> mes de una fecha
    * @param <year> <int> año de una fecha
    * @return <fecha> <Date>, Una fecha en especifico
    */
	public Date addDate(int day, int month, int year){
		Date fecha = new Date(day,month,year);
		return fecha;
	}


	/**
    * Descripción: Este metodo permite crear una temporada
    * @param <number> <int> numero de la temporada
    * @param <programEpisodes> <int> episodios programados
    * @param <publishedEpisodes> <int> episodios publicados
    * @param <trailer> <boolean> existe un trailer
    * @param <releaseDateFirstSeason> <Date> un objeto de fecha creado
    * @return <primeraSeason> <Season>, la primera temporada de una serie
    */
	public Season addFirstSeason(int number, int programEpidodes, int publishedEpisodes, Date releaseDateFirstSeason, boolean trailer ){
		Season primeraSeason = new Season(number, programEpidodes, publishedEpisodes, releaseDateFirstSeason, trailer);
		return primeraSeason;
	}

	/**
    * Descripción: Este metodo permite agregar una pelicula al arreglo de productos
    * <b> pre:</b> El arreglo de productos debe haber sido declarado e inicializado
    * <b> pos:</b> En una posicion, se le agrega una serie
    * @param <posMovie> <int> indica la posicion donde se agregara la serie
    * @param <dayMovie> <int> dia de una fecha
    * @param <monthMovie> <int> mes de una fecha
    * @param <yearMovie> <int> año de una fecha
    * @param <name> <String> nombre de la serie
    * @param <DirectorName> <String> nombre del director
    * @param <producerName> <String> nombre del productor
    * @param <sypnosis> <String> sypnosis de la serie
    * @param <minimumAge> <int> edad minima de la pelicula
    * @param <category> <enum> episodios programados
    * @param <trailer> <boolean> existe un trailer
    */
	public void addMovie(int dayMovie, int monthMovie, int yearMovie,String name, String directorName, String producerName, String sypnopsis, int minimunAge, boolean trailer, Enum category, int posMovie){
		Date realeseMovie = new Date(dayMovie,monthMovie,yearMovie);
		catalogo[posMovie] = new Movie(realeseMovie, name, directorName,producerName,sypnopsis,minimunAge,trailer,category);
		System.out.println(catalogo[posMovie].toString());

	}

	/**
    * Descripción: Este metodo permite cambiar la opcion del usuario frente a la cetegoria que es un numero, cambiarlo a una enumeracion
    * @param <opcion> <int>, El usuario digito esta opcion
    * @return <varBuscada> <Enum>, Indica la enumeracion o categoria que el usuario escogio
    */
	public Enum searchCategory(int opcion){
		Enum varBuscada = null;
		switch(opcion){
			case 1:
			varBuscada = Category.ROMANTICA;
			break;
			case 2:
			varBuscada = Category.ACCION;
			break;
			case 3:
			varBuscada = Category.SUSPENSO;
			break;
			case 4:
			varBuscada = Category.TERROR;
			break;
			case 5:
			varBuscada = Category.COMEDIA;
			break;
		}
		return varBuscada;
	}


	/**
    * Descripción: Este metodo permite mostrar las peliculas dependiendo de la categoria que el usuario desee
    * <b> pre:</b> Los arreglos de catalogo y peliculasCategori debieron de ser declarados e inicializados
    * <b> pos:</b> el catalogo no sufre ningun cambio pero el peliculas categoria se iba llenando
    * @param <categoriaBuscar> <int>, representa la categoria que el usuario quiere
    */
	public void mostrarPeliculas(int categoriaBuscar){
		Enum categoriaEncontrada = searchCategory(categoriaBuscar);


		for (int i = 0; i<peliculasCategoria.length;i++){
			peliculasCategoria[i] = null;
		}


		int contador = 1;
		System.out.println("Las peliculas que hay en la categoria: " + categoriaEncontrada + " son: ");
		for(int i = 0; i<catalogo.length;i++){
			if (catalogo[i] != null){
				if (catalogo[i] instanceof Movie){
					if (((Movie)catalogo[i]).getCategory() == categoriaEncontrada){
					peliculasCategoria[i] = catalogo[i].getName();
					System.out.println(contador+ ") "+ peliculasCategoria[i]);
					contador++;
				}
			}
			}
		}
	}

	public void searchProduct(String nameProducto){
		boolean flag = false;
		for(int i=0; i<catalogo.length && !flag ;i++){
			if(catalogo[i] != null){
				if(catalogo[i].getName().equalsIgnoreCase(nameProducto)){
					System.out.println(catalogo[i].toString());
					flag = true;
				}
			}
		}
		if (flag == false){
			System.out.println("No existe el producto que estas buscando");
		}
	}

	/**
    * Descripción: Este metodo permite registrar una nueva temporada a una serie
    * <b> pre:</b> El arreglo catalogo debio de haber sido inicializado y declarado con anteriorirdad
    * <b> pos:</b> Ninguno
    * @param <nameSerieNewSeason> <String> Es el nonbre de la serie a la que se le quiere agregar una nueva temporada
    * @param <number> <int> numero de la temporada
    * @param <programEpisodes> <int> episodios programados
    * @param <publishedEpisodes> <int> episodios publicados
    * @param <trailer> <boolean> existe un trailer
    * @param <day2> <int> dia de una fecha
    * @param <month2> <int> mes de una fecha
    * @param <year2> <int> año de una fecha
    * @param <nombre_par> <tipo>, condiciones sobre el parametro --> si tiene
    */
	public void addRegisterNewSeason(String nameSerieNewSeason,int number,boolean trailer,int programEpidodes,int publishedEpisodes,int day2,int month2,int year2){
		for (int i=0; i<catalogo.length ;i++) {
			if (catalogo[i] != null ){
				if (catalogo[i] instanceof Serie){
					if (catalogo[i].getName().equalsIgnoreCase(nameSerieNewSeason)){
						Date newDateNewSeason = addDate(day2,month2,year2);
						((Serie)catalogo[i]).addNewSeason(number, programEpidodes, publishedEpisodes, newDateNewSeason,trailer);
						System.out.println("Se ha cerado exitosamente la nueva temporada");
					}
					else{
						System.out.println("No hay una serie con el nombre digitado");
					}
				}
			}
		}
	}



	/**
    * Descripción: Este metodo permite mostras la informacion de las series que hay
    * <b> pre:</b> El arreglo catalogo debio de haber sido inicializado y declarado con anteriorirdad
    * <b> pos:</b> Ninguno
    */
	public void mostrarSeries(){
		int pos = -1;
		for (int i = 0; i<catalogo.length;i++){
			if (catalogo[i] != null){
				if (catalogo[i] instanceof Serie){
					System.out.println("Nombre de la serie: " + catalogo[i].getName());
					Season[] temp = ((Serie)catalogo[i]).getSeasons();
					boolean flag = false;
					for (int z=0; z<temp.length && !flag;z++){
						if (temp[z] == null){
							pos = z-1;
							flag = true;
						}
					}
					System.out.println(temp[pos].toString());
				}
			}
		}
	}
	


}