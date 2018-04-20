package com.typesize.parcel.checkProductOnTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithCompanyCodeRUandProductCodePKTtest extends BaseProperty {

    @Test

    public void getAvailableProductForRUandPKT(){

        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("result", is(1))
                .when().post("/check-product-on-typesize");

    }
}
