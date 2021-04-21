package APITesting;

import org.json.simple.JSONObject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	@Test
	void RegistrationTesting() 
	{
		//This is the first step =Specify base URI
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		
		//Second Step =We have to create a Request Object 
		RequestSpecification httpRequest = RestAssured.given();
		
		//In Post Request we have to send some pay load(Request Parameters) with post request (Normally with JSON Format)
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "baljev123");
		requestParams.put("LastName", "Radha1343");
		requestParams.put("UserName", "Radha676");
		requestParams.put("Password", "12345");
		requestParams.put("Email", "1235456@gmail.com");
		
		httpRequest.header("Content-Type","application/json");//This will specify what type of format we are sending with the request
		httpRequest.body(requestParams.toJSONString()); //this will attach the data to the request
		
		//Create a response object to collect the response from request.
		Response response = httpRequest.request(Method.POST,"/register");
		
		//This will capture the response in a variable(responseBody)from response.
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);
		
		//This will capture the response code from response
		int statusCode = response.getStatusCode();
		System.out.println("Status code is :" + statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//Getting Success code from response (it is normally inJSON format) and validating
		
		String successCode = response.jsonPath().get("SuccessCode");
		System.out.println("Success code is :" + successCode);
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}
	
	
	
	
	
	
	

}
