
package cinebro.reviews.model;

import java.util.Date;

public class Review {
	
	private int id;               //리뷰 아이디
	private String writer;        //리뷰어
	private int filmId;            //영화아이디
	private String filmTitle;     //영화제목
	private String content;       //리뷰내용
	private int liked;            //좋아요 여부
	private int watched;          //봤어요 여부
	private Date watchDate;       //영화 본 날짜
	private Date writeDate;       //리뷰 쓴 날짜 
	private int getlike;          //받은 좋아요 수
	private int rating;           //평점
	private String nickname;      //나의 닉네임
	private String email;         //나의 이메일
	
	
	public int getFilmId() {
		return filmId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getFilmTitle() {
		return filmTitle;
	}


	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getLiked() {
		return liked;
	}


	public void setLiked(int liked) {
		this.liked = liked;
	}


	public int getWatched() {
		return watched;
	}


	public void setWatched(int watched) {
		this.watched = watched;
	}


	public Date getWatchDate() {
		return watchDate;
	}


	public void setWatchDate(Date watchDate) {
		this.watchDate = watchDate;
	}


	public Date getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}


	public int getGetlike() {
		return getlike;
	}


	public void setGetlike(int getlike) {
		this.getlike = getlike;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", writer=" + writer + ", filmId=" + filmId + ", filmTitle=" + filmTitle
				+ ", content=" + content + ", liked=" + liked + ", watched=" + watched + ", watchDate=" + watchDate
				+ ", writeDate=" + writeDate + ", getlike=" + getlike + ", rating=" + rating + ", nickname=" + nickname
				+ ", email=" + email + "]";
	}

	}
	
	
	
