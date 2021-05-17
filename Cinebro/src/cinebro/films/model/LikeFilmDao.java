package cinebro.films.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cinebro.common.model.SuperDao;
public class LikeFilmDao extends SuperDao {

	public Film findLike(String id, String email) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;	
		Film bean = null;
		
		String sql = "select * from likefilms where email = ? and film_id = ?" ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }			
			pstmt = super.conn.prepareStatement(sql) ;	
			
			pstmt.setString(1, email);
			pstmt.setString(2, id);
			
			rs = pstmt.executeQuery() ;
					
			while ( rs.next() ) {
				bean = new Film();
				bean.setId(rs.getInt("film_id"));
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

	public int deleteLikeFilm(String email, String id) {
		String sql = "delete from likefilms where email = ? and film_id = ?" ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, email);
			pstmt.setString(2, id);
			
			cnt = pstmt.executeUpdate() ; 
			conn.commit(); 
		} catch (Exception e) {
			SQLException err = (SQLException)e ;
			cnt = - err.getErrorCode() ;			
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally{
			try {
				if( pstmt != null ){ pstmt.close(); }
				super.closeConnection(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
	}

	public int insertLikefilm(String email, String id) {
		String sql = "insert into likefilms values(?, ?)" ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, email);
			pstmt.setString(2, id);
			
			cnt = pstmt.executeUpdate() ; 
			conn.commit(); 
		} catch (Exception e) {
			SQLException err = (SQLException)e ;
			cnt = - err.getErrorCode() ;			
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally{
			try {
				if( pstmt != null ){ pstmt.close(); }
				super.closeConnection(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
	}


}
