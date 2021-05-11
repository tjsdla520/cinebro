package cinebro.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;
import cinebro.search.model.SearchDao;
import cinebro.common.utility.*;
import cinebro.films.model.Film;
import cinebro.lists.model.FilmList;
import cinebro.members.model.Member;

public class SearchController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		FlowParameters parameters = new FlowParameters(
				request.getParameter("pageNumber"), 
				request.getParameter("mode"),
				request.getParameter("keyword"));

		System.out.println("parameter list ");
		System.out.println(parameters.toString());

		String contextPath = request.getContextPath();
		String url = contextPath + "/Cinebro?command=search";

		SearchDao dao = new SearchDao();
		
		// 행(row) 총 개수
		int totalCount = dao.SelectTotalCount(parameters.getMode(), parameters.getKeyword()) ; 
		System.out.println("total data size : " + totalCount); 
		
		Paging pageInfo = new Paging(
								parameters.getPageNumber(), 
								totalCount, 
								url, 
								parameters.getMode(), 
								parameters.getKeyword()) ;	
		
		if(request.getParameter("mode").equals("film") || request.getParameter("mode").equals("") || request.getParameter("mode").equals(null)) {
			List<Film> lists = dao.SearchFilm(
					pageInfo.getBeginRow(), 
					pageInfo.getEndRow(), 
					parameters.getMode(), 
					parameters.getKeyword() ) ;
		
			System.out.println("search film count : " + lists.size()); 
			
			request.setAttribute("lists", lists);
			request.setAttribute("pageInfo", pageInfo);
			
			// 자주 사용되는 파라미터를 속성으로 정의합니다. 
			request.setAttribute("parameters", parameters.toString());
			
			String gotopage = "/lists/Searchlist.jsp" ;
			super.GotoPage(gotopage);		
		}
		
		if (request.getParameter("mode").equals("filmlist") ) {
			List<FilmList> lists = dao.SearchFilmList(
					pageInfo.getBeginRow(), 
					pageInfo.getEndRow(), 
					parameters.getMode(), 
					parameters.getKeyword() ) ;
		
			System.out.println("search filmlist count : " + lists.size()); 
			
			request.setAttribute("lists", lists);
			request.setAttribute("pageInfo", pageInfo);
			
			// 자주 사용되는 파라미터를 속성으로 정의합니다. 
			request.setAttribute("parameters", parameters.toString());
			
			String gotopage = "/lists/Searchlist.jsp" ;
			super.GotoPage(gotopage);		
		}
		
		if(request.getParameter("mode").equals("member") ) {
			List<Member> lists = dao.SearchMember(
					pageInfo.getBeginRow(), 
					pageInfo.getEndRow(), 
					parameters.getMode(), 
					parameters.getKeyword() ) ;
		
			System.out.println("search member count : " + lists.size()); 
			
			request.setAttribute("lists", lists);
			request.setAttribute("pageInfo", pageInfo);
			
			// 자주 사용되는 파라미터를 속성으로 정의합니다. 
			request.setAttribute("parameters", parameters.toString());
			
			String gotopage = "/lists/Searchlist.jsp" ;
			super.GotoPage(gotopage);		
		}
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}
