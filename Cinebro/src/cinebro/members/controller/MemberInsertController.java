package cinebro.members.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.MainController;
import cinebro.common.controller.SuperClass;
import cinebro.members.model.Member;
import cinebro.members.model.MemberDao;

public class MemberInsertController<PopularMember> extends SuperClass {
	
	private Object lists;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
			
		request.setAttribute("lists", lists);
	
		String gotopage = "/members/meInsertForm.jsp" ;
		super.GotoPage(gotopage);
	}	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		Member bean = new  Member();
		
		bean.setEmail(request.getParameter("email"));
		bean.setPassword(request.getParameter("password"));	
		bean.setNickname(request.getParameter("nickname"));	
		
		MemberDao dao = new MemberDao();
		
		int cnt = -99999;
		cnt = dao.insertData(bean);
		
		new MemberLogInController().doGet(request, response);
	
	}	
}