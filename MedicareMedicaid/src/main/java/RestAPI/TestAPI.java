package RestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestAPI {

    /*
    There are following public apis

#   Route           Method  Type                        Full route                              Description Details
1   /employees      GET     JSON    http://dummy.restapiexample.com/api/v1/employees        Getting all employee data Details
2   /employee/{id}  GET     JSON    http://dummy.restapiexample.com/api/v1/employees/{id}   Get a single employee data Details
3   /create         POST    JSON    http://dummy.restapiexample.com/api/v1/create           Create new record in database Details
4   /update/{id}    PUT     JSON    http://dummy.restapiexample.com/api/v1/update/{id}      Update an amployee record Details
5   /delete/{id}    DELETE  JSON    http://dummy.restapiexample.com/api/v1/delete/{id}      Delete an employee record Details
*/

    private String baseURI = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
    private String employees = "employees";
    private String emplyeeWithId = "employee/";
    private String create = "create/";
    private String update = "update/";
    private String delete = "delete/";

    @Test
    public void testGetAllEmployeeInfo() {
        Response response = given().when().get(employees).then().statusCode(200).extract().response();
        System.out.println("Respone is : " + response.asString());
        System.out.println("Respone code is : " + response.getStatusCode());

        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println("employess name : " + jsonPath.get("employee_name").toString());
    }

    @Test
    public void testGetSpecificEmployee() {
        Response response = given().when().get(emplyeeWithId + 170967).then().extract().response();
        System.out.println("Respone is : " + response.asString());
        System.out.println("Respone code is : " + response.getStatusCode());
    }

    @Test
    public void testPostCalls() {

        //storing all the parameters in the JSONObject
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "peopleNtech");
        jsonObject.put("salary", "100000");
        jsonObject.put("age", "22");

        //creating the response
        Response response = given().header("Content-Type", "application/json").body(jsonObject.toString())
                .when().post(create).then().statusCode(200).extract().response();

        //printing the response
        System.out.println(response.toString());

        //validate the response
    }

    @Test
    public void testPutCalls() {
        String requestBody = "{\r\n" + " \"name\":\"LukeNotTheFather\",\r\n" + " \"salary\":\"100000\",\r\n" + " \"age\":" +
                "\"25\"\r\n" + "}";

        Response response = given().contentType(ContentType.JSON).body(requestBody).put(update + 171214);
    }

    @Test
    public void testDeleteCalls() {
        Response response = given().contentType(ContentType.JSON).delete(delete + 172213);

        System.out.println(response.asString());

    }
}
