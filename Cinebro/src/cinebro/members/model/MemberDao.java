package cinebro.members.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinebro.common.model.SuperDao;
import cinebro.lists.model.FilmList;
import cinebro.profile.model.Profile;

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
				bean.setSubscribe(rs.getInt("subscribe"));
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

	public int insertPayInfo(Member bean) {
		String sql = "update members set subscribe = 1, cardnumber = ?, name = ?, enddate = ?, cardpassword = ? where email = ?";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getCardnumber());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getEnddate());
			pstmt.setString(4, bean.getCardpassword());
			pstmt.setString(5, bean.getEmail());
			cnt = pstmt.executeUpdate(); 
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

	public List<Member> popularMember() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select ranking, email, nickname, followers from(select m.email, m.nickname, v1.followers as followers, rank() over(order by v1.followers desc) as ranking from members m inner join howmanyfollwer v1 on m.email = v1.email ) where ranking between 1 and 5 " ;
		
		List<Member> lists = new ArrayList<Member>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				Member bean = new Member();				
				
				bean.setEmail(rs.getString("email"));
				bean.setNickname(rs.getString("nickname"));				
				bean.setFollower(rs.getInt("followers"));
				
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

	public List<Member> manyReviewMember() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select ranking, email, nickname, reviews from(select m.email, m.nickname, v1.reviews as reviews, rank() over(order by v1.reviews desc) as ranking from members m inner join howmanyreviews v1 on m.email = v1.email ) where ranking between 1 and 5 " ;
		
		List<Member> lists = new ArrayList<Member>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				Member bean = new Member();				
				
				bean.setEmail(rs.getString("email"));
				bean.setNickname(rs.getString("nickname"));				
				bean.setAllReviews(rs.getInt("reviews"));
				
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

	public List<Member> followingMember(String followingemail) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select ranking, email, nickname, followers, reviews from(select m.email, m.nickname, v1.followers as followers, v2.reviews as reviews, rank() over(order by m.nickname asc) as ranking from members m left outer join howmanyfollwer v1 on m.email = v1.email left outer join howmanyreviews v2 on m.email = v2.email left outer join myfollowingview v3 on  m.email = v3.email where v3.followingemail = ? ) where ranking between 1 and 5 " ;
		
		List<Member> lists = new ArrayList<Member>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, followingemail);
			
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				Member bean = new Member();
								
				bean.setEmail(rs.getString("email"));
				bean.setNickname(rs.getString("nickname"));				
				bean.setFollower(rs.getInt("followers"));
				bean.setAllReviews(rs.getInt("reviews"));
				
				
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
