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
	
	public Response getCitySpec() {
		String apiKey = pro.getPropValue("openWeatherAPIKey");
		String cityName = "India";
		
		builder = new RequestSpecBuilder();
		builder.setBaseUri(pro.getPropValue("openWeatherBaseURI"));
		builder.addQueryParam("q", cityName);
		builder.addQueryParam("appid", apiKey);
		reqspec = builder.build();
		reqspec = RestAssured.given().spec(reqspec);
		return response =  reqspec.get("/data/2.5/weather");
	}
	
	public Response gethttpbin() {
		builder = new RequestSpecBuilder();
		builder.setBaseUri(pro.getPropValue("httpbinBaseURI"));
		builder.setAccept("application/json");
		reqspec = builder.build();
		reqspec = RestAssured.given().spec(reqspec);
		return response =  reqspec.get("/get");	
	}
	
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
