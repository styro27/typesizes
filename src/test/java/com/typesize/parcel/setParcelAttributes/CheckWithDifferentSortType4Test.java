package com.typesize.parcel.setParcelAttributes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CheckWithDifferentSortType4Test extends BaseProperty {

    @Test

    public void checkWithSortTypeZeroAndWidthMoreLength() {

        given()
                .request().body("{\"length\": 12,\"width\": 15,\"height\": \"\",\"sortType\": \"0\",\"calcDerived\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("length", equalTo(15.0f))
                .body("width", equalTo(12.0f))
                .when().post("/set-parcel-attributes");
    }

    @Test

    public void checkWithSortTypeZeroAndWidthLessLength() {

        given()
                .request().body("{\"length\": 20.5,\"width\": 18.7,\"height\": \"12\",\"sortType\": \"0\",\"calcDerived\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("length", equalTo(20.5f))
                .body("width", equalTo(18.7f))
                .when().post("/set-parcel-attributes");
    }

    @Test

    public void checkRankingWithSortTypeNull() {

        given()
                .request().body("{\"length\": 15.09,\"width\": 39,\"height\": \"43.05\",\"sortType\":\"\",\"calcDerived\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("length", equalTo(39.0f))
                .body("width", equalTo(15.09f))
                .body("height", equalTo(43.05f))
                .when().post("/set-parcel-attributes");
    }
}
