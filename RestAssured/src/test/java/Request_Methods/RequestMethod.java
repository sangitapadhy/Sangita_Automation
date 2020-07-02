package Request_Methods;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

public class RequestMethod  extends Payloads {

	@Test
	public void RequestMethods() {

		RestAssured.baseURI="https://rahulshettyacademy.com";
		//POST REQUEST
		String postresponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body(AddPlace()).when().post("/maps/api/place/add/json").then().assertThat().log().all()
				.statusCode(200).extract().response().asString();

		JsonPath js=new JsonPath(postresponse);
		String placeid=js.getString("place_id");
		System.out.println(placeid);

		//PUT REQUEST
		String putresponse=given().log().all().queryParam("key", "qaclick123").body(Updateplace(placeid)).when()
				.put("/maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();

		JsonPath msg=jsonraw(putresponse);
		String putrespmsg=msg.getString("msg");
		System.out.println(putrespmsg);


		//Delete request
		String deleteresponse=given().log().all().queryParam("key", "qaclick123").body(Deleteplace(placeid)).when()
				.delete("/maps/api/place/delete/json").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();

		JsonPath status=jsonraw(deleteresponse);
		String Deletestatus=status.getString("status");
		System.out.println(Deletestatus);

	}


}

