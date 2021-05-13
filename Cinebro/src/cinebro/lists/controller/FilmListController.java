package cinebro.lists.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
		FilmListDao dao = new FilmListDao();
		String email = request.getParameter("email");
		String mode = request.getParameter("mode");
		//Map<String, Object> map = dao.selectFilmList(email);
		//System.out.println("영화리스트 맵 사이즈 : "+map.size());
//////////////////////////전체필름리스트조회
		
		if(mode==null||mode.equals("")||mode.equals("all")) {
			List<FilmList> lists = dao.SelectDataList();
		
			request.setAttribute("lists", lists);
			
		}else if(mode.equals("like")) {
			List<FilmList> lists = dao.SelectByLike(email);
			
			request.setAttribute("lists", lists);
			
		}else if(mode.equals("popular")) {
			List<FilmList> lists = dao.SelectByPopular();
			
			request.setAttribute("lists", lists);
		}
		
		
////////////////////////////내가 좋아요한	 필름리스트 조회	
//		System.out.println(email);
//				
//		List<FilmList> lists2 = dao1.SelectByLike(email);
//		if(lists2==null) {
//			System.out.println("lists2 null");
//		}
//		for (FilmList filmList : lists2) {
//			System.out.println(filmList);
//		}
//		
//		request.setAttribute("lists2", lists2);
////		
//////////////////////////////인기많은	 필름리스트 조회		
//
//		List<FilmList> lists3 = dao1.SelectByPopular();
//	
//		FilmListDao dao4 = new FilmListDao();
//		List<FilmList> lists4 = dao4.SelectByAdmin();
//		
//		request.setAttribute("list3", lists3);
		
		
//		List<FilmList> list1 = (List<FilmList>)map.get("list1");
//		for (FilmList filmList : list1) {
//			System.out.println(filmList);
//		}
//		
//		System.out.println("list2");
//		List<FilmList> list2 = (List<FilmList>)map.get("list2");
//		if(list2==null) {
//			System.out.println("list2는 null");
//		}
//		for (FilmList filmList : list2) {
//			System.out.println(filmList);
//		}
//		
//		System.out.println("list3");
//		List<FilmList> list3 = (List<FilmList>)map.get("list3");
//		for (FilmList filmList : list3) {
//			System.out.println(filmList);
//		}
//		
//		request.setAttribute("list1", list1);
//		request.setAttribute("list2", list2);
//		request.setAttribute("list3", list3);
		String gotopage = "/lists/filmList.jsp" ;
		super.GotoPage(gotopage);
	}	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}