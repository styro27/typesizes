package com.typesize.parcel.getTypesizePayweight;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetPayWeightForMsizeTest extends BaseProperty {


    @Test
    public void getPayWeightForM() {
        given()
                .request().body("{\"companyCode\": \"RU\",\"typesizeCode\": \"M\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("payWeight", is(10))
                .when().post("/get-typesize-payweight");
    }
}
