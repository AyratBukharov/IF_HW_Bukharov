package ru.ifellow.bukharov.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

    public static RequestSpecification baseRequestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .log(LogDetail.BODY)
                .build();
    }

    public static ResponseSpecification baseResponseSpecOK200() {
        return baseResponse(200);
    }

    public static ResponseSpecification baseResponseError401() {
        return baseResponse(401);
    }

    private static ResponseSpecification baseResponse(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .log(LogDetail.ALL)
                .build();
    }
}
