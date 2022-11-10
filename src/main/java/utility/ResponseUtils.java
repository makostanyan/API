package utility;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import io.restassured.module.jsv.JsonSchemaValidator;

public final class ResponseUtils {
    private ResponseUtils() {}

    private static ValidatableResponse getResponse() {
        return RequestUtils.getResponse();
    }

    public static void validateResponseWithJsonSchema(String schemaPath) {
        getResponse()
                .assertThat()
                .body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath(schemaPath));
    }

    public static <T> T getObjectFromResponse(final Class<T> type) {
        return getResponse()
                .extract()
                .response()
                .as(type);
    }

    public static int getStatusCode() {
        return getResponse()
                .extract()
                .statusCode();
    }


    public static String getMessageInJsonPath(){
        return getResponse()
                .extract()
                .body()
                .jsonPath()
                .get("message");
    }

    public static void printBody() {
        getResponse().extract().response().prettyPrint();
    }


    public static ResponseSpecification responseSpecification(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }


}
