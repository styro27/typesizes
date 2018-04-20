package com.typesize.parcel.getTypesizeWeightdimensions;

import com.typesize.parcel.BaseProperty;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckWithNullTypeSizeCode extends BaseProperty {

    @Test
    public void checkWithEmptyTypeSizeCode() {
        given()
                .request().body("{\"companyCode\": \"RU\",\"typesizeCode\": \"\"}")
                .with().contentType(ContentType.JSON).then().expect()
                .body("type", is("dataValidationError"))
                .body("code", is(101))
                .body("message", equalTo("Ошибка вaлидации входных параметров"))
                .when().post("/get-typesize-weightdimensions");
    }
}
