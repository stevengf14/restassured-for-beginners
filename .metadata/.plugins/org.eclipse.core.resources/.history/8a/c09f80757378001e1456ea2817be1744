package ec.com.learning.restassured.restfulbooker;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateBookingTests extends BaseTest {

	//@Test
	public void createBookingTest() {
		// Create Booking
		Response response = createBooking();
		response.print();

		// Verifications
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");

		// Verify all fields
		SoftAssert softAssert = new SoftAssert();

		String actualFirstName = response.jsonPath().getString("booking.firstname");
		softAssert.assertEquals(actualFirstName, "Jim", "firstname in response is not expected");

		String lastName = response.jsonPath().getString("booking.lastname");
		softAssert.assertEquals(lastName, "Brown", "lastname in response is not expected");

		int price = response.jsonPath().getInt("booking.totalprice");
		softAssert.assertEquals(price, 111, "totalprice in response is not expected");

		boolean depositpaid = response.jsonPath().getBoolean("booking.depositpaid");
		softAssert.assertTrue(depositpaid, "depositpaid in response is not expected");

		String actualCheckin = response.jsonPath().getString("booking.bookingdates.checkin");
		softAssert.assertEquals(actualCheckin, "2018-01-01", "checkin in response is not expected");

		String actualCheckout = response.jsonPath().getString("booking.bookingdates.checkout");
		softAssert.assertEquals(actualCheckout, "2019-01-01", "checkout in response is not expected");

		String additionalNeeds = response.jsonPath().getString("booking.additionalneeds");
		softAssert.assertEquals(additionalNeeds, "Breakfast", "additionalneeds in response is not expected");

		softAssert.assertAll();
	}

	@Test
	public void createBookingWithPOJOTest() {
		// Create body using POJOs
		Bookingdates bookingdates = new Bookingdates("2020-03-25", "2023-03-27");
		Booking booking = new Booking("Nicole", "Latorre", 200, false, bookingdates, "Baby crib");

		// Get response
		Response response = RestAssured.given(spec).contentType(ContentType.JSON).body(booking).post("/booking");
		response.print();

		// Verifications
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");

		// Verify all fields
		SoftAssert softAssert = new SoftAssert();

		String actualFirstName = response.jsonPath().getString("booking.firstname");
		softAssert.assertEquals(actualFirstName, "Nicole", "firstname in response is not expected");

		String lastName = response.jsonPath().getString("booking.lastname");
		softAssert.assertEquals(lastName, "Latorre", "lastname in response is not expected");

		int price = response.jsonPath().getInt("booking.totalprice");
		softAssert.assertEquals(price, 200, "totalprice in response is not expected");

		boolean depositpaid = response.jsonPath().getBoolean("booking.depositpaid");
		softAssert.assertFalse(depositpaid, "depositpaid in response is not expected");

		String actualCheckin = response.jsonPath().getString("booking.bookingdates.checkin");
		softAssert.assertEquals(actualCheckin, "2020-03-251", "checkin in response is not expected");

		String actualCheckout = response.jsonPath().getString("booking.bookingdates.checkout");
		softAssert.assertEquals(actualCheckout, "2023-03-27", "checkout in response is not expected");

		String additionalNeeds = response.jsonPath().getString("booking.additionalneeds");
		softAssert.assertEquals(additionalNeeds, "Baby crib", "additionalneeds in response is not expected");

		softAssert.assertAll();
	}

}
