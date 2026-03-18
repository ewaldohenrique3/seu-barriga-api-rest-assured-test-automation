package rest.core;

import io.restassured.http.ContentType;

public interface Constantes {

    String appBaseURL = "https://barrigarest.wcaquino.me";
    Integer appPort = 443;  // http -> 80
    String appBasePath = "";

    ContentType appContentType = ContentType.JSON;

    Long maxTimeout = 7000L;


}
