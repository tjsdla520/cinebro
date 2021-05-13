package cinebro.profile.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.profile.model.Profile;
import cinebro.profile.model.ProfileDao;

public class MyFollowingController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		ProfileDao dao = new ProfileDao();
		
		String email = request.getParameter("email");
		
		List<Profile> lists = dao.selectMyfollowing(email);
		
		request.setAttribute("lists", lists);
		
		String gotopage = "/profile/myFollowing.jsp" ;
		
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
