package controller;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Store;

import static constants.CommonConstants.BASE_URL;
import static io.restassured.RestAssured.given;

public class StoreController {
    RequestSpecification requestSpecification = given();

    public StoreController() {
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.accept("application/json");
        requestSpecification.contentType("application/json");
        requestSpecification.filter(new AllureRestAssured());
    }

    @Step("Create store")
    public Response createStore(Store store) {
        requestSpecification.body(store);
        return given(requestSpecification).when().post("/v2/store/order");
    }

    @Step("Get store")
    public Response getStore() {
        return given(requestSpecification).when().get("/v2/store/inventory");
    }

    @Step("Get store by order id")
    public Response getStoreByOrderId(Integer orderId) {
        return given(requestSpecification).when().get("/v2/store/order/" + orderId);
    }

    @Step("Delete store by order id")
    public Response deleteStoreByOrderId(Integer orderId) {
        return given(requestSpecification).when().delete("/v2/store/order/" + orderId);
    }
}
