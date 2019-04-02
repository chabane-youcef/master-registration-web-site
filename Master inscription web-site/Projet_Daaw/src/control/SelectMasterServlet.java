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

import model.Filiere;
import model.StudentDBA;
import model.Universite;
import model.specialite;

/**
 * Servlet implementation class SelectMasterServlet
 */
@WebServlet("/SelectMasterServlet")
public class SelectMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thecommand = request.getParameter("command");
		switch(thecommand) {
		case "listuniv":
			getUnivsList(request,response);
			break;
		default:
			break;
		}
	}

	
	


	private void getUnivsList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		StudentDBA DBA = new StudentDBA();
		List<Universite> univs_list = DBA.getUniv();
		session.setAttribute("univs_list", univs_list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/UniverSelect.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doing good");
		
			getFilieres(request,response);
			
		
	}


	


	private void getFilieres(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		StudentDBA DBA = new StudentDBA();
		int id = Integer.parseInt(request.getParameter("univ_id"));
		List<Filiere> filieres = DBA.getFiliere(id);
		
		session.setAttribute("filiere_list", filieres);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/FiliereSelect.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
