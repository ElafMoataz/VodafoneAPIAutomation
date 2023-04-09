package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.models.PostItem;

import static io.restassured.RestAssured.given;

public class RequestActions {
    public Response sendGetAllPostsRequest(){
        return given().get(System.getProperty("postsEndPoint"));
    }
    public PostItem[] getAllPostsResponseAsJson(Response response){
        return response.as(PostItem[].class);
    }
    public Response sendGetPostByIdRequest(String id){
        return given().get(System.getProperty("postIdEndPoint") + id);
    }
    public PostItem getPostItemResponseAsJson(Response response){
        return response.as(PostItem.class);
    }
    public Response sendCreatePostsRequest(Object requestBody){
        return given().accept(ContentType.JSON).header("Content-Type","application/json").
                body(requestBody).post(System.getProperty("postsEndPoint"));
    }
}
