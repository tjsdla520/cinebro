package cinebro.actor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.actor.model.Actor;
import cinebro.actor.model.ActorDao;
import cinebro.common.controller.SuperClass;
import cinebro.films.model.Film;
import cinebro.films.model.FilmDetailDao;
import cinebro.lists.model.FilmList;
import cinebro.lists.model.FilmListDao;
import cinebro.lists.model.FilmListDetailDao;
import cinebro.lists.model.LikefilmListDao;


public class ActorDetailController extends SuperClass {
	

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		ActorDao dao = new ActorDao();
		Actor bean = dao.selectActor(id); 
		request.setAttribute("bean", bean);
		String gotopage = "actors/actorDetail.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}