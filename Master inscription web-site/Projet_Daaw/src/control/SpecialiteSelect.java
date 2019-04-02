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

import model.StudentDBA;
import model.specialite;

/**
 * Servlet implementation class SpecialiteSelect
 */
@WebServlet("/SpecialiteSelect")
public class SpecialiteSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doing good");
		
		getSpecs(request,response);
			
		
	}


	private void getSpecs(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		StudentDBA DBA = new StudentDBA();
		int id = Integer.parseInt(request.getParameter("fil_id"));
		List<specialite> specialites = DBA.getSpecs(id);
		
		session.setAttribute("specialites_list", specialites);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SpecialiteSelect.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
