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

    public void setFloatSortType() {

        given()

                .request().body("{\"length\": 6,\"width\": \"\",\"height\": \"\",\"sortType\": \"0.15\",\"calcDerived\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("length", equalTo(6.0f))
                .when().post("/set-parcel-attributes");


                //должен возвращать ошибку и для строки, и для числа!!!
    }
}
