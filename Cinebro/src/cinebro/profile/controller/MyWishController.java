package cinebro.profile.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.members.model.Member;
import cinebro.profile.model.ProfileDao;
import cinebro.reviews.model.ReviewDao;

public class MyWishController extends SuperClass {
	
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		 
		
		String gotopage = "/profile/myWish.jsp" ;
		super.GotoPage(gotopage);
		
	}
    
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);

	}	
}
