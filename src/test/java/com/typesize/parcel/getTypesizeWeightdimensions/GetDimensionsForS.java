package com.typesize.parcel.getTypesizeWeightdimensions;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetDimensionsForS extends BaseProperty {

    @Test
    public void getDimensionsForS() {
        given()
                .request().body("{\"companyCode\": \"RU\",\"typesizeCode\": \"S\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("weight", is(5f))
                .body("length", is(39f))
                .body("width", is(18f))
                .body("height", is(18f))
                .when().post("/get-typesize-weightdimensions");
    }
}
