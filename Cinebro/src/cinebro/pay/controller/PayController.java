package cinebro.pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.members.model.Member;
import cinebro.members.model.MemberDao;



public class PayController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String gotopage = "/filmwatch/payForm.jsp";
		super.GotoPage(gotopage);
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		System.out.println("pay controller dopost");
		
		Member bean = new Member();
		bean.setEmail(request.getParameter("email"));
		bean.setCardnumber(request.getParameter("cardnumber"));
		bean.setName(request.getParameter("name"));
		bean.setEnddate(request.getParameter("enddate"));
		
		System.out.println(bean);
		MemberDao dao = new MemberDao();
		int cnt = dao.insertPayInfo(bean);
		request.setAttribute("bean", bean);
		String gotopage = "/filmwatch/payConfirm.jsp";
		super.GotoPage(gotopage);
			
	}
}