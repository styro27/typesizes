package com.typesize.parcel.setParcelAttributes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithSortTypeZeroTest extends BaseProperty {

    @Test

    public void getReplacedLengthAndWidth() {

        given()
                .request().body("{\"length\": \"10\",\"width\": \"15\",\"height\": \"\",\"sortType\": \"0\",\"calcDerived\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("width",equalTo(10f))
                .body("length", equalTo(15f))
                .when().post("/set-parcel-attributes");

    }
}
