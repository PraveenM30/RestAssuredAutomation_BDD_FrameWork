package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import api.payload.FireFlinkPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FireFlinkEndPoints {
	public static String accessToken; // Make it global
    public static String PROJECTID; 
    public static String message; 
    
    
	static Properties p=new Properties();
	
	// static block to load the properties only once
    static {
        try {
            FileInputStream fi = new FileInputStream("./src/test/resources/Fireflink.properties");
            p.load(fi);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load routes.properties file");
        }
    }
	
	public static  Response SignIn() {
        String userName = p.getProperty("userName");
        String password = p.getProperty("password");


		FireFlinkPayload SignInPayload=new FireFlinkPayload();
		SignInPayload.setEmailId(userName);
		SignInPayload.setPassword(password);
		SignInPayload.setLastSessionData("/signin");
		
	       Response response= given()
			  .contentType(ContentType.JSON)
			  .accept(ContentType.JSON)
			  .body(SignInPayload)
			  .when()
			  .post(Routes.SignIn_url);
			  accessToken=response.jsonPath().getString("responseObject.access_token");
			  System.out.println("Access_Token is >>>>>"+accessToken);

			return response; 
       }
	
	
	public static  Response projectCreation() {
        String projectCreationBody = p.getProperty("projectCreationBody");
		
	    String jsonPayload = projectCreationBody;

	       Response response= given()
	 	      .contentType("multipart/form-data")
			  .accept(ContentType.JSON)
		      .multiPart("data", jsonPayload)  // key = "data", value = JSON string
		      .header("Authorization", "Bearer " + accessToken)
		      .when()
			  .post(Routes.projectCreation_url);
			  PROJECTID=response.jsonPath().getString("responseObject.id");
	       
			return response; 
    }
	
	public static  Response projectUpdation () {
        String projectUpdationBody = p.getProperty("projectUpdationBody");

	    String jsonPayload = projectUpdationBody;

	       Response response= given()
	    	  .pathParam("projectId", PROJECTID)
	    	  .contentType("multipart/form-data")
			  .accept(ContentType.JSON)
		      .multiPart("data", jsonPayload)  // key = "data", value = JSON string
		      .header("Authorization", "Bearer " + accessToken)
		      .when()
			  .put(Routes.projectUpdation_URL);
	       
			return response; 
   }
	public static  Response projectDeletion() {
	       Response response= given()
	    	  .pathParam("projectId", PROJECTID)
			  .accept(ContentType.JSON)
		      .header("Authorization", "Bearer " + accessToken)
			  .when()
			  .delete(Routes.deleteProject_url);
			   message=response.jsonPath().getString("message");

			return response; 
    }
}
