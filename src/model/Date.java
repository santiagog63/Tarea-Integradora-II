package model;


public class Date{
	private int day;
	private int month;
	private int year;


	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}


	//gets

	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}

	// sets

	public void setDay(int day){
		this.day = day;
	}
	public void setMonth(int month){
		this.month = month;
	}
	public void setYear(int year){
		this.year = year;
	}

	public String toString(){
		String out = "";
		out += "Dia: " + day + "\n";
		out += "Mes: " + month  + "\n";
		out += "Año: " +  year + "\n";
		return out;
	}

}