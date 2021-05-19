
package cinebro.lists.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cinebro.common.model.SuperDao;

public class FilmListDao extends SuperDao {

	public List<FilmList> SelectDataList() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select ranking, id, email, list_title, comments, nickname from (select l.id, l.email, l.list_title, m.nickname, l.comments, rank() over(order by l.id desc) as ranking from lists l inner join members m on m.email = l.email ) where ranking between 1 and 5 " ;
		
		List<FilmList> lists = new ArrayList<FilmList>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				FilmList bean = new FilmList();				
				
				bean.setId(rs.getInt("id"));
				bean.setEmail(rs.getString("email"));				
				bean.setList_title(rs.getString("list_title"));
				bean.setComments(rs.getString("comments"));
				bean.setNickname(rs.getString("nickname"));
				
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

	public List<FilmList> SelectByLike(String email) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select m.nickname, l.id, l.email, l.comments, l.list_title, m2.nickname as listmaker from members m inner join likefilmlists lfl on m.email = lfl.email inner join lists l on lfl.list_id = l.id inner join members m2 on m2.email = l.email where m.email = ? " ;
		
		List<FilmList> lists = new ArrayList<FilmList>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				FilmList bean = new FilmList();
								
				bean.setId(rs.getInt("id"));
				bean.setEmail(rs.getString("email"));				
				bean.setList_title(rs.getString("list_title"));
				bean.setComments(rs.getString("comments"));
				bean.setNickname(rs.getString("listmaker"));
				
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

	public List<FilmList> SelectByPopular() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select ranking, id, email, comments, list_title, nickname, cnt from(select id, email, comments, list_title, nickname, cnt, rank() over(order by cnt desc) as ranking from("
				+ "select l.id, l.email, l.comments, l.list_title, m.nickname, count(*) as cnt from lists l inner join likefilmlists lkf on l.id = lkf.list_id inner join members m on l.email = m.email group by l.id, l.email, l.comments, l.list_title, m.nickname order by cnt desc)) where ranking between 1 and 5";
			
		List<FilmList> lists = new ArrayList<FilmList>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				FilmList bean = new FilmList();
								
				bean.setId(rs.getInt("id"));
				bean.setEmail(rs.getString("email"));				
				bean.setList_title(rs.getString("list_title"));
				bean.setComments(rs.getString("comments"));
				bean.setNickname(rs.getString("nickname"));
				
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

	public int insertFilmList(String title, String comments, String email) {
		String sql = "insert into lists(id, email, list_title, comments) values(lists_SEQ.nextval, ?, ?, ?)";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, email);
			pstmt.setString(2, title);
			pstmt.setString(3, comments);
			
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

	public int insertMakeList(int listid, int filmid1) {
		String sql = "insert into makelist values(?, ?)";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, listid);
			pstmt.setInt(2, filmid1);
			
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

	public int updateFilmList(String id, String title, String comments) {
		String sql = "update lists set list_title = ?, comments = ? where id = ?";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, title);
			pstmt.setString(2, comments);
			pstmt.setString(3, id);
			
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

	public int deleteMakeList(int id) {
		String sql = "delete from makelist where list_id = ?";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, id);
			
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

	public int deleteFilmList(String id) {
		String sql = "delete from lists where id = ?";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, id);
			
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

	public List<String> findFilmListImage(int id) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select ml.film_id, f.image from makelist ml inner join films f on ml.film_id = f.id where ml.list_id = ?" ;
		
		List<String> lists = new ArrayList<String>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				lists.add(rs.getString("image"));
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





