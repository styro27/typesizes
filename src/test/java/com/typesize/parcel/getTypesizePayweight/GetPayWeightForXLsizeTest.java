package com.typesize.parcel.getTypesizePayweight;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetPayWeightForXLsizeTest extends BaseProperty {

    @Test
    public void getPayWeightForXL() {
        given()
                .request().body("{\"companyCode\": \"RU\",\"typesizeCode\": \"XL\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("payWeight", is(30))
                .when().post("/get-typesize-payweight");
    }
}
