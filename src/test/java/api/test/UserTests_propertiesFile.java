package api.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints_PropertiesFile;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests_propertiesFile {

	Faker faker;
	User userpayload;

	@BeforeClass
	public void setupdata() {
		faker = new Faker();
		userpayload = new User();
		userpayload.setId(faker.number().numberBetween(1000, 9999));
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
	}

	@Test(priority = 1)
	public void testPostUserByName() throws IOException {
		Response response = UserEndPoints_PropertiesFile.createUser(userpayload);
		response.then().statusCode(200);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(">>>>created name :"+userpayload.getFirstname());
	}

	@Test(priority = 2)
	public void testGetUserByName() throws InterruptedException {
		Response response = UserEndPoints_PropertiesFile.readUser(this.userpayload.getUsername());
		response.then().statusCode(200);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(">>>>original FirstName: " + userpayload.getFirstname());
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void testUpdateUserByName() throws InterruptedException {
		Thread.sleep(1000); // 1 second delay before update

		// update the data using same payload
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());

		Response response = UserEndPoints_PropertiesFile.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().statusCode(200);
		response.then().log().body();

		// response.then().log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);

		// checking the data after update
		Response responseAfterUpdate = UserEndPoints_PropertiesFile.readUser(this.userpayload.getUsername());
		responseAfterUpdate.then().statusCode(200);
		System.out.println(">>>>Updated FirstName: " + userpayload.getFirstname());
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void testDeleteUserByName() {
		Response response = UserEndPoints_PropertiesFile.deleteUser(this.userpayload.getUsername());
		response.then().statusCode(200);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);

	}
}
