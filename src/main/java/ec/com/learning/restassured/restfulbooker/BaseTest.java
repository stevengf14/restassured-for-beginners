package ec.com.learning.restassured.restfulbooker;

import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	protected RequestSpecification spec;

	@BeforeMethod
	public void setUp() {
		spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
	}

	protected Response createBooking() {
		// Create JSON body
		JSONObject body = new JSONObject();
		body.put("firstname", "Jim");
		body.put("lastname", "Brown");
		body.put("totalprice", 111);
		body.put("depositpaid", true);

		JSONObject bookingdates = new JSONObject();
		bookingdates.put("checkin", "2018-01-01");
		bookingdates.put("checkout", "2019-01-01");

		body.put("bookingdates", bookingdates);
		body.put("additionalneeds", "Breakfast");

		// Get response
		Response response = RestAssured.given(spec).contentType(ContentType.JSON).body(body.toString())
				.post("/booking");
		return response;
	}
}
