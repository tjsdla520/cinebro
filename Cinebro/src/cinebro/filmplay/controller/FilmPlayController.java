package cinebro.filmplay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.films.model.Film;
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
		request.setAttribute("list2", list2);
		for (Film film : list2) {
			System.out.println("보고싶어요 한 영화들 : "+film);
		}
		
		String gotopage = "/filmwatch/filmPlay.jsp" ;
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
