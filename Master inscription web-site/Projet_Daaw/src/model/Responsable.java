// CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK
package model;

public class Responsable {
	private String fname;
	private String lname;
	private String pswrd;
	public Responsable() {
		
	}
	public Responsable(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	public Responsable(String fname, String lname, String pswrd) {
		this.fname = fname;
		this.lname = lname;
		this.pswrd = pswrd;
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
	public String getPswrd() {
		return pswrd;
	}
	public void setPswrd(String pswrd) {
		this.pswrd = pswrd;
	}
	
	
	
	
	
	
	
	
}
