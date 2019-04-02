// CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK
package model;

public class ViceDoyen {
	private String fname;
	private String lname;
	private String password;
	
	
	
	public ViceDoyen(String fname, String lname, String password) {
		this.fname = fname;
		this.lname = lname;
		this.password = password;
	}
	
	public ViceDoyen() {
		
	}
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
