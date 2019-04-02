// CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK
package control;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.Responsable;
import model.ResponsableDBA;
import model.student;


import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 


/**
 * Servlet implementation class ResponsableServlet
 */
@WebServlet("/ResponsableServlet")
public class ResponsableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thecommand = request.getParameter("command");
		System.out.println(thecommand);
		switch(thecommand) {
		case "delete":
			delete_student(request,response);
			break;
		case "add":
			add_student(request,response);
			break;
		case "deletedLink":
			
			refusedStudents(request,response);
			break;
		case "acceptedLink":
			acceptedStudents(response, request);
			break;
		case "acceptedLink1":
			AcceptedStudentsList(response,request);
			break;
		case "profil":
			getStudentProfil(request,response);
			break;
		case "file":
			downloadFile(request,response);
			break;
		case "AcceptedExcel":
			downloadAcceptedExcel(request,response);
			break;
		case "Reject":
			RejectAcceptedStudent(request,response);
			break;
		case "accept":
			acceptStudent(request,response);
			break;
		
		}
	}


	


	private void acceptStudent(HttpServletRequest request, HttpServletResponse response) {
		ResponsableDBA DBA = new ResponsableDBA();
		String email = request.getParameter("studentId");
		student s = DBA.getStudent(email);
		if(DBA.CheckDeleted(email) == false) {
			DBA.AccepteRejected(s);
		}else {
			DBA.removeDeletedStudent(email);
			DBA.AccepteRejected(s);
		}
		
		
		acceptedStudents(response, request);
		
	}





	private void RejectAcceptedStudent(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("studentId");
		ResponsableDBA DBA = new ResponsableDBA();
		student s= DBA.getAcceptedStudent(email);;
		if(DBA.CheckDeleted(email) == false) {
			
			 DBA.RejectAccepeted(email);
			 DBA.toDeltedStudent(s);
		}else {
			System.out.println("already rejected");
			DBA.RejectAccepeted(email);
		}
		
		DBA.deleteMaster(email);
		
		AcceptedStudentsList(response,request);
		
	}





	private void AcceptedStudentsList(HttpServletResponse response, HttpServletRequest request) {
		ResponsableDBA DBA = new ResponsableDBA();
		List<student> students = DBA.getAcceptedStudents();
		request.setAttribute("StudentsAccepted", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Students_list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}





	private void downloadAcceptedExcel(HttpServletRequest request, HttpServletResponse response) {
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		ResponsableDBA DBA = new ResponsableDBA();
		List<student> acceptedStudents = DBA.getStudentstoExel();
		
		
		HSSFWorkbook wb = DBA.writeAcceptedToExcel(acceptedStudents);
		try {
			wb.write(outByteStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte [] outArray = outByteStream.toByteArray();
		response.setContentType("application/ms-excel");
		response.setContentLength(outArray.length); 
		response.setHeader("Expires:", "0");
		response.setHeader("Content-Disposition", "attachment; filename=Leave Details.xls");
		try {
			OutputStream outStream = response.getOutputStream();
			outStream.write(outArray);
			outStream.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/acceptedStudent.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}


	private void downloadFile(HttpServletRequest request, HttpServletResponse response) {
		final int BUFFER_SIZE = 4096;  
		ResponsableDBA DBA = new ResponsableDBA();
		String email = request.getParameter("studentId");
		InputStream is = DBA.getFile(email);
		String fileName = "Application/pdf";
		try {
			int fileLength = is.available();
			ServletContext context = getServletContext();
			String mimeType = context.getMimeType(fileName);
            if (mimeType == null) {        
                mimeType = "application/octet-stream";
            } 
            
            response.setContentType(mimeType);
            response.setContentLength(fileLength);
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", fileName);
            response.setHeader(headerKey, headerValue);
            
         // writes the file to the client
            OutputStream outStream = response.getOutputStream();
             
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
             
            while ((bytesRead = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
             
            is.close();
            outStream.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentInfo.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}


	private void getStudentProfil(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ResponsableDBA DBA = new ResponsableDBA();
		String email = request.getParameter("studentId");
		student s = DBA.etInfo(email);
		session.setAttribute("studentInfo", s);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentInfo.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}


	private void add_student(HttpServletRequest request, HttpServletResponse response) {
		ResponsableDBA DBA = new ResponsableDBA();
		String email = request.getParameter("studentId");
		student s = DBA.getStudent(email);
		
		if(DBA.CheckDeleted(email) == false) {
			DBA.AccepteRejected(s);
		}else {
			DBA.removeDeletedStudent(email);
			DBA.AccepteRejected(s);
		}
		
		refusedStudents(request, response);
	}


	private void refusedStudents(HttpServletRequest request, HttpServletResponse response) {
		ResponsableDBA DBA = new ResponsableDBA();
		List<student> students = DBA.getrefusedStudents();
		request.setAttribute("refusedStudents", students);
		System.out.println("passed");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/refusedStudents.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thecommand = request.getParameter("command");
		if(thecommand == null) {
			thecommand = "login";
		}
		switch(thecommand) {
		case "login":
			login_responsable(request,response);
			break;
		}
	}

	private void login_responsable(HttpServletRequest request, HttpServletResponse response) {
		ResponsableDBA DBA = new ResponsableDBA();
		String R_fname = request.getParameter("fname");
		String R_lname = request.getParameter("lname");
		String password = request.getParameter("password");
		Responsable resp = new Responsable(R_fname,R_lname,password);
		DBA.check_user(resp);
		HttpSession session = request.getSession();
		session.setAttribute("responsable_fname", R_fname);
		session.setAttribute("responsable_lname", R_lname);
		
		acceptedStudents(response,request);
		
	}


	private void acceptedStudents(HttpServletResponse response, HttpServletRequest request) {
		ResponsableDBA DBA = new ResponsableDBA();
		List<student> students = DBA.getStudents();
		request.setAttribute("acceptedStudents", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/acceptedStudents.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	private void delete_student(HttpServletRequest request, HttpServletResponse response) {
		ResponsableDBA DBA = new ResponsableDBA();
		String email = request.getParameter("studentId");
		student s = DBA.getStudent(email);
		if(DBA.checkAccepted(email) == true) {
			DBA.RejectAccepeted(email);
		}
		
		if(DBA.CheckDeleted(email) == false) {
			DBA.toDeltedStudent(s);
		}
		
		DBA.deleteMaster(email);
		acceptedStudents(response, request);
	}
}
