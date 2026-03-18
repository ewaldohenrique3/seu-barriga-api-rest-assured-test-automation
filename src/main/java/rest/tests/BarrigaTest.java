package rest.tests;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;
import rest.core.BaseTest;

import java.util.HashMap;
import java.util.Map;

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


    @Test
    public void deveIncluirContaComSucesso() {
        Map<String, String> login = new HashMap<>();

        login.put("email", userEmail);
        login.put("senha", userPassword);

        String token = given()
                .body(login)
                .when()
                .post("/signin")
                .then()
                .statusCode(200)
                .extract().path("token")
                ;

        given()
                .header("Authorization", "JWT " + token)
                .body("{\"nome\": \"conta qualquer\"}")
                .when()
                .post("/contas")
                .then()
                .statusCode(201)
        ;

    }
}
