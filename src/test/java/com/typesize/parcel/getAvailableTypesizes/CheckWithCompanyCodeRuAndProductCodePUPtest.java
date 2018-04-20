package com.typesize.parcel.getAvailableTypesizes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class CheckWithCompanyCodeRuAndProductCodePUPtest extends BaseProperty {

    @Test

    public void getAllAvailableTypesizesForRuAndPUP(){

        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PUP\",\"typesizeCode\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("size()", is(5))
                .body("typesizeCode", hasItems("XS","S","M","L","XL"))
                .when().post("/get-available-typesizes");

    }
}
