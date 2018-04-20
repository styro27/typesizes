package com.typesize.parcel.getParcelTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithFloatSortTypeTest extends BaseProperty {

    @Test

    public void getTypeSizeWithFloatSortType() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"\",\"length\":\"\",\"width\":\"\",\"height\":\"\",\"sortType\":\"1.1\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("general"))
                .body("code", is(100))
                .when().post("/get-parcel-typesize");

    }
}
