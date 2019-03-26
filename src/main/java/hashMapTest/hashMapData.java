package hashMapTest;

import java.util.HashMap;

public class hashMapData {
	
	public static HashMap<String, String> getUserLoginInfo() {
		
		HashMap<String, String> userMap = new HashMap<String, String>();
		
		userMap.put("1stAdmin", "admin_admin123");
		userMap.put("2ndAdmin", "Admin_admin123");
		
		
		
		return userMap;
	}
	
	public static HashMap<Integer, String> monthMap() {
		HashMap<Integer, String> monthMap = new HashMap<Integer, String>();
		
		monthMap.put(1, "January");
		monthMap.put(2, "February");
		monthMap.put(3, "March");
		monthMap.put(4, "April");
		
		return monthMap;
	}

}
