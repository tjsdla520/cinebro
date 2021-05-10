package cinebro.members.model;

public class Member {
	private String email;           //나의 이메일
	private String password;        //나의 비밀번호
	private String nickname;        //나의 닉네임
	private String cardnumber;      //나의 카드번호
	private String enddate;         //나의 카드만료일 
	private String name;	        //나의 카드에 명시되 이름
	private String favoriteFilm;    //내가 가장좋아하는 영화 제목
	private String favoriteGenre;   //내가 가장 좋아하는 장르
	private int follower;           //나를 팔로우하는 사람 수 
	private int allreviews;         //내가 쓴 총 리뷰수
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
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFavoriteFilm() {
		return favoriteFilm;
	}
	public void setFavoriteFilm(String favoriteFilm) {
		this.favoriteFilm = favoriteFilm;
	}
	public String getFavoriteGenre() {
		return favoriteGenre;
	}
	public void setFavoriteGenre(String favoriteGenre) {
		this.favoriteGenre = favoriteGenre;
	}
	public int getFollower() {
		return follower;
	}
	public void setFollower(int follower) {
		this.follower = follower;
	}
	public int getAllreviews() {
		return allreviews;
	}
	public void setAllreviews(int allreviews) {
		this.allreviews = allreviews;
	}
	@Override
	public String toString() {
		return "Member [email=" + email + ", password=" + password + ", nickname=" + nickname + ", cardnumber="
				+ cardnumber + ", enddate=" + enddate + ", name=" + name + ", favoriteFilm=" + favoriteFilm
				+ ", favoriteGenre=" + favoriteGenre + ", follower=" + follower + ", allreviews=" + allreviews + "]";
	}
	
	
}

