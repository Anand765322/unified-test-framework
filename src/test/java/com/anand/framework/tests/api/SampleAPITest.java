package com.anand.framework.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAPITest {

    @Test
    public void testGetUser() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users/1");
        Assert.assertEquals(response.getStatusCode(), 200);

        String name = response.jsonPath().getString("name");
        System.out.println("User name: " + name);
        Assert.assertEquals(name, "Leanne Graham");
    }
}