package utils.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostItem {

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("title")
	@Expose
	private String title;

	@SerializedName("body")
	@Expose
	private String body;

	@SerializedName("userId")
	@Expose
	private int userId;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}
}