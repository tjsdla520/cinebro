package cinebro.lists.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cinebro.common.model.SuperDao;
import cinebro.films.model.Film;

public class FilmListDetailDao extends SuperDao {

	public FilmList SelectByOne(String id) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		FilmList bean = new FilmList();
		Map<Integer, String> films = new HashMap<Integer, String>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			
			//필름리스트 기본정보 가져오기
			String sql = "select l.id, l.email, l.list_title, l.comments, m.nickname from lists l inner join members m on l.email = m.email where l.id = ?";
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setString(1, id);
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){		
				
				bean.setId(rs.getInt("id"));
				bean.setEmail(rs.getString("email"));
				bean.setList_title(rs.getString("list_title"));
				bean.setComments(rs.getString("comments"));
				bean.setNickname(rs.getString("nickname"));				
			}
			if( rs != null ){ rs.close(); }
			if( pstmt != null ){ pstmt.close(); }
			
			//필름리스트에 들어있는 영화들 가져오기
			sql = "select ml.film_id, f.film_title from makelist ml inner join films f on ml.film_id = f.id where ml.list_id = ?";
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setString(1, id);
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){		
				films.put(rs.getInt("film_id"), rs.getString("film_title"));
				bean.setFilm_title(films);
			}
			if( rs != null ){ rs.close(); }
			if( pstmt != null ){ pstmt.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if( rs != null ){ rs.close(); }
				if( pstmt != null ){ pstmt.close(); }
				super.closeConnection(); 
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}		
		return bean ;
	}
}