package cinebro.profile.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.following.model.MemberFollowDao;
import cinebro.members.model.Member;
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
			
			//해당 멤버 팔로우 여부 확인하는 메서드
			MemberFollowDao dao2 = new MemberFollowDao();
			Member member = (Member)super.session.getAttribute("loginfo");
			String myemail = member.getEmail();
			Profile bean2 = dao2.findFollow(myemail, email);
			System.out.println("bean2 : "+bean2);
			System.out.println(bean2);
			request.setAttribute("bean", bean);
			request.setAttribute("bean2", bean2);
			String gotopage = "/profile/myProfileDetail.jsp" ;
			super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}