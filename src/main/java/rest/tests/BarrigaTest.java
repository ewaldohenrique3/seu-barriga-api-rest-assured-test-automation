package rest.tests;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;
import rest.core.BaseTest;

import static io.restassured.RestAssured.*;

public class BarrigaTest extends BaseTest {

    private static final Dotenv dotenv = Dotenv.load();

    private static final String userEmail = dotenv.get("USER_EMAIL");
    private static final String userPassword = dotenv.get("USER_PASSWORD");

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
