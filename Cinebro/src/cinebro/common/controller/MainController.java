package cinebro.common.controller ;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.films.model.Film;
import cinebro.films.model.FilmDao;
import cinebro.lists.model.FilmList;
import cinebro.lists.model.FilmListDao;
import cinebro.reviews.model.Review;
import cinebro.reviews.model.ReviewDao;

public class MainController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		//리뷰수 많은 영화 10개
		FilmDao dao = new FilmDao();
		List<Film> list1 = dao.selectFamousFilms();
		int list1size = list1.size();
		System.out.println("인기많은 영화 10개 개수 : "+list1size);
		int endpage = (int)Math.ceil((double)list1size/5);
		System.out.println("list1 총 페이지 : "+endpage);
		request.setAttribute("endpage1", endpage);
		request.setAttribute("list1", list1);
		for (Film film : list1) {
			System.out.println("인기영화 : " + film);
		}
		request.setAttribute("lists1", list1);
		
		//평점 총 개수 5개 이상인 것 중에서 평점순으로 상위 10개 가져오기 
		FilmDao dao4 = new FilmDao();
		List<Film> list4 = dao4.selectByRatingFilm();
		int list4size = list4.size();
		System.out.println("평점 높은 영화 개수 : "+list4size);
		int endpage4 = (int)Math.ceil((double)list4size/5);
		System.out.println("list4 총 페이지 : "+endpage4);
		request.setAttribute("endpage4", endpage4);
		request.setAttribute("list4", list4);
		for (Film film : list4) {
			System.out.println("평점 높은 영화 : "+film);
		}
		
		//좋아요 많은 필름리스트 5개
		FilmListDao dao2 = new FilmListDao();
		List<FilmList> lists2 = dao2.SelectByPopular();
		
		for (FilmList filmList : lists2) {
		System.out.println("list2 : "+filmList);
		}
		
		request.setAttribute("lists2", lists2);
	
		//좋아요 많은 리뷰 5개	
		ReviewDao dao3 = new ReviewDao();
		List<Review> lists3 = dao3.selectPopularReview();
		
		for (Review review : lists3) {
		System.out.println("list3 : "+review);
		}
		request.setAttribute("lists3", lists3);
		
		String gotopage = "/anime-main/main.jsp" ;
		super.GotoPage(gotopage);
		}
}