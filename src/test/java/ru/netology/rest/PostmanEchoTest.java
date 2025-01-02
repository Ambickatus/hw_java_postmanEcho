package ru.netology.rest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


public class PostmanEchoTest {
    @Test
    void shouldReturnTestDataInFieldData() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Leg") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when().log().all()
                .post("/post")
                // Проверки
                .then().log().all()
                .statusCode(200)
                .body("data", org.hamcrest.Matchers.equalTo("Leg"));
        ;
    }
}
