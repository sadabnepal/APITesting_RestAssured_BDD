package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utilities {

	public static JsonPath rawToJson(Response response) {
		JsonPath js = new JsonPath(response.body().asString());
		return js;
	}
}
