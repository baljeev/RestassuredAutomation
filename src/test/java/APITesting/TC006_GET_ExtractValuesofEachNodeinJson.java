package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_ExtractValuesofEachNodeinJson {
	
	@Test
	public void getWeatherDetails() throws InterruptedException 
	{
	//Specify Base URI
		RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
		
		//Create a Request Object
		RequestSpecification httpRequest =RestAssured.given();
		
		//Create a Response Object
		Response response = httpRequest.request(Method.GET,"/Delhi");
		
		//Capture the complete path of response body and store that in to a variable
		JsonPath jsonpath = response.jsonPath(); //This contains the whole value of the response body
		
		Thread.sleep(5000);
		
		System.out.println(jsonpath.get("City"));
		System.out.println(jsonpath.get("Temperature"));
		System.out.println(jsonpath.get("Humidity"));
		System.out.println(jsonpath.get("WeatherDescription"));
		System.out.println(jsonpath.get("WindSpeed"));
		System.out.println(jsonpath.get("WindDirectionDegree"));
		Assert.assertEquals(jsonpath.get("Temperature"),"33.17 Degree celsius" );
	}
	
	
	
	

}
