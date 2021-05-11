package cinebro.members.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.lists.model.FilmListDao;
import cinebro.members.model.MemberDao;


public class MemberLogOutController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		

//		// 나의 로그인 정보 및 관련 모든 것들을 비웁니다.
		super.session.invalidate(); 
		
		String gotopage = "/members/meLoginForm.jsp" ;
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}