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
		response.setContentType("text/html");
		
		
		PrintWriter out=response.getWriter();
		database db=new database("localhost", "root", "", "pär");
		
		if(request.getParameter("submit").equals("bok")) {
			
			String bokId=request.getParameter("bokId");
			String title=request.getParameter("title");
			String skaparefnamn=request.getParameter("skaparefnamn");
			String skapareenamn=request.getParameter("skapareenamn");
			
			Object[][] bok=db.getData("bok where bokId="+bokId);
			if(bok.length>0) {
				out.print("bok med detta id finns redan!");
			}
			else {
				db.execute("insert into bok(bokId,title,skaparefnamn,skapareenamn) values ('"+bokId+"','"+title+"','"+skaparefnamn+"','"+skapareenamn+"')");
				out.print("bok registrerad");
			}
		}
		else if(request.getParameter("submit").equals("dvd")) {
			String dvdId=request.getParameter("dvdId");
			String title=request.getParameter("title");
			String skaparefnamn=request.getParameter("skaparefnamn");
			String skapareenamn=request.getParameter("skapareenamn");
			
			Object[][] dvd=db.getData("dvd where dvdId="+dvdId);
			if(dvd.length>0) {
				out.print("dvd med detta id finns redan!");
			}
			else {
			db.execute("insert into dvd(dvdId,title,skaparefnamn,skapareenamn) values ('"+dvdId+"','"+title+"','"+skaparefnamn+"','"+skapareenamn+"')");
			out.print("dvd registrerad");
			}
		}
		else if(request.getParameter("submit").equals("cd")) {
			String cdId=request.getParameter("cdId");
			String title=request.getParameter("title");
			String skaparefnamn=request.getParameter("skaparefnamn");
			String skapareenamn=request.getParameter("skapareenamn");
			String uppläsarefnamn=request.getParameter("uppläsarefnamn");
			String uppläsareenamn=request.getParameter("uppläsareenamn");
			
			Object[][] dvd=db.getData("cd where cdId="+cdId);
			if(dvd.length>0) {
				out.print("cd med detta id finns redan!");
			}
			else {
				db.execute("insert into cd(cdId,title,skaparefnamn,skapareenamn,uppläsarefnamn,uppläsareenamn) values ('"+cdId+"','"+title+"','"+skaparefnamn+"','"+skapareenamn+"','"+uppläsarefnamn+"','"+uppläsareenamn+"')");
				out.print("cd registrerad");
			}
		}
		
		
		
		
		out.print("<form action='index.jsp'>"
				+ "<input type='submit' value='go back'>"
				+ "</form>");
		
		doGet(request, response);
	}

}
