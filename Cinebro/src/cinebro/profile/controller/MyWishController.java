package cinebro.profile.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cinebro.common.controller.SuperClass;
import cinebro.profile.model.Profile;
import cinebro.profile.model.ProfileDao;



public class MyWishController extends SuperClass {
	
    @SuppressWarnings("unused")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		Profile bean = new Profile();
		ProfileDao dao = new ProfileDao();
		
        String email = request.getParameter("email");
        
        String nickname = request.getParameter("nickname");
		
		List<Profile> lists = dao.selectMyWish(email, nickname);
		
		request.setAttribute("lists", lists);
		
        request.setAttribute("bean", bean);
		

		String gotopage = "/profile/myWish.jsp" ;
		super.GotoPage(gotopage);
		
	}
    
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	}	
}
