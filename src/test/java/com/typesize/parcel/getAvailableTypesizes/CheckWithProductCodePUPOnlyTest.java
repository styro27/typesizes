package com.typesize.parcel.getAvailableTypesizes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class CheckWithProductCodePUPOnlyTest extends BaseProperty {

    @Test

    public void getAllAvailableTypesizesForPUP() {

        given().request().body("{\"companyCode\": \"\",\"productCode\": \"PUP\",\"typesizeCode\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("productId",hasSize(5))
                .body("companyCode", hasItems("RU"))
                .body("typesizeCode",hasItems("XL","L","M","S","XS"))
                .when().post("/get-available-typesizes");
    }
}
