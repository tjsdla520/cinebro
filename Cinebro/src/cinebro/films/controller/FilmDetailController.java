
package cinebro.films.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.films.model.Film;
import cinebro.films.model.FilmDetailDao;
import cinebro.films.model.LikeFilmDao;

public class FilmDetailController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		System.out.println("로그인 이메일 : "+email);
		
		FilmDetailDao dao = new FilmDetailDao();
		LikeFilmDao dao2 = new LikeFilmDao();
		Film fbean = dao.selectFilm(id);
		
		List<String> f = fbean.getGenres();
		System.out.println("장르리스트 사이즈 : "+f.size());
		for (String genre : f) {
			System.out.println("장르는" +genre);
		}
		
		List<String> l = fbean.getActors();
		System.out.println("배우리스트 사이즈 : "+l.size());
		for (String actor : l) {
			System.out.println("배우는" +actor);
		}
		
		//해당 영화 좋아요 눌렀는지 여부 확인하는 매서드
		Film fbean2 = dao2.findLike(id, email);
		System.out.println("bean2 : "+fbean2);
		System.out.println(fbean2);
		request.setAttribute("fbean2", fbean2);
		request.setAttribute("fbean", fbean);
		String gotopage = "/reviews/filmDetail.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}
