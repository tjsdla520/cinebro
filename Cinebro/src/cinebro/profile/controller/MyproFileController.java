package cinebro.profile.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.profile.model.Profile;
import cinebro.profile.model.ProfileDao;

public class MyproFileController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
			Profile bean = new Profile();
			ProfileDao dao = new ProfileDao();
			String email = request.getParameter("email") ;
			System.out.println(email);
			bean = dao.selectMyinfo(email);
			
			session.setAttribute("bean", bean);
			String gotopage = "/profile/myProfileDetail.jsp" ;
			super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}