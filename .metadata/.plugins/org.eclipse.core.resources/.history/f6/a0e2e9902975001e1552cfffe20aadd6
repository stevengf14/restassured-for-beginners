package ec.com.learning.restassured.restfulbooker;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingTests {

	@Test
	public void getBookingTest() {
		// Get response with booking ids
		Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/5");
		response.print();

		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");

		// Verify all fields
		SoftAssert softAssert = new SoftAssert();

		String actualFirstName = response.jsonPath().getString("firstname");
		softAssert.assertEquals(actualFirstName, "Mary", "firstname in response is not expected");

		String lastName = response.jsonPath().getString("lastname");
		softAssert.assertEquals(lastName, "Jackson", "lastname in response is not expected");

		int price = response.jsonPath().getInt("totalprice");
		softAssert.assertEquals(price, 246, "totalprice in response is not expected");

		boolean depositpaid = response.jsonPath().getBoolean("depositpaid");
		softAssert.assertFalse(depositpaid, "depositpaid in response is not expected");

		String actualCheckin = response.jsonPath().getString("bookingdates.checkin");
		softAssert.assertEquals(actualCheckin, "2015-05-19", "checkin in response is not expected");

		String actualCheckout = response.jsonPath().getString("bookingdates.checkout");
		softAssert.assertEquals(actualCheckout, "2023-04-09", "checkout in response is not expected");

		String additionalNeeds = response.jsonPath().getString("additionalneeds");
		softAssert.assertEquals(additionalNeeds, "Breakfast", "additionalneeds in response is not expected");

		softAssert.assertAll();

	}
}
