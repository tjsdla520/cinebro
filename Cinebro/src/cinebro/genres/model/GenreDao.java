package cinebro.genres.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinebro.common.model.SuperDao;
import cinebro.lists.model.FilmList;

public class GenreDao extends SuperDao {

	public List<Genre> selectAllGenres() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		List<Genre> list = new ArrayList<Genre>();
		
		String sql = "select * from genres";
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				Genre bean = new Genre();
				
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));				
				
				list.add(bean);
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
		
		return list ;
	}

	public int deleteFilmnGenre(int id) {
		String sql = "delete from filmngenre where film_id = ?";
		
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

	public int insertFilmnGenre(int id, int genreid) {
		PreparedStatement pstmt = null ;
		int cnt = -99999;

		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			
			//영화 기본정보 넣기
			String sql = "insert into filmngenre values(?, ?)";
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setInt(1, id);
			pstmt.setInt(2, genreid);
	
			cnt = pstmt.executeUpdate(); 
			
			conn.commit();
			
		} catch (Exception e) {			
			e.printStackTrace();

		}finally {
			try {
				if(pstmt != null) {pstmt.close();} 
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}
}
