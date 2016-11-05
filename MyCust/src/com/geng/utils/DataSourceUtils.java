package com.geng.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	static DataSource source=new ComboPooledDataSource();
	private DataSourceUtils() {
	}
	
	public static DataSource getSource(){
		return source;
	}
	
	public static Connection getConnection(){
		try {
			return source.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
