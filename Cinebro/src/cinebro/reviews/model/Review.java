

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
	
	
	
	public int getFilmId() {
		return filmId;
	}



	public void setFilmId(int filmId) {
		this.filmId = filmId;
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



	@Override
	public String toString() {
		return "Review [id=" + id + ", writer=" + writer + ", filmTitle=" + filmTitle + ", content=" + content
				+ ", liked=" + liked + ", watched=" + watched + ", watchDate=" + watchDate + ", writeDate=" + writeDate
				+ ", getlike=" + getlike + ", rating=" + rating + "]";
	}
	
	
	
}