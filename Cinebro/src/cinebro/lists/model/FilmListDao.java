package cinebro.lists.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cinebro.common.model.SuperDao;

public class FilmListDao extends SuperDao {

	public List<FilmList> SelectDataList() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select l.id, l.email, l.list_title, m.nickname, l.comments from lists l inner join members m on m.email = l.email order by l.id desc "; 

		List<FilmList> lists1 = new ArrayList<FilmList>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				FilmList bean1 = new FilmList();
				
				
				bean1.setId(rs.getInt("id"));
				bean1.setEmail(rs.getString("email"));				
				bean1.setList_title(rs.getString("list_title"));
				bean1.setComments(rs.getString("comments"));
				bean1.setNickname(rs.getString("nickname"));
				
				lists1.add(bean1);
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
		
		return lists1 ;
	}

	public List<FilmList> SelectByLike(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FilmList> SelectByPopular() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FilmList> SelectByAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	


	
	
}