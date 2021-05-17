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



public class GenrePlayController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String id = request.getParameter("id");
		String name = request.getParameter("name") ;
		FilmDao dao = new FilmDao();
		
		List<Film> films = dao.SelectDataByPk(id);
		
		//전체 장르정보 가져오기
		GenreDao dao2 = new GenreDao();
		List<Genre> list1 = dao2.selectAllGenres();
		request.setAttribute("list1", list1);
		
		request.setAttribute("films", films);
		request.setAttribute("genreid", id);
		request.setAttribute("genrename", name);

		String gotopage = "/filmwatch/genrePlay.jsp" ;
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}