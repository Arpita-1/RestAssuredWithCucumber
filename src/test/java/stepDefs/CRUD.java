package stepDefs;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CRUD {
	
	Response response;
	RequestSpecification request;
	Map<String,Object> MapObj ;
	
	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) {
	    // Write code here that turns the phrase above into concrete actions
	
		request = RestAssured.given().baseUri(URI);

	}

	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
	    // Write code here that turns the phrase above into concrete actions
		response = request.get();

	  
	}

	@Then("Response code should be {int}")
	public void response_code_should_be(int expResponsecode) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(expResponsecode, response.getStatusCode());
		
	   
	}
	@When("I enter the name as {string} and salary as {string}")
	public void i_enter_the_name_as_and_salary_as(String name, String salary) {
	    // Write code here that turns the phrase above into concrete actions
		
		MapObj = new HashMap<String,Object>();
		MapObj.put("name", name);
		MapObj.put("salary", salary);
	  
	   
	}

	@When("I perform Post operation")
	public void i_perform_Post_operation() {
	    // Write code here that turns the phrase above into concrete actions
		 response =(request.contentType(ContentType.JSON).accept(ContentType.JSON).body(MapObj).post("/create"));
		 System.out.println(response.getBody().asString());

	}
	

}
