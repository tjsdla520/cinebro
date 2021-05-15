package cinebro.following.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.profile.controller.MyproFileController;
import cinebro.profile.model.Profile;
import cinebro.profile.model.ProfileDao;

public class MemberFollowController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		ProfileDao dao = new ProfileDao();
		
		String followemail = request.getParameter("email2");
		String myemail = request.getParameter("email1");
		System.out.println(myemail +"확인");
		int cnt = dao.followMember(myemail, followemail);
		
		new MyproFileController().doGet(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
