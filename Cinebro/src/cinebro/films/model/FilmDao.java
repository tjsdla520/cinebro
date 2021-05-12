package cinebro.films.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cinebro.common.model.SuperDao;


public class FilmDao extends SuperDao {

	public Film SelectDataByPk(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

			
		String sql = " select m.nickname, f.film_title, g.name from members m inner join reviews r on m.email = r.email inner join films f on r.film_id = f.id  " ; 
		sql += " inner join filmngenre fg on f.id = fg.film_id " ; 
		sql += " inner join genres g on fg.genre_id = g.id " ;
		sql += " where g.id = ? " ;
		
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			pstmt.setString(1, genre);
			
			
			rs = pstmt.executeQuery() ;
			
			if ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
				bean.setCountry(rs.getString("country")) ;
				bean.setDirector(rs.getString("director")) ;
				bean.setName(rs.getString("name")) ;
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
		return bean  ;
	}
}