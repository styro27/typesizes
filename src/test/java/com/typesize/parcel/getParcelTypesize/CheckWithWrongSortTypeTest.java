package com.typesize.parcel.getParcelTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithWrongSortTypeTest extends BaseProperty {

    @Test

    public void getTypeSizeWithWrongSortType() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"\",\"length\":\"\",\"width\":\"\",\"height\":\"\",\"sortType\":\"2\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-parcel-typesize");

    }
}
