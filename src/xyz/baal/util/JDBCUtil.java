package xyz.baal.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * connection mysql util class
 */
public class JDBCUtil {

	private static String USERNAME;

	private static String PASSWORD;

	private static String DRIVER;

	private static String URL;

	static{
		loadConfig();
	}
	
	public static void loadConfig(){		
		try {
			InputStream inputstream = JDBCUtil.class.getResourceAsStream("/jdbc.properties");
			Properties pop = new Properties();
			pop.load(inputstream);
			USERNAME = pop.getProperty("jdbc.username");
			PASSWORD = pop.getProperty("jdbc.password");
			DRIVER = pop.getProperty("jdbc.driver");
			URL = pop.getProperty("jdbc.url");
		} catch (Exception e) {
			throw new RuntimeException("JDBC config load fail!",e);
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			throw new RuntimeException("Driver load fail!",e);
		}
		return conn;
	}

	public static void close(Connection conn, Statement stmt,
			PreparedStatement psmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
