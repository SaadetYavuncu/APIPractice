package day01;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class GetRequest01 {
    @Test
    public void test01(){

        String url = "https://restful-booker.herokuapp.com/booking";

        Response response = given().when().get(url);
        //given().when().get(url);  end pointe göndermek için request oluşturmuş olduk...
        //Response response-->api tarafından bana dönen response(cevap)
        /*
        Response response = given().auth().basic("user","password").when().get(url);
        basic aut ile request göndermek için
         */

        //response.prettyPrint();  //body'i yazdırır
        //response.prettyPeek();  //hem header i hem body i yani responsedaki herşeyi yazdırır
        //response.peek();  //header ı ve bodyi String olarak döndürüyor
        //response.print();  // tüm veriyi String olarak verir.[{"bookingid":1215},{"bookingid":844},{"bookingid":87},...]

        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.statusLine() = " + response.statusLine());
        System.out.println("response.contentType() = " + response.contentType());

        //1) Junit Assertleri ile API testi yapabiliriz...
        Assert.assertEquals("Status code hatalı...",200,response.statusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8",response.contentType());

        //2) assertthat ile
        response.then().assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");

        /*
        response.then().    //assertThat olmadan da çalışıyor...
                statusCode(200).
                contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");
         */







    }

}
/*
GithUb da target cakismamasi icin:
1- Git ignore eklemek
2- Target dosyasini silmek
3- Terminal'de mvn clean
 */


