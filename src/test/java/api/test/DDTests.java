package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = Dataproviders.class)
	public void testPostUserByName(String UserId, String UName, String FName, String LName, String userEmail,
			String pwd, String ph) throws InterruptedException {
		User userpayload = new User();

		userpayload.setId(Integer.parseInt(UserId));
		userpayload.setUsername(UName);
		userpayload.setFirstname(FName);
		userpayload.setLastname(LName);
		userpayload.setEmail(userEmail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);

		Response response = UserEndPoints.createUser(userpayload);
		response.then().statusCode(200);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		Thread.sleep(2000);
	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = Dataproviders.class)
	public void testDeleteUserByName(String UName) throws InterruptedException {

		Response response = UserEndPoints.deleteUser(UName);
		response.then().statusCode(200);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		Thread.sleep(2000);
	}
}
