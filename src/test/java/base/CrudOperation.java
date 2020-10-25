package base;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Utilities;

public class CrudOperation {
	static Response response;
	
	public Response performGETcall(String apiName) {
		
		if(apiName.equalsIgnoreCase("getWeatherAPI")) { 
			response = new BaseBuilder().getCitySpec(); 
		} 
		else if(apiName.equalsIgnoreCase("getHttpBin")) { 
			response = new BaseBuilder().gethttpbin(); 
		}
		
		response = response.then().statusCode(200).extract().response();
		return response;
	}
	
	public Response performPOSTcall(String apiName) {
		
		if(apiName.equalsIgnoreCase("addPlaceAPI")) {
			response = new BaseBuilder().postAddPlace();
		}
		else if(apiName.equalsIgnoreCase("deletePlaceAPI")) {
			if(response == null) {
				performPOSTcall("addPlaceAPI");
			}
			JsonPath js = Utilities.rawToJson(response);
			String placeId = js.get("place_id").toString();
			response = new BaseBuilder().postDeletePlace(placeId);
		}
		return response;
	}

}
