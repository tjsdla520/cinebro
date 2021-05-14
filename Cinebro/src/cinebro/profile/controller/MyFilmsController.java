package cinebro.profile.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.films.model.Film;
import cinebro.films.model.FilmDao;


public class MyFilmsController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		FilmDao dao = new FilmDao();
		String email = request.getParameter("email");

//////////////////////////내가본 영화 조회
		List<Film> lists = dao.selectWatchedFilms(email);
		for (Film filmList : lists) {
			System.out.println("list : " + filmList);
		}
		request.setAttribute("lists", lists);
		
		String gotopage = "/profile/myFilms.jsp" ;
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
