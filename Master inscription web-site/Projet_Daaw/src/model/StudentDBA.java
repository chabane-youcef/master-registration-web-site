// CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK
package model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.apache.poi.hssf.record.DrawingRecordForBiffViewer;


@MultipartConfig(maxFileSize = 16177215)
public class StudentDBA {
	
	String url = "jdbc:mysql://localhost:3306/daaw";    
	String DBuser = "root";    
	String DBpass = "youcef110863";
	
	public boolean InsertStudent(student x) {
		boolean ver = false;
		
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		PreparedStatement stat = null;    
		ResultSet res = null;
		InputStream is = null;
		try {
			if (x.getCv() != null) {
	            
	            System.out.println(x.getCv().getName());
	            System.out.println(x.getCv().getSize());
	            System.out.println(x.getCv().getContentType());
	             
	            try {
					is = x.getCv().getInputStream();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
			System.out.println(x.getEmail());
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			String sql = "insert into student(fname,lname,Bd_date,Bd_place,email,pswrd,specialite,cv,moy,nbr_red,nbr_prg,nbr_rat) values('"+x.getFname()+"','"+x.getLname()+"','"+x.getBdDate()+"','"+x.getBdPlace()+"','"+x.getEmail()+"','"+x.getPswrd()+"','"+x.getSpecialite()+"',?,"+x.getMoy()+","+x.getNbrRed()+","+x.getNbrPrg()+","+x.getNbrRat()+")";                                                                    
			stat = conn.prepareStatement(sql);
			stat.setBlob(1, is);
			
			int status = stat.executeUpdate();
			
			if(status >0) {
				System.out.println("ok");
				ver = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {               
			 try {
			 	if(res != null) { res.close(); }
			 	if(stat != null) { stat.close(); }
			 	if(conn != null) { conn.close(); }
			 }catch(SQLException e) {
			 		e.printStackTrace();
			 }
		}
		
		return ver;
	}

	

	public boolean checkInsc(student s) {
		boolean ver = false;
		
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		
		try {
			conn =DriverManager.getConnection(url, DBuser, DBpass);
			String sql = "SELECT * FROM student WHERE fname='"+s.getFname()+"' AND lname='"+s.getLname()+"' and email='"+s.getEmail()+"' ";
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			
			while(res.next()) {
				ver = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ver;
	}



	public boolean login_student(student s) {
		boolean ver = false;
		
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		System.out.println(s.getEmail());
		try {
			conn =DriverManager.getConnection(url, DBuser, DBpass);
			String sql = "SELECT * FROM student WHERE email='"+s.getEmail()+"' AND pswrd='"+s.getPswrd()+"' ";
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			
			while(res.next()) {
				ver = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(ver);
		return ver;
	}




	public student getInfos(String email) {
		student s = new student();
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		
		try {
			conn =DriverManager.getConnection(url, DBuser, DBpass);
			String sql = "SELECT * FROM student WHERE email='"+email+"' ";
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			
			if(res.next()) {
				s.setFname(res.getString("fname"));
				s.setLname(res.getString("lname"));
				s.setEmail(res.getString("email"));
				s.setMaster1(res.getString("master1"));
				s.setMaster2(res.getString("master2"));
				s.setMaster3(res.getString("master3"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}



	



	public List<Filiere> getFiliere(int id) {
		List<Filiere> filieres = new ArrayList<>();
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM filiere where id_univ_f='"+id+"'";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()) {
				
				filieres.add(new Filiere(res.getInt("id_fil"),res.getInt("id_univ_f"),res.getString("nom_fil")));
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		finally {               
			 try {
			 	if(res != null) { res.close(); }
			 	if(stat != null) { stat.close(); }
			 	if(conn != null) { conn.close(); }
			 }catch(SQLException e) {
			 		e.printStackTrace();
			 }
		 }
		
		return filieres;
	}



	public List<Universite> getUniv() {
		List<Universite> univs = new ArrayList<>();
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM universite";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()) {
				
				univs.add(new Universite(res.getInt("id_univ"),res.getString("nom_univ")));
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		finally {               
			 try {
			 	if(res != null) { res.close(); }
			 	if(stat != null) { stat.close(); }
			 	if(conn != null) { conn.close(); }
			 }catch(SQLException e) {
			 		e.printStackTrace();
			 }
		 }
		
		return univs;
	}



	public List<specialite> getSpecs(int id) {
		List<specialite> specs = new ArrayList<>();
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM specialite where id_fil_s='"+id+"'";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()) {
				
				specs.add(new specialite(res.getInt("id_spec"),res.getInt("id_fil_s"),res.getString("nom_spec"),res.getInt("nbr_places")));
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		finally {               
			 try {
			 	if(res != null) { res.close(); }
			 	if(stat != null) { stat.close(); }
			 	if(conn != null) { conn.close(); }
			 }catch(SQLException e) {
			 		e.printStackTrace();
			 }
		 }
		
		return specs;
	}





	public void insertMaster( String email,String master1,String master2,String master3) {
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		PreparedStatement stat = null;    
		ResultSet res = null;
		String sql = "UPDATE student set master1='"+master1+"', master2='"+master2+"', master3='"+master3+"' where email='"+email+"'";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.prepareStatement(sql);


			 stat.executeUpdate();

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {               
			 try {
			 	if(res != null) { res.close(); }
			 	if(stat != null) { stat.close(); }
			 	if(conn != null) { conn.close(); }
			 }catch(SQLException e) {
			 		e.printStackTrace();
			 }
		 }
		
	}



	public void insertIntoRegister(student s, String master) {
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		PreparedStatement stat = null;    
		ResultSet res = null;
		String sql = "Insert into registred_students(fname,lname,email,master_choosed) values('"+s.getFname()+"','"+s.getLname()+"','"+s.getEmail()+"','"+master+"') ";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.prepareStatement(sql);
			int status = stat.executeUpdate();
			if(status != 0) {
				System.out.println("insert into registred_student is done");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {               
			 try {
			 	if(res != null) { res.close(); }
			 	if(stat != null) { stat.close(); }
			 	if(conn != null) { conn.close(); }
			 }catch(SQLException e) {
			 		e.printStackTrace();
			 }
		 }
		
	}



	public String getSpecialiteName(int m1) {
		String master = null;
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String SQL = "SELECT * FROM specialite WHERE id_spec='"+m1+"'";
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(SQL);
			
			while(res.next()) {
				master = res.getString("nom_spec");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {               
			 try {
			 	if(res != null) { res.close(); }
			 	if(stat != null) { stat.close(); }
			 	if(conn != null) { conn.close(); }
			 }catch(SQLException e) {
			 		e.printStackTrace();
			 }
		 }
		
		return master;
	}



	public void DeletedFromRegistredTable(String email) {
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		PreparedStatement stat = null;    
		ResultSet res = null;
		
		String sql = "DELETE FROM registred_students WHERE email='"+email+"'";
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.prepareStatement(sql);
			int status = stat.executeUpdate();
			if(status != 0) {
				System.out.println("deleted succefully!!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}



	public void ResetStudentStatus(String email) {
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		PreparedStatement stat = null;    
		ResultSet res = null;
		
		String sql = "UPDATE student SET master1= NULL ,master2= NULL ,master3= NULL WHERE email='"+email+"'";
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.prepareStatement(sql);
			int status = stat.executeUpdate();
			
			if(status != 0) {
				System.out.println("status reseted succefully!!");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}





















