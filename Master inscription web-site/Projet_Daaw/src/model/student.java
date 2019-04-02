// CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK
package model;

import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.http.Part;

public class student {
	private int id;
	private String fname;
	private String lname;
	private String bdDate;
	private String bdPlace;
	private String email;
	private String pswrd;
	private String specialite;
	private Part cv;
	private float moy;
	private int nbrRed;
	private int nbrPrg;
	private int nbrRat;
	private String master1;
	private String master2;
	private String master3;
	
	
	
	
	public student(int id, String fname, String lname, String bdDate, String bdPlace, String email, String specialite,
			float moy, int nbrRed, int nbrPrg, int nbrRat) {
		
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.bdDate = bdDate;
		this.bdPlace = bdPlace;
		this.email = email;
		this.specialite = specialite;
		this.moy = moy;
		this.nbrRed = nbrRed;
		this.nbrPrg = nbrPrg;
		this.nbrRat = nbrRat;
	}






	public student(int id, String fname, String lname, String specialite, float moy, int nbrRed, int nbrPrg,int nbrRat) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.specialite = specialite;
		this.moy = moy;
		this.nbrRed = nbrRed;
		this.nbrPrg = nbrPrg;
		this.nbrRat = nbrRat;
	}
	
	
	
	
	
	
	public student(String fname, String lname, String bdDate, String bdPlace, String email, String specialite,float moy, int nbrRed, int nbrPrg, int nbrRat) {
		
		this.fname = fname;
		this.lname = lname;
		this.bdDate = bdDate;
		this.bdPlace = bdPlace;
		this.email = email;
		this.specialite = specialite;
		this.moy = moy;
		this.nbrRed = nbrRed;
		this.nbrPrg = nbrPrg;
		this.nbrRat = nbrRat;
	}




	public student(int id, String fname, String lname, String bdDate, String bdPlace, String email, String pswrd,String specialite, float moy, int nbrRed, int nbrPrg, int nbrRat) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.bdDate = bdDate;
		this.bdPlace = bdPlace;
		this.email = email;
		this.pswrd = pswrd;
		this.specialite = specialite;
		this.moy = moy;
		this.nbrRed = nbrRed;
		this.nbrPrg = nbrPrg;
		this.nbrRat = nbrRat;
	}

	
	
	public student(String fname, String lname, String bdDate, String bdPlace, String email, String pswrd,String specialite, float moy, int nbrRed, int nbrPrg, int nbrRat) {
		
		this.fname = fname;
		this.lname = lname;
		this.bdDate = bdDate;
		this.bdPlace = bdPlace;
		this.email = email;
		this.pswrd = pswrd;
		this.specialite = specialite;
		this.moy = moy;
		this.nbrRed = nbrRed;
		this.nbrPrg = nbrPrg;
		this.nbrRat = nbrRat;
	}
	
	


	public student(int id, String fname, String lname, String email, String specialite, float moy, int nbrRed,
			int nbrPrg, int nbrRat) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.specialite = specialite;
		this.moy = moy;
		this.nbrRed = nbrRed;
		this.nbrPrg = nbrPrg;
		this.nbrRat = nbrRat;
	}


	public student() {
		
	}
	public student(int id, String fname, String lname, String email) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
	
	public student(String fname, String lname, String email) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
	
	
	
	public student(String fname, String lname, String bdDate, String bdPlace, String email, String pswrd, String specialite, Part cv, float moy, int nbrRed, int nbrPrg, int nbrRat) {
		
		this.fname = fname;
		this.lname = lname;
		this.bdDate = bdDate;
		this.bdPlace = bdPlace;
		this.email = email;
		this.pswrd = pswrd;
		this.specialite = specialite;
		this.cv = cv;
		this.moy = moy;
		this.nbrRed = nbrRed;
		this.nbrPrg = nbrPrg;
		this.nbrRat = nbrRat;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getBdDate() {
		return bdDate;
	}
	public void setBdDate(String bdDate) {
		this.bdDate = bdDate;
	}
	public String getBdPlace() {
		return bdPlace;
	}
	public void setBdPlace(String bdPlace) {
		this.bdPlace = bdPlace;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPswrd() {
		return pswrd;
	}
	public void setPswrd(String pswrd) {
		this.pswrd = pswrd;
	}
	public float getMoy() {
		return moy;
	}
	public void setMoy(float moy) {
		this.moy = moy;
	}
	public int getNbrRed() {
		return nbrRed;
	}
	public void setNbrRed(int nbrRed) {
		this.nbrRed = nbrRed;
	}
	public int getNbrPrg() {
		return nbrPrg;
	}
	public void setNbrPrg(int nbrPrg) {
		this.nbrPrg = nbrPrg;
	}
	public int getNbrRat() {
		return nbrRat;
	}
	public void setNbrRat(int nbrRat) {
		this.nbrRat = nbrRat;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}


	public Part getCv() {
		return cv;
	}


	public void setCv(Part cv) {
		this.cv = cv;
	}




	public String getMaster1() {
		return master1;
	}




	public void setMaster1(String master1) {
		this.master1 = master1;
	}




	public String getMaster2() {
		return master2;
	}




	public void setMaster2(String master2) {
		this.master2 = master2;
	}




	public String getMaster3() {
		return master3;
	}




	public void setMaster3(String master3) {
		this.master3 = master3;
	}
	
	
}
