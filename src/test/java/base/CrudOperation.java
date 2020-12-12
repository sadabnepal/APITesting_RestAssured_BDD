package base;

import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Payload;
import stepdef.GoogleMap;

public class CrudOperation  {
	static Response response;
	RequestSpecification reqspec;
	
	public Response performPOSTcall(String apiName) throws FileNotFoundException {
		APIResources resourceAPI= APIResources.valueOf(apiName);
		reqspec = new BaseBuilder().placeSpecBuilder();
		
		if(apiName.equalsIgnoreCase("AddPlaceAPI")) 
		{
			System.out.println("Sending POST request to: "+resourceAPI.getResource()+" service");
			reqspec = RestAssured.given().spec(reqspec).body(Payload.addPlacePayload());
		}
		else if(apiName.equalsIgnoreCase("DeletePlaceAPI")) 
		{
			if(GoogleMap.placeID == null) {
				GoogleMap gm = new GoogleMap();
				gm.user_calls_request_with_http_request("AddPlaceAPI", "POST");
				gm.i_retrieve_the_place_id();
			}
			System.out.println("Sending POST request to: "+resourceAPI.getResource()+" service");
			reqspec = RestAssured.given().spec(reqspec).body(Payload.deletePayload(GoogleMap.placeID));
		}
		response = reqspec.post(resourceAPI.getResource()).then().extract().response();
		return response;
	}

}
