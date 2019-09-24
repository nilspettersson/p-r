package pär;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class registreringAnvändare
 */
@WebServlet("/registreringElev")
public class registreringElev extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public registreringElev() {
        // TODO Auto-generated constructor stub
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String personnummer=request.getParameter("personnummer");
		String fnamn=request.getParameter("fnamn");
		String enamn=request.getParameter("enamn");
		
		
		database db=new database("localhost", "root", "", "pär");
		
		
		db.execute("insert into elev(personnummer,fnamn,enamn) values ('"+personnummer+"','"+fnamn+"','"+enamn+"')");
		
		
		
		doGet(request, response);
	}

}
