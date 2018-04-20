package com.typesize.parcel.getAvailableTypesizes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;


public class CheckWithProductCodePKTOnlyTest extends BaseProperty{

    @Test

    public void getAllAvailableTypesizesForPKT() {

        given().request().body("{\"companyCode\": \"\",\"productCode\": \"PKT\",\"typesizeCode\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("productId",hasSize(3))
                .body("companyCode", hasItems("RU"))
                .body("typesizeCode",hasItems("M","S","XS"))
                .when().post("/get-available-typesizes");
    }

}
