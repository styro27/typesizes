package com.typesize.parcel.checkProductOnTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CheckWithCompanyCodeRUandProductCodePUPtest extends BaseProperty {

    @Test

    public void getAvailableProductForRUandPUP(){

        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PUP\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("result", is(1))
                .when().post("/check-product-on-typesize");

    }
}
