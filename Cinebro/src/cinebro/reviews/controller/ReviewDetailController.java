package cinebro.reviews.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.reviews.model.LikeReviewDao;
import cinebro.reviews.model.Review;
import cinebro.reviews.model.ReviewDao;

public class ReviewDetailController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		Review bean1 = new Review();
		Review bean2 = new Review();
		ReviewDao dao1 = new ReviewDao();
		LikeReviewDao dao2 = new LikeReviewDao();
		//해당 리뷰 상세정보 가져오기
		bean1 = dao1.selectReview(request.getParameter("id"));
		//내가 해당리뷰 좋아요 했는지 여부 가져오기
		bean2 = dao2.findlike(request.getParameter("email"),request.getParameter("id"));
		System.out.println("bean2 : "+bean2);
		System.out.println(bean2);
		session.setAttribute("bean1", bean1);
		session.setAttribute("bean2", bean2);
		String gotopage = "/reviews/reviewDetail.jsp";
		super.GotoPage(gotopage);
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
