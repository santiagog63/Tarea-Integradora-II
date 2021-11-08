package model;

public class Movie extends Product{

	//relacion
	private Date releaseDate;
	private String producerName;
	private int minimunAge;
	private boolean trailer;
	private Enum category;

	public Movie(Date releaseDate, String name, String directorName, String producerName, String sypnopsis, int minimunAge, boolean trailer, Enum category){
		
		super(directorName,sypnopsis,name);
		this.trailer = trailer;
		this.releaseDate = releaseDate;
		this.producerName = producerName;
		this.minimunAge = minimunAge;
		this.category = category;
	}



	@Override
	public String toString(){
		String out = "";
		out += "El tipo de producto es: Pelicula " + "\n";
		out += super.toString();
		out += "Nombre del productor: " +  producerName + "\n";
		out += "Edad minima : " +  minimunAge + "\n";
		out += "La pelicual tiene trailer: " + "\n";
		out += "Categoria " +  category + "\n";
		return out;
	}


	// gets
	public Date getRealeaseDate(){
		return releaseDate;
	}


	public String getProducerName(){
		return producerName;
	}

	public int getMinimumAge(){
		return minimunAge;
	}
	public boolean getTrailer(){
		return trailer;
	}
	public Enum getCategory(){
		return category;
	}

	// sets
	public void setReleaseDate(Date releaseDate){
		this.releaseDate = releaseDate;
	}


	public void setProducerName(String producerName){
		this.producerName = producerName;
	}

	public void setMinimumAge(int minimunAge){
		this.minimunAge = minimunAge;
	}
	public void setTraile(boolean trailer){
		this.trailer = trailer;
	}
	public void setCategory(Enum category){
		this.category = category;
	}




}