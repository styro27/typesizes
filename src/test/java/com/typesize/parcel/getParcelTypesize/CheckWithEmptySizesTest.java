package com.typesize.parcel.getParcelTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithEmptySizesTest extends BaseProperty {

    @Test

    public void getTypeSizeWithoutSizes() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"\",\"length\":\"\",\"width\":\"\",\"height\":\"\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("typesizeCode", is("XS"))
                .body("typesizeId", is( 6964824477L))
                .when().post("/get-parcel-typesize");

    }
}
