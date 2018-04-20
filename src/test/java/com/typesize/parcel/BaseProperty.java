package com.typesize.parcel;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseProperty {
    @BeforeClass
    public static void setup(){

        String port = System.getProperty("server.port");
        if (port == null) {
            //RestAssured.port = Integer.valueOf(8088);
            RestAssured.port = Integer.valueOf(18080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/typesizes";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            //baseHost = "http://mowlxwww1.office.mow";
            baseHost = "http://haproxy.lb.deployment.do.spsr.ru";
        }
        RestAssured.baseURI = baseHost;

    }
}
