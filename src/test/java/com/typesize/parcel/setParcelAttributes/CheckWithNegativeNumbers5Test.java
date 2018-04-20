package com.typesize.parcel.setParcelAttributes;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithNegativeNumbers5Test extends BaseProperty {

    @Test

    public void setParcelAttributesWithNegativeLength() {

        given()
                .request().body("{\"length\": \"-25\",\"width\": \"\",\"height\": \"\",\"sortType\": \"\",\"calcDerived\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/set-parcel-attributes");

    }

    @Test

    public void setParcelAttributesWithNegativeWidth() {

        given()
                .request().body("{\"length\": \"\",\"width\": \"-10\",\"height\": \"\",\"sortType\": \"\",\"calcDerived\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/set-parcel-attributes");

    }

    @Test

    public void setParcelAttributesWithNegativeHeaght() {

        given()
                .request().body("{\"length\": \"\",\"width\": \"\",\"height\": \"-12\",\"sortType\": \"\",\"calcDerived\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/set-parcel-attributes");

    }

    @Test

    public void setParcelAttributesWithNegativeSortType() {

        given()
                .request().body("{\"length\": \"\",\"width\": \"\",\"height\": \"\",\"sortType\": \"-1\",\"calcDerived\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/set-parcel-attributes");

    }

    @Test

    public void setParcelAttributesWithNegativeSortCalcDerived() {

        given()
                .request().body("{\"length\": \"\",\"width\": \"\",\"height\": \"\",\"sortType\": \"\",\"calcDerived\": \"-1\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/set-parcel-attributes");

    }
}
