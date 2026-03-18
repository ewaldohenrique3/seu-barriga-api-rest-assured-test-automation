package rest.tests;

import org.junit.jupiter.api.Test;
import rest.core.BaseTest;

import static io.restassured.RestAssured.*;

public class BarrigaTest extends BaseTest {

    @Test
    public void naoDeveAcessarAPISemToken(){
        given()
        .when()
                .get("/contas")
        .then()
                .statusCode(401)
        ;
    }
}
