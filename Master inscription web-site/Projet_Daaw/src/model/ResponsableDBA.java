// CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK
package model;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.mysql.cj.jdbc.Driver;




public class ResponsableDBA {
	String url = "jdbc:mysql://localhost:3306/daaw";    
	String DBuser = "root";    
	String DBpass = "youcef110863";

	
	public boolean check_user(Responsable resp) {
		boolean ver = false;
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM responsable where fname='"+resp.getFname()+"' AND lname='"+resp.getLname()+"' AND pswrd='"+resp.getPswrd()+"'";
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()) {
				ver = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ver;
	}

	
	public List<student> getAcceptedStudents(){
		List<student> acceptedStudents = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement stat = null;
		ResultSet res = null;
		
		String sql = "SELECT * from accepted_student";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			
			while(res.next()) {
				acceptedStudents.add(new student(res.getInt("id"),res.getString("fname"),res.getString("lname"),res.getString("email"),res.getString("specialite"),res.getFloat("moy"),res.getInt("nbr_red"),res.getInt("nbr_prg"),res.getInt("nbr_rat")));
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
		
		return acceptedStudents;
	}
	
	
	public List<student> getStudents(){
		List<student> students = new ArrayList<>();
		
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM student";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()) {
				
				
				students.add(new student(res.getInt("id"),res.getString("fname"),res.getString("lname"),res.getString("email"),res.getString("specialite"),res.getFloat("moy"),res.getInt("nbr_red"),res.getInt("nbr_prg"),res.getInt("nbr_rat")));                                                                                                                                                                                              
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
		
		return students;
	}
	
	public student getAcceptedStudent(String email) {
		student student = new student();
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM accepted_student where email='"+email+"'";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()) {
				
				student = new student(res.getString("fname"),res.getString("lname"),res.getString("Bd_date"),res.getString("Bd_place"),res.getString("email"),res.getString("pswrd"),res.getString("specialite"),res.getFloat("moy"),res.getInt("nbr_red"),res.getInt("nbr_prg"),res.getInt("nbr_rat"));                                                                                                                                                                        
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public student getStudent(String email) {
		student student = new student();
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM student where email='"+email+"'";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()) {
				
				student = new student(res.getString("fname"),res.getString("lname"),res.getString("Bd_date"),res.getString("Bd_place"),res.getString("email"),res.getString("pswrd"),res.getString("specialite"),res.getFloat("moy"),res.getInt("nbr_red"),res.getInt("nbr_prg"),res.getInt("nbr_rat"));                                                                                                                                                                        
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public void toDeltedStudent(student s) {
		student x = s;
		InputStream is = null;
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			
			String sql ="insert into deleted_student(fname,lname,Bd_date,Bd_place,email,pswrd,specialite,moy,nbr_red,nbr_prg,nbr_rat) values('"+x.getFname()+"','"+x.getLname()+"','"+x.getBdDate()+"','"+x.getBdPlace()+"','"+x.getEmail()+"','"+x.getPswrd()+"','"+x.getSpecialite()+"',"+x.getMoy()+","+x.getNbrRed()+","+x.getNbrPrg()+","+x.getNbrRat()+")";
			stat = conn.createStatement();
			
			int status = stat.executeUpdate(sql);
			System.out.println(status);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	

	public List<student> getrefusedStudents() {
		List<student> students = new ArrayList<>();
		
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM deleted_student";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()) {
				
				
				students.add(new student(res.getInt("id"),res.getString("fname"),res.getString("lname"),res.getString("email"),res.getString("specialite"),res.getFloat("moy"),res.getInt("nbr_red"),res.getInt("nbr_prg"),res.getInt("nbr_rat")));                                                                                                                                                                                              
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
		
		return students;
	}

	

	
	

	public void removeDeletedStudent(String email) {
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null; 
		
		try {              
			conn = DriverManager.getConnection(url, DBuser, DBpass);
	 		stat = conn.createStatement();   
	 		int status = stat.executeUpdate("Delete From deleted_student where email='"+email+"';" );    
	 		 } catch ( SQLException e ) {  
	 			 System.out.println("Erreur SQL ");
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

	public student etInfo(String email) {
		student student = new student();
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM student where email='"+email+"'";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			if(res.next()) {
				student = new student(res.getString("fname"),res.getString("lname"),res.getString("Bd_date"),res.getString("Bd_place"),res.getString("email"),res.getString("specialite"),res.getFloat("moy"),res.getInt("nbr_red"),res.getInt("nbr_prg"),res.getInt("nbr_rat"));                                                                                                                                                                        
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public InputStream getFile(String email) {
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM student where email='"+email+"'";
		InputStream inputStream = null;
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			if(res.next()) {
				Blob blob = res.getBlob("cv");
				inputStream = blob.getBinaryStream();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return inputStream;
	}
	

	//double moy = x.getMoy() * (1-0.004*(x.getNbrRed() + (x.getNbrPrg() / 2)+ (x.getNbrRat() /4)));
	public HSSFWorkbook writeAcceptedToExcel(List<student> acceptedStudents) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		HSSFRow row = sheet.createRow(0);
		
		
		int rowIndex = 0;
		
		for(student x : acceptedStudents) {
			row = sheet.createRow(rowIndex++);
			
			HSSFCell cell = row.createCell(0);
			int cellIndex=0;
			cell = row.createCell(cellIndex++);
			cell.setCellValue(x.getFname());
			
			cell = row.createCell(cellIndex++);
			cell.setCellValue(x.getLname());
			
			cell = row.createCell(cellIndex++);
			cell.setCellValue(x.getBdDate());
			
			cell = row.createCell(cellIndex++);
			cell.setCellValue(x.getBdPlace());
			
			cell = row.createCell(cellIndex++);
			cell.setCellValue(x.getEmail());
			
			cell = row.createCell(cellIndex++);
			cell.setCellValue(x.getSpecialite());
			
			double moy = x.getMoy() * (1-0.004*(x.getNbrRed() + (x.getNbrPrg() / 2)+ (x.getNbrRat() /4)));
			cell = row.createCell(cellIndex++);
			cell.setCellValue(moy);
			
			//row.createCell(cellIndex++).setCellValue(x.getFname());
			//row.createCell(cellIndex++).setCellValue(x.getLname());
//			row.createCell(cellIndex++).setCellValue(x.getBdDate());
//			row.createCell(cellIndex++).setCellValue(x.getBdPlace());
//			row.createCell(cellIndex++).setCellValue(x.getEmail());
//			row.createCell(cellIndex++).setCellValue(x.getSpecialite());
//			double moy = x.getMoy() * (1-0.004*(x.getNbrRed() + (x.getNbrPrg() / 2)+ (x.getNbrRat() /4)));
//			row.createCell(cellIndex++).setCellValue(moy);
		}
		
		//ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		
		
		
		return wb;
		
		
		
	}

	public List<student> getStudentstoExel() {
		List<student> students = new ArrayList<>();
		
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM student";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()) {
				
				
				students.add(new student(res.getInt("id"),res.getString("fname"),res.getString("lname"),res.getString("Bd_date"),res.getString("Bd_place"),res.getString("email"),res.getString("specialite"),res.getFloat("moy"),res.getInt("nbr_red"),res.getInt("nbr_prg"),res.getInt("nbr_rat")));                                                                                                                                                                                              
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
		
		return students;
	}

	
	
	public List<student> getDstudentstoExel() {
		List<student> students = new ArrayList<>();
				
				try {     	
					Class.forName( "com.mysql.jdbc.Driver" );        
				} catch ( ClassNotFoundException e ) {
					e.printStackTrace();
				}
				
				Connection conn = null;    
				Statement stat = null;    
				ResultSet res = null;
				String sql = "SELECT * FROM deleted_student";
				
				try {
					conn = DriverManager.getConnection(url, DBuser, DBpass);
					stat = conn.createStatement();
					res = stat.executeQuery(sql);
					while(res.next()) {
						
						
						students.add(new student(res.getInt("id"),res.getString("fname"),res.getString("lname"),res.getString("Bd_date"),res.getString("Bd_place"),res.getString("email"),res.getString("specialite"),res.getFloat("moy"),res.getInt("nbr_red"),res.getInt("nbr_prg"),res.getInt("nbr_rat")));                                                                                                                                                                                              
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
				
				return students;
			}


	public boolean CheckDeleted(String email) {
		boolean ver = false;
		
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM deleted_student where email ='"+email+"'";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			if(res.next()) {
				ver = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ver;
	}


	public void RejectAccepeted(String email) {
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null; 
		
		try {              
			conn = DriverManager.getConnection(url, DBuser, DBpass);
	 		stat = conn.createStatement();   
	 		int status = stat.executeUpdate("Delete From accepted_student where email='"+email+"';" );    
	 		 } catch ( SQLException e ) {  
	 			 System.out.println("Erreur SQL ");
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


	public boolean checkAccepted(String email) {
boolean ver = false;
		
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM accepted_student where email ='"+email+"'";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			if(res.next()) {
				ver = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ver;
	}


	public void AccepteRejected(student s) {
		student x = s;
		
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			
			String sql ="insert into accepted_student(fname,lname,Bd_date,Bd_place,email,pswrd,specialite,moy,nbr_red,nbr_prg,nbr_rat) values('"+x.getFname()+"','"+x.getLname()+"','"+x.getBdDate()+"','"+x.getBdPlace()+"','"+x.getEmail()+"','"+x.getPswrd()+"','"+x.getSpecialite()+"',"+x.getMoy()+","+x.getNbrRed()+","+x.getNbrPrg()+","+x.getNbrRat()+")";
			stat = conn.createStatement();
			
			int status = stat.executeUpdate(sql);
			System.out.println(status);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


	public void deleteMaster(String email) {
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null; 
		
		try {              
			conn = DriverManager.getConnection(url, DBuser, DBpass);
	 		stat = conn.createStatement();   
	 		int status = stat.executeUpdate("Delete From registred_students where email='"+email+"';" );    
	 		 } catch ( SQLException e ) {  
	 			 System.out.println("Erreur SQL ");
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

	
}























