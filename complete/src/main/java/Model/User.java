package Model;

public class User { // model ผู้ใช้งานในระบบ
	private int ID;
	private String user;
	private String pass;
	
	public int getId() {
		return this.ID;
	}
	public void setId(int ID) {
		this.ID = ID;
	}
	public String getUser() {
		return this.user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return this.pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}

