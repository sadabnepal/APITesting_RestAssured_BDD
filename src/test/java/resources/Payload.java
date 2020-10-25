package resources;

import java.util.ArrayList;
import java.util.HashMap;

public class Payload {
	
	public static HashMap<String, Object> addPlacePayload() {
		HashMap<String, Object> addplace = new HashMap<String, Object>();
		
		HashMap<String, Object> locmap = new HashMap<String, Object>();
		locmap.put("lat", "-38.383494");
		locmap.put("lng", "33.427362");
		
		addplace.put("location", locmap);
		addplace.put("accuracy", "50");
		addplace.put("name", "API house");
		addplace.put("phone_number", "(+91) 983 893 3937");
		addplace.put("address", "29, side layout, cohen 09");
		
		ArrayList<String> typelist=new ArrayList<String>();
		typelist.add("shoe park");
		typelist.add("shop");
		
		addplace.put("types", typelist);
		addplace.put("website", "http://google.com");
		addplace.put("language", "French-IN");
		return addplace;
	}

	public static HashMap<String, Object> deletePayload(String placeId) {
		HashMap<String, Object> deleteplacemap = new HashMap<String, Object>();
		deleteplacemap.put("place_id", placeId);
		return deleteplacemap;
	}
}
