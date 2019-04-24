package com.sh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBConnector {

	public static Connection getConnection() throws Exception{

		String user = "teacher";
		String password = "teacher";
		String url = "jdbc:oracle:thin:@211.238.142.30:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);

		Connection conn= DriverManager.getConnection(url, user, password);

		return conn;
	}

	public static void disConnect(PreparedStatement st, Connection conn) throws Exception{
		st.close();
		conn.close();
	}

	public static void disConnect(PreparedStatement st, Connection conn, ResultSet rs) throws Exception{
		rs.close();
		DBConnector.disConnect(st, conn);
	}

}
