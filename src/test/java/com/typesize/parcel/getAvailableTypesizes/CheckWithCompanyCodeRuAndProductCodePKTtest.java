package com.typesize.parcel.getAvailableTypesizes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class CheckWithCompanyCodeRuAndProductCodePKTtest extends BaseProperty {

    @Test

    public void getAllAvailableTypesizesForRuAndPKT(){

        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"typesizeCode\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("size()", is(3))
                .body("typesizeCode", hasItems("XS","S","M"))
                .when().post("/get-available-typesizes");

    }
}
