package com.typesize.parcel.checkProductOnTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CheckWithCompanyCodeBYandProductCodePKTtest extends BaseProperty {

    @Test

    public void getAvailableProductForBYandPKT(){

        given()
                .request()
                .body("{\"companyCode\": \"BY\",\"productCode\":\"PKT\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("result", is(0))
                .when().post("/check-product-on-typesize");

    }
}
