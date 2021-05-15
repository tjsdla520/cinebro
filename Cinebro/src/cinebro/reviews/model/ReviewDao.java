
package cinebro.reviews.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinebro.common.model.SuperDao;
import cinebro.films.model.Film;


public class ReviewDao extends SuperDao {

	public List<Review> selectPopularReview() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select r.id, r.film_id, m.nickname, f.film_title, r.content, r.rating, r.watch_date, r.write_date, v.getlike from reviews r inner join members m on r.email = m.email inner join films f on r.film_id = f.id inner join view05 v on r.id=v.id where v.getlike >= 2 order by getlike desc" ;

		List<Review> lists = new ArrayList<Review>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				Review bean = new Review();
				
				bean.setId(rs.getInt("id"));
				bean.setWriter(rs.getString("nickname"));
				bean.setFilmTitle(rs.getString("film_title"));
				bean.setContent(rs.getString("content"));
				bean.setRating(rs.getInt("rating"));
				bean.setWatchDate(rs.getDate("watch_date"));
				bean.setWriteDate(rs.getDate("write_date"));
				bean.setGetlike(rs.getInt("getlike"));
				bean.setFilmId(rs.getInt("film_id"));
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

	public Review selectReview(String id) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		Review bean = new Review();
		
		String sql = "select r.id, r.film_id, m.nickname, f.film_title, r.content, r.rating, r.watch_date, r.write_date, v.getlike from reviews r inner join members m on r.email = m.email inner join films f on r.film_id = f.id inner join view05 v on r.id=v.id where r.id = ?" ;

		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setString(1, id);
			rs = pstmt.executeQuery() ;		
			while( rs.next() ){
						
				bean.setId(rs.getInt("id"));
				bean.setWriter(rs.getString("nickname"));
				bean.setFilmTitle(rs.getString("film_title"));
				bean.setContent(rs.getString("content"));
				bean.setRating(rs.getInt("rating"));
				bean.setWatchDate(rs.getDate("watch_date"));
				bean.setWriteDate(rs.getDate("write_date"));
				bean.setGetlike(rs.getInt("getlike"));
				bean.setFilmId(rs.getInt("film_id"));
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
		
		return bean ;
	}

	public int editReview(Review bean) {
		String sql = "update reviews set content = ?, rating = ? where id = ?";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getContent());
			pstmt.setInt(2, bean.getRating());
			pstmt.setInt(3, bean.getId());
			
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

	public int deleteReview(String id) {
		String sql = "delete from reviews where id = ?";
		
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

	public int insertReview(String email, int id, String content, int rating) {
		String sql = "insert into reviews(id, email, film_id, content, rating, watched, write_date) values(reviews_SEQ.nextval, ?, ?, ?, ?, 1, default)";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, email);
			pstmt.setInt(2, id);
			pstmt.setString(3, content);
			pstmt.setInt(4, rating);
			
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

	public List<Review> selectMyreviews(String email) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;	
			
		String sql = " select m.nickname, f.film_title, r.id, r.content, r.rating, r.watch_date from members m inner join reviews r on r.email = m.email inner join films f on r.film_id = f.id where m.email = ?  " ;
		
		List<Review> reviews = new ArrayList<Review>();
		
	
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }			
			pstmt = super.conn.prepareStatement(sql) ;	
			
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery() ;
		
			
			while ( rs.next() ) {
				Review bean = new Review(); 
				bean.setId(rs.getInt("id"));
				bean.setNickname(rs.getString("nickname")) ;
			    bean.setFilmTitle(rs.getString("film_title"));
			    bean.setContent(rs.getString("content"));
			    bean.setRating(rs.getInt("rating"));
			    bean.setWatchDate(rs.getDate("watch_date"));
			    
			    reviews.add(bean);
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
		return reviews  ;
	}
}
