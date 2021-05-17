package cinebro.lists.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cinebro.common.model.SuperDao;
import cinebro.films.model.Film;
import cinebro.reviews.model.Review;

public class LikefilmListDao extends SuperDao {

	public int InsertLikefilmList(String email, String id) {
		String sql = "insert into likefilmlists values(?, ?)" ;
		
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

	public FilmList findLike(String id, String email) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;	
		FilmList bean = null;
		
		String sql = "select * from likefilmlists where email = ? and list_id = ?" ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }			
			pstmt = super.conn.prepareStatement(sql) ;	
			
			pstmt.setString(1, email);
			pstmt.setString(2, id);
			
			rs = pstmt.executeQuery() ;
					
			while ( rs.next() ) {
				bean = new FilmList();
				bean.setId(rs.getInt("list_id"));
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

	public int deleteLikefilmList(String email, String id) {
		String sql = "delete from likefilmlists where email = ? and list_id = ?" ;
		
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
