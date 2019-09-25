package pär;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registreringMedia
 */
@WebServlet("/registreringMedia")
public class registreringMedia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registreringMedia() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		database db=new database("localhost", "root", "", "pär");
		
		if(request.getParameter("submit").equals("bok")) {
			String title=request.getParameter("title");
			String skaparefnamn=request.getParameter("skaparefnamn");
			String skapareenamn=request.getParameter("skapareenamn");
			db.execute("insert into bok(title,skaparefnamn,skapareenamn) values ('"+title+"','"+skaparefnamn+"','"+skapareenamn+"')");
		}
		else if(request.getParameter("submit").equals("dvd")) {
			String title=request.getParameter("title");
			String skaparefnamn=request.getParameter("skaparefnamn");
			String skapareenamn=request.getParameter("skapareenamn");
			db.execute("insert into dvd(title,skaparefnamn,skapareenamn) values ('"+title+"','"+skaparefnamn+"','"+skapareenamn+"')");
		}
		else if(request.getParameter("submit").equals("cd")) {
			String title=request.getParameter("title");
			String skaparefnamn=request.getParameter("skaparefnamn");
			String skapareenamn=request.getParameter("skapareenamn");
			String uppläsarefnamn=request.getParameter("uppläsarefnamn");
			String uppläsareenamn=request.getParameter("uppläsareenamn");
			db.execute("insert into cd(title,skaparefnamn,skapareenamn,uppläsarefnamn,uppläsareenamn) values ('"+title+"','"+skaparefnamn+"','"+skapareenamn+"','"+uppläsarefnamn+"','"+uppläsareenamn+"')");
		}
		
		
		doGet(request, response);
	}

}
