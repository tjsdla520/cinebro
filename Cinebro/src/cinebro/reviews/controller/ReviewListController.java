
package cinebro.reviews.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.members.model.Member;
import cinebro.reviews.model.Review;
import cinebro.reviews.model.ReviewDao;

public class ReviewListController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		ReviewDao dao = new ReviewDao();
		List<Review> popularReviews = dao.selectPopularReview();
		
		request.setAttribute("popularReviews", popularReviews);
		
		System.out.println("리스트값 보기");
		for (Review review : popularReviews) {
			System.out.println(review);
		}
		
		Member member = (Member)session.getAttribute("loginfo");
		if(member!=null) {
		String email = member.getEmail();
		System.out.println(email);
		List<Review> mylikeReviews = dao.selectLikeReview(email);
		request.setAttribute("mylikeReviews", mylikeReviews);
		System.out.println("리스트값 보기");
		for (Review review : mylikeReviews) {
			System.out.println(review);
		}
		}
		String gotopage = "/reviews/reviewList.jsp" ;
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
