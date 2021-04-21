package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_Get_Request_ValidatingJSONResponse {
	@Test
	public void getWeatherDetails() 
	{
		//Create Base URI
		RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
		
		//Create Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Create a Response Object
		Response response =httpRequest.request(Method.GET,"/Delhi");
		
		//Print Response in console Window
		String responseBody = response.getBody().asString();
		System.out.println("The response body is :" + responseBody);
		Assert.assertEquals(responseBody.contains("Delhi"), true);







	}

}
