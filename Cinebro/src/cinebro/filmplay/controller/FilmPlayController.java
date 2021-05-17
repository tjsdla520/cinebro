package cinebro.filmplay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.films.model.Film;
import cinebro.films.model.FilmDao;
import cinebro.genres.model.Genre;
import cinebro.genres.model.GenreDao;
import cinebro.profile.model.ProfileDao;

public class FilmPlayController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		//전체 장르 리스트 
		GenreDao dao = new GenreDao();
		List<Genre> list1 = dao.selectAllGenres();
		request.setAttribute("list1", list1);
		
		//보고싶어요 누른 영화들 중에서 URL 있는거
		
		String email = request.getParameter("email");
		ProfileDao dao2 = new ProfileDao();
		
		List<Film> list2 = dao2.selectMywish(email);
		int list2size = list2.size();
		System.out.println("보고싶어요 영화 개수 : "+list2size);
		int endpage2 = (int) Math.ceil((double)list2size/5);
		System.out.println("보고싶어요 영화 총 페이지 수 : " + endpage2);
		request.setAttribute("endpage2", endpage2);
		request.setAttribute("list2", list2);
		for (Film film : list2) {
			System.out.println("보고싶어요 한 영화들 : "+film);
		}
		
		//재생URL있는 영화 중에서 평점 총 개수 5개 이상인 것 중에서 평점순으로 상위 10개 가져오기 
		FilmDao dao3 = new FilmDao();
		List<Film> list3 = dao3.selectByRatingUrl();
		int list3size = list3.size();
		System.out.println("평점 높은 영화 개수 : "+list3size);
		int endpage3 = (int)Math.ceil((double)list3size/5);
		System.out.println("list3 총 페이지 : "+endpage3);
		request.setAttribute("endpage3", endpage3);
		request.setAttribute("list3", list3);
		for (Film film : list3) {
			System.out.println("평점 높은 영화 : "+film);
		}
				
		String gotopage = "/filmwatch/filmPlay.jsp" ;
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
