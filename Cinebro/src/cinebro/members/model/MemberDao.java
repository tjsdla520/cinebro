package cinebro.members.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import cinebro.common.model.SuperDao;

public class MemberDao<cinebro> extends SuperDao {

	public int DeleteData( String email ){		
		String sql ;		
		PreparedStatement pstmt = null ;		
		Member bean = null;
		int cnt = -99999 ;
		try {
			
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			
			sql = " delete from members " ;
			sql += " where email = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setString(1, email);			
			cnt = pstmt.executeUpdate() ;
			if(pstmt != null) {pstmt.close();}
			
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

	public Member selectDataByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}	
