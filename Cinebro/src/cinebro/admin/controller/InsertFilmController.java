package cinebro.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import cinebro.common.controller.SuperClass;
import cinebro.films.model.Film;
import cinebro.films.model.FilmDao;
import cinebro.films.model.FilmDetailDao;
import cinebro.search.controller.SearchController;

public class InsertFilmController extends SuperClass {
	private Film bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String gotopage = "/profile/InsertFilmForm.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cnt = -99999 ; 
		
		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi");
		bean = new Film();
		
		System.out.println(multi.getParameter("film_title")+"테스트");
		bean.setFilm_title(multi.getParameter("film_title"));
		bean.setImage(multi.getFilesystemName("image"));
		bean.setDirector(multi.getParameter("director"));
		bean.setYear(Integer.parseInt(multi.getParameter("year")));
		bean.setCountry(multi.getParameter("country"));
				
		String genre = multi.getParameter("genre");
		String actorid1 = multi.getParameter("actorid1");
		String actorid2 = multi.getParameter("actorid2");
		
		if (multi.getParameter("playUrl") == null || multi.getParameter("playUrl").equals("")) {
			bean.setPlayUrl("");	
		}else {
			bean.setPlayUrl(multi.getParameter("playUrl"));
		}
				
		if (this.validate(request) == true) { 
			System.out.println("member insert validation check success");
			//새로운 영화 값 넣기
			FilmDetailDao dao = new FilmDetailDao();
			cnt = dao.InsertFilm(bean);
			
			//방금 추가한 영화의 id 값 가져오기
			int filmid = dao.selectFilmByTitlenDirector(multi.getParameter("film_title"), multi.getParameter("director"));
			
			//장르 값 넣기
			cnt = dao.insertFilmnGenre(filmid, genre);
			//영화배우1 값 넣기
			cnt = dao.insertFilmnActor(filmid, actorid1);
			//영화배우2 값 넣기
			cnt = dao.insertFilmnActor(filmid, actorid2);
			new SearchController().doGet(request, response);		
			
		} else {
			System.out.println("member insert validation check failure");
			super.doPost(request, response);
			request.setAttribute("bean", bean);
			String gotopage = "/profile/InsertFilmForm.jsp" ;
			super.GotoPage(gotopage);
		}
	}	
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;
		
		if(bean.getFilm_title()==null || bean.getFilm_title().equals("")) {
			request.setAttribute(super.PREFIX + "film_title", "영화 제목은 필수입력 사항입니다.");
			isCheck = false;
		}
		
		if(bean.getDirector()==null || bean.getDirector().equals("")) {
			request.setAttribute(super.PREFIX + "director", "영화 감독은 필수입력 사항입니다.");
			isCheck = false;
		}
		if(bean.getYear()==0) {
			request.setAttribute(super.PREFIX + "year", "개봉년도는 필수입력 사항입니다.");
			isCheck = false;
		}
		if(bean.getCountry()==null || bean.getCountry().equals("")) {
			request.setAttribute(super.PREFIX + "country", "개봉국가는 필수입력 사항입니다.");
			isCheck = false;
		}
		return isCheck;
	}

}
