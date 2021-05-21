package cinebro.actor.model;
import java.util.List;
import cinebro.films.model.*;

public class Actor {
	private int id;
	private String name;
	private List<Film> actingfilms;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Film> getActingfilms() {
		return actingfilms;
	}
	public void setActingfilms(List<Film> actingfilms) {
		this.actingfilms = actingfilms;
	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", actingfilms=" + actingfilms + "]";
	}
	
}
