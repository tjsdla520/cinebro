package cinebro.reviews.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cinebro.common.model.SuperDao;

public class ReviewDao extends SuperDao {


	public List<Review> selectPopularReview() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;

		String sql = "select r.id, m.nickname, f.film_title, r.content, r.rating, r.watch_date, r.write_date, v.getlike from reviews r inner join members m on r.email = m.email inner join films f on r.film_id = f.id inner join view05 v on r.id=v.id order by getlike desc" ; 	
		
		
		List<Review> lists = new ArrayList<Review>();
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;			
//			pstmt.setInt(1, beginRow);
//			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery() ;			
			while( rs.next() ){
				Review bean = new Review();
				
				
				bean.setId(rs.getInt("r.id"));
				bean.setWriter(rs.getString("m.nickname"));
				bean.setFilmTitle(rs.getString("f.film_title"));
				bean.setContent(rs.getString("r.content"));
				bean.setRating(rs.getInt("r.rating"));
				bean.setWriteDate((rs.getDate("r.write_date")));
				bean.setGetlike(rs.getInt("v.getlike"));
							 				 
				lists.add( bean ) ;
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
