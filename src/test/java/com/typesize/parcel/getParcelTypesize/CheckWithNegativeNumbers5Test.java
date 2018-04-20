package com.typesize.parcel.getParcelTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithNegativeNumbers5Test extends BaseProperty {

    @Test

    public void getTypeSizeWithNegativeWeight() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"-1\",\"length\":\"\",\"width\":\"\",\"height\":\"\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-parcel-typesize");

    }
    @Test

    public void getTypeSizeWithNegativeLength() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"\",\"length\":\"-15\",\"width\":\"\",\"height\":\"\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-parcel-typesize");

    }
    @Test

    public void getTypeSizeWithNegativeWidth() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"\",\"length\":\"\",\"width\":\"-27\",\"height\":\"\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-parcel-typesize");

    }
    @Test

    public void getTypeSizeWithNegativeHeight() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"\",\"length\":\"\",\"width\":\"\",\"height\":\"-55\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-parcel-typesize");

    }
    @Test

    public void getTypeSizeWithNegativeSortType() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"\",\"length\":\"\",\"width\":\"\",\"height\":\"\",\"sortType\":\"-1\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-parcel-typesize");

    }
}
