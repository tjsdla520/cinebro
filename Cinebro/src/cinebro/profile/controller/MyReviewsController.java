package cinebro.profile.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.profile.model.ProfileDao;
import cinebro.reviews.model.Review;
import cinebro.reviews.model.ReviewDao;

public class MyReviewsController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String email = request.getParameter("email");
		ReviewDao dao = new ReviewDao();
				
		List<Review> reviews = dao.selectMyreviews(email);
		
		request.setAttribute("Review", reviews);
				
        String gotopage = "/profile/myReviews.jsp" ;
	    super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}