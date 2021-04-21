package APITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_Get_Request_PrintAllHeaders {

	@Test
	public void GetWeatherDetails() 
	{
		//Specify Base URI
		RestAssured.baseURI ="https://maps.googleapis.com";
		
		//Create a Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Create a Response Object
		Response response = httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//Print Response in console window
		String responseBody = response.getBody().asString();
		System.out.println("The ResponseBody is :" + responseBody);
		
		Headers allheaders = response.headers(); //This will capture all the headers in a key and value format(HashMap)
		
		for(Header header:allheaders) 
		{
			System.out.println(header.getName() +"             " + header.getValue());
		
		}
	}
}
