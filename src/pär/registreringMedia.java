package p�r;

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
		database db=new database("localhost", "root", "", "p�r");
		
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
			String uppl�sarefnamn=request.getParameter("uppl�sarefnamn");
			String uppl�sareenamn=request.getParameter("uppl�sareenamn");
			db.execute("insert into cd(title,skaparefnamn,skapareenamn,uppl�sarefnamn,uppl�sareenamn) values ('"+title+"','"+skaparefnamn+"','"+skapareenamn+"','"+uppl�sarefnamn+"','"+uppl�sareenamn+"')");
		}
		
		
		doGet(request, response);
	}

}
