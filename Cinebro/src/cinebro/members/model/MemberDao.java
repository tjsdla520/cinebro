package cinebro.members.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cinebro.common.model.SuperDao;

public class MemberDao extends SuperDao {

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
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		String sql = " select * from members  " ; 
		sql += " where email = ? " ; 

		Member bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery() ;
			
			if ( rs.next() ) {
				bean = new Member(); 
				bean.setEmail(rs.getString("email")) ;				

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

	public Member selectDataByNickname(String nickname) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		String sql = " select * from members  " ; 
		sql += " where nickname = ? " ; 

		Member bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			pstmt.setString(1, nickname);
			
			rs = pstmt.executeQuery() ;
			
			if ( rs.next() ) {
				bean = new Member(); 
				bean.setNickname(rs.getString("nickname")) ;				

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

	public int insertData(Member bean) {
		String sql = " insert into members(email, nickname, password) " ; 
		sql += "                    values(?,  ?,    ?) " ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getNickname());
			pstmt.setString(3, bean.getPassword());
			
			
			cnt = pstmt.executeUpdate() ; 
			conn.commit(); 
		} catch (Exception e) {
			SQLException err = (SQLException)e ;
			//getErrorCode() : ����Ŭ ���� ����� ����
			//�� : not null �̸� 1400 
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

	public Member SelectData(String email, String password) {
		Member bean = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from members where email = ? and password = ? " ;
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery() ; 
			
			if(rs.next()) {
				bean = new Member() ;
				
				
				bean.setPassword(rs.getString("password"));				
				bean.setEmail(rs.getString("email"));
				bean.setNickname(rs.getString("nickname"));
			}
		} catch (Exception e) {			
			e.printStackTrace();
			bean = null ; 
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();} 
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean ;
	}
}	
