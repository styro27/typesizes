package com.typesize.parcel.getTypesizeWeightdimensions;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetDimensionsForXL extends BaseProperty {

    @Test
    public void getDimensionsForXL() {
        given()
                .request().body("{\"companyCode\": \"RU\",\"typesizeCode\": \"XL\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("weight", is(30f))
                .body("length", is(150f))
                .body("width", is(25f))
                .body("height", is(25f))
                .when().post("/get-typesize-weightdimensions");
    }
}
