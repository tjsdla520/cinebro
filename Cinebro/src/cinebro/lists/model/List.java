package cinebro.lists.model;

public class List {
	private String id ;
	private String email ;
	private String list_title ;
	private int comments ;
	
	public List() {
		
	}
	public String getId() {
		return id;
	}


	public void setId(String id) {
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
	public int Comments() {
		return comments;
	}
	
	
	public void comments(int comments) {
		this.comments = comments;
	}
	
	

}