package cinebro.profile.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cinebro.common.controller.SuperClass;
import cinebro.films.model.Film;
import cinebro.profile.model.Profile;
import cinebro.profile.model.ProfileDao;



public class MyWishController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String email = request.getParameter("email");
		ProfileDao dao = new ProfileDao();
		
		List<Film> lists = dao.selectMywish(email);
		request.setAttribute("lists", lists);
		for (Film film : lists) {
			System.out.println(film);
		}
		String gotopage = "/profile/myWish.jsp" ;
		super.GotoPage(gotopage);		
	}
    
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	}	
}
