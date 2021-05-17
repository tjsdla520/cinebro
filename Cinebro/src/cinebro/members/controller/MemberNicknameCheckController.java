package cinebro.members.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.members.model.Member;
import cinebro.members.model.MemberDao;

public class MemberNicknameCheckController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
				
		String nickname = request.getParameter("nickname") ;
		MemberDao dao = new MemberDao();
		
		Member bean = dao.selectDataByNickname(nickname);
		
		if(bean==null) { //존재하지 않는 아이디
			request.setAttribute("message", nickname+"은(는) <font color = 'blue'><b>사용 가능</b></font>합니다.");
			request.setAttribute("isCheck", true);
		}else { //아이디기 있어서 객체를 생성해줌.
			if(bean.getNickname().equals("admin")) {//for 관리자
				request.setAttribute("message", "admin은 <font color = 'red'><b>사용 불가능</b></font>한 아이디입니다.");
				request.setAttribute("isCheck", false);
			}else { //일반사용자ㄴㄴ
				request.setAttribute("message", nickname + "은(는) 이미 <font color = 'red'><b>사용중</b></font>인 아이디입니다.");
				request.setAttribute("isCheck", false);
			}
		}
		String gotopage = "/members/nicknameCheck.jsp" ;
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
