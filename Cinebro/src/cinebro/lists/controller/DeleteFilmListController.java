package cinebro.lists.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.lists.model.FilmListDao;
import cinebro.reviews.model.ReviewDao;

public class DeleteFilmListController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		FilmListDao dao = new FilmListDao();
		String id = request.getParameter("id");
		int cnt = dao.deleteFilmList(id);
		
		new FilmListController().doGet(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
