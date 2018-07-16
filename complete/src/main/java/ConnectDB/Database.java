package ConnectDB;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import Model.User;


//import com.mysql.jdbc.Statement;
public class Database { // การเข้าถึง Database ต่างๆ เช่น insert update delete

    
	 @Autowired
	public JdbcTemplate jdbctemplate;
	static Logger log =Logger.getLogger(Database.class.toString());
	 
	public User Login(User user) //เช็ค Login จาก Database
	{
		log.info("Enter Login");
//		logger.info("");
		String selectSql = "SELECT ID,Username as user,Password as pass FROM user Where Username = '"+user.getUser()+"' AND Password = '"+user.getPass()+"'";
		try {
			User u = (User)jdbctemplate.queryForObject(selectSql, new BeanPropertyRowMapper<User>(User.class));
			log.info("Login Success");
			return u;
		}
		catch(Exception e){			
			log.error("Error Login. Message: " );
			return new User();
		}
	}
	public int Delete(User user) // การ  Delete ข้อมูลใน Database
	{
		String deleteSql = "DELETE FROM user Where Username = '"+user.getUser()+"' AND Password = '"+user.getPass()+"'";
		int rows = jdbctemplate.update(deleteSql);
		return rows;
	}
	public int Insert(User insertuser) // การ  Insert ข้อมูลใน Database
	{
			String sql = "INSERT INTO user (Username,Password) Select '"+insertuser.getUser()+"','"+insertuser.getPass()+"' WHERE NOT EXISTS(SELECT * FROM user WHERE Username='"+insertuser.getUser()+"' AND Password='"+insertuser.getPass()+"')";
			if(insertuser.getId() == 99999)
			{
				sql = "INSERT INTO user (ID,Username,Password) VALUES(99999,'"+insertuser.getUser()+"','"+insertuser.getPass()+"')";
			}
			int rows = jdbctemplate.update(sql);
			return rows;
	}
	public int Update(User edituser)// การ  Update ข้อมูลใน Database
	{
		String selectEditSql = "SELECT Username as user,Password as pass FROM user Where Username = '"+edituser.getUser()+"' AND Password = '"+edituser.getPass()+"'";
		try {
			User u = (User)jdbctemplate.queryForObject(selectEditSql, new BeanPropertyRowMapper<User>(User.class));
			return 0;
		}
		catch(Exception e){	
			String updateSql = "UPDATE user SET Username = '"+edituser.getUser()+"',Password = '"+edituser.getPass()+"' WHERE ID = '"+edituser.getId()+"'";
			int rows = jdbctemplate.update(updateSql);
			return rows;
		}
	}
	
	public List<User> DetailUser()// การดึงข้อมูลผู้ใช้ทั้งหมดใน Database
	{
		List<User> listUser = new ArrayList<User>();
		String updateSql = "SELECT ID,Username as user,Password as pass FROM user";
		listUser = jdbctemplate.query(updateSql, new BeanPropertyRowMapper<User>(User.class));
		return listUser;
	}
	public List<User> SearchUser(String searchUser)// การSearchข้อมูลผู้ใช้ทั้งหมดใน Database
	{
		List<User> listUser = new ArrayList<User>();
		String searchSql = "SELECT ID,Username as user,Password as pass FROM user WHERE Username LIKE '%"+searchUser+"%' OR Password LIKE '%"+searchUser+"%'";
		listUser = jdbctemplate.query(searchSql, new BeanPropertyRowMapper<User>(User.class));
		return listUser;
	}
	public void uploadImage(String path,String id)// 
	{
		String Sql = "UPDATE user SET PathImage = '"+path+"' WHERE ID = '"+id+"'";
		jdbctemplate.update(Sql);
	}
	public String loadImage(String id)// 
	{
		String Sql = "SELECT PathImage FROM user WHERE ID = '"+id+"'";
		String path = (String) jdbctemplate.queryForObject(Sql, String.class);
		return path;
	}
}
