package cinebro.films.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinebro.common.model.SuperDao;
import cinebro.lists.model.FilmList;


public class FilmDao extends SuperDao {

	public List<Film> SelectDataAll() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			
		String sql = " select * from films  " ; 
		
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
//			pstmt.setString(1, genre);
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
				bean.setCountry(rs.getString("country")) ;
				bean.setDirector(rs.getString("director")) ;
				bean.setId(rs.getInt("id")) ;
				bean.setYear(rs.getInt("year")) ;
				
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
	
	
	public List<Film> SelectDataByPk(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				
		List<Film> films = new ArrayList<Film>();
			
		String sql = " select fm.film_title, grn.name from filmngenre fng  " ; 
		sql += " join genres grn on fng.genre_id = grn.id " ; 
		sql += " join films fm on fng.film_id = fm.id " ;
		sql += " where grn.id = ? " ;
		
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			pstmt.setString(1, genre);
			
			
			rs = pstmt.executeQuery() ;
			
			while ( rs.next() ) {
				
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
				bean.setCountry(rs.getString("country")) ;
				bean.setDirector(rs.getString("director")) ;
				bean.setId(rs.getInt("id")) ;
				bean.setYear(rs.getInt("year")) ;
				

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
}