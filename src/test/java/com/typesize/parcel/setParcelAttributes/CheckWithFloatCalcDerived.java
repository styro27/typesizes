package com.typesize.parcel.setParcelAttributes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithFloatCalcDerived extends BaseProperty {

    @Test

    public void setFloatCalcDerived() {

        given()
                .request().body("{\"length\": 12,\"width\": \"\",\"height\": \"\",\"sortType\": \"\",\"calcDerived\": \"0.14\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("length", equalTo(12.0f))
                .when().post("/set-parcel-attributes");

        // ошибка для строки и числа

    }
}
