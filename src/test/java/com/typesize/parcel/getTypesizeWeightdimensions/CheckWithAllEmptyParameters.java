package com.typesize.parcel.getTypesizeWeightdimensions;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithAllEmptyParameters extends BaseProperty {

    @Test
    public void checkWithEmptyParameters() {
        given()
                .request().body("{\"companyCode\": \"\",\"typesizeCode\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-typesize-weightdimensions");
    }
}
