package cinebro.genres.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

}
