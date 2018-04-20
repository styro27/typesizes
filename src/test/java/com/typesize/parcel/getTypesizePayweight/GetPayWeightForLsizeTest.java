package com.typesize.parcel.getTypesizePayweight;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetPayWeightForLsizeTest extends BaseProperty {

    @Test
    public void getPayWeightForL() {
        given()
                .request().body("{\"companyCode\": \"RU\",\"typesizeCode\": \"L\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("payWeight", is(15))
                .when().post("/get-typesize-payweight");
    }
}
