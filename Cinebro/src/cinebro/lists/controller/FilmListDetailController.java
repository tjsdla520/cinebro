package cinebro.lists.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.films.model.FilmDetailDao;
import cinebro.lists.model.FilmListDao;
import cinebro.lists.model.FilmListDetailDao;


public class FilmListDetailController extends SuperClass {
	
	private Object id;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int num = Integer.parseInt(request.getParameter("num")) ;
		
		FilmListDao dao = new FilmListDao();
		
		FilmListDetailDao bean = dao.SelectByOne(id) ; 
		
		if (bean == null) {
			new FilmListController().doGet(request, response);
			
		} else {
			request.setAttribute("bean", bean);
			String gotopage = "/product/prDetailView.jsp" ;
			super.GotoPage(gotopage);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}