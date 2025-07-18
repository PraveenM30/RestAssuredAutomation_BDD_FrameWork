package api.test;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.FireFlinkEndPoints;
import io.restassured.response.Response;

public class FireFlinkCrud {

	@Test
	public void SignIn() {	
		Response response=FireFlinkEndPoints.SignIn();
		response.then().statusCode(200);
	}
	
	@Test(priority = 2)
	public void ProjectCreation() {
		
		Response response=FireFlinkEndPoints.projectCreation();
		response.then().statusCode(200);
		System.out.println("Project id id >>>>>>> "+FireFlinkEndPoints.PROJECTID);
		response.then().log().all();
	}
	
	@Test(priority = 3)
	public void projectupdation() {
		Response response=FireFlinkEndPoints.projectUpdation();
		response.then().statusCode(200);
		response.then().log().all();
	}
	
	@Test(priority = 4)
	public void projectDeletion() {
		Response response=FireFlinkEndPoints.projectDeletion();
		response.then().statusCode(200);
		response.then().log().all();
		Assert.assertEquals(FireFlinkEndPoints.message, "Project is deleted successfully");
	}
}
