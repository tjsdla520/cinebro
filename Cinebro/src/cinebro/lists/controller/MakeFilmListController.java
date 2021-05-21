
package cinebro.lists.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;

import cinebro.lists.model.*;

public class MakeFilmListController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		String email = request.getParameter("email");
		request.setAttribute("email", email);
		String gotopage = "/lists/makeFilmListForm.jsp" ;
		super.GotoPage(gotopage);
	}	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		String email = request.getParameter("email");
		String title = request.getParameter("filmlist_title");
		String comments = request.getParameter("comments");
		int filmid1 = Integer.parseInt(request.getParameter("filmid1"));
		int filmid2 = Integer.parseInt(request.getParameter("filmid2"));
		int filmid3 = Integer.parseInt(request.getParameter("filmid3"));
		int filmid4 = Integer.parseInt(request.getParameter("filmid4"));
		int filmid5 = Integer.parseInt(request.getParameter("filmid5"));
		
		FilmListDao dao = new FilmListDao();
		FilmListDetailDao dao2 = new FilmListDetailDao();
		int cnt = dao.insertFilmList(title, comments, email);
		
		FilmList bean = dao2.SelectListByTitleAndEmail(title, email);
		int listid = bean.getId();
		
		int cnt2 = dao.insertMakeList(listid, filmid1);
		int cnt3 = dao.insertMakeList(listid, filmid2);
		int cnt4 = dao.insertMakeList(listid, filmid3);
		int cnt5 = dao.insertMakeList(listid, filmid4);
		int cnt6 = dao.insertMakeList(listid, filmid5);
		
		new FilmListController().doGet(request, response);
	}	
}