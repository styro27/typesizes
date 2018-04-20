package com.typesize.parcel.getAvailableTypesizes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CheckWithTypeSizeXMtest extends BaseProperty {

    @Test

    public void getAllAvailableProductForXMsize() {

        given().request().body("{\"companyCode\": \"\",\"productCode\": \"\",\"typesizeCode\": \"XM\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("size",is(0))
                .when().post("/get-available-typesizes");
    }
}
