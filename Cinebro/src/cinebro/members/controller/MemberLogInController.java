package cinebro.members.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.ItemList;

import cinebro.common.controller.MainController;
import cinebro.common.controller.SuperClass;
import cinebro.members.model.Member;
import cinebro.members.model.MemberDao;


public class MemberLogInController extends SuperClass {
	private String email ;
	private String password  ;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	
		String gotopage = "/members/meLoginForm.jsp" ;
		super.GotoPage(gotopage);
	}	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true ; 
		
		if(this.password.length() < 4 || this.password.length() > 10) {
			request.setAttribute(super.PREFIX + "password", "비밀 번호는 4자리 이상 10자리 이하이어야 합니다."); 
			isCheck = false ;
		}
		return isCheck ;
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		this.email = request.getParameter("email") ;
		this.password = request.getParameter("password") ;
		
		System.out.println(email + "/" + password);
		
		String gotopage = "" ;
		
		MemberDao dao = new MemberDao();
		Member bean = dao.SelectData(email, password) ;
		if(bean==null) {
			System.out.println("로그인 실패");
			String message = "이메일 혹은 비밀 번호가 잘못되었습니다." ;
			super.setErrorMessage(message);
			gotopage = "/members/meLoginForm.jsp" ;
			super.GotoPage(gotopage); 	
		}else { 
			System.out.println("로그인 성공");
			super.session.setAttribute("loginfo", bean);
		
			// 메인 페이지로 이동합니다.
			new MainController().doGet(request, response); 
		}
//		if (this.validate(request) == true) {
//			System.out.println("유효성 검사에 문제 없슴");
//			
//			
//			
//			if (bean == null) { 
//				System.out.println("로그인 실패");
//				String message = "이메일 혹은 비밀 번호가 잘못되었습니다." ;
//				super.setErrorMessage(message);
//				gotopage = "/members/meLoginForm.jsp" ;
//				super.GotoPage(gotopage); 				
//			} else { 
//				System.out.println("로그인 성공");
//				super.session.setAttribute("loginfo", bean);
//				
				
//				MemberDao mdao = new MemberDao() ;
//				// 쇼핑에 장바구니가 있듯이 재생중인 영화를 바인딩
//				List<cinebro> lists = mdao.Getcinebro(bean.getId()) ;
//				if (lists.size() > 0) {
//					ItemList mycart = new ItemList(); 
//					// insert mycart for statement
//					for(cinebro shop : lists) {
//					}
//					super.session.setAttribute("mycart", mycart);
//				}
//				
//			
//			}
//			
//			
//		} else { // 문제가 있슴
//			// 이전에 입력했던 정보를 다시 바인딩해줍니다.
//			request.setAttribute("email", this.email);
//			request.setAttribute("password", this.password);
//			
//			gotopage = "/members/meLoginForm.jsp" ;
//			super.GotoPage(gotopage); 
//		}
	}
}