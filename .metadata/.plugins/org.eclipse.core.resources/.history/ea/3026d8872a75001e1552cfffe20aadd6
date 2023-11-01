package ec.com.learning.restassured.restfulbooker;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PartialUpdateBookingTests extends BaseTest {

	@Test
	public void partialUpdateBookingTest() {
		// Create Booking
		Response responseCreate = createBooking();
		responseCreate.print();

		// Get bookingid of new booking
		int bookingid = responseCreate.jsonPath().getInt("bookingid");

		// Create JSON body
		JSONObject body = new JSONObject();
		body.put("firstname", "Nicole");
		body.put("lastname", "Latorre");

		// Partial Update booking
		Response responseUpdate = RestAssured.given().auth().preemptive().basic("admin", "password123")
				.contentType(ContentType.JSON).body(body.toString())
				.patch("https://restful-booker.herokuapp.com/booking/" + bookingid);
		responseUpdate.print();

		// Verifications
		// Verify response 200
		Assert.assertEquals(responseUpdate.getStatusCode(), 200, "Status code should be 200, but it's not");

		// Verify all fields
		SoftAssert softAssert = new SoftAssert();

		String actualFirstName = responseUpdate.jsonPath().getString("firstname");
		softAssert.assertEquals(actualFirstName, "Nicole", "firstname in response is not expected");

		String lastName = responseUpdate.jsonPath().getString("lastname");
		softAssert.assertEquals(lastName, "Latorre", "lastname in response is not expected");

		int price = responseUpdate.jsonPath().getInt("totalprice");
		softAssert.assertEquals(price, 111, "totalprice in response is not expected");

		boolean depositpaid = responseUpdate.jsonPath().getBoolean("depositpaid");
		softAssert.assertTrue(depositpaid, "depositpaid in response is not expected");

		String actualCheckin = responseUpdate.jsonPath().getString("bookingdates.checkin");
		softAssert.assertEquals(actualCheckin, "2018-01-01", "checkin in response is not expected");

		String actualCheckout = responseUpdate.jsonPath().getString("bookingdates.checkout");
		softAssert.assertEquals(actualCheckout, "2019-01-01", "checkout in response is not expected");

		String additionalNeeds = responseUpdate.jsonPath().getString("additionalneeds");
		softAssert.assertEquals(additionalNeeds, "Breakfast", "additionalneeds in response is not expected");

		softAssert.assertAll();
	}

}
