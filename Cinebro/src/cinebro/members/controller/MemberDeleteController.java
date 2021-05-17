package cinebro.members.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.members.model.MemberDao;

public class MemberDeleteController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	
		String email  = request.getParameter("email");
		MemberDao dao = new MemberDao();
		int cnt = -99999;
		cnt = dao.DeleteData(email) ;
		
		super.session.invalidate();
		
		new MemberLogInController().doGet(request, response);
	
	
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
