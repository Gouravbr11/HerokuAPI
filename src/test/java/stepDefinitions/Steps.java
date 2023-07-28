package stepDefinitions;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;



public class Steps {
	RequestSpecification req;
	Response res;

@Given("^Pass the valid (.+) and (.+)$")
public void pass_the_valid_admin_and_password123(String username, String password) {
	RestAssured.baseURI="https://restful-booker.herokuapp.com";
	 req=given().header("Content-Type","application/json").body("{\r\n"
			+ "    \"username\" : \""+username+"\",\r\n"
			+ "    \"password\" : \""+password+"\"\r\n"
			+ "}");
}
@When("^submit the api with (.+)$")
public void submit_the_api_with_post(String reqType) {
	
	if(reqType.equalsIgnoreCase("POST")||reqType.equalsIgnoreCase("GET")||reqType.equalsIgnoreCase("DELETE")) 
	{
		 res=req.when().post("/auth");
	}
    
}
@Then("validate that status code is {string}")
public void validate_that_status_code_is(String resCode) {
	
	res.then().log().all();
	assertEquals(res.statusCode(),200);
   
}


	

}
