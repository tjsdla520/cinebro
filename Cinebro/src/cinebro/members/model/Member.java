package cinebro.members.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	
}

