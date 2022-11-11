package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest03 {


    /*
     Matchers ile dataları doğrulayınız
             "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"
     */


    @Test
    public void test03() {
        String url = "https://reqres.in/api/users";

        Response response = given().when().get(url);
        //response.prettyPrint();

        //Header için
        //1.yol
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("HTTP/1.1 200 OK", response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8", response.contentType());


        //2.yol
        response.then().statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");


        //Matchers Class ile
        response.then().body("data[4].id", equalTo(5),
                "data[4].email", equalTo("charles.morris@reqres.in"),
                "data[4].first_name", equalTo("Charles"),
                "data[4].last_name", equalTo("Morris"),
                "data[4].avatar", equalTo("https://reqres.in/img/faces/5-image.jpg"));

        response.then().body("support.url", equalTo("https://reqres.in/#support-heading"),
                "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));



       /*
        {
            "id": 1,
            "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
            "avatar": "https://reqres.in/img/faces/1-image.jpg"
        }
        */

    }

        @Test
        public void test03a() {

        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);

        //Headars

            Assert.assertEquals(200,response.statusCode());
            Assert.assertEquals("application/json; charset=utf-8", response.contentType());
            Assert.assertEquals("HTTP/1.1 200 OK",response.statusLine());

            //Matchers Class

            response.then().body("data[0].id",equalTo(1),
                    "data[0].email",equalTo("george.bluth@reqres.in"),
                    "data[0].first_name", equalTo("George"),
                    "data[0].last_name", equalTo("Bluth"),
                    "data[0].avatar", equalTo("https://reqres.in/img/faces/1-image.jpg"));
            response.then().body("support.url",equalTo("https://reqres.in/#support-heading"),
            "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));




        }
        /*
        {
            "id": 2,
            "email": "janet.weaver@reqres.in",
            "first_name": "Janet",
            "last_name": "Weaver",
            "avatar": "https://reqres.in/img/faces/2-image.jpg"
        }
        */

    @Test
    public void test03b() {
        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);
        response.then().body("data[1].id", equalTo(2),
                "data[1].first_name", equalTo("Janet"),
                "data[1].last_name", equalTo("Weaver"),
                "data[1].avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"),
                "support.url", equalTo("https://reqres.in/#support-heading"),
                "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }

    /*
        {
            "id": 3,
            "email": "emma.wong@reqres.in",
            "first_name": "Emma",
            "last_name": "Wong",
            "avatar": "https://reqres.in/img/faces/3-image.jpg"
        }
        */

    @Test
    public void test03c() {
        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);
        response.then().body("data[2].id",equalTo(3),
                "data[2].first_name", equalTo("Emma"),
                "data[2].last_name", equalTo("Wong"),
                "data[2].avatar", equalTo("https://reqres.in/img/faces/3-image.jpg"),
                "support.url", equalTo("https://reqres.in/#support-heading"),
                "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }
    /*
        {
            "id": 4,
            "email": "eve.holt@reqres.in",
            "first_name": "Eve",
            "last_name": "Holt",
            "avatar": "https://reqres.in/img/faces/4-image.jpg"
        }
        */

    @Test
    public void test03d() {
        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);
        response.then().body("data[3].id",equalTo(4),
                "data[3].first_name", equalTo("Eve"),
                "data[3].last_name", equalTo("Holt"),
                "data[3].avatar", equalTo("https://reqres.in/img/faces/4-image.jpg"),
                "support.url", equalTo("https://reqres.in/#support-heading"),
                "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));




    }
}
