package cinebro.lists.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.films.model.Film;
import cinebro.films.model.FilmDetailDao;
import cinebro.lists.model.FilmList;
import cinebro.lists.model.FilmListDao;
import cinebro.lists.model.FilmListDetailDao;


public class FilmListDetailController extends SuperClass {
	

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		FilmListDetailDao dao = new FilmListDetailDao();
		String id = request.getParameter("id");
		
		FilmList bean = dao.SelectByOne(id);
		
		request.setAttribute("bean", bean);
		
		String gotopage = "lists/filmListDetail.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}