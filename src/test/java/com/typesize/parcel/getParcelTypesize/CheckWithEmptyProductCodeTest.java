package com.typesize.parcel.getParcelTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithEmptyProductCodeTest extends BaseProperty {

    @Test

    public void getTypeSizeWithoutProductCode() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"\",\"weight\":\"1\",\"length\":\"1\",\"width\":\"1\",\"height\":\"1\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-parcel-typesize");

    }
}
