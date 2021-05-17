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
import cinebro.lists.model.LikefilmListDao;


public class FilmListDetailController extends SuperClass {
	

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		FilmListDetailDao dao = new FilmListDetailDao();
		LikefilmListDao dao2 = new LikefilmListDao();
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		FilmList bean1 = dao.SelectByOne(id);
		FilmList bean2 = dao2.findLike(id,email);
		
		request.setAttribute("bean1", bean1);
		request.setAttribute("bean2", bean2);
		System.out.println("bean2 : "+bean2);
		System.out.println(bean2);
		String gotopage = "lists/filmListDetail.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}