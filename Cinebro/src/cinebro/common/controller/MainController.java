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
		
		//리뷰수 많은 영화 5개
//		FilmDao dao = new FilmDao();
//		List<Film> lists1 = dao.SelectDataList();
//		for (Film film : lists1) {
//		System.out.println("list1 : " + film);
//		}
//		request.setAttribute("lists1", lists1);
//		
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