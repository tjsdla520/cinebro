package cinebro.profile.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.profile.model.Profile;
import cinebro.profile.model.ProfileDao;

public class EditNicknameController extends SuperClass {
	Profile bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		bean = new Profile();
		String email = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		String film_title = request.getParameter("film_title");
		String genre_name = request.getParameter("genre_name");
		
		bean.setFilm_id(Integer.parseInt(request.getParameter("film_id")));
		bean.setEmail(email);
		bean.setNickname(nickname);
		bean.setFilm_title(film_title);
		bean.setGenre_name(genre_name);
		
		request.setAttribute("bean", bean);
		String gotopage = "/profile/myProfileUpdateForm.jsp" ;
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);

		bean = new Profile();
		String email = request.getParameter("email");
		bean.setEmail(email);
		bean.setNickname(request.getParameter("nickname"));
		bean.setFilm_id(Integer.parseInt(request.getParameter("filmid1")));
		bean.setGenre_id(Integer.parseInt(request.getParameter("genre")));
		System.out.println(bean);
		ProfileDao dao = new ProfileDao();
		
		if (this.validate(request) == true) { 
			System.out.println("member insert validation check success");
			int cnt = dao.editNickname(bean);
			
			bean = dao.selectMyinfo(email);
			request.setAttribute("bean", bean);
			String gotopage = "/profile/myProfileDetail.jsp" ;
			super.GotoPage(gotopage);
		}else {
			System.out.println("member insert validation check failure");
			request.setAttribute("bean", bean);
			super.doPost(request, response);
			String gotopage = "/profile/myProfileUpdateForm.jsp" ;
			super.GotoPage(gotopage);
		}
			
			
			
	}	
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true ;
//		// 유효성 검사 수행 예정
//		if (bean.getNickname().length() < 2 || bean.getNickname().length() > 8
//				|| bean.getNickname()==null || bean.getNickname()=="") {
//				request.setAttribute(super.PREFIX + "nickname", "닉네임은 2자리 이상 8자리 이하이어야 합니다.");
//				isCheck = false ;
//			}
		return isCheck ;
	}
}
