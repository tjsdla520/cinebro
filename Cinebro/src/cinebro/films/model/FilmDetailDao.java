
package cinebro.films.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cinebro.common.model.SuperDao;
import cinebro.members.model.Member;

public class FilmDetailDao extends SuperDao {

	public Film selectFilm(String id) {
		Film bean = new Film() ;
		List<String> genreList = new ArrayList<String>();
		Map<Integer, String> actorList = new HashMap<Integer, String>();
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
				
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			
			//영화 기본정보 가져오기 
			String sql = "select f.id, f.film_title, f.director, f.year, f.country, f.playurl, f.image, ar.avgrate, ar.totalrate from films f left outer join filmavgrating ar on f.id = ar.film_id where f.id = ?";
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery() ; 
			
			while(rs.next()) {				
				bean.setId(rs.getInt("id"));
				bean.setFilm_title(rs.getString("film_title"));
				bean.setDirector(rs.getString("director"));
				bean.setYear(rs.getInt("year"));
				bean.setCountry(rs.getString("country"));
				bean.setPlayUrl(rs.getString("playurl"));
				bean.setTotalratings(rs.getInt("totalrate"));
				bean.setAvgrating(rs.getDouble("avgrate"));
				bean.setImage(rs.getString("image"));
			}
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();} 
			
			//영화별 장르 리스트 가져오기 
			sql = " select g.id, g.name from genres g inner join filmngenre fg on g.id = fg.genre_id where fg.film_id = ? " ;
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery() ; 
			
			while(rs.next()) {				
				genreList.add(rs.getString("name"));		
			}
			bean.setGenres(genreList);
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();} 
			
			
			//배우 리스트 가져오기
			sql = " select f.film_title, a.id, a.name from films f inner join filmnactor fa on f.id = fa.film_id inner join actors a on fa.actor_id = a.id where f.id = ? " ;
			pstmt = conn.prepareStatement(sql) ;			
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery() ; 
			
			while(rs.next()) {				
				actorList.put(rs.getInt("id"), rs.getString("name"));
			}
			
			bean.setActors(actorList);
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();} 
			
		} catch (Exception e) {			
			e.printStackTrace();
			bean = null ; 
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();} 
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean ;
	}
	

	

	public int DeleteFilm(int id) {
		System.out.println(id + "2차확인");
		String sql = " delete from films where id = ? " ;
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setInt(1, id);
			
			cnt = pstmt.executeUpdate() ;
			
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


	public int UpdateFilm(Film bean) {
		String sql = "update films set film_title = ?, director = ?, year = ?, country = ?, playurl = ?, image = ? where id = ? ";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getFilm_title());
			pstmt.setString(2, bean.getDirector());
			pstmt.setInt(3, bean.getYear());
			pstmt.setString(4, bean.getCountry());
			pstmt.setString(5, bean.getPlayUrl());
			pstmt.setString(6, bean.getImage());
			pstmt.setInt(7, bean.getId());
			
			System.out.println(bean.getId() + "sql실행문 확인");
			
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




	public int InsertFilm(Film bean) {
		PreparedStatement pstmt = null ;
		int cnt = -99999;
		int id = -9999999;				
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			
			//영화 기본정보 넣기
			String sql = "insert into films values(films_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getFilm_title());
			pstmt.setString(2, bean.getDirector());
			pstmt.setInt(3, bean.getYear());
			pstmt.setString(4, bean.getCountry());
			pstmt.setString(5, bean.getPlayUrl());
			pstmt.setString(6, bean.getImage());
			
			cnt = pstmt.executeUpdate(); 
			
			conn.commit();
			
		} catch (Exception e) {			
			e.printStackTrace();
			bean = null ; 
		}finally {
			try {
				if(pstmt != null) {pstmt.close();} 
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return id;
	}




	public int selectFilmByTitlenDirector(String title, String director) {
		int id = -9999;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
				
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			
			//영화 기본정보 가져오기 
			String sql = "select id from films where film_title = ? and director = ?";
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, title);
			pstmt.setString(2, director);
			rs = pstmt.executeQuery() ; 
			
			while(rs.next()) {				
				id = rs.getInt("id");
			}

		} catch (Exception e) {			
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();} 
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return id;
	}




	public int insertFilmnGenre(int filmid, String genre) {
		PreparedStatement pstmt = null ;
		int cnt = -99999;

		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			
			//영화 기본정보 넣기
			String sql = "insert into filmngenre values(?, ?)";
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setInt(1, filmid);
			pstmt.setString(2, genre);
	
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




	public int insertFilmnActor(int filmid, String actorid) {
		PreparedStatement pstmt = null ;
		int cnt = -99999;

		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			
			//영화 기본정보 넣기
			String sql = "insert into filmnactor values(?, ?)";
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setInt(1, filmid);
			pstmt.setString(2, actorid);
	
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

	public int deleteFilmnActor(int id) {
String sql = "delete from filmnactor where film_id = ?";
		
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
}
