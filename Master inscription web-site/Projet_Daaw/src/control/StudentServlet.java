// CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK
package control;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Filiere;
import model.StudentDBA;
import model.student;
import model.Universite;
import model.specialite;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
@MultipartConfig(maxFileSize = 16177215) 
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thecommand = request.getParameter("command");
		switch(thecommand) {
		case "showF":
			showallSpecs(request,response);
			break;
		case "deletemaster":
			deleteMasterInscription(request,response);
			break;
		}
	}

	

	private void deleteMasterInscription(HttpServletRequest request, HttpServletResponse response) {
		StudentDBA DBA = new StudentDBA();
		String email = request.getParameter("studentEmail");
		DBA.DeletedFromRegistredTable(email);
		DBA.ResetStudentStatus(email);
		
		HttpSession session = request.getSession();
		student x = DBA.getInfos(email);
		session.setAttribute("studentOK", x);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentAccount.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String studentCommand = request.getParameter("command");
		
		switch(studentCommand) {
		case "inscritpion":
			try {
				inscription(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "login":
			login(request,response);
			break;
		case "masterChoice":
			filMasterChoices(request,response);
		
		
		}
	}



	private void filMasterChoices(HttpServletRequest request, HttpServletResponse response) {

		
		int m1=Integer.parseInt(request.getParameter("spec"));
		int m2=Integer.parseInt(request.getParameter("spec1"));
		int m3=Integer.parseInt(request.getParameter("spec2"));
		String email = request.getParameter("StudentEmail");
		
		StudentDBA DBA = new StudentDBA();
		String master1 = DBA.getSpecialiteName(m1);
		String master2 = DBA.getSpecialiteName(m2);
		String master3 = DBA.getSpecialiteName(m3);
		student s = DBA.getInfos(email);
		DBA.insertIntoRegister(s, master1);
		DBA.insertIntoRegister(s, master2);
		DBA.insertIntoRegister(s, master3);
		
		DBA.insertMaster(email, master1,master2,master3);
		HttpSession session = request.getSession();
		student x = DBA.getInfos(email);
		session.setAttribute("studentOK", x);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentAccount.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}





	





	private void showallSpecs(HttpServletRequest request, HttpServletResponse response) {
		
		StudentDBA DBA = new StudentDBA();
		List<Universite> univs = DBA.getUniv();
		//List<Filiere> filiereList = DBA.getFiliere();
		//List<specialite> specs = DBA.getSpecs();
		request.setAttribute("univs", univs);
//		request.setAttribute("Filiere", filiereList);
//		request.setAttribute("specs", specs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ExploreSpecs.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}


	private void login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String message;
		StudentDBA DBA = new StudentDBA();
		student s = new student();
		student x = new student();
		String email = request.getParameter("emailS");
		String password = request.getParameter("passwordS");
		s.setEmail(email);
		s.setPswrd(password);
		if(DBA.login_student(s) == false) {
			session.setAttribute("student", s);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login-student.html");
			try {
				dispatcher.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}else {
			x = DBA.getInfos(email);
			session.setAttribute("studentOK", x);
			RequestDispatcher dispatcher = request.getRequestDispatcher("studentAccount.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}	
	}


	private void inscription(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		student s = new student();
		StudentDBA DBA = new StudentDBA();

		s.setFname(request.getParameter("fname"));
		s.setLname(request.getParameter("lname"));
		s.setBdDate(request.getParameter("BdDate"));
		s.setBdPlace(request.getParameter("DbPlace"));
		s.setEmail(request.getParameter("Email"));
		s.setPswrd(request.getParameter("password"));
		s.setSpecialite(request.getParameter("specialite"));
		s.setCv(request.getPart("cv"));
		s.setMoy(Float.parseFloat(request.getParameter("moy")));
		s.setNbrRed(Integer.parseInt(request.getParameter("nbrRed")));
		s.setNbrPrg(Integer.parseInt(request.getParameter("nbrPrg")));
		s.setNbrRat(Integer.parseInt(request.getParameter("nbrRat")));
		String message;
		if(!DBA.checkInsc(s)) {
			if(DBA.InsertStudent(s)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login-student.html");
				try {
					dispatcher.forward(request, response);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}else {
			message = "user already exist";
			request.setAttribute("message",message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("inscriptio.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

}

















