package rest.tests;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.core.BaseTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BarrigaTest extends BaseTest {

    private static final Dotenv dotenv = Dotenv.load();

    private static final String userEmail = dotenv.get("USER_EMAIL");
    private static final String userPassword = dotenv.get("USER_PASSWORD");
    private String token;

    @BeforeEach
    public void login() {
        Map<String, String> login = new HashMap<>();

        login.put("email", userEmail);
        login.put("senha", userPassword);

    token = given()
        .body(login)
            .when()
            .post("/signin")
            .then()
            .statusCode(200)
            .extract().path("token")
            ;
        }

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

        given()
            .header("Authorization", "JWT " + token)
            .body("{\"nome\": \"conta qualquer\"}")
        .when()
            .post("/contas")
        .then()
            .statusCode(201)
        ;

    }

    @Test
    public void deveAlterarContaComSucesso() {
        given()
            .header("Authorization", "JWT " + token)
            .body("{\"nome\": \"conta alterada\"}")
        .when()
            .put("/contas/2590386")
        .then()
            .statusCode(200)
        ;
    }

    @Test
    public void naoDeveInserirContaMesmoNome() {
        given()
            .header("Authorization", "JWT " + token)
            .body("{\"nome\": \"conta alterada\"}")
        .when()
            .post("/contas")
        .then()
            .statusCode(400)
            .body("error", is("Já existe uma conta com esse nome!"))
        ;
    }
}
