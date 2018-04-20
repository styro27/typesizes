package com.typesize.parcel.getParcelTypesize;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CheckWithDifferentDimensions7Test extends BaseProperty {

    @Test

    public void getTypeSizeWithTwoLimitValues() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"2\",\"length\":\"35\",\"width\":\"10\",\"height\":\"15\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("typesizeCode", is("XS"))
                .body("typesizeId", is( 6964824477L))
                .when().post("/get-parcel-typesize");

    }

    @Test

    public void getTypeSizeWithWeightOnly() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PUP\",\"weight\":\"15\",\"length\":\"\",\"width\":\"\",\"height\":\"\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("typesizeCode", is("L"))
                .body("typesizeId", is( 6964824483L))
                .when().post("/get-parcel-typesize");

    }

    @Test

    public void getTypeSizeWithFloatOverWeight() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"2.01\",\"length\":\"\",\"width\":\"\",\"height\":\"\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("typesizeCode", is("S"))
                .body("typesizeId", is( 6964824479L))
                .when().post("/get-parcel-typesize");

    }

    @Test

    public void getTypeSizeWithFloatOverLength() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"2\",\"length\":\"35.01\",\"width\":\"\",\"height\":\"\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("typesizeCode", is("S"))
                .body("typesizeId", is( 6964824479L))
                .when().post("/get-parcel-typesize");

    }

    @Test

    public void getTypeSizeWithFloatOverWidth() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PKT\",\"weight\":\"2\",\"length\":\"15\",\"width\":\"39.01\",\"height\":\"10\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("typesizeCode", is("M"))
                .body("typesizeId", is( 6964824481L))
                .when().post("/get-parcel-typesize");

    }

    @Test

    public void getTypeSizeWithFloatOverHeight() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PUP\",\"weight\":\"2\",\"length\":\"15\",\"width\":\"8\",\"height\":\"90.01\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("typesizeCode", is("XL"))
                .body("typesizeId", is( 6964824485L))
                .when().post("/get-parcel-typesize");

    }

    @Test

    public void getTypeSizeWithMaxDimensions() {
        given()
                .request()
                .body("{\"companyCode\": \"RU\",\"productCode\":\"PUP\",\"weight\":\"30\",\"length\":\"25\",\"width\":\"25\",\"height\":\"150\",\"sortType\":\"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("typesizeCode", is("XL"))
                .body("typesizeId", is( 6964824485L))
                .when().post("/get-parcel-typesize");

    }
}
