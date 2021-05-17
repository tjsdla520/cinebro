package cinebro.pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.members.model.Member;
import cinebro.members.model.MemberDao;



public class PayController extends SuperClass {
	Member bean = null;
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true ;
		// 유효성 검사 수행 예정
		if (bean.getName()==null || bean.getName().equals("")) {
			request.setAttribute(super.PREFIX + "name", "이름을 입력해주세요.");
			isCheck = false ;
		}
		if (bean.getCardnumber().length() != 16 || bean.getCardnumber() == null || bean.getCardnumber().equals("") ) {
			request.setAttribute(super.PREFIX + "cardnumber", "카드 번호 16자리를 입력해주세요");
			isCheck = false ;
		}
		if (bean.getCardpassword().length() != 4 || bean.getCardpassword() == null || bean.getCardpassword().equals("") ) {
			request.setAttribute(super.PREFIX + "cardpassword", "카드 비밀번호 4자리를 입력해주세요");
			isCheck = false ;
		}
		if (bean.getEnddate().length() != 4 || bean.getEnddate() == null || bean.getEnddate().equals("") ) {
			request.setAttribute(super.PREFIX + "enddate", "카드 만료일을 입력해주세요.");
			isCheck = false ;
		}
		
		return isCheck ;
	}
	
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
		
		bean = new Member();
		bean.setEmail(request.getParameter("email"));
		bean.setName(request.getParameter("name"));
		bean.setCardnumber(request.getParameter("cardnumber"));
		bean.setCardpassword(request.getParameter("cardpassword"));
		bean.setEnddate(request.getParameter("enddate"));
		
		System.out.println(bean);
		MemberDao dao = new MemberDao();
		
		if (this.validate(request) == true) { 
			System.out.println("member insert validation check success");
			int cnt = -99999 ; 
			cnt = dao.insertPayInfo(bean) ;
			request.setAttribute("bean", bean);
			String gotopage = "/filmwatch/payConfirm.jsp";
			super.GotoPage(gotopage);
			
		} else {
			System.out.println("member insert validation check failure");
			request.setAttribute("bean", bean);
			super.doPost(request, response);
			String gotopage = "/filmwatch/payForm.jsp";
			super.GotoPage(gotopage);
			
		}
		
			
	}
	
	
	
	
}