package Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import Model.Response;
import Model.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;

@RestController
public class Controller {
    

    @Autowired
    public Service service;
    private static Logger log = Logger.getLogger(Controller.class);
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/")
    public String Root(){
    	return "Hello World!";
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/login")
    public Response con(@RequestBody User name){
    	Response returnUser = service.Login(name);
    	return returnUser;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/delete")
    public Response delete(@RequestBody User name){
    	Response res = service.Delete(name);
    	return res;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/insert")
    public Response insert(@RequestBody User name){
    	Response res = service.Insert(name);
    	return res;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/update")
    public Response update(@RequestBody User user){
		//System.out.println(user.getUser());
    	Response res = service.Update(user);
    	return res;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/detailuser")
    public Response detailUser(){
    	Response res = service.detailUser();
    	
		return res;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/searchuser")
    public Response searchUser(@RequestParam (value="username") String search){ // ใช้ Search ข้อมูลในระบบ
    	Response res = service.searchUser(search);
		return res;
    }
    
  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/uploadimage")
  public ResponseEntity<Object> uploadImage(@RequestParam("myFile") MultipartFile image,@RequestParam (value="id")  String id) throws IOException{
    	log.info("upload file");
    	try {
	      	File convertFile = new File("D:\\Image\\"+image.getOriginalFilename());
	      	String path = "D:/Image/" + image.getOriginalFilename();
	      	//System.out.println(id);
//	        convertFile.createNewFile();
	        FileOutputStream fout = new FileOutputStream(convertFile);
	        fout.write(image.getBytes());
	        fout.close();
	      	service.UploadImage(path,id);
	        //System.out.println("Success");
    	}
    	catch (IOException e) {
           e.printStackTrace();
         }
  	return new ResponseEntity<>("File is upload seccessfully",HttpStatus.OK);
    }
  
  @CrossOrigin(origins = "http://localhost:4200")
  @RequestMapping(value="/loadImage",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
  public void loadImage(@RequestParam (value="id")  String id,HttpServletResponse Response)throws IOException { // ใช้ Search ข้อมูลในระบบ
	  String path = service.LoadImage(id);
	  if(path != null)
	  {
		  File convertFile = new File(path);
		  FileInputStream File = new FileInputStream(convertFile);
		  IOUtils.copy(File,Response.getOutputStream());
		  File.close();
	  }
	  else 
	  {
		 File convertFile = new File("D:/Image/images.png");
		  FileInputStream File = new FileInputStream(convertFile);
		  IOUtils.copy(File,Response.getOutputStream());
		  File.close();
	  }
  }
}



//InputStream in = getClass().getResourceAsStream(path);
//IOUtils.toByteArray(in);



//try {
//		BufferedImage originalImage = ImageIO.read(new File("D:\\Image\\generic-woman.png"));
//		ImageIO.write(originalImage, "png", new File("D:\\Image\\generic-woman_new.png"));
//	} catch (IOException e) {
//		System.out.println(e.getMessage());
//	}