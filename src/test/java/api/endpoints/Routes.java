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
	public static String FFbaseURL="https://app.fireflink.com";
	
	
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

	
	//FireFlink module
    public static String SignIn_url=FFbaseURL+"/appmanagement/optimize/v1/public/user/signin";	
    public static String projectCreation_url=FFbaseURL+"/project/optimize/v1/projects/";	
    public static String projectUpdation_URL=FFbaseURL+"/project/optimize/v1/projects/{projectId}";	
    public static String deleteProject_url=FFbaseURL+"/project/optimize/v1/projects/{projectId}";	


}
