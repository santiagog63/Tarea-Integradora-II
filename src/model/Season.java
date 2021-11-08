package model;

public class Season{
	

	private int number;
	private int numberScheduleEpisodes;
	private int numberEpisodesPublished;
	private Date relaseDateSeason;
	private boolean trailer;

	public Season(int number, int numberScheduleEpisodes, int numberEpisodesPublished, Date relaseDateSeason, boolean trailer){
		this.number = number;
		this.numberScheduleEpisodes = numberScheduleEpisodes;
		this.numberEpisodesPublished = numberEpisodesPublished;
		this.relaseDateSeason = relaseDateSeason;
		this.trailer = trailer;
	}


	//get
	public int getNumber(){
		return number;
	}
	public int getNumberScheduleEpisodes(){
		return numberScheduleEpisodes;
	}
	public int getNumberEpisodesPublished(){
		return numberEpisodesPublished;
	}
	public Date getReleaseDateSeason(){
		return relaseDateSeason;
	}
	public boolean getTrailer(){
		return trailer;
	}

	//set

	public void setNumber(int number){
		this.number = number;
	}

	public void setNumberScheduleEpisodes(int numberScheduleEpisodes){
		this.numberScheduleEpisodes = numberScheduleEpisodes;
	}

	public void setNumberEpisodesPublished(int numberScheduleEpisodes){
		this.numberScheduleEpisodes = numberScheduleEpisodes;
	}

	public void setReleaseDateSeason(Date relaseDateSeason){
		this.relaseDateSeason = relaseDateSeason;
	}

	public void setTrailer(boolean trailer){
		this.trailer = trailer;
	}

	public String toString(){
		String out = "";
		out += "Temporada: " + number + "\n";
		out += "Episodios programados: " + numberScheduleEpisodes  + "\n";
		out += "Episodios publicados: " +  numberEpisodesPublished + "\n";
		out += "La temporada tiene trailer " + "\n";
		return out;
	}

}