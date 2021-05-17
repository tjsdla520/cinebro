package cinebro.members.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.members.model.Member;
import cinebro.members.model.MemberDao;

public class MemberEmailCheckController extends SuperClass {
	
	Member bean = null;
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true ;
		
		var regExp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}";

		
		if(bean.getEmail().length() == 0 ||bean.getEmail()==null || bean.getEmail()=="" ) {
			request.setAttribute(super.PREFIX + "email", "이메일은 '@' 와 ','이 포함되어야 합니다.");
			isCheck = false;
		}
		
		boolean result = Pattern.matches(regExp, bean.getEmail());
		if(result == false) {
			request.setAttribute(super.PREFIX + "email", "이메일은 '@' 와 ','이 포함되어야 합니다.");
		}
		
		return isCheck ;
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String email = request.getParameter("email") ;
		MemberDao dao = new MemberDao();
		bean = dao.selectDataByEmail(email);
		
		if(this.validate(request) == true) {	
			if(bean==null) { //존재하지 않는 아이디
				request.setAttribute("message", email+"은(는) <font color = 'blue'><b>사용 가능</b></font>합니다.");
				request.setAttribute("isCheck", true);
			}else { //아이디기 있어서 객체를 생성해줌.
				if(bean.getEmail().equals("admin")) {//for 관리자
					request.setAttribute("message", "admin은 <font color = 'red'><b>사용 불가능</b></font>한 아이디입니다.");
					request.setAttribute("isCheck", false);
				}else { //일반사용자ㄴㄴ
					request.setAttribute("message", email + "은(는) 이미 <font color = 'red'><b>사용중</b></font>인 아이디입니다.");
					request.setAttribute("isCheck", false);
				}
			}
			String gotopage = "/members/emailCheck.jsp" ;
			super.GotoPage(gotopage);
		}else {
			request.setAttribute("bean", bean);
			super.doGet(request, response);
			String gotopage = "/members/emailCheck.jsp" ;
			super.GotoPage(gotopage);
		}
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}