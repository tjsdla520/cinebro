package cinebro.search.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cinebro.lists.model.FilmList;
import cinebro.common.model.SuperDao;
import cinebro.films.model.Film;
import cinebro.members.model.Member;

public class SearchDao extends SuperDao {

	public List<Film> SearchFilm(int beginRow, int endRow, String mode, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select ranking, id, film_title, director, year, country from(select id, film_title, director, year, country, rank() over(order by year desc) as ranking"
				+ " from films where " + mode + " like '%" + keyword + "%') where ranking between ? and ?" ;

		List<Film> lists = new ArrayList<Film>();
		try {
			if (this.conn == null) {
				this.conn = this.getConnection();
			}
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Film bean = new Film();
				bean.setId(rs.getInt("id"));
				bean.setFilm_title(rs.getString("film_title"));
				bean.setDirector(rs.getString("director"));
				bean.setYear(rs.getInt("year"));
				bean.setCountry(rs.getString("country"));
				lists.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists;
	}

	public List<FilmList> SearchFilmList(int beginRow, int endRow, String mode, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select ranking, id, email, list_title, maker, comments from(select l.id, l.email, l.list_title, m.nickname as maker, l.comments, rank() over(order by l.list_title desc) as ranking from lists l inner join members m on l.email = m.email";
		sql += " where " + mode + " like '%" + keyword + "%'";
		sql += " ) where ranking between ? and ?";

		List<FilmList> lists = new ArrayList<FilmList>();
		try {
			if (this.conn == null) {
				this.conn = this.getConnection();
			}
			pstmt = this.conn.prepareStatement(sql);

			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FilmList bean = new FilmList();
				bean.setId(rs.getInt("id"));
				bean.setEmail(rs.getString("email"));
				bean.setList_title(rs.getString("list_title"));
				bean.setComments(rs.getString("comments"));
				bean.setNickname(rs.getString("maker"));
				lists.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists;
	}

	public List<Member> SearchMember(int beginRow, int endRow, String mode, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select ranking, email, password, nickname, cardnumber, enddate, name, favoriteFilm, favoriteGenre, follower, "
				+ "Reviews ";
		sql += " from(select email, password, nickname, cardnumber, enddate, name, favoriteFilm, favoriteGenre, follower, allReviews ";
		sql += " rank()over(order by nickname asc) as ranking from members ";
		sql += " where " + mode + " like '%" + keyword + "%'";
		sql += " ) where ranking between ? and ?";

		List<Member> lists = new ArrayList<Member>();
		try {
			if (this.conn == null) {
				this.conn = this.getConnection();
			}
			pstmt = this.conn.prepareStatement(sql);

			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member bean = new Member();
				
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setNickname(rs.getString("nickname"));
				bean.setCardnumber(rs.getString("cardnumber"));
				bean.setEnddate(rs.getString("enddate"));
				bean.setName(rs.getString("name"));
				bean.setFavoriteFilm(rs.getString("favoriteFilm"));
				bean.setFavoriteGenre(rs.getString("favoriteGenre"));
				bean.setFollower(rs.getInt("follower"));
				bean.setAllReviews(rs.getInt("allReviews"));
				
				lists.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists;
	}

	public int SelectTotalCount(String mode, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int cnt = 0;
		try {
			if (this.conn == null) {
				this.conn = this.getConnection();
			}

				String sql = " select count(*) as cnt from films";
					sql += " where " + mode + " like '%" + keyword + "%'"  ;
					pstmt = this.conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						cnt = rs.getInt("cnt");
					}
					if (rs != null) {
						rs.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}

	public int SelectListTotalCount(String mode, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int cnt = 0;
		try {
			if (this.conn == null) {
				this.conn = this.getConnection();
			}

				String sql = " select count(*) as cnt from lists";
					sql += " where " + mode + " like '%" + keyword + "%'"  ;
					pstmt = this.conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						cnt = rs.getInt("cnt");
					}
					if (rs != null) {
						rs.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}
}
