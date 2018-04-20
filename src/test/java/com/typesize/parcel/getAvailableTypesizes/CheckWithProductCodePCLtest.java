package com.typesize.parcel.getAvailableTypesizes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class CheckWithProductCodePCLtest extends BaseProperty {


    @Test

    public void getAllAvailableTypesizesForPCL() {

        given().request().body("{\"companyCode\": \"\",\"productCode\": \"PCL\",\"typesizeCode\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("size",is(0))
                .when().post("/get-available-typesizes");
    }
}
