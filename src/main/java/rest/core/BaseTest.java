package rest.core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest implements Constantes {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = appBaseURL;
        RestAssured.port = appPort;
        RestAssured.basePath = appBasePath;

        RequestSpecBuilder reqBuild = new RequestSpecBuilder();
        reqBuild.setContentType(appContentType);

        RestAssured.requestSpecification = reqBuild.build();

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(maxTimeout));

        RestAssured.responseSpecification = resBuilder.build();


        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

}
