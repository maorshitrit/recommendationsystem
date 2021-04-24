package recommendationsystem;

import java.awt.List;
import java.util.ArrayList;

public class movie {

private int  id;
private String Name;
private ArrayList<String> geners;
private int year;
private String director;
private ArrayList<String> country;
private int minutes;
private String poster;


public movie(int id, String name, ArrayList<String> geners, int year, String director,int minutes,String poster,ArrayList<String> country) {
super();
this.id =id;
Name = name;
this.geners  = geners;
this.year = year;
this.director = director;
this.minutes = minutes;
this.poster = poster;
this.country = country;
}



public ArrayList<String> getCountry() {
	return country;
}



public void setCountry(ArrayList<String> country) {
	this.country = country;
}



public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getName() {
return Name;
}
public void setName(String name) {
this.Name = name;
}
public ArrayList<String> getGeners() {
return geners;
}
public void setGeners(ArrayList<String> geners) {
this.geners = geners;
}
public int getYear() {
return year;
}
public void setYear(int year) {
this.year = year;
}
public String getdirector() {
return director;
}
public void setdirector(String director) {
this.director = director;
}

public void addGeners(List geners,String gener)
{
	geners.add(gener); 
}
public void removeGeners(List geners,String gener)
{
	geners.remove(gener); 
}

public int getMinutes() {
	return minutes;
}

public void setMinutes(int minutes) {
	this.minutes = minutes;
}

public String getPoster() {
	return poster;
}

public void setPoster(String poster) {
	this.poster = poster;
}



@Override
public String toString() {
	return "movie [id=" + id + ", Name=" + Name + ", geners=" + geners + ", year=" + year + ", director=" + director
			+ ", country=" + country + ", minutes=" + minutes + ", poster=" + poster + "]";
}




}