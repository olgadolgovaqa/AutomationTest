package apiTests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class ReqresTests {
    static String baseUrl = "https://reqres.in/";
    static String token = "QpwL5tke4Pnpja7X4";
    static String email;


    @Test(priority = 1)
    public void getSingleUserCredentials() {

        String endPoint = "api/users/4";
        Response response = given()
                .baseUri(baseUrl)
                .basePath(endPoint)
                .when()
                .get()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
        JsonPath js = response.jsonPath();
        email = js.getString("data.email");
    }

    @Test(priority = 2)
    public void registerSuccessful() {
        String endpoint = "/api/register";
        Credentials credentials = new Credentials(email, "pistol");

        Response response = given()
                .baseUri(baseUrl)
                .basePath(endpoint)
                .header("Content-type", "application/json")
                .body(credentials)
                .when()
                .post()
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract()
                .response();
        JsonPath js = response.jsonPath();
        String token1 = js.getString("token");
        Assert.assertEquals(token1, token);
    }

    @Test(priority = 3)
    public void loginSuccessful() {
        String endpoint = "/api/login";
        Credentials credentials = new Credentials(email, "pistol");

        Response response = given()
                .baseUri(baseUrl)
                .basePath(endpoint)
                .header("Content-type", "application/json")
                .body(credentials)
                .when()
                .post()
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract()
                .response();
        JsonPath js = response.jsonPath();
        String token2 = js.getString("token");
        Assert.assertEquals(token2, token);

    }

}
