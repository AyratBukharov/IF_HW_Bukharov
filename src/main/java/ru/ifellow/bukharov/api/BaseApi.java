package ru.ifellow.bukharov.api;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import ru.ifellow.bukharov.spec.Specification;

import static org.hamcrest.Matchers.lessThan;

public abstract class BaseApi {

    public BaseApi(String url) {
        RestAssured.requestSpecification = Specification.baseRequestSpec(url);
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(5000L))
                .build();
    }
}
