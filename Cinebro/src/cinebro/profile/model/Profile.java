package cinebro.profile.model;

import cinebro.members.model.Member;

public class Profile extends Member{

	private String email; //로그인한사람 이메일
	private String password;  //로그인한사람 비밀번호
	private String nickname;  //로그인한사람 닉네임
	private String follwingemail; //내가 팔로우한사람 이메일
	private String following;	//내가 팔로우한사람 닉네임
	private int subscribe;	//나의 구독여부
	private String film_title;	//내가 종아하는 영화 제목
	private String genre_name;	// 내가 좋아아흔 영화 장르
	private String name;	// 카드이름
	private String cardnumber; //내카드정보
	private String film_id;
	private int genre_id;
	private int follower;           //나를 팔로우하는 사람 수 
	private int allReviews;         //내가 쓴 총 리뷰수
	
	
	
	public String getFilm_id() {
		return film_id;
	}
	public int getFollower() {
		return follower;
	}
	public void setFollower(int follower) {
		this.follower = follower;
	}
	public int getAllReviews() {
		return allReviews;
	}
	public void setAllReviews(int allReviews) {
		this.allReviews = allReviews;
	}
	public void setFilm_id(String film_id) {
		this.film_id = film_id;
	}
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public int getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}
	public String getFilm_title() {
		return film_title;
	}
	public void setFilm_title(String film_title) {
		this.film_title = film_title;
	}
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	@Override
	public String toString() {
		return "Profile [email=" + email + ", password=" + password + ", nickname=" + nickname + ", follwingemail="
				+ follwingemail + ", following=" + following + ", subscribe=" + subscribe + ", film_title=" + film_title
				+ ", genre_name=" + genre_name + ", name=" + name + ", cardnumber=" + cardnumber + ", film_id="
				+ film_id + ", genre_id=" + genre_id + ", follower=" + follower + ", allReviews=" + allReviews + "]";
	}

}