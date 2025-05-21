package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	Store storePayload;
	Faker faker;
	int id;
	
	@BeforeClass
	public void setUpData() {
		storePayload=new Store();
		faker=new Faker();
	    
	    storePayload.setId(faker.number().numberBetween(1000, 9999));
		storePayload.setPetId(faker.number().numberBetween(1, 10));
		storePayload.setQuantitiy(2);
		storePayload.setShipDate("2025-05-21T15:10:00.000Z");
		storePayload.setStatus("Placed");
		storePayload.setComplete(true);
	}
	
	@Test(priority = 1)
	public void getInventory() {
		Response response=StoreEndPoints.getInventory();
		response.then().statusCode(200);
	}
	
	@Test(priority = 2)
	public void postORDER() throws InterruptedException {
		Response response=StoreEndPoints.postorder(storePayload);
		response.then().statusCode(200);
		response.then().log().body();
	    id=response.jsonPath().getInt("id");
		System.out.println(">>>>id is: "+id);
		Thread.sleep(2000);
	}
	
	@Test(priority = 3,dependsOnMethods = "postORDER")
	public void getOrder() throws InterruptedException {
		System.out.println(">>>>Current id is: "+id);
		Response response=StoreEndPoints.getOrder(id);
		response.then().statusCode(200);
		response.then().log().body();
		Thread.sleep(2000);
	}
	@Test(priority = 4,dependsOnMethods = "postORDER")
	public void deleteOrder() {
		System.out.println(">>>>Deleteing id is: "+id);
		Response response=StoreEndPoints.DeleteOrder(id);
		response.then().statusCode(200);
		response.then().log().body();
	}
}
