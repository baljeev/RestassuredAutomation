package APITesting;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class TC007_Get_Request_Authorisation{
	
	@Test
	public void AuthorisationTest() 
	{
	//Specify Base URI

	RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
	
	//Basic Authentication
	PreemptiveBasicAuthScheme authentic = new PreemptiveBasicAuthScheme();
	authentic.setUserName("ToolsQA");
	authentic.setPassword("TestPassword");
	RestAssured.authentication = authentic;

	//Create a Request Object
	RequestSpecification httpRequest = RestAssured.given();

	//Create a Response Object
	Response response = httpRequest.request(Method.GET,"/");
	//Print Response in console window

	String responseBody = response.getBody().asString();
	System.out.println("Response body is :" + responseBody);

//Status code validation
	int responseCode = response.getStatusCode();
	System.out.println("Response code is :" + responseCode );
	Assert.assertEquals(responseCode, 200);
}
}
