package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Payload;
import utilities.PropertiesReader;

public class BaseBuilder {
	PropertiesReader pro = new PropertiesReader();
	RequestSpecBuilder builder;
	RequestSpecification reqspec;
	Response response;
		
	public Response postAddPlace() {
		String addPlacePayload = Payload.addPlacePayload();
		builder = new RequestSpecBuilder();
		builder.setBaseUri(pro.getPropValue("rahulShettyBaseURI"));
		builder.addQueryParam("key", "qaclick123");
		builder.setContentType("application/json");
		reqspec =  builder.build();
		reqspec = RestAssured.given().spec(reqspec).body(addPlacePayload);
		response = reqspec.post("/maps/api/place/add/json").then().extract().response();
		return response;
	}
	
	public Response postDeletePlace(String placeId) {
		String deletePayload = Payload.deletePayload(placeId);
		builder = new RequestSpecBuilder();
		builder.setBaseUri(pro.getPropValue("rahulShettyBaseURI"));
		builder.addQueryParam("key", "qaclick123");
		builder.setContentType("application/json");
		reqspec = builder.build();
		reqspec = RestAssured.given().spec(reqspec).body(deletePayload);
		response = reqspec.post("/maps/api/place/delete/json").then().extract().response();
		return response;
	}
}
