package se.atg.service.harrykart.java;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.*;
import java.net.URI;
import java.util.Objects;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("java-test")
public class HarryKartAppTest {

    private final static URI harryKartApp = URI.create("http://localhost:8181/java/api/play");

    @BeforeAll
    void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @DisplayName("Trying to GET instead of POST should return 405 Method not allowed")
    void useGetOnPostEndpointShouldNotBePossible() {
        when()
                .get(harryKartApp)
        .then()
                .assertThat()
                .statusCode(405);
    }

    @Test
    @DisplayName("Successful response matching example 1")
    void testScenario1() throws FileNotFoundException {
        JsonPath expectedJson = new JsonPath(new File("src/main/resources/responses/response_0.json"));
        given()
                .header("Content-Type", ContentType.XML)
                .body(readFileToString("input_0.xml"))
        .when()
                .post(harryKartApp)

        .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .body("",equalTo(expectedJson.getMap("")));
    }

    @Test
    @DisplayName("Successful response matching example 2")
    void testScenario2() throws FileNotFoundException {
        JsonPath expectedJson = new JsonPath(new File("src/main/resources/responses/response_1.json"));
        given()
                .header("Content-Type", ContentType.XML)
                .body(readFileToString("input_1.xml"))
                .when()
                .post(harryKartApp)

                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .body("",equalTo(expectedJson.getMap("")));
    }

    @Test
    @DisplayName("Successful response matching example 3")
    void testScenario3() throws FileNotFoundException {
        JsonPath expectedJson = new JsonPath(new File("src/main/resources/responses/response_2.json"));
        given()
                .header("Content-Type", ContentType.XML)
                .body(readFileToString("input_2.xml"))
                .when()
                .post(harryKartApp)

                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .body("",equalTo(expectedJson.getMap("")));
    }

    @Test
    @DisplayName("Successful response and one horse is disqualified")
    void testScenarioDisqualified() throws FileNotFoundException {
        JsonPath expectedJson = new JsonPath(new File("src/main/resources/responses/response_disqualified.json"));
        given()
                .header("Content-Type", ContentType.XML)
                .body(readFileToString("input_disqualified.xml"))
                .when()
                .post(harryKartApp)

                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .body("",equalTo(expectedJson.getMap("")));
    }

    @Test
    @DisplayName("Successful response and 2 horses are tied")
    void testScenarioDraw() throws FileNotFoundException {
        JsonPath expectedJson = new JsonPath(new File("src/main/resources/responses/response_draw.json"));
        given()
                .header("Content-Type", ContentType.XML)
                .body(readFileToString("input_draw.xml"))
                .when()
                .post(harryKartApp)

                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .body("",equalTo(expectedJson.getMap("")));
    }

    @Test
    @DisplayName("Successful response when there are additional loops")
    void testScenarioMoreLoops() throws FileNotFoundException {
        JsonPath expectedJson = new JsonPath(new File("src/main/resources/responses/response_more_loops.json"));
        given()
                .header("Content-Type", ContentType.XML)
                .body(readFileToString("input_more_loops.xml"))
                .when()
                .post(harryKartApp)

                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .body("",equalTo(expectedJson.getMap("")));
    }
    @Test
    @DisplayName("Successful response when there are fewer loops")
    void testScenarioLessLoops() throws FileNotFoundException {
        JsonPath expectedJson = new JsonPath(new File("src/main/resources/responses/response_less_loops.json"));
        given()
                .header("Content-Type", ContentType.XML)
                .body(readFileToString("input_less_loops.xml"))
                .when()
                .post(harryKartApp)

                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .body("",equalTo(expectedJson.getMap("")));
    }


    /**
     *
     * @param filename XML filename to be read from /resources
     * @return
     */
    private String readFileToString(String filename) {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(filename);
        Objects.requireNonNull(in);
        String xmlString = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            xmlString = br.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
            return xmlString;
        }
        return xmlString;
    }

}
