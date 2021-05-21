package cinebro.lists.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.lists.model.FilmList;
import cinebro.lists.model.FilmListDao;
import cinebro.lists.model.FilmListDetailDao;
import cinebro.reviews.model.Review;
import cinebro.reviews.model.ReviewDao;

public class EditFilmListController extends SuperClass {
	ReviewDao dao = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String gotopage = "/lists/editFilmListForm.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		String id = request.getParameter("id");
		String title = request.getParameter("filmlist_title");
		String comments = request.getParameter("comments");
		int filmid1 = Integer.parseInt(request.getParameter("filmid1"));
		int filmid2 = Integer.parseInt(request.getParameter("filmid2"));
		int filmid3 = Integer.parseInt(request.getParameter("filmid3"));
		int filmid4 = Integer.parseInt(request.getParameter("filmid4"));
		int filmid5 = Integer.parseInt(request.getParameter("filmid5"));
		
		FilmListDao dao = new FilmListDao();
		FilmListDetailDao dao2 = new FilmListDetailDao();
		int cnt = dao.updateFilmList(id, title, comments);
		
		int cnt3 = dao.deleteMakeList(Integer.parseInt(id));
		int cnt2 = dao.insertMakeList(Integer.parseInt(id), filmid1);
		int cnt4 = dao.insertMakeList(Integer.parseInt(id), filmid2);
		int cnt5 = dao.insertMakeList(Integer.parseInt(id), filmid3);
		int cnt6 = dao.insertMakeList(Integer.parseInt(id), filmid4);
		int cnt7 = dao.insertMakeList(Integer.parseInt(id), filmid5);
		new FilmListController().doGet(request, response);

	}	
}
