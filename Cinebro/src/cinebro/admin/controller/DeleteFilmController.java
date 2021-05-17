package cinebro.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.films.model.FilmDetailDao;
import cinebro.search.controller.SearchController;

public class DeleteFilmController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==0) {
			System.out.println("넘어오는 아이디값 0");
		}else {
		
		System.out.println(id+"영화 아이디값 화인");
		}
		FilmDetailDao dao = new FilmDetailDao();
		
		int cnt = -99999;
		
		cnt = dao.DeleteFilm(id);
		
		new SearchController().doGet(request, response);
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
