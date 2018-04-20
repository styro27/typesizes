package com.typesize.parcel.setParcelAttributes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithFloatNumbers3Test extends BaseProperty {

    @Test

    public void setLengthWith3DigitsAfterComma() {

        given()
                .request().body("{\"length\": 15.285,\"width\": \"\",\"height\": \"\",\"sortType\": \"\",\"calcDerived\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/set-parcel-attributes");

    }


    @Test

    public void setWidthWith3DigitsAfterComma() {

        given()
                .request().body("{\"length\": \"\",\"width\": 9.981,\"height\": \"\",\"sortType\": \"\",\"calcDerived\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/set-parcel-attributes");

    }
    @Test

    public void setHeightWith3DigitsAfterComma() {

        given()
                .request().body("{\"length\": \"\",\"width\": \"\",\"height\": 0.977,\"sortType\": \"\",\"calcDerived\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/set-parcel-attributes");

    }
}
