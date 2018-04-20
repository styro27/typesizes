package com.typesize.parcel.getTypesizeWeightdimensions;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GetDimensionsForXS extends BaseProperty {

    @Test
    public void getDimensionsForXS() {
        given()
                .request().body("{\"companyCode\": \"RU\",\"typesizeCode\": \"XS\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("weight", is(2f))
                .body("length", is(35f))
                .body("width", is(12.5f))
                .body("height", is(12.5f))
                .when().post("/get-typesize-weightdimensions");
    }
}
