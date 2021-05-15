package cinebro.films.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinebro.common.model.SuperDao;
import cinebro.lists.model.FilmList;



public class FilmDao extends SuperDao {

	public List<Film> SelectDataByPk(String id) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = "select f.id as filmid, f.film_title, g.id as gernreid, g.name as genrename, v.cnt as popular from films f inner join filmngenre fg on f.id = fg.film_id inner join genres g on fg.genre_id = g.id inner join popularmovie v on f.id = v.id where g.id = ? order by popular desc";

		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			pstmt.setString(1, id);
			rs = pstmt.executeQuery() ;
			
						
			while ( rs.next() ) {
				Film bean = new Film(); 
				bean.setId(rs.getInt("filmid"));
				bean.setFilm_title(rs.getString("film_title")) ;				
			    films.add(bean);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			try {
				if( rs != null){ rs.close(); } 
				if( pstmt != null){ pstmt.close(); } 
				this.closeConnection() ;
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		} 		
		return films  ;
	}

	


	public List<Film> selectWatchedFilms(String email) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select f.film_title, f.id from members m inner join reviews r on m.email = r.email inner join films f on r.film_id = f.id where m.email = ? " ;
		
		List<Film> lists = new ArrayList<Film>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				Film bean = new Film();
				
				bean.setId(rs.getInt("id"));
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
