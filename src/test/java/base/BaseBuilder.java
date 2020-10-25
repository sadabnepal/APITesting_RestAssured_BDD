package base;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Payload;
import utilities.PropertiesReader;

public class BaseBuilder {
	PropertiesReader pro = new PropertiesReader();
	RequestSpecBuilder builder;
	RequestSpecification reqspec;
	Response response;
	PrintStream log;
		
	public Response postAddPlace() throws FileNotFoundException {
		String addPlacePayload = Payload.addPlacePayload();
		builder = new RequestSpecBuilder();
		builder.setBaseUri(pro.getPropValue("rahulShettyBaseURI"));
		builder.addQueryParam("key", "qaclick123");
		builder.setContentType("application/json");
		log = new PrintStream(new FileOutputStream("log.txt"));
		builder.addFilter(RequestLoggingFilter.logRequestTo(log));
		builder.addFilter(ResponseLoggingFilter.logResponseTo(log));
		reqspec =  builder.build();
		reqspec = RestAssured.given().spec(reqspec).body(addPlacePayload);
		response = reqspec.post("/maps/api/place/add/json").then().extract().response();
		return response;
	}
	
	public Response postDeletePlace(String placeId) throws FileNotFoundException {
		String deletePayload = Payload.deletePayload(placeId);
		builder = new RequestSpecBuilder();
		builder.setBaseUri(pro.getPropValue("rahulShettyBaseURI"));
		builder.addQueryParam("key", "qaclick123");
		builder.setContentType("application/json");
		log = new PrintStream(new FileOutputStream("log.txt"));
		builder.addFilter(RequestLoggingFilter.logRequestTo(log));
		builder.addFilter(ResponseLoggingFilter.logResponseTo(log));
		reqspec = builder.build();
		reqspec = RestAssured.given().spec(reqspec).body(deletePayload);
		response = reqspec.post("/maps/api/place/delete/json").then().extract().response();
		return response;
	}
}
