package com.typesize.parcel.getTypesizePayweight;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CheckWithWrongTypesizeCodeTest extends BaseProperty {

    @Test
    public void checkWithWrongTypesizeCode() {
        given()
                .request().body("{\"companyCode\": \"RU\",\"typesizeCode\": \"LL\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("general"))
                .body("code", is(100))
                .when().post("/get-typesize-payweight");
    }
}
