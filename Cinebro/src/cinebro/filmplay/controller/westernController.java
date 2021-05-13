package cinebro.filmplay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.films.model.Film;
import cinebro.films.model.FilmDao;



public class westernController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String email = request.getParameter("email");
		String genre = request.getParameter("genre") ;
		FilmDao dao = new FilmDao();
		
//		Film bean = dao.SelectDataByPk(genre) ;
//////
		String mode = request.getParameter("mode");
		
		
		if(mode==null||mode.equals("")||mode.equals("all")) {
			List<Film> films = dao.SelectDataWestern(genre);
		
			request.setAttribute("films", films);
			
		}
//		else if(mode.equals("like")) {
//			List<Film> films = dao.SelectDataByPk(genre);
//			
//			request.setAttribute("lists", lists);
//			
//		}else if(mode.equals("popular")) {
//			List<FilmList> lists = dao.SelectByPopular();
//			
//			request.setAttribute("lists", lists);
				
		
		
		
///////
		
			
		String gotopage = "/filmwatch/genrePlay.jsp" ;
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}