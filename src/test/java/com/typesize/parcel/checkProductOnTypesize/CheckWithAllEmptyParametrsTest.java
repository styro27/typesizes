package com.typesize.parcel.checkProductOnTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CheckWithAllEmptyParametrsTest extends BaseProperty {

    @Test

    public void getAvailableProductForEmptyParametrs(){

        given()
                .request()
                .body("{\"companyCode\": \"\",\"productCode\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/check-product-on-typesize");

    }
}
