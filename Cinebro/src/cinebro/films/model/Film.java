
package cinebro.films.model;

import java.util.List;

public class Film {
	private int id;
	private String film_title;
	private String director;
	private int year;
	private String country;
	private String name;
	private List<String> genres;
	private List<String> actors;
	private int totalratings;
	private double avgrating;
	private String playUrl;
	
	public Film() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getTotalratings() {
		return totalratings;
	}



	public void setTotalratings(int totalratings) {
		this.totalratings = totalratings;
	}



	public double getAvgrating() {
		return avgrating;
	}



	public void setAvgrating(double avgrating) {
		this.avgrating = avgrating;
	}



	public String getPlayUrl() {
		return playUrl;
	}



	public void setPlayUrl(String playUrl) {
		this.playUrl = playUrl;
	}



	public List<String> getGenres() {
		return genres;
	}



	public void setGenres(List<String> genres) {
		this.genres = genres;
	}



	public List<String> getActors() {
		return actors;
	}



	public void setActors(List<String> actors) {
		this.actors = actors;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilm_title() {
		return film_title;
	}

	public void setFilm_title(String film_title) {
		this.film_title = film_title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Film [id=" + id + ", film_title=" + film_title + ", director=" + director + ", year=" + year
				+ ", country=" + country + ", name=" + name + ", genres=" + genres + ", actors=" + actors
				+ ", totalratings=" + totalratings + ", avgrating=" + avgrating + ", playUrl=" + playUrl
				+ ", getTotalratings()=" + getTotalratings() + ", getAvgrating()=" + getAvgrating() + ", getPlayUrl()="
				+ getPlayUrl() + ", getGenres()=" + getGenres() + ", getActors()=" + getActors() + ", getId()="
				+ getId() + ", getFilm_title()=" + getFilm_title() + ", getDirector()=" + getDirector() + ", getYear()="
				+ getYear() + ", getCountry()=" + getCountry() + ", getName()=" + getName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}