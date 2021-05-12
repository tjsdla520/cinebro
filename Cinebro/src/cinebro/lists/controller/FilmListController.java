package cinebro.lists.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;

import cinebro.lists.model.*;

public class FilmListController extends SuperClass {
//	private static final String email = null;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
//////////////////////////전체필름리스트조회
		FilmListDao dao1 = new FilmListDao();
		List<FilmList> lists1 = dao1.SelectDataList();
		
		request.setAttribute("lists1", lists1);
		
//////////////////////////내가 좋아요한	 필름리스트 조회	
		String email = request.getParameter("email") ;
		System.out.println(email);
		
		FilmListDao dao2 = new FilmListDao();
		
		List<FilmList> lists2 = dao2.SelectByLike(email);
		
		request.setAttribute("lists2", lists2);
		
		
//////////////////////////인기많은	 필름리스트 조회		
		FilmListDao dao3 = new FilmListDao();
		List<FilmList> lists3 = dao3.SelectByPopular();
		
//		FilmListDao dao4 = new FilmListDao();
//		List<FilmList> lists4 = dao4.SelectByAdmin();
		
		request.setAttribute("list3", lists3);
		
		String gotopage = "/lists/filmList.jsp" ;
		super.GotoPage(gotopage);
	}	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}