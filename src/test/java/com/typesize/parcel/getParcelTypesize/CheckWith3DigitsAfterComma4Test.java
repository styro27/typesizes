package com.typesize.parcel.getParcelTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWith3DigitsAfterComma4Test extends BaseProperty {

    @Test

    public void getTypeSizeWithWrongWeightType() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"1.111\",\"length\":\"\",\"width\":\"\",\"height\":\"\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-parcel-typesize");

}
    @Test

    public void getTypeSizeWithWrongLengthType() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"\",\"length\":\"2.555\",\"width\":\"\",\"height\":\"\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-parcel-typesize");

    }
    @Test

    public void getTypeSizeWithWrongWidthType() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"\",\"length\":\"\",\"width\":\"3.777\",\"height\":\"\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-parcel-typesize");

    }

    @Test

    public void getTypeSizeWithWrongHeightType() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"1.111\",\"length\":\"\",\"width\":\"\",\"height\":\"0.789\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-parcel-typesize");

    }


}
