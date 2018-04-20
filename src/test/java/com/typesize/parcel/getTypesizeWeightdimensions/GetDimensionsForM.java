package com.typesize.parcel.getTypesizeWeightdimensions;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetDimensionsForM extends BaseProperty {

    @Test
    public void getDimensionsForM() {
        given()
                .request().body("{\"companyCode\": \"RU\",\"typesizeCode\": \"M\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("weight", is(10f))
                .body("length", is(60f))
                .body("width", is(20f))
                .body("height", is(20f))
                .when().post("/get-typesize-weightdimensions");
    }
}
