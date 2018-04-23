package com.typesize.parcel.setParcelAttributes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.is;

public class CheckWithFloatSortTypeTest extends BaseProperty {

    @Test

    public void setFloatSortTypeString() {

        given()

                .request().body("{\"length\": 6,\"width\": 12,\"height\": 25,\"sortType\": \"0.15\",\"calcDerived\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("general"))
                .body("code", equalTo(100))
                .when().post("/set-parcel-attributes");


    }

    @Test

    public void setFloatSortTypeNumber() {

        given()

                .request().body("{\"length\": 6,\"width\": 12,\"height\": 25,\"sortType\": 1.1,\"calcDerived\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("general"))
                .body("code", equalTo(100))
                .when().post("/set-parcel-attributes");



    }
}
