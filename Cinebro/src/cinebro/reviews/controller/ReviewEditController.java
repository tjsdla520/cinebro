package cinebro.reviews.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.reviews.model.Review;
import cinebro.reviews.model.ReviewDao;

public class ReviewEditController extends SuperClass {
	ReviewDao dao = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		String gotopage = "/reviews/reviewEditForm.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		Review bean = new Review();
		ReviewDao dao = new ReviewDao();
		String id = request.getParameter("id");
		bean.setContent(request.getParameter("content"));
		bean.setRating(Integer.parseInt(request.getParameter("rating")));
		bean.setId(Integer.parseInt(id));
		System.out.println(bean);
		
		int cnt = dao.editReview(bean);
		
		bean = dao.selectReview(id);		
		session.setAttribute("bean", bean);
		String gotopage = "/reviews/reviewDetail.jsp";
		super.GotoPage(gotopage);

	}	
}
