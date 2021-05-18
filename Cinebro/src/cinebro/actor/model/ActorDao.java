package cinebro.actor.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinebro.common.model.SuperDao;
import cinebro.films.model.Film;
import cinebro.lists.model.FilmList;



public class ActorDao extends SuperDao {

	public Actor selectActor(int id) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				
		Actor one = new Actor();
		List<Film> films = new ArrayList<Film>();
		Film bean = new Film();
			
		String sql = "select f.film_title, fa.film_id, f.image, fa.actor_id, a.name from filmnactor fa inner join actors a on fa.actor_id = a.id inner join films f on f.id = fa.film_id where fa.actor_id = ?";
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery() ;
									
			while ( rs.next() ) {
				one.setId(rs.getInt("actor_id"));
				one.setName(rs.getString("name"));
				
				bean.setId(rs.getInt("film_id"));
				bean.setFilm_title(rs.getString("film_title"));
				bean.setImage(rs.getString("image"));
				films.add(bean);
			}
			one.setActingfilms(films);			
			
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
		return one  ;
	}

}
