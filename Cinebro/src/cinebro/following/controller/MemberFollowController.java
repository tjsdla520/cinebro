package cinebro.following.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.profile.controller.MyFollowingController;
import cinebro.profile.controller.MyproFileController;
import cinebro.profile.model.Profile;
import cinebro.profile.model.ProfileDao;
import cinebro.reviews.controller.ReviewDetailController;

public class MemberFollowController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
//		Profile follow = new Profile();
		
		ProfileDao dao = new ProfileDao();
		String myemail = request.getParameter("email1");
		String followemail = request.getParameter("email2");
		System.out.println(myemail +followemail+"1차확인");
		int cnt = dao.followMember(myemail,followemail);
		
//		follow = dao.followMember(myemail, followemail);
//		request.setAttribute("follow", follow);
//		System.out.println(follow.getName() + follow.getFollwingemail()+"3차확인");
	
		//follow에 있는 follwingemail가 
		//new MyproFileController().doGet(request, response); 여기로 가야함	
		
		request.setAttribute("email", myemail);
		new MyFollowingController().doGet(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		
	}	
}
