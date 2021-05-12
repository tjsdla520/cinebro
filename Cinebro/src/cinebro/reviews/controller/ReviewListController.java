package cinebro.reviews.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.films.model.Film;
import cinebro.films.model.FilmDetailDao;
import cinebro.reviews.model.Review;
import cinebro.reviews.model.ReviewDao;

public class ReviewListController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		FilmDetailDao dao1 = new FilmDetailDao();
		List<Film> popularFilms = dao1.selectPopularFilm();
		request.setAttribute("popularFilm", popularFilms);
		
		
		ReviewDao dao2 = new ReviewDao();
		List<Review> reviewLists = dao2.selectPopularReview();
		
		request.setAttribute("reviewlists", reviewLists);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
