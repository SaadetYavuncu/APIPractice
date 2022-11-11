package day02;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05Token {
    @Test
    public void test05() {

        String url = "https://www.gmibank.com/api/tp-customers";

        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDgxIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE2NzAwMDQzNTB9.4H5GTv6LK-Q908NEx3osyxSYCdBhuuT6X2BQdsytgLEUq5yJUvIgW9I6sg_LWrtLZoysHEMDc9hMvdUIGVggEg";

        Response response = given().headers("Authorization","Bearer "+token).when().get(url);
        response.prettyPrint();
    }
}
