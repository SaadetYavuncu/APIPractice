package day04;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Account;
import pojos.Country;
import pojos.Customer;
import pojos.User;
import utilities.GMIBankBaseURL;
import utilities.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest09 extends GMIBankBaseURL {

    /*
    http://www.gmibank.com/api/tp-customers/110452
    Pojo ile doprulama yap
     */

    @Test
    public void test09(){

        spec01.pathParams("bir", "tp-customers", "iki", 110452);

        //EXPECTED DATA
        /*
            /*
        "user": {
        "id": 110016,
        "login": "leopoldo.reinger",
        "firstName": "Jasmine",
        "lastName": "Stehr",
        "email": "marni.zboncak@yahoo.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null
    }
     */

        //Account [] accounts;
        User user = new User(110016,"leopoldo.reinger", "Jasmine", "Stehr",
                "marni.zboncak@yahoo.com", true, "en", null, null);

        Country country = new Country(3, "USA", null);

        Customer expectedData = new Customer(110452, "Jasmine", "Stehr", "V", "marni.zboncak@yahoo.com"
                , "463-609-2097", "1-112-497-0270", "16525", "14387 Al Ridge5343 Bert Burgs","Waltermouth"
                , "761-59-2911", "2021-11-28T21:00:00Z", false, country, "California", user);

        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec01).headers("Authorization", "Bearer " + generateToken())
                .when()
                .get("/{bir}/{iki}");



        //response.prettyPrint();

        Customer actualData = response.as(Customer.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getUser().getLogin(), actualData.getUser().getLogin());
        assertEquals(expectedData.getCountry().getName(), actualData.getCountry().getName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getMiddleInitial(), actualData.getMiddleInitial());
        assertEquals(expectedData.getEmail(), actualData.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(), actualData.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(), actualData.getPhoneNumber());
        assertEquals(expectedData.getZipCode(), actualData.getZipCode());
        assertEquals(expectedData.getAddress(), actualData.getAddress());
        assertEquals(expectedData.getCity(), actualData.getCity());
        assertEquals(expectedData.getSsn(), actualData.getSsn());
        assertEquals(expectedData.getCreateDate(), actualData.getCreateDate());
        assertEquals(expectedData.isZelleEnrolled(), actualData.isZelleEnrolled());
        assertEquals(expectedData.getCountry().getId(), actualData.getCountry().getId());
        assertEquals(expectedData.getCountry().getName(), actualData.getCountry().getName());
        assertEquals(expectedData.getCountry().getStates(), actualData.getCountry().getStates());
        assertEquals(expectedData.getState(), actualData.getState());
        assertEquals(expectedData.getUser().getId(), actualData.getUser().getId());
        assertEquals(expectedData.getUser().getLogin(), actualData.getUser().getLogin());
        assertEquals(expectedData.getUser().getFirstName(), actualData.getUser().getFirstName());
        assertEquals(expectedData.getUser().getLastName(), actualData.getUser().getLastName());
        assertEquals(expectedData.getUser().getEmail(), actualData.getUser().getEmail());
        assertEquals(expectedData.getUser().isActivated(), actualData.getUser().isActivated());
        assertEquals(expectedData.getUser().getLangKey(), actualData.getUser().getLangKey());
        assertEquals(expectedData.getUser().getImageUrl(), actualData.getUser().getImageUrl());
        assertEquals(expectedData.getUser().getResetDate(), actualData.getUser().getResetDate());

        //Object Mapper
        Customer actualData2 = JsonUtil.convertJsonToJava(response.asString(), Customer.class);
        System.out.println("actualData2 = " + actualData2);

        assertEquals(expectedData.getId(), actualData2.getId());
        assertEquals(expectedData.getUser().getLogin(), actualData2.getUser().getLogin());
        assertEquals(expectedData.getCountry().getName(), actualData2.getCountry().getName());
        assertEquals(expectedData.getLastName(),actualData2.getLastName());
        assertEquals(expectedData.getMiddleInitial(),actualData2.getMiddleInitial());
        assertEquals(expectedData.getEmail(),actualData2.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(),actualData2.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(),actualData2.getPhoneNumber());
        assertEquals(expectedData.getZipCode(),actualData2.getZipCode());
        assertEquals(expectedData.getAddress(),actualData2.getAddress());
        assertEquals(expectedData.getCity(),actualData2.getCity());
        assertEquals(expectedData.getSsn(),actualData2.getSsn());
        assertEquals(expectedData.getCreateDate(),actualData2.getCreateDate());
        assertEquals(expectedData.isZelleEnrolled(),actualData2.isZelleEnrolled());
        assertEquals(expectedData.getCountry().getId(),actualData2.getCountry().getId());
        assertEquals(expectedData.getCountry().getName(),actualData2.getCountry().getName());
        assertEquals(expectedData.getCountry().getStates(),actualData2.getCountry().getStates());
        assertEquals(expectedData.getState(),actualData2.getState());
        assertEquals(expectedData.getUser().getId(),actualData2.getUser().getId());
        assertEquals(expectedData.getUser().getLogin(),actualData2.getUser().getLogin());
        assertEquals(expectedData.getUser().getFirstName(),actualData2.getUser().getFirstName());
        assertEquals(expectedData.getUser().getLastName(),actualData2.getUser().getLastName());
        assertEquals(expectedData.getUser().getEmail(),actualData2.getUser().getEmail());
        assertEquals(expectedData.getUser().isActivated(),actualData2.getUser().isActivated());
        assertEquals(expectedData.getUser().getLangKey(),actualData2.getUser().getLangKey());
        assertEquals(expectedData.getUser().getImageUrl(),actualData2.getUser().getImageUrl());
        assertEquals(expectedData.getUser().getResetDate(),actualData2.getUser().getResetDate());

    }
}
