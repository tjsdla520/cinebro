package cinebro.following.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.members.model.Member;
import cinebro.members.model.MemberDao;

public class MemberListController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		MemberDao dao = new MemberDao();
		String email = request.getParameter("email");
		////////////////////인기많은 멤버 추출
		List<Member> lists1 = dao.popularMember();
		request.setAttribute("lists1", lists1);
		////////////////////리뷰많은 멤버 추출
		List<Member> lists2 = dao.manyReviewMember();
		request.setAttribute("lists2", lists2);
		///////////////////내가 팔로우한 멤버 추출
		List<Member> lists3 = dao.followingMember(email);
		for (Member member : lists3) {
			System.out.println(member);
		}
		request.setAttribute("lists3", lists3);
		
		String gotopage = "/members/memberList.jsp" ;
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
