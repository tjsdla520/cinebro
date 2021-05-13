package cinebro.lists.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		String sql = " select m.nickname, l.id, l.email, l.comments, l.list_title, m2.nickname as listmaker from members m inner join likefilmlists lfl on m.email = lfl.email inner join lists l on lfl.lklistno = l.id inner join members m2 on m2.email = l.email where m.email = ? " ;
		
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
				bean.setNickname(rs.getString("m2.nickname"));
				
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
		String sql="select ranking, id, email, list_title, comments, nickname from (select l.id, l.email, l.list_title, m.nickname, l.comments, rank() over(order by l.id desc) as ranking from lists l inner join members m on m.email = l.email ) where ranking between 1 and 5 " ;
		//String sql = " select l.id, l.email, l.comments, l.list_title, m.nickname, count(*) as cnt from lists l inner join likefilmlists lkf on l.id = lkf.lklistno inner join members m on l.email = m.email group by l.id, l.email, l.comments, l.list_title, m.nickname order by cnt desc " ;
			
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

	public Map<String, Object> selectFilmList(String email) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FilmList> list1 = new ArrayList<FilmList>();
		List<FilmList> list2 = new ArrayList<FilmList>();
		List<FilmList> list3 = new ArrayList<FilmList>();
		
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = "";
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			
			//step 01 : 최신 리스트 조회
			sql = "select ranking, id, email, list_title, comments, nickname from (select l.id, l.email, l.list_title, m.nickname, l.comments, rank() over(order by l.id desc) as ranking from lists l inner join members m on m.email = l.email ) where ranking between 1 and 5";
			pstmt = super.conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				FilmList bean = new FilmList();
								
				bean.setId(rs.getInt("id"));
				bean.setEmail(rs.getString("email"));				
				bean.setList_title(rs.getString("list_title"));
				bean.setComments(rs.getString("comments"));
				bean.setNickname(rs.getString("nickname"));
				
				list1.add(bean);
			}
			map.put("list1", list1);
			if( rs != null ){ rs.close(); }
			if(pstmt!=null) {pstmt.close();}
			
			//step 02 : 내가 좋아요 누른 리스트 조회
			if( conn == null ){ super.conn = super.getConnection() ; }
			sql = "select m.nickname, l.id, l.email, l.comments, l.list_title, m2.nickname as listmaker from members m inner join likefilmlists lfl on m.email = lfl.email inner join lists l on lfl.lklistno = l.id inner join members m2 on m2.email = l.email where m.email = ?";
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				FilmList bean2 = new FilmList();
								
				bean2.setId(rs.getInt("id"));
				bean2.setEmail(rs.getString("email"));				
				bean2.setList_title(rs.getString("list_title"));
				bean2.setComments(rs.getString("comments"));
				bean2.setNickname(rs.getString("listmaker"));
				
				list2.add(bean2);
			}
			map.put("list2", list2);
			System.out.println("list2 넣었음");
			if( rs != null ){ rs.close(); }
			if(pstmt!=null) {pstmt.close();}
			
			//step 03 : 인기순 필름리스트 조회
			if( conn == null ){ super.conn = super.getConnection() ; }
			sql = "select l.id, l.email, l.comments, l.list_title, m.nickname, count(*) as cnt from lists l inner join likefilmlists lkf on l.id = lkf.lklistno inner join members m on l.email = m.email group by l.id, l.email, l.comments, l.list_title, m.nickname order by cnt desc" ;
			pstmt = super.conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				FilmList bean3 = new FilmList();
								
				bean3.setId(rs.getInt("id"));
				bean3.setEmail(rs.getString("email"));				
				bean3.setList_title(rs.getString("list_title"));
				bean3.setComments(rs.getString("comments"));
				bean3.setNickname(rs.getString("nickname"));
				
				list3.add(bean3);
			}
			map.put("list3", list3);
			System.out.println("list3 넣었음");
			if( rs != null ){ rs.close(); }
			if(pstmt!=null) {pstmt.close();}
			
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
		return map;
	}
}







































