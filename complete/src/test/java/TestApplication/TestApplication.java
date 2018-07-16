package TestApplication;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import Controller.Application;
import Controller.Controller;
import Model.Response;
import Model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class,webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestApplication {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
    private static Logger log = Logger.getLogger(Controller.class);
	
	
	@Test
	public void _01loginSuccess() {
//		this.webClient.get().uri("http://localhost:"+port+"/detailuser").exchange().expectStatus().isOk()
//			.expectBody(String.class).isEqualTo("success");
		User user = new User();
		user.setUser("123");
		user.setPass("111");
		Response response = this.restTemplate.postForObject("http://localhost:"+port+"/login",user,Response.class);
		//assertThat(Response.class,response.getResult().contain("success"));
        assertThat(response.getCode()).isEqualTo("success");
	}
	
	@Test
	public void _02loginFail() {
		User user = new User();
		user.setUser("111");
		user.setPass("111");
		Response response = this.restTemplate.postForObject("http://localhost:"+port+"/login",user,Response.class);
        assertThat(response.getCode()).isEqualTo("fail");
	}
	
	@Test
	public void _03allDetailUser() {
		Response response = this.restTemplate.getForObject("http://localhost:"+port+"/detailuser",Response.class);
        assertThat(response.getCode()).isEqualTo("success");
	}
	
	@Test
	public void _04insrtSuccess(){
		User user = new User();
		user.setId(99999);
		user.setUser("JJ");
		user.setPass("JJ");
		Response response = this.restTemplate.postForObject("http://localhost:"+port+"/insert",user,Response.class);
        assertThat(response.getCode()).isEqualTo("success");
	}
	
	@Test
	public void _05insertFail(){
		User user = new User();
		user.setId(1);
		user.setUser("JJ");
		user.setPass("JJ");
		Response response = this.restTemplate.postForObject("http://localhost:"+port+"/insert",user,Response.class);
        assertThat(response.getCode()).isEqualTo("fail");
	}
	
	@Test
	public void _06updateSuccess(){
		User user = new User();
		user.setId(99999);
		user.setUser("JJJ");
		user.setPass("JJJ");
		Response response = this.restTemplate.postForObject("http://localhost:"+port+"/update",user,Response.class);
        assertThat(response.getCode()).isEqualTo("success");
	}
	
	@Test
	public void _07updateFail(){
		User user = new User();
		user.setId(99999);
		user.setUser("JJJ");
		user.setPass("JJJ");
		Response response = this.restTemplate.postForObject("http://localhost:"+port+"/update",user,Response.class);
        assertThat(response.getCode()).isEqualTo("fail");
	}
	
	@Test
	public void _08searchSuccess() {
		Response response = this.restTemplate.getForObject("http://localhost:"+port+"/searchuser?username=JJJ",Response.class);
        assertThat(response.getCode()).isEqualTo("success");
	}
	
	@Test
	public void _09searchFail() {
		Response response = this.restTemplate.getForObject("http://localhost:"+port+"/searchuser?username=JJJJJJJJJ",Response.class);
        assertThat(response.getCode()).isEqualTo("fail");
	}
	
	
//
//	@Test
//	public void _10loadImageNoImage() {
//		ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:8080/loadImage?id=99999",String.class);
//		log.info(response);
//		Response res = this.restTemplate.getForObject("http://localhost:8080/loadImage?id=99999",Response.class);
//		log.info(res);
//        assertThat(response).isEqualTo("fail");
//	}
	
//	@Test
//	public void _11uploadImageSuccess() {
//		File convertFile = new File("D:/Image/gosoft.jpg");
//		String response = this.restTemplate.postForObject("http://localhost:8080/uploadimage?id=99999",convertFile,String.class);
//		System.out.println(response);
////        assertThat(response.getCode()).isEqualTo("fail");
//	}
	
	@Test
	public void _13deleteSuccess() {
		User user = new User();
		user.setUser("JJJ");
		user.setPass("JJJ");
		Response response = this.restTemplate.postForObject("http://localhost:"+port+"/delete",user,Response.class);
        assertThat(response.getCode()).isEqualTo("success");
	}

	@Test
	public void _14deleteFail() {
		User user = new User();
		user.setUser("JJJ");
		user.setPass("JJJ");
		Response response = this.restTemplate.postForObject("http://localhost:"+port+"/delete",user,Response.class);
        assertThat(response.getCode()).isEqualTo("fail");
	}
}
