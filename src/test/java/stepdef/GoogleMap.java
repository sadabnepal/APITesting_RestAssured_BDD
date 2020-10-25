package stepdef;

import java.io.FileNotFoundException;

import org.junit.Assert;

import base.CrudOperation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Utilities;

public class GoogleMap extends CrudOperation{
	public static Response response;
	JsonPath js;
	public static String placeID;

	@Given("User calls {string} with {string} http request")
	public void user_calls_request_with_http_request(String apiName, String requestType) throws FileNotFoundException {
		if(requestType.equalsIgnoreCase("POST")) {
			response = performPOSTcall(apiName);
		} else if(requestType.equalsIgnoreCase("GET")) {
//			response = performGETcall(apiName);
		}
	}
	
	@Then("Status code is {int}")
	public void status_code_is(Integer int1) {
		System.out.println("Status Code: "+response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String value1, String value2) {
		js = Utilities.rawToJson(response);
		Assert.assertEquals(js.get(value1), value2);
	}
	
	@Then("I retrieve the Place ID")
	public void i_retrieve_the_place_id() {
		js = Utilities.rawToJson(response);
		placeID = js.get("place_id");
		System.out.println("Place ID: "+placeID);
	}

}
