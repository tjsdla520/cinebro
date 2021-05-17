package cinebro.lists.model;

import java.util.List;
import java.util.Map;

public class FilmList {
	private int id ;
	private String email ;
	private String list_title ;
	private String comments ;
	private String nickname ;
	private Map<Integer, String> film_title;
	
	

	public Map<Integer, String> getFilm_title() {
		return film_title;
	}

	public void setFilm_title(Map<Integer, String> film_title) {
		this.film_title = film_title;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getList_title() {
		return list_title;
	}

	public void setList_title(String list_title) {
		this.list_title = list_title;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	public FilmList() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FilmList [id=" + id + ", email=" + email + ", list_title=" + list_title + ", comments=" + comments
				+ ", nickname=" + nickname + "]";
	}
	
	
}