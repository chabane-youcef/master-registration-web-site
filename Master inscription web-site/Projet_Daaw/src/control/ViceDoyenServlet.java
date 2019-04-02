// CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK
package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ResponsableDBA;
import model.ViceDoyen;
import model.ViceDoyenDBA;
import model.specialite;
import model.student;

/**
 * Servlet implementation class ViceDoyenServlet
 */
@WebServlet("/ViceDoyenServlet")
public class ViceDoyenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thecommand = request.getParameter("command");
		switch(thecommand) {
		case "SpecialiteList":
			getSpecStudents(request,response);
			break;
		case "acceptEmail":
			sendAcceptedEmail(request,response);
			break;
		case "refuseEmail":
			sendRefusedEmil(request,response);
			break;
		case "EditPlaces":
			EditPlaces(request,response);
			break;
		case "UpdatePlaces":
			UpdatePlaces(request,response);
			break;
		}
		
	}
	
	private void UpdatePlaces(HttpServletRequest request, HttpServletResponse response) {
		String SpecName = request.getParameter("specName");
		String n = request.getParameter("nbr");
		ViceDoyenDBA DBA = new ViceDoyenDBA();
		DBA.UpdateSpecPlaces(SpecName,n);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/viceAccount.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}


	private void EditPlaces(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String spec_name = request.getParameter("SpecName");
		session.setAttribute("specName", spec_name);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/EditSpec.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}



	private void sendRefusedEmil(HttpServletRequest request, HttpServletResponse response) {
		ViceDoyenDBA VDBA = new ViceDoyenDBA();
		String email = request.getParameter("studentEmail");
		VDBA.sendRefusedMailToStudent(email);
		getSpecStudents(request,response);
		
	}



	private void sendAcceptedEmail(HttpServletRequest request, HttpServletResponse response) {
		ViceDoyenDBA VDBA = new ViceDoyenDBA();
		String email = request.getParameter("studentEmail");
		VDBA.sendMailToAcceptedStudent(email);
		getSpecStudents(request,response);
	}



	private void getSpecStudents(HttpServletRequest request, HttpServletResponse response) {
		String spec = request.getParameter("specName");
		ViceDoyenDBA VDBA = new ViceDoyenDBA();
		List<student> specStudents = VDBA.getSpecStudent(spec);	
		request.setAttribute("specStudents", specStudents);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viceAccount1.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thecommand = request.getParameter("command");
		if(thecommand == null) {
			thecommand= "login";
		}
		
		switch(thecommand) {
		case "login":
			loginVice(request,response);
		}
		
	}



	private void loginVice(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ViceDoyenDBA VDBA = new ViceDoyenDBA();
		ViceDoyen v = new ViceDoyen();
		
		v.setFname(request.getParameter("Vfname"));
		v.setLname(request.getParameter("Vlname"));
		v.setPassword(request.getParameter("password"));
		if(VDBA.checkUser(v)) {
			List<specialite> specialites = VDBA.getSpecialites();
			session.setAttribute("specialites_list", specialites);
			RequestDispatcher dispatcher = request.getRequestDispatcher("viceAccount.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	}


	

}
