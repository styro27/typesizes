package com.typesize.parcel.getAvailableTypesizes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CheckWithCompanyCodeRuOnlyTest extends BaseProperty {

    @Test

    public void getAllAvailableTypesizesForRU(){

        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"\",\"typesizeCode\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("size()", is(8))
                .body("companyId", hasItems(49765660))
                .when().post("/get-available-typesizes");

    }
}
