package cinebro.films.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinebro.common.model.SuperDao;
import cinebro.lists.model.FilmList;



public class FilmDao extends SuperDao {

	public List<Film> SelectDataByPk(String id) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = "select f.id as filmid, f.film_title, f.image, g.id as gernreid, g.name as genrename, v.cnt as popular from films f inner join filmngenre fg on f.id = fg.film_id inner join genres g on fg.genre_id = g.id inner join popularmovie v on f.id = v.id where g.id = ? order by popular desc";

		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			pstmt.setString(1, id);
			rs = pstmt.executeQuery() ;
			
						
			while ( rs.next() ) {
				Film bean = new Film(); 
				bean.setId(rs.getInt("filmid"));
				bean.setFilm_title(rs.getString("film_title")) ;		
				bean.setImage(rs.getString("image"));
			    films.add(bean);
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
		return films  ;
	}

	


	public List<Film> selectWatchedFilms(String email) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select f.film_title, f.id, f.image from members m inner join reviews r on m.email = r.email inner join films f on r.film_id = f.id where m.email = ? " ;
		
		List<Film> lists = new ArrayList<Film>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				Film bean = new Film();
				
				bean.setId(rs.getInt("id"));
				bean.setFilm_title(rs.getString("film_title"));		
				bean.setImage(rs.getString("image"));
				
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




	public List<Film> selectByRatingUrl() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select ranking, id, film_title, image, director, year, country, playurl, avgrate, totalrate from("
				+ "select id, film_title, image, director, year, country, playurl, avgrate, totalrate, rank() over(order by avgrate desc) as ranking from("
				+ "select f.id, f.film_title, f.image, f.director, f.year, f.country, f.playurl, ar.avgrate, ar.totalrate from films f inner join filmavgrating ar on f.id = ar.film_id  where totalrate >=5 and playurl is not null order by avgrate desc)) where ranking between 1 and 10" ;
		
		List<Film> lists = new ArrayList<Film>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;

			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				Film bean = new Film();
				
				bean.setId(rs.getInt("id"));
				bean.setYear(rs.getInt("year"));
				bean.setTotalratings(rs.getInt("totalrate"));
				bean.setAvgrating(rs.getDouble("avgrate"));
				bean.setFilm_title(rs.getString("film_title"));
				bean.setDirector(rs.getString("director"));
				bean.setCountry(rs.getString("country"));
				bean.setPlayUrl(rs.getString("playurl"));
				bean.setImage(rs.getString("image"));
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

	public List<Film> selectFamousFilms() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql ="select ranking, id, film_title, image, cnt from("
				+ "select id, film_title, image, cnt, rank() over(order by cnt desc) as ranking from("
				+ "select f.id, f.film_title, f.image, count(*) as cnt from films f inner join reviews r on f.id = r.film_id group by f.id, f.film_title, f.image order by cnt desc)) where ranking between 1 and 10"; 
		
		List<Film> lists = new ArrayList<Film>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;

			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				Film bean = new Film();
				
				bean.setId(rs.getInt("id"));
				bean.setFilm_title(rs.getString("film_title"));
				bean.setImage(rs.getString("image"));
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




	public List<Film> selectByRatingFilm() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select ranking, id, film_title, image, director, year, country, playurl, avgrate, totalrate from("
				+ "select id, film_title, image, director, year, country, playurl, avgrate, totalrate, rank() over(order by avgrate desc) as ranking from("
				+ "select f.id, f.film_title, f.image, f.director, f.year, f.country, f.playurl, ar.avgrate, ar.totalrate from films f inner join filmavgrating ar on f.id = ar.film_id  where totalrate >=5 order by avgrate desc)) where ranking between 1 and 10" ;
		
		List<Film> lists = new ArrayList<Film>();
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;

			rs = pstmt.executeQuery() ;	
			
			while( rs.next() ){
				Film bean = new Film();
				
				bean.setId(rs.getInt("id"));
				bean.setYear(rs.getInt("year"));
				bean.setTotalratings(rs.getInt("totalrate"));
				bean.setAvgrating(rs.getDouble("avgrate"));
				bean.setFilm_title(rs.getString("film_title"));
				bean.setDirector(rs.getString("director"));
				bean.setCountry(rs.getString("country"));
				bean.setPlayUrl(rs.getString("playurl"));
				bean.setImage(rs.getString("image"));
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
