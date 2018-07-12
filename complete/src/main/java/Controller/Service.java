package Controller;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ConnectDB.Database;
import Model.Response;
import Model.User;


public class Service {

    
    @Autowired
    public Database connect;
	
	public Response Login(User user) { 
    	User userLogin = connect.Login(user);
		Response res = new Response();
    	if(userLogin.getUser() == null){
    		res.setCode("fail");
    		res.setResult(userLogin);
    	}
    	else {
	    	res.setCode("success");
			res.setResult(userLogin);
    	}
    	return res;
	}
	public Response Delete(User user) {
		int rowsDelete = connect.Delete(user);
		Response res = new Response();
		if(rowsDelete > 0){
			res.setCode("success");
		}
		else {
			res.setCode("fail");
		}
		return res;
	}
	public Response Insert(User user) {
		int rowsInsert = connect.Insert(user);
		Response res = new Response();
		if(rowsInsert > 0){
			res.setCode("success");
		}
		else {
			res.setCode("fail");
		}
		return res;
	}
	public Response Update(User edituser) {
		int rowsUpdate = connect.Update(edituser);
		Response res = new Response();
		if(rowsUpdate > 0){
			res.setCode("success");
		}
		else {
			res.setCode("fail");
		}
		return res;
	}
	public Response detailUser() {
		Response res = new Response();
		List<User> listUser = connect.DetailUser();
		res.setResult(listUser);
		if(listUser.size() > 0) {
			res.setCode("success");
		}
		else {
			res.setCode("fail");
		}
		return res;
	}
	public Response searchUser(String searchUser) {
		Response res = new Response();
		List<User> listUser = connect.SearchUser(searchUser);
		res.setResult(listUser);
		if(listUser.size() > 0) {
			res.setCode("success");
		}
		else {
			res.setCode("fail");
		}
		return res;
	}
	public void UploadImage(String path,String id) {
		connect.uploadImage(path,id);
	}
	public String LoadImage(String id) {
		String path = connect.loadImage(id);
		return path;
	}
}
