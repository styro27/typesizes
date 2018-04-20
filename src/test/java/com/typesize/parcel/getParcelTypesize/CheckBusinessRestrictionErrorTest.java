package com.typesize.parcel.getParcelTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckBusinessRestrictionErrorTest extends BaseProperty {

    @Test

    public void getBusinessRestrictionError() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"15\",\"length\":\"\",\"width\":\"\",\"height\":\"\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("businessRestrictionError"))
                .body("code", is(200))
                .body("message", equalTo("Указанным параметрам не соответствует ни один типоразмер"))
                .when().post("/get-parcel-typesize");
    }
}