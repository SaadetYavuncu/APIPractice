package day02;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequest06 extends Authentication {

    //import static utilities.Authentication.generateToken;
    //extends etmek yerine import edilerek te kullanılabilir

    @Test
    public void tets06() {

        String url ="https://www.gmibank.com/api/tp-customers/114351";
        Response response = given().headers("Authorization","Bearer "+ generateToken()).when().get(url);
        response.prettyPrint();

        //Matcher class ile müsteri bilgilerini dogrulayın
        response.then().assertThat().body("firstName",equalTo("Della"),
                "lastName",equalTo("Heaney"),
                "email",equalTo("ricardo.larkin@yahoo.com"),
                "mobilePhoneNumber",equalTo("123-456-7893"),
                "accounts[0].id",equalTo( 2333),
                "accounts[0].balance",equalTo(69700),
                "accounts[0].accountType",equalTo("CREDIT_CARD"),
                "accounts[1].balance",equalTo(11190),
                "accounts[1].accountType",equalTo("CHECKING"));

            assertTrue(response.asString().contains("Della"));

        //JsonPath ile müsteri bilgilerini dogrulayınız
        JsonPath json = response.jsonPath();
        //response.prettyPrint();
        assertEquals("Della", json.getString("firstName"));
        assertEquals("Heaney", json.getString("lastName"));
        assertEquals("ricardo.larkin@yahoo.com", json.getString("email"));
        assertEquals("123-456-7893", json.getString("mobilePhoneNumber"));
        assertEquals(69700, json.getInt("accounts[0].balance"));
        assertEquals("CREDIT_CARD", json.getString("accounts[0].accountType"));
        assertEquals(11190, json.getInt("accounts[1].balance"));
        assertEquals("CHECKING", json.getString("accounts[1].accountType"));


    }
}