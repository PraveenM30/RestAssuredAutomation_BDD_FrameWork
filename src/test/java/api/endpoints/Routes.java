package api.endpoints;

public class Routes {

	/* Swagger URL : https://petstore.swagger.io/v2
	 *
	 * Create_User https://petstore.swagger.io/v2/ /user 
	 * Get_User https://petstore.swagger.io/v2/ /user/{username} 
	 * Update_User https://petstore.swagger.io/v2/ /user/{username} 
	 * Delete_User DELETE https://petstore.swagger.io/v2/ /user/{username}
	 */
	
	public static String baseURL="https://petstore.swagger.io/v2";
	
	//User module
	public static String post_url=baseURL+"/user";
	public static String get_url=baseURL+"/user/{userName}";
	public static String put_url=baseURL+"/user/{userName}";
	public static String delete_url=baseURL+"/user/{userName}";

	//Store module
	
    public static String getStoreInventory_url=baseURL+"/store/inventory";	
    public static String postStoreOrder_url=baseURL+"/store/order";	
    public static String getOrder_url=baseURL+"/store/order/{orderId}";	
    public static String deleteOrder_url=baseURL+"/store/order/{orderId}";	

	
	//Pet module

	  //here u will create pet module URL's


}
