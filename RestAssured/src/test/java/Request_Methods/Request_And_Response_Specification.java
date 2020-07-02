package Request_Methods;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;


public class Request_And_Response_Specification  extends Payloads {
	
	 RequestSpecification resq;
	 ResponseSpecification resp;
	
	@Test
	public  void specification() {
		
		resq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		resp = new ResponseSpecBuilder().expectStatusCode(200).
				expectContentType(ContentType.JSON).build();
		
		String placeid=postMethod();
		
			putMethod(placeid);
			deleteMethod(placeid);
	 }
	 
	 public String postMethod() {
		//Post Method
			Response postResp=given().log().all().spec(resq).body(AddPlace()).when().post("/maps/api/place/add/json")
					.then().log().all().spec(resp).extract().response();
			
			String postresponse=postResp.asString();
			
			JsonPath post=jsonraw(postresponse);
			String placeid=post.getString("place_id");
			System.out.println(placeid);
			return placeid;
	 }
	 
	 public void putMethod(String placeid) {
		 
		//Update Method
			Response putResp=given().spec(resq).log().all().body(Updateplace(placeid)).when().put("/maps/api/place/update/json")
			.then().log().all().spec(resp).extract().response();
			
			JsonPath put=jsonraw(putResp.asString());
			String msg=put.getString("msg");
			System.out.println(msg);
		 
	 }

	 public void deleteMethod(String placeid) {
	 
		//Delete Method
			Response deleteResp=given().spec(resq).log().all().body(Deleteplace(placeid)).when().delete("/maps/api/place/delete/json")
					.then().log().all().spec(resp).extract().response();
			
			JsonPath del=jsonraw(deleteResp.asString());
			String status=del.getString("status");
			System.out.println(status);	
	 
	 }



}