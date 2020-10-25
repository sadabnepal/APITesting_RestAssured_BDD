package base;

import java.io.FileNotFoundException;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Utilities;

public class CrudOperation extends BaseBuilder {
	static Response response;
	
	public Response performPOSTcall(String apiName) throws FileNotFoundException {
		
		if(apiName.equalsIgnoreCase("addPlaceAPI")) {
			response = postAddPlace();
		}
		else if(apiName.equalsIgnoreCase("deletePlaceAPI")) {
			if(response == null) {
				performPOSTcall("addPlaceAPI");
			}
			JsonPath js = Utilities.rawToJson(response);
			String placeId = js.get("place_id").toString();
			response = postDeletePlace(placeId);
		}
		return response;
	}

}
