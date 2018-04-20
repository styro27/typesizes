package com.typesize.parcel.getTypesizePayweight;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetPayWeightForSsizeTest extends BaseProperty {


    @Test
    public void getPayWeightForS() {
        given()
                .request().body("{\"companyCode\": \"RU\",\"typesizeCode\": \"S\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("payWeight", is(5))
                .when().post("/get-typesize-payweight");
    }
}
