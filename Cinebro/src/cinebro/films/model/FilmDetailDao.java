
package cinebro.films.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cinebro.common.model.SuperDao;
import cinebro.members.model.Member;

public class FilmDetailDao extends SuperDao {

	public Film selectFilm(String id) {
		Film bean = new Film() ;
		List<String> genreList = new ArrayList<String>();
		List<String> actorList = new ArrayList<String>();
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
				
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			
			//영화 기본정보 가져오기 
			String sql = "select f.id, f.film_title, f.director, f.year, f.country from films f inner join filmngenre fg on f.id = fg.film_id where f.id = ?" ;
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery() ; 
			
			while(rs.next()) {				
				bean.setId(rs.getInt("id"));
				bean.setFilm_title(rs.getString("film_title"));
				bean.setDirector(rs.getString("director"));
				bean.setYear(rs.getInt("year"));
				bean.setCountry(rs.getString("country"));
			}
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();} 
			
			//영화별 장르 리스트 가져오기 
			sql = "select g.id, g.name from genres g inner join filmngenre fg on g.id = fg.genre_id where fg.film_id = ?" ;
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery() ; 
			
			while(rs.next()) {				
				genreList.add(rs.getString("name"));		
			}
			bean.setGenres(genreList);
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();} 
			
			
			//배우 리스트 가져오기
			sql = "select f.film_title, a.name from films f inner join filmnactor fa on f.id = fa.film_id inner join actors a on fa.actor_id = a.id where f.id = ?" ;
			pstmt = conn.prepareStatement(sql) ;			
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery() ; 
			
			while(rs.next()) {				
				actorList.add(rs.getString("name"));
				System.out.println(rs.getString("name"));
			}
			
			bean.setActors(actorList);
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();} 
			
		} catch (Exception e) {			
			e.printStackTrace();
			bean = null ; 
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();} 
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean ;
	}


	
}
