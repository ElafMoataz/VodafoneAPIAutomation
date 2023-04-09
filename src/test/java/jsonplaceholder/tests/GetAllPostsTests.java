package jsonplaceholder.tests;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import utils.models.PostItem;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import requests.RequestActions;

public class GetAllPostsTests extends BaseTest {
    RequestActions requestActions= new RequestActions();
    Response allPostsResponse;
    PostItem[] allPostsAsJson;
    @BeforeTest
    public void init(){
        loadProperties();
        allPostsResponse = requestActions.sendGetAllPostsRequest();
        allPostsAsJson = requestActions.getAllPostsResponseAsJson(allPostsResponse);
    }

    @Test
    public void validateTheSuccessStatusCodeOfGetAllPostsRequest(){

        Assert.assertEquals(allPostsResponse.statusCode(), 200);
    }

    @Test
    public void validateThatEachTenIdsAreRelatedToOneUserId(){
        for(int i = 0; i < allPostsAsJson.length; i+= 10){
            int userId= allPostsAsJson[i].getUserId();

            for (int j= i; j < i+10; j++){
                Assert.assertEquals(allPostsAsJson[j].getUserId(), userId);
                Assert.assertEquals(allPostsAsJson[j].getId(),j+1 );
            }
        }
    }
}
