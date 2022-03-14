package step01.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import step01.User;
import step01.dao.UserDao;

public class JdbcUserDaoImpl implements UserDao {
	private String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
	private String dbuser = "victory";
	private String dbpwd = "victory123";

	/// Constructor
	public JdbcUserDaoImpl() {
		System.out.println("::==>" + getClass().getName() + ".UserDAO Default Constructor");
	}

	/// Method
	// ==> 회원정보 :: INSERT ( 회원가입 )
	public int addUser(User user) throws Exception {
		// ::JDBC 절차에 따른 instance 생성
		Connection con = null;
		PreparedStatement pStmt = null;

		try {
			// 1단계 connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl, dbuser, dbpwd);

			// 2단계 INSERT 문을 생성및 전송
			StringBuffer insertQuery = new StringBuffer();
			insertQuery.append("INSERT ");
			insertQuery.append("INTO USERS( user_id,user_name,password,age,reg_date) ");
			insertQuery.append("VALUES( ? , ? , ? , ? , ? )");

			pStmt = con.prepareStatement(insertQuery.toString());
			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, user.getUserName());
			pStmt.setString(3, user.getPassword());
			pStmt.setInt(4, user.getAge());
			pStmt.setTimestamp(5, user.getRegDate());

			// 3단계 INSERT 실행
			return pStmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			// 4. 각각의 DB와 관련된 instance close
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch (Exception e2) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e3) {
				}
			}
		}
	}// end of method

	// ==> 회원정보 :: SELECT ( 회원정보 검색 )
	public User getUser(String userId) throws Exception {
		// ::JDBC 절차에 따른 instance 생성
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet result = null;

		try {
			// 1단계 connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl, dbuser, dbpwd);

			// 2단계 SELECT 문 생성 및 전송
			StringBuffer userSelect = new StringBuffer();
			userSelect.append("SELECT ");
			userSelect.append("user_id, user_name, password, age, reg_date ");
			userSelect.append("FROM USERS ");
			userSelect.append("WHERE user_id = ?");

			pStmt = con.prepareStatement(userSelect.toString());
			pStmt.setString(1, userId);

			// 3단계 SELECT 실행
			result = pStmt.executeQuery();

			// 4단계 SELECT 결과 처리( ? ) :: Domain Object 에 회원정보 set(Binding)
			User user = null;
			if (result.next()) {
				user = new User();
				user.setUserId(result.getString("user_id"));
				user.setUserName(result.getString("user_name"));
				user.setPassword(result.getString("password"));
				user.setAge(result.getInt("age"));
				user.setRegDate(result.getTimestamp("reg_date"));
			}

			return user;

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			// 5. 각각의 DB와 관련된 instance close
			if (result != null) {
				try {
					result.close();
				} catch (Exception e1) {
				}
			}
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch (Exception e2) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e3) {
				}
			}
		}
	}// end of method

	// ==> 회원정보 :: UPDATE ( 회원정보 변경 )
	public int updateUser(User user) throws Exception {
		// ::JDBC 절차에 따른 instance 생성
		Connection con = null;
		PreparedStatement pStmt = null;

		try {
			// 1단계 connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl, dbuser, dbpwd);

			// 2단계 UPDATE 문 생성및 전송
			StringBuffer userUpdate = new StringBuffer();
			userUpdate.append("UPDATE USERS ");
			userUpdate.append("SET  user_name = ?, password = ?,age = ? ");
			userUpdate.append("WHERE user_id = ?");

			pStmt = con.prepareStatement(userUpdate.toString());
			pStmt.setString(1, user.getUserName());
			pStmt.setString(2, user.getPassword());
			pStmt.setInt(3, user.getAge());
			pStmt.setString(4, user.getUserId());

			// 3단계 UPDATE 실행
			return pStmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			// 4. 각각의 DB와 관련된 instance close
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch (Exception e2) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e3) {
				}
			}
		}
	}

	// ==> 회원정보 :: DELETE ( 회원정보 삭제 )
	public int removeUser(String userId) throws Exception {
		// ::JDBC 절차에 따른 instance 생성
		Connection con = null;
		PreparedStatement pStmt = null;

		try {
			// 1단계 connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl, dbuser, dbpwd);

			// 2단계 DELETE 문 생성및 전송
			StringBuffer userDelete = new StringBuffer();
			userDelete.append("DELETE ");
			userDelete.append("FROM USERS ");
			userDelete.append("WHERE user_id = ?");

			pStmt = con.prepareStatement(userDelete.toString());
			pStmt.setString(1, userId);

			// 3단계 DELETE 실행
			return pStmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			// 4. 각각의 DB와 관련된 instance close
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch (Exception e2) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e3) {
				}
			}
		}
	}// end of class

	// ==> 회원정보 :: SELECT ( 모든 회원 정보 검색 )
	public List<User> getUserList() throws Exception {
		// ::JDBC 절차에 따른 instance 생성
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet selectResult = null;

		try {
			// 1단계 connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl, dbuser, dbpwd);

			// 2단계 SELECT 문 생성 및 전송
			StringBuffer userSelectAll = new StringBuffer();
			userSelectAll.append("SELECT ");
			userSelectAll.append("user_id, user_name, password, age, reg_date ");
			userSelectAll.append("FROM USERS ");

			pStmt = con.prepareStatement(userSelectAll.toString());

			// 3단계 SELECT 실행
			selectResult = pStmt.executeQuery();

			// 4단계 SELECT 결과 처리( ? ) :: Domain Object 에 회원정보 set(Binding)
			// ==> DB 에 저장된 모든 회원정보를 ArrayList에 저장하기 위한....
			ArrayList<User> arrayList = new ArrayList<User>();

			while (selectResult.next()) {
				User user = new User();
				user.setUserId(selectResult.getString("user_id"));
				user.setUserName(selectResult.getString("user_name"));
				user.setPassword(selectResult.getString("password"));
				user.setAge(selectResult.getInt("age"));
				user.setRegDate(selectResult.getTimestamp("reg_date"));

				arrayList.add(user);
			}

			return arrayList;

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			// 5. 각각의 DB와 관련된 instance close
			if (selectResult != null) {
				try {selectResult.close();} catch (Exception e1) {}
			}
			if (pStmt != null) {
				try {pStmt.close();} catch (Exception e2) {}
			}
			if (con != null) {
				try {con.close();} catch (Exception e3) {}
			}
		}
	}
}