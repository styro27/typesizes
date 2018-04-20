package com.typesize.parcel.getTypesizePayweight;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GetPayWeightForXSsizeTest extends BaseProperty {

    @Test
    public void getPayWeightForXS() {
        given()
                .request().body("{\"companyCode\": \"RU\",\"typesizeCode\": \"XS\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("payWeight", is(1))
                .when().post("/get-typesize-payweight");
    }
}
