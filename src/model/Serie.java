package model;

public class Serie extends Product{

	private Date firstBroadCast;
	private String protagonistName; 
	private boolean censored;
	private String reasonCensored;
	private Season firstSeason;
	private Season [] temporadas;
	private int cantSeason;


	public Serie(Date firstBroadCast, String name, String protagonistName, String directorName, String synopsis, boolean censored, String reasonCensored, Season firstSeason){
		super(directorName,synopsis,name);
		this.firstBroadCast = firstBroadCast;
		this.protagonistName = protagonistName;
		this.censored = censored;
		this.reasonCensored = reasonCensored;
		cantSeason = 0;
		temporadas = new Season[20];
		temporadas[cantSeason] = firstSeason; 
	}

	public Season[] getSeasons(){
		return temporadas;
	}


	@Override
	public String toString(){
		String out = "";
		out += super.toString();
		out += "El tipo de producto es: Serie " + "\n";
		out += "Los protagonistas son: " + protagonistName + "\n";
		if (censored == true){
			out += "La serie ha sido sensurada " + "\n";
			out += "Razon por la cual la serie fue censurada:  " +  reasonCensored + "\n";
		} else{
			out += "La serie no ha sido censurada " + "\n";
		}
		out += firstBroadCast.toString();
		return out;
	}

	/**
    * Descripción: Este metodo permite agregar una nueva temporada a una serie
    * @param <number> <int> numero de la temporada
    * @param <programEpisodes> <int> episodios programados
    * @param <publishedEpisodes> <int> episodios publicados
    * @param <trailer> <boolean> existe un trailer
    * @param <newDateNewSeason> <Date>, un objeto fecha
    */
	public void addNewSeason(int number, int programEpidodes, int publishedEpisodes, Date newDateNewSeason,boolean trailer){
		//cantSeason = number + 1;
		//number = cantSeason;
		temporadas[cantSeason] = new Season(number, programEpidodes, publishedEpisodes, newDateNewSeason,trailer); 
	}


	public String getProtagonistName(){
		return protagonistName;
	}
	public boolean getCensored(){
		return censored;
	}
	public String getReasonCensored(){
		return  reasonCensored;
	}
	public Season getFirstSeason(){
		return firstSeason;
	}

	public void setProtagonistName(String protagonistName){
		this.protagonistName = protagonistName;
	}

	public void setCensored(boolean censored){
		this.censored = censored;
	}
	public void setReasonCensored(String reasonCensored){
		this.reasonCensored = reasonCensored;
	}


}