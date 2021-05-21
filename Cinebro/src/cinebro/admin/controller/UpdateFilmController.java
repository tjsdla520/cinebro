package cinebro.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import cinebro.common.controller.SuperClass;
import cinebro.films.controller.FilmDetailController;
import cinebro.films.model.Film;
import cinebro.films.model.FilmDetailDao;

public class UpdateFilmController extends SuperClass {
	private Film bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String id = request.getParameter("id");
		FilmDetailDao dao = new FilmDetailDao();
		Film fbean = dao.selectFilm(id);
		int actorsize = fbean.getActors().size();
		System.out.println("배우사이즈 : " + actorsize);
		request.setAttribute("actorsize", actorsize);
		request.setAttribute("fbean", fbean);
		String gotopage = "/profile/UpdateFilmForm.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi");
		bean = new Film();
		
		System.out.println(multi.getParameter("id")+"수정시 넘어오는 id값");
		bean.setId(Integer.parseInt(multi.getParameter("id")));
		bean.setFilm_title(multi.getParameter("film_title"));
		bean.setPlayUrl(multi.getParameter("playUrl"));
		bean.setImage(multi.getFilesystemName("image"));
		String actor1 = multi.getParameter("actorid1");
		String actor2 = multi.getParameter("actorid2");
		if (multi.getParameter("director") == null || multi.getParameter("director").equals("")) {
			bean.setDirector("");	
		}else {
			bean.setDirector(multi.getParameter("director"));
		}
		
		if (multi.getParameter("year") == null || multi.getParameter("year").equals("")) {
			bean.setYear(0);	
		}else {
			bean.setYear(Integer.parseInt(multi.getParameter("year")));
		}
		
		if (multi.getParameter("country") == null || multi.getParameter("country").equals("")) {
			bean.setCountry("");	
		}else {
			bean.setCountry(multi.getParameter("country"));
		}
		
		if (this.validate(request) == true) { 
			System.out.println("member insert validation check success");
			FilmDetailDao dao = new FilmDetailDao();
			
			int cnt = -99999; 
			cnt = dao.UpdateFilm(bean);
			int cnt2 = dao.insertFilmnActor(bean.getId(), actor1);
			int cnt3 = dao.insertFilmnActor(bean.getId(), actor2);
			Film fbean = dao.selectFilm(multi.getParameter("id"));
			session.setAttribute("fbean", fbean);
			String gotopage = "/reviews/filmDetail.jsp";
			super.GotoPage(gotopage);
			
		} else {
			System.out.println("member insert validation check failure");
			super.doPost(request, response);
			request.setAttribute("bean", bean);
			String gotopage = "/profile/UpdateFilmForm.jsp" ;
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
		
		if(bean.getPlayUrl()==null || bean.getFilm_title().equals("")) {
			request.setAttribute(super.PREFIX + "playUrl", "영화 url은 필수입력 사항입니다.");
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
