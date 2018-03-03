package com.epcompany.emepeAPI.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class ConnectionManager {

	// JDBC Driver Name & Database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/emepeTest";

	// JDBC Database Credentials
	static final String JDBC_USER = "root";
	static final String JDBC_PASS = "root";
	
	// Connection object
	private static Connection connection;

	private static GenericObjectPool gPool = null;
	
	public ConnectionManager() {
		DataSource dataSource;
		try {
			dataSource = this.setUpPool();
			connection = dataSource.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@SuppressWarnings("unused")
	public DataSource setUpPool() throws Exception {
		Class.forName(JDBC_DRIVER);

		// Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object!
		gPool = new GenericObjectPool();
		gPool.setMaxActive(5);

		// Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!
		ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASS);

		// Creates a PoolableConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
		return new PoolingDataSource(gPool);
	}

	public static GenericObjectPool getConnectionPool() {
		return gPool;
	}
	
	public static int getLastGenerated(String tabla){
		int res = 0;
		ResultSet rSet = null;
		PreparedStatement pstmtObj = null;
		try {
			
			pstmtObj = connection.prepareStatement("select auto_increment from INFORMATION_SCHEMA.TABLES where table_name = '"+tabla+"'");
			rSet = pstmtObj.executeQuery();
			rSet.next();
			res = rSet.getInt(1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

		
	public static Connection getConnection() {
		return connection;
	}
	
}
