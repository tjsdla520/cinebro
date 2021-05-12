package cinebro.lists.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cinebro.common.model.SuperDao;
import cinebro.films.model.Film;

public class FilmListDetailDao extends SuperDao {

	public List<FilmList> SelectByOne(String id) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select l.list_title, m.nickname as maker, l.comments, f.film_title from lists l inner join makelist ml on l.id = ml.list_id inner join films f on ml.film_id = f.id inner join members m on l.email = m.email where l.id = 1";
		
		List<FilmList> lists = new ArrayList<FilmList>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				FilmList bean = new FilmList();				
								
				bean.setList_title(rs.getString("list_title"));
				bean.setComments(rs.getString("comments"));
				bean.setNickname(rs.getString("maker"));
				bean.setFilm_title(rs.getString("film_title"));
				
				lists.add(bean);
			}
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
		return lists ;
	}
}