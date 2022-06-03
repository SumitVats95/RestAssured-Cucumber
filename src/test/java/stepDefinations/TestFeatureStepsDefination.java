package stepDefinations;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.google.common.io.Files;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestPojo.User;

public class TestFeatureStepsDefination {
	String base_Url = "https://reqres.in/";
	RequestSpecification request;
	Response response;
	
	
	@Given("I set base URL of the API.")
	public void i_set_base_url_of_the_api() {
		RestAssured.baseURI = base_Url;
		request = RestAssured.given()
				.log().all();
	}
	@Given("I set headers of the API.")
	public void i_set_headers_of_the_api() {
		request.header("content-type", "application/json");
	}
	@Given("I set the query param\\(s) of the API.")
	public void i_set_the_query_param_s_of_the_api() {
		request.queryParam("page", 2);
	}
	@When("I send request to see all users on page")
	public void i_send_request_to_see_all_users_on_page() {
		response = request.get("/api/users");
	}
	@Then("I validate the API response code.")
	public void i_validate_the_api_response_code() {
		Assert.assertEquals(200, response.getStatusCode());
	}
	@Then("I validate the API response body.")
	public void i_validate_the_api_response_body() {
		System.out.println(response.asPrettyString());
	}


	@When("I send request with payload")
	public void i_send_request_with_payload() throws IOException {
		//1. reading data from json file and sending as string
		//		String file = "/home/daffolap-976/Documents/RestAssuredTeamDemo/src/test/java/jsonData/createUser.json";
		//		String file1 = new String(java.nio.file.Files.readAllBytes(Paths.get(file)));
		//	    response = request.body(file1).post("/api/users");

		//2. sending json payload as string
		//	    response =  request.body("{\n"
		//	    		+ "    \"name\": \"morpheus\",\n"
		//	    		+ "    \"job\": \"leader\"\n"
		//	    		+ "}").post("/api/users");


		//3. using map interface
		//	    Map<String, String> postRequestBody = new HashMap<String, String>();
		//	    postRequestBody.put("name", "morpheus");
		//	    postRequestBody.put("job", "leader");
		//	    response = request.body(postRequestBody).post("/api/users");

		//4. Using pojo(plain old java object)

		
		//4.1 By using paramterized constructor
//		User user = new User("morpheus","leader");
//		response = request.body(user).post("/api/users");

		//4.2 By using default constructor for serialization
		User user = new User();
		user.setName("morpheus");
		user.setJob("leader");
		response = request.body(user).post("/api/users");
	}

	@Then("I validate the Post API response code.")
	public void i_validate_the_post_api_response_code() {
		Assert.assertEquals(201, response.getStatusCode());
	}

	@Then("I validate the  Post API response body.")
	public void i_validate_the_post_api_response_body() {
		//using jsonpath 
	     Assert.assertEquals("morpheus", response.getBody().jsonPath().getString("name"));
	}
}
