package com.typesize.parcel.getAvailableTypesizes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class CheckWithTypeSizeXSonlyTest extends BaseProperty {

    @Test

    public void getAllAvailableProductForXS(){

        given()
                .request()
                .body("{\"companyCode\": \"\",\"productCode\":\"\",\"typesizeCode\": \"XS\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("size()", is(2))
                .body("productCode", hasItems("PUP","PKT"))
                .when().post("/get-available-typesizes");

    }
}

