package br.com.secoti.util;

import java.io.IOException;
import java.util.Properties;

public abstract class PropUtil {
	
	private static Properties prop = new Properties();
	
	public static String get(String key) {
		try {
			prop.load(PropUtil.class.getClassLoader().getResourceAsStream("config.properties"));
			Object value = prop.get(key);
			
			if(value != null) {
				return value.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}