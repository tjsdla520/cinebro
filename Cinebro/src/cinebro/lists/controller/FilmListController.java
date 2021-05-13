
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

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		FilmListDao dao = new FilmListDao();
		String email = request.getParameter("email");

//////////////////////////전체필름리스트조회
		List<FilmList> lists1 = dao.SelectDataList();
		for (FilmList filmList : lists1) {
			System.out.println("list1 : " + filmList);
		}
		request.setAttribute("lists1", lists1);
		
//////////////////////////내가 좋아요한	 필름리스트 조회	
		System.out.println(email);
				
		List<FilmList> lists2 = dao.SelectByLike(email);

		for (FilmList filmList : lists2) {
			System.out.println("list2 : "+filmList);
		}
		
		request.setAttribute("lists2", lists2);
//		
////////////////////////////인기많은	 필름리스트 조회		

		List<FilmList> lists3 = dao.SelectByPopular();
	
		for (FilmList filmList : lists3) {
			System.out.println("list3 : "+filmList);
		}
		request.setAttribute("lists3", lists3);
		

		String gotopage = "/lists/filmList.jsp" ;
		super.GotoPage(gotopage);
	}	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}