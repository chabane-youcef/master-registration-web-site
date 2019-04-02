// CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ViceDoyenDBA {
	String url = "jdbc:mysql://localhost:3306/daaw";    
	String DBuser = "root";    
	String DBpass = "youcef110863";
	public boolean checkUser(ViceDoyen v) {
		boolean ver = false;
		
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "SELECT * FROM ViceDoyen where fname='"+v.getFname()+"' AND lname='"+v.getLname()+"' AND pswrd='"+v.getPassword()+"'";
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
		
		finally {               
			 try {
			 	if(res != null) { res.close(); }
			 	if(stat != null) { stat.close(); }
			 	if(conn != null) { conn.close(); }
			 }catch(SQLException e) {
			 		e.printStackTrace();
			 }
		 }
		System.out.println("vice is done");
		return ver;
	}
	public List<specialite> getSpecialites() {
		List<specialite> specialites = new ArrayList<>();
		
		
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "select * from specialite";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()) {
				specialites.add(new specialite(res.getInt("id_spec"),res.getString("nom_spec")));
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
		
		
		return specialites;
	}
	public List<student> getSpecStudent(String spec) {
		List<student> specStudents = new ArrayList<>();
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		Statement stat = null;    
		ResultSet res = null;
		String sql = "select * from Registred_students where master_choosed='"+spec+"'";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while(res.next()) {
				specStudents.add(new student(res.getString("fname"),res.getString("lname"),res.getString("email")));
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
		return specStudents;
	}
	public void sendMailToAcceptedStudent(String email) {
			String host = "smtp.gmail.com";
			String port = "587";
			String userName = "chabaneyoucef63@gmail.com";
			String password = "110863on";
			String toAddress = email;
			String subject = "accepted to formation";
			String message = "<i>Greetings!</i><br>";
	        message += "<b>you have been accepted to the formation you choosed!</b><br>";
	        message += "<font color=red>Vice-Doye,</font>";
	        // sets SMTP server properties
			Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", port);
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	 
	        
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	 
	        Session session = Session.getInstance(properties, auth);
	 
	       
	        Message msg = new MimeMessage(session);
	        try {
	        msg.setFrom(new InternetAddress(userName));
	        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
	        msg.setRecipients(Message.RecipientType.TO, toAddresses);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	        // set plain text message
	        msg.setContent(message, "text/html");
	 
	        // sends the e-mail
	        Transport.send(msg);
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
	        
	 
	    }
	public void sendRefusedMailToStudent(String email) {
		String host = "smtp.gmail.com";
		String port = "587";
		String userName = "chabaneyoucef63@gmail.com";
		String password = "110863on";
		String toAddress = email;
		String subject = "Refused to formation";
		String message = "<i>Greetings!</i><br>";
        message += "<b>We are sorry to tell you that you have been refused to the formation you choosed</b><br>";
        message += "<font color=red>Vice-Doye,</font>";
        // sets SMTP server properties
		Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
       
        Message msg = new MimeMessage(session);
        try {
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        // set plain text message
        msg.setContent(message, "text/html");
 
        // sends the e-mail
        Transport.send(msg);
        }catch(Exception e) {
        	e.printStackTrace();
        }
		
	}
		
	public void UpdateSpecPlaces(String specName, String n) {
		try {     	
			Class.forName( "com.mysql.jdbc.Driver" );        
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		Connection conn = null;    
		PreparedStatement stat = null;    
		ResultSet res = null;
		String sql = "update specialite set nbr_places= "+n+" where nom_spec='"+specName+"'";
		
		try {
			conn = DriverManager.getConnection(url, DBuser, DBpass);
			stat = conn.prepareStatement(sql);
			int status = stat.executeUpdate();
			if(status != 0) {
				System.out.println("updated");
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
