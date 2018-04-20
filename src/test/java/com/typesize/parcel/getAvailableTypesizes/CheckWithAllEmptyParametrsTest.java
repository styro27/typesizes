package com.typesize.parcel.getAvailableTypesizes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CheckWithAllEmptyParametrsTest extends BaseProperty {

    @Test

    public void getAllAvailableTypesizes(){

        given()
                .request()
                .body("{\"companyCode\": \"\",\"productCode\":\"\",\"typesizeCode\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("size()", is(8))
                .when().post("/get-available-typesizes");

    }
}
