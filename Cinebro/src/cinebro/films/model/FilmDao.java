package cinebro.films.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinebro.common.model.SuperDao;
import cinebro.lists.model.FilmList;



public class FilmDao extends SuperDao {

	public List<Film> SelectDataByPk(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 1 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataPerformance(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 2 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataHorror(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 3 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataDacumentary(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 4 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataRomance(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 6 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataDrama(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 5 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataMusical(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 7 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataMystery(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 8 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataCrime(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 9 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectHistorical(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 10 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataWestern(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 11 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataThriller(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 12 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	

	public List<Film> SelectDataAction(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 14 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataAnimation(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 13 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataAdventure(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 15 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataWar(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 16 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataComedy(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 17 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataFantasy(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 18 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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

	public List<Film> SelectDataScience(String genre) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		List<Film> films = new ArrayList<Film>();
			

		String sql = " select film_title, name   " ; 
		sql += " from (select fm.film_title as film_title, grn.name as name  " ; 
		sql += " from filmngenre fng join genres grn on fng.genre_id = grn.id  " ;
		sql += " join films fm on fng.film_id = fm.id Where grn.id = 19 ) " ;
		sql += " where rownum <= 10 ";
		Film bean = null ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;
			
			/* pstmt.setString(1, genre); */
			
			
			while ( rs.next() ) {
				bean = new Film(); 
				bean.setFilm_title(rs.getString("film_title")) ;
			    bean.setName(rs.getString("name"));
				
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
		
		String sql = " select r.id, f.film_title from members m inner join reviews r on m.email = r.email inner join films f on r.film_id = f.id where m.email = ? " ;
		
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
/*
 * public List<Film> SelectDataByPk(String genre) { PreparedStatement pstmt =
 * null ; ResultSet rs = null ; List<Film> films = new ArrayList<Film>();
 * 
 * String sql = " select fm.film_title, grn.name from filmngenre fng  " ; sql +=
 * " join genres grn on fng.genre_id = grn.id " ; sql +=
 * " join films fm on fng.film_id = fm.id " ; sql += " where grn.id = 1 " ;
 * 
 * Film bean = null ;
 * 
 * try { if( this.conn == null ){ this.conn = this.getConnection() ; } pstmt =
 * this.conn.prepareStatement(sql) ;
 * 
 * pstmt.setString(1, genre);
 * 
 * 
 * rs = pstmt.executeQuery() ;
 * 
 * while ( rs.next() ) {
 * 
 * bean = new Film(); bean.setFilm_title(rs.getString("film_title")) ;
 * 
 * bean.setName(rs.getString("name")) ;
 * 
 * 
 * 
 * }
 * 
 * } catch (SQLException e) { e.printStackTrace(); } finally{ try { if( rs !=
 * null){ rs.close(); } if( pstmt != null){ pstmt.close(); }
 * this.closeConnection() ; } catch (Exception e2) { e2.printStackTrace(); } }
 * return films ; } }
 */