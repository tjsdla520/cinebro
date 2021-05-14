package cinebro.profile.model;

public class Profile {

	private String email;
	private String password;
	private String nickname;
	private String follwingemail;
	private String following;
	
	
	
	
	public String getFollwingemail() {
		return follwingemail;
	}
	public void setFollwingemail(String follwinemail) {
		this.follwingemail = follwinemail;
	}
	public String getFollowing() {
		return following;
	}
	public void setFollowing(String following) {
		this.following = following;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
}