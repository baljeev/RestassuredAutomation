package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {

@Test
	void googleMapTest() 
	{
		//Specify Base URI
		RestAssured.baseURI ="https://maps.googleapis.com";

		//Create a Request Object
		RequestSpecification httpRequest = RestAssured.given();

		//Create a Response Object
		Response response = httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		//Print Response in console window

		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);
		

		int responseCode = response.getStatusCode();
		System.out.println("Response code is :" + responseCode );
		Assert.assertEquals(responseCode, 200);

		//Capture details of headers from response and validate it
		String contType = response.header("Content-Type");
		System.out.println("This is Content-Type :" + contType);
		Assert.assertEquals(contType, "application/xml; charset=UTF-8");

		String pragma = response.header("Pragma");
		System.out.println("This is pragma:" +pragma);
		Assert.assertEquals(pragma, "no-cache");

		String contEncode = response.header("Content-Encoding");
		System.out.println("This is Content Encoding:"+ contEncode);
		Assert.assertEquals(contEncode, "gzip");





	}



}
