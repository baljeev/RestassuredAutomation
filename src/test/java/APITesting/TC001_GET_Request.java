package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {

	@Test
	void getweatherDetails() 
	{
		//This is First Step =Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		//Second Step =This is creating a Request Object
		RequestSpecification httpRequest =RestAssured.given();

		//Third Step =This is creating a Response Object
		Response response = httpRequest.request(Method.GET,"/Hyderabad");

		//Print Response in the console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" +responseBody);

		//Getting status code from response and validating it
		int statuscode = response.getStatusCode();
		System.out.println("status code is :" + statuscode);
		Assert.assertEquals(statuscode, 200);

		//Capture status line from response and validating it
		String statusline = response.getStatusLine();
		System.out.println("Status Line is :" + statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");



	}
}
