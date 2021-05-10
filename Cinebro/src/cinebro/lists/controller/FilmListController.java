package cinebro.lists.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.films.model.Film;
import cinebro.lists.model.FilmListDao;

public class FilmListController extends SuperClass {
	private static final String email = null;

	//selectByLike(email),selectByPopular(),selectByAdmin()
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		FilmListDao dao = new FilmListDao();
		List<Film> lists = dao.SelectDataList(0, 0);
		FilmListDao dao1 = new FilmListDao();
		List<Film> lists1 = dao1.SelectByLike(email);
		FilmListDao dao2 = new FilmListDao();
		List<Film> lists2 = dao2.SelectByPopular();
		FilmListDao dao3 = new FilmListDao();
		List<Film> lists3 = dao3.SelectByAdmin();
		
		request.setAttribute("lists", lists1);
		
		String gotopage = "/film/filmList.jsp" ;
		super.GotoPage(gotopage);
	}	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}