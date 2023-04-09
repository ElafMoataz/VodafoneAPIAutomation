package jsonplaceholder.tests;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import requests.RequestActions;
import utils.models.PostItem;

public class CreatePostTests extends BaseTest {
    RequestActions requestActions = new RequestActions();
    Response postItemResponse;
    PostItem postItemAsJson;
    PostItem requestBody = new PostItem();
    String itemBody= "bar";
    String itemTitle= "foo";
    int itemUserId= 1;

    @BeforeTest
    public void init(){
        loadProperties();
        requestBody.setBody(itemBody);
        requestBody.setTitle(itemTitle);
        requestBody.setUserId(itemUserId);
        postItemResponse = requestActions.sendCreatePostsRequest(requestBody);
        postItemAsJson = requestActions.getPostItemResponseAsJson(postItemResponse);
    }
    @Test
    public void validateTheSuccessStatusCodeOfGetPostByIdRequest(){
        Assert.assertEquals(postItemResponse.statusCode(), 201);
    }
    @Test
    public void validateThatResponseDataAreReturnedCorrectly(){
        Assert.assertEquals(postItemAsJson.getUserId(), itemUserId );
        Assert.assertEquals(postItemAsJson.getTitle(), itemTitle);
        Assert.assertEquals(postItemAsJson.getBody(),itemBody);
    }
}
