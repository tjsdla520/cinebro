package cinebro.lists.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.films.model.Film;
import cinebro.lists.model.FilmListDao;
import cinebro.lists.model.LikefilmListDao;

public class DeleteLikeFilmListController extends SuperClass {
	

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		LikefilmListDao dao = new LikefilmListDao();
		String email = request.getParameter("email");
		System.out.println(email);
		String id = request.getParameter("id");
		int cnt = dao.deleteLikefilmList(email, id);
		
		new FilmListDetailController().doGet(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}