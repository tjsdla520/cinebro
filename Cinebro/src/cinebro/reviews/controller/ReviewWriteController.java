
package cinebro.reviews.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.reviews.model.ReviewDao;

public class ReviewWriteController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String filmid = request.getParameter("id");
		String gotopage = "/reviews/reviewWriteForm.jsp?id="+filmid;
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		ReviewDao dao = new ReviewDao();
		
		int id = Integer.parseInt(request.getParameter("filmid"));
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		int rating = Integer.parseInt(request.getParameter("rating"));
		
		int cnt = dao.insertReview(email, id, content, rating);
		
		new ReviewListController().doGet(request, response);
	}	
}
