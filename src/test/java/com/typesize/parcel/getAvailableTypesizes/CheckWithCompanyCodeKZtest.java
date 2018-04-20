package com.typesize.parcel.getAvailableTypesizes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class CheckWithCompanyCodeKZtest extends BaseProperty {

    @Test

    public void getAllAvailableTypesizesForKZ(){

        given()
                .request()
                .body("{\"companyCode\": \"KZ\",\"productCode\":\"\",\"typesizeCode\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("size()",is(0))
                .when().post("/get-available-typesizes");

    }
}
