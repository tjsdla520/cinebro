package cinebro.following.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.following.model.MemberFollowDao;
import cinebro.profile.controller.MyFollowingController;
import cinebro.profile.controller.MyproFileController;


public class MemberFollowController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
//		Profile follow = new Profile();
		
		MemberFollowDao dao = new MemberFollowDao();
		String myemail = request.getParameter("myemail");
		String followemail = request.getParameter("followemail");
		System.out.println(myemail +followemail+"1차확인");
		int cnt = dao.followMember(myemail,followemail);

		
		new MyFollowingController().doGet(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		
	}	
}
