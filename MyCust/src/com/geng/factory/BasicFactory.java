package com.geng.factory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BasicFactory {
	static BasicFactory factory=new BasicFactory();
	private static Properties prop=null;
	private BasicFactory() {
	}
 
	public static BasicFactory getFactory(){
		return factory;
	}
	
	static{
		prop=new Properties();
		try {
			prop=new Properties();
			prop.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public <T> T getInstence(Class<T> clazz){
		String cName=clazz.getSimpleName();
		String ImplCName=prop.getProperty(cName);
		try {
			return (T) Class.forName(ImplCName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
