package cinebro.profile.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.profile.model.Profile;
import cinebro.profile.model.ProfileDao;

public class EditNicknameController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String email = request.getParameter("email");
		request.setAttribute("email", email);
		String gotopage = "/profile/myProfileUpdateForm.jsp" ;
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);

		Profile bean = new Profile();
		ProfileDao dao = new ProfileDao();
		String email = request.getParameter("email");
		int genre = Integer.parseInt(request.getParameter("genre"));
		int filmid1 = Integer.parseInt(request.getParameter("filmid1"));

		bean.setEmail(email);
		bean.setPassword(request.getParameter("password"));
		bean.setNickname(request.getParameter("nickname"));
		bean.setFilm_id(filmid1);
		bean.setGenre_id(genre);
		System.out.println(bean);
		
		int cnt = dao.editNickname(bean);
		
		bean = dao.selectMyinfo(email);
		request.setAttribute("bean", bean);
		String gotopage = "/profile/myProfileDetail.jsp" ;
		super.GotoPage(gotopage);
	}	
}
