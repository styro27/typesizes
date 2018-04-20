package com.typesize.parcel.getParcelTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithEmptyCompanyCodeTest extends BaseProperty {

    @Test

    public void getTypeSizeWithoutCompanyCode() {
        given()
                .request()
                .body("{\"companyCode\": \"\",\"productCode\":\"PKT\",\"weight\":\"1\",\"length\":\"1\",\"width\":\"1\",\"height\":\"1\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-parcel-typesize");

    }

}
