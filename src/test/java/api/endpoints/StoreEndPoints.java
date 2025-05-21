package api.endpoints;

import com.aventstack.extentreports.gherkin.model.Given;

import api.payload.Store;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class StoreEndPoints {

	public static Response getInventory() {
		Response response = given()
				.when()
				.get(Routes.getStoreInventory_url);
		        return response;
	}
	public static Response postorder(Store payload) {
		Response response = given()
				.contentType("application/json")
				.body(payload)
				.when()
				.post(Routes.postStoreOrder_url);
		        return response;
	}
	public static Response getOrder(int orderID) {
		Response response = given()
				.pathParam("orderId", orderID)
				.when()
				.get(Routes.getOrder_url);
		        return response;
	}
	public static Response DeleteOrder(int orderID) {
		Response response = given()
				.pathParam("orderId", orderID)
				.when()
				.delete(Routes.deleteOrder_url);
		        return response;
	}
}
