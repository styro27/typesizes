package com.typesize.parcel.getAvailableTypesizes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class CheckWithTypeSizeXLonlyTest extends BaseProperty {

    @Test

    public void getAllAvailableProductForXL(){

        given()
                .request()
                .body("{\"companyCode\": \"\",\"productCode\":\"\",\"typesizeCode\": \"XL\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("size()", is(1))
                .body("productCode", hasItem("PUP"))
                .when().post("/get-available-typesizes");

    }
}
