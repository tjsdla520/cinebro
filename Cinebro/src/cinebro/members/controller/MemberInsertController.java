package cinebro.members.controller;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cinebro.common.controller.SuperClass;
import cinebro.members.model.Member;
import cinebro.members.model.MemberDao;

public class MemberInsertController<PopularMember> extends SuperClass {
	
	private Object lists;
	Member bean = null;
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true ;
		// 유효성 검사 수행 예정
		
		if (bean.getNickname().length() < 2 || bean.getNickname().length() > 8
			|| bean.getNickname()==null || bean.getNickname()=="") {
			request.setAttribute(super.PREFIX + "nickname", "닉네임은 2자리 이상 8자리 이하이어야 합니다.");
			isCheck = false ;
		}
		
		var regex = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,8}";

		if (bean.getPassword().length() < 6 || bean.getPassword().length() > 8 
				|| bean.getPassword()==null || bean.getPassword()=="") {
			request.setAttribute(super.PREFIX + "password", "비밀 번호는 6-8자리 영문, 숫자, 특수 문자가 들어가야 합니다.");
			isCheck = false ;
		}
		
		boolean result = Pattern.matches(regex,bean.getPassword());
		if(result == false) {
			request.setAttribute(super.PREFIX + "password", "비밀 번호는 6-8자리 영문, 숫자, 특수 문자가 들어가야 합니다.");
			isCheck = false ;
		}
		
		
		return isCheck ;
	}
	
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
		bean = new  Member();
		
		bean.setEmail(request.getParameter("email"));
		bean.setPassword(request.getParameter("password"));	
		bean.setNickname(request.getParameter("nickname"));	
		
		MemberDao dao = new MemberDao();
		
		if(this.validate(request) == true) {
			System.out.println("member insert validation check success");
			int cnt = -99999;
			cnt = dao.insertData(bean);
			new MemberLogInController().doGet(request, response);
		}else {
			System.out.println("member insert validation check failure");
			request.setAttribute("bean", bean);
			super.doPost(request, response);
			String gotopage = "/members/meInsertForm.jsp" ;
			super.GotoPage(gotopage);
		}
		
		
		
	
	}	
}