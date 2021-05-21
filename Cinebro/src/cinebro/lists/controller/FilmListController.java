
package cinebro.lists.controller;

import java.io.IOException;
import java.util.HashMap;
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

//////////////////////////최신필름리스트조회
		List<FilmList> lists1 = dao.SelectDataList();
		Map<Integer, List<String>> films1 = new HashMap<Integer, List<String>>();
		for (FilmList filmList : lists1) {
			//각 리스트의 아이디 값 뽑아내기
			int id = filmList.getId();
			//각 아이디에 들어있는 영화들의 이미지명을 DB에서 가져와서 Map에 넣어주기
			List<String> filmimage = dao.findFilmListImage(id);
			films1.put(id, filmimage);
		}
		request.setAttribute("films1", films1);
		request.setAttribute("lists1", lists1);
		
//////////////////////////내가 좋아요한	 필름리스트 조회	
		System.out.println(email);
				
		List<FilmList> lists2 = dao.SelectByLike(email);
		Map<Integer, List<String>> films2 = new HashMap<Integer, List<String>>();
		for (FilmList filmList : lists2) {
			//각 리스트의 아이디 값 뽑아내기
			int id = filmList.getId();
			//각 아이디에 들어있는 영화들의 이미지명을 DB에서 가져와서 Map에 넣어주기
			List<String> filmimage = dao.findFilmListImage(id);
			films2.put(id, filmimage);
		}
		request.setAttribute("films2", films2);
		request.setAttribute("lists2", lists2);
		
		//인기많은	 필름리스트 조회
		List<FilmList> lists3 = dao.SelectByPopular();
		Map<Integer, List<String>> films3 = new HashMap<Integer, List<String>>();
		for (FilmList filmList : lists3) {
			//각 리스트의 아이디 값 뽑아내기
			int id = filmList.getId();
			//각 아이디에 들어있는 영화들의 이미지명을 DB에서 가져와서 Map에 넣어주기
			List<String> filmimage = dao.findFilmListImage(id);
			films3.put(id, filmimage);
		}
		request.setAttribute("films3", films3);
		request.setAttribute("lists3", lists3);
		
		String gotopage = "/lists/filmList.jsp" ;
		super.GotoPage(gotopage);
	}	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}	
}