package cinebro.profile.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cinebro.common.controller.SuperClass;
import cinebro.profile.model.Profile;
import cinebro.profile.model.ProfileDao;
import cinebro.reviews.model.Review;


public class MyWishController extends SuperClass {
	//wishfilms
	
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		Profile bean = new Profile();
		ProfileDao dao = new ProfileDao();
		
	
	List<Profile> lists = new ArrayList<Profile>() ;
		
		request.setAttribute("bean", bean);
		

		String gotopage = "/profile/myWish.jsp" ;
		super.GotoPage(gotopage);
		
	}
    
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		Profile bean = new Profile();
		ProfileDao dao = new ProfileDao();

	}	
}
