package utility;

import constants.Auth;
import constants.Path;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class RequestUtils {

    private static ValidatableResponse response;

    public static ValidatableResponse  getResponse(){
        return response;
    }

    public static void get(String endpoint) {
        response = given()
                .spec(requestSpecification())
                .when()
                .get(endpoint)
                .then()
                .log()
                .ifError();
    }

    public static void post(String endpoint, Object body) {
        response = given()
                .spec(requestSpecification())
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log()
                .ifError();
    }

    public static void delete(String endpoint) {
        response = given()
                .spec(requestSpecification())
                .when()
                .delete(endpoint)
                .then()
                .log()
                .ifError();
    }

    public static void update(String endpoint) {
        response = given()
                .spec(requestSpecification())
                .when()
                .patch(endpoint)
                .then()
                .log()
                .ifError();
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + Auth.AUTH)
                .setBaseUri(Path.URI)
                .setBasePath(Path.PATH)
                .setContentType(ContentType.JSON)
                .build();
    }
}
