
package cinebro.reviews.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinebro.common.model.SuperDao;

public class LikeReviewDao extends SuperDao {

	public int insertLikeReview(String email, String id) {
		String sql = "insert into likereviews values(?, ?)" ;
		
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

	public Review findlike(String email, String id) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;	
		Review bean = null;
		
		String sql = " select lr.email, lr.review_id, r.email as find from reviews r inner join likereviews lr on r.id = lr.review_id where lr.email = ? and lr.review_id = ? ";
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }			
			pstmt = super.conn.prepareStatement(sql) ;	
			
			pstmt.setString(1, email);
			pstmt.setString(2, id);
			
			rs = pstmt.executeQuery() ;
					
			while ( rs.next() ) {
				bean = new Review();
				bean.setEmail("email");
				bean.setId(rs.getInt("review_id"));
				bean.setEmail(rs.getString("email"));
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

	public int deleteLikeReview(String email, String id) {
		String sql = "delete from likereviews where email = ? and review_id = ?" ;
		
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
