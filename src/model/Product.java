package model;


public abstract class Product{
	private String directorName;
	private String sypnosis;
	private String name;


	public Product(String directorName, String sypnosis, String name){
		this.name = name;
		this.directorName = directorName;
		this.sypnosis = sypnosis;
	}
	
	public String getDirectorName(){
		return directorName;
	}
	public String getSypnosis(){
		return sypnosis;
	}
	public String getName(){
		return name;
	}
	/*public boolean getTrailer(){
		return trailer;
	}*/

	// set
	public void setName(String name){
		this.name = name;
	}
	/*public void setTrailer(boolean trailer){
		this.trailer = trailer;
	}*/
	public void setDirectorName(){
		this.directorName = directorName;
	}
	public void setSypnosis(){
		this.sypnosis = sypnosis;
	}

	@Override
	public String toString(){
		String out = "";
		out += "Nombre: " + name + "\n";
		out += "Nombre del director: " + directorName  + "\n";
		out += "sypnosis: " +  sypnosis + "\n";
		return out;
	}

}