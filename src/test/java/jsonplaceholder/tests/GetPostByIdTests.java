package jsonplaceholder.tests;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import requests.RequestActions;
import utils.models.PostItem;

public class GetPostByIdTests extends BaseTest {
    RequestActions requestActions = new RequestActions();
    Response postItemResponse;
    PostItem postItemAsJson;
    int id= 1;
    @BeforeTest
    public void init(){
        loadProperties();
        postItemResponse = requestActions.sendGetPostByIdRequest(Integer.toString(id));
        postItemAsJson = requestActions.getPostItemResponseAsJson(postItemResponse);
    }
    @Test
    public void validateTheSuccessStatusCodeOfGetPostByIdRequest(){
        Assert.assertEquals(postItemResponse.statusCode(), 200);
    }
    @Test
    public void validateThatResponseIdAndUserIdAreReturnedCorrectly(){
        Assert.assertEquals(postItemAsJson.getId(), id);
        Assert.assertEquals(postItemAsJson.getUserId(), (int) postItemAsJson.getUserId() );
    }
    @Test
    public void validateThatResponseTitleAndBodyAreReturnedInAStringFormat(){
        Assert.assertTrue(postItemAsJson.getTitle() instanceof String);
        Assert.assertTrue(postItemAsJson.getBody() instanceof String);
    }
}
