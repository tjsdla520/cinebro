package cinebro.reviews.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.films.controller.FilmDetailController;
import cinebro.films.model.FilmDao;
import cinebro.reviews.model.WishFilmDao;

public class WishFilmController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		FilmDao dao = new FilmDao();
		int cnt = dao.insertWishFilm(id, email);
		
		new FilmDetailController().doGet(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
