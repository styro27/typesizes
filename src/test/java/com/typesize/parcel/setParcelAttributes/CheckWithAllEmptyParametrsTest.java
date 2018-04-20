package com.typesize.parcel.setParcelAttributes;



import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.equalTo;


public class CheckWithAllEmptyParametrsTest extends BaseProperty {

    @Test
    public void setEmptyParametrs () {
        given()
                .request().body("{\"length\": \"\",\"width\": \"\",\"height\": \"\",\"sortType\": \"\",\"calcDerived\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body(equalTo("{\"length\":0.00,\"width\":0.00,\"height\":0.00,\"perimeterHeight\":null,\"dimensionSum\":null,\"maxSize\":null}"))
                .when().post("/set-parcel-attributes");

    }
}
