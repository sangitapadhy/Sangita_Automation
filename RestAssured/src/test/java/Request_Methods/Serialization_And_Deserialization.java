package Request_Methods;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import baseclass.Location_Json;
import baseclass.baseclass;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Serialization_And_Deserialization extends Payloads {
	
	 RequestSpecification resq;
	 ResponseSpecification resp;
	
	public baseclass jsonfileformat() {
		
		baseclass jsonfile =new baseclass();
		Location_Json location = new Location_Json();
		location.setLat(-33.12345);
		location.setLng(30.12345);
		
		jsonfile.setAccuracy(50);
		jsonfile.setAddress("123, Some where, Some Place");
		jsonfile.setLanguage("English");
		jsonfile.setName("Change to Automation");
		jsonfile.setPhone_number("1234567890");
		jsonfile.setWebsite("https://domainname.com");
		jsonfile.setLocation(location);

		List<String> list = new ArrayList<String>();
		list.add("Shoe Park");
		list.add("Shop");
		jsonfile.setTypes(list);
		
		return jsonfile;
		
	}
	
	@Test
	public void postRequest() throws FileNotFoundException {
		PrintStream log = new PrintStream(new FileOutputStream("src/test/resources/LogFile/Logging.txt"));
		
		resq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
	
		resp = new ResponseSpecBuilder().expectStatusCode(200).
				expectContentType(ContentType.JSON).build();
		
		Response postResp=given().log().all().spec(resq).body(jsonfileformat()).when().post("/maps/api/place/add/json")
				.then().log().all().spec(resp).extract().response();
		
		String postresponse=postResp.asString();
		
		JsonPath post=jsonraw(postresponse);
		String placeid=post.getString("place_id");
		System.out.println(placeid);
		
	}

}