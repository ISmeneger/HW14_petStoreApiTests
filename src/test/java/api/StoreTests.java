package api;

import controller.StoreController;
import io.restassured.response.Response;
import models.ApiStoreDeleteResponse;
import models.ApiStoreResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static constants.CommonConstants.DEFAULT_STORE;

class StoreTests {
    @Test
    void successfulCreateOrderTest () {
//        String body = """
//                {
//                  "id": 0,
//                  "petId": 0,
//                  "quantity": 0,
//                  "shipDate": "2025-05-19T13:52:31.330Z",
//                  "status": "placed",
//                  "complete": true
//                }
//                """;
//        given().
//                baseUri(BASE_URL).
//                accept("application/json").
//                contentType("application/json").
//                body(body).
//                log().all().
//        when().
//                post("/v2/store/order").
//                then().
//                statusCode(200).
//                log().all().
//                body("id", Matchers.notNullValue(String.class),
//                        "petId",  Matchers.equalTo(0),
//                        "quantity",  Matchers.equalTo(0),
//                        "shipDate",  Matchers.equalTo("2025-05-19T13:52:31.330+0000"),
//                        "status",  Matchers.equalTo("placed"),
//                        "complete",  Matchers.equalTo(true));

        StoreController storeController = new StoreController();

        Response response = storeController.createStore(DEFAULT_STORE);
        Assertions.assertEquals(200, response.getStatusCode());

        ApiStoreResponse store = response.as(ApiStoreResponse.class);
        Assertions.assertTrue(store.getId() > 46116860184273890L);
        Assertions.assertEquals(0, store.getPetId());
        Assertions.assertEquals("2025-05-18T22:49:47.993+0000", store.getShipDate());
        Assertions.assertEquals("placed", store.getStatus());
        Assertions.assertTrue(store.isComplete());
    }

    @Test
    void getStoreTest() {
        StoreController storeController = new StoreController();

        Response response = storeController.getStore();

        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    void getStoreByOrderIdTest() {
        int orderId = 5;

        StoreController storeController = new StoreController();

        Response response = storeController.getStoreByOrderId(orderId);
        Assertions.assertEquals(200, response.getStatusCode());

        ApiStoreResponse store = response.as(ApiStoreResponse.class);
        Assertions.assertEquals(orderId, store.getId());
        Assertions.assertEquals(0, store.getPetId());
        Assertions.assertEquals("2023-03-27T02:14:59.643+0000", store.getShipDate());
        Assertions.assertEquals("placed", store.getStatus());
        Assertions.assertTrue(store.isComplete());
    }

    @Test
    void deleteStoreByOrderIdTest() {
        int orderId = 6;

        StoreController storeController = new StoreController();

        Response response = storeController.deleteStoreByOrderId(orderId);
        Assertions.assertEquals(200, response.getStatusCode());

        ApiStoreDeleteResponse store = response.as(ApiStoreDeleteResponse.class);

        Assertions.assertEquals(200, store.getCode());
        Assertions.assertEquals("unknown", store.getType());
        Assertions.assertEquals("6", store.getMessage());
    }
}
