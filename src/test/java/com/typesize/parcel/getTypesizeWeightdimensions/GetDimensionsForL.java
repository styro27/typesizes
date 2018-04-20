package com.typesize.parcel.getTypesizeWeightdimensions;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetDimensionsForL extends BaseProperty {

    @Test
    public void getDimensionsForL() {
        given()
                .request().body("{\"companyCode\": \"RU\",\"typesizeCode\": \"L\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("weight", is(15f))
                .body("length", is(90f))
                .body("width", is(20f))
                .body("height", is(20f))
                .when().post("/get-typesize-weightdimensions");
    }
}
