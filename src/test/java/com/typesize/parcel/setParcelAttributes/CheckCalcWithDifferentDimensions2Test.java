package com.typesize.parcel.setParcelAttributes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CheckCalcWithDifferentDimensions2Test extends BaseProperty {

    @Test

    public void checkPerimeterHeightWithZeroSortType() {

        given()
                .request().body("{\"length\": 12,\"width\": 15.08,\"height\": 8.01,\"sortType\": \"0\",\"calcDerived\":1}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("perimeterHeight", equalTo(55.1f))
                .body("dimensionSum", equalTo(35.09f))
                .body("maxSize", equalTo(15.08f))
                .when().post("/set-parcel-attributes");
    }

    @Test

    public void checkPerimeterHeightWithOneSortType() {

        given()
                .request().body("{\"length\": 12,\"width\": 15,\"height\": 20.98,\"sortType\": \"1\",\"calcDerived\":1}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("perimeterHeight", equalTo(74.98f))
                .body("dimensionSum", equalTo(47.98f))
                .body("maxSize", equalTo(20.98f))
                .when().post("/set-parcel-attributes");
    }
}
