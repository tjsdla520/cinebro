package cinebro.following.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cinebro.common.model.SuperDao;
import cinebro.profile.model.Profile;

public class MemberFollowDao extends SuperDao {

	public Profile findFollow(String myemail, String email) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;	
		Profile bean = null;
		
		String sql = "select * from myfollowing where my_email = ? and follow_email = ?" ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }			
			pstmt = super.conn.prepareStatement(sql) ;	
			
			pstmt.setString(1, myemail);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery() ;
					
			while ( rs.next() ) {
				bean = new Profile();
				bean.setEmail(rs.getString("my_email"));
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

	public int followMember(String myemail, String followemail) {
		String sql = "insert into myfollowing values(?, ?)" ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, myemail);
			pstmt.setString(2, followemail);
			
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

	public int unfollowMember(String myemail, String followemail) {
		String sql = "delete from myfollowing where my_email = ? and follow_email = ?" ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, myemail);
			pstmt.setString(2, followemail);
			
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
