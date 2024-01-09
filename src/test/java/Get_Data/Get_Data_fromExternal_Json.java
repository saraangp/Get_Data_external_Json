package Get_Data;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Get_Data_fromExternal_Json {

	         // using External json file
			// already have data in external json file
			
			void testPostUsingExternalJsonFile() throws FileNotFoundException {
				
			File file = new File(".\\body.json");	// extract data from body.json file which is store json data
				
			FileReader fr = new FileReader(file);  // Read the file from file
			
			JSONTokener jt = new JSONTokener(fr);  // pass the json data using JsonTokener
			
			JSONObject data = new JSONObject(jt); // after pass the json data recieve the json object
			
				
			
			given()
		    .contentType("application/json") 
		    .body(data.toString())     
		    
		    
		.when()
		    .post("https://www.reqres.com/user")
		    
		    
		.then()
		    .statusCode(201)
		    .body("name", equalTo("Scott"))    // validation part
		    .body("location",equalTo("France"))
		    .body("phone", equalTo("123456"))
		    .log().all();
				
				
			}
			
			
	
}
