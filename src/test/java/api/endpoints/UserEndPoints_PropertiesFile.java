package api.endpoints;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;;

public class UserEndPoints_PropertiesFile {
	
	static Properties p=new Properties();
	
	// static block to load the properties only once
    static {
        try {
            FileInputStream fi = new FileInputStream("./src/test/resources/routes.properties");
            p.load(fi);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load routes.properties file");
        }
    }

	public static  Response createUser(User payload) throws IOException {
        String postURL = p.getProperty("post_url");

		       Response response= given()
				  .contentType(ContentType.JSON)
				  .accept(ContentType.JSON)
				  .body(payload)
				  .when()
				  .post(postURL);
		       
				return response; 
	}
	
	public static  Response readUser(String userName) {
        String getURL = p.getProperty("get_url");

	       Response response= given()
	    		 .pathParam("userName", userName)
			     .when()
			     .get(getURL);
	       
			return response; 
      }
	public static  Response updateUser(String userName,User payload) {
        String updateURL = p.getProperty("update_url");
  
		Response response= given()
		      .pathParam("userName", userName)
			  .contentType("application/json")
			  .body(payload)
			  .when()
			  .put(updateURL);
	       
			return response; 
       }
	public static  Response deleteUser(String userName) {
        String deleteURL = p.getProperty("delete_url");

	       Response response= given()
	    		 .pathParam("userName", userName)
			     .when()
			     .delete(deleteURL);
	       
			return response; 
   }
	
}
