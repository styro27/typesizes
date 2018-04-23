package com.typesize.parcel.setParcelAttributes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithFloatCalcDerived extends BaseProperty {

    @Test

    public void setFloatCalcDerivedString() {

        given()
                .request().body("{\"length\": 6,\"width\": 12,\"height\": 25,\"sortType\": 1,\"calcDerived\": \"0.11\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("general"))
                .body("code", equalTo(100))
                .when().post("/set-parcel-attributes");

    }

    @Test

    public void setFloatCalcDerivedNumber() {

        given()
                .request().body("{\"length\": 6,\"width\": 12,\"height\": 25,\"sortType\": 1,\"calcDerived\": 1.12}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("general"))
                .body("code", equalTo(100))
                .when().post("/set-parcel-attributes");

    }
}
