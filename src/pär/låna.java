package pär;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class låna
 */
@WebServlet("/låna")
public class låna extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public låna() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		database db=new database("localhost", "root", "", "pär");
		
		
		Object[][] elev=db.getData("elev where personNummer="+request.getParameter("elevId"));
		
		
		
		if(elev.length>0) {
			if(request.getParameter("submit").equals("låna bok")) {
				String elevId=request.getParameter("elevId");
				String bokId=request.getParameter("bokId");
				String datum=getTime();
				
				
				Object[][] lånadeBöker=db.getData("lånadeBoker where bokId="+bokId);
				if(lånadeBöker.length>0) {
					System.out.println("boken är redan lånad");
					response.sendRedirect("index.jsp");
				}
				
				
				Object[][] bok=db.getData("bok where bokId="+bokId);
				if(bok.length>0) {
					db.execute("insert into lånadeboker(elevId,bokId,datum) values('"+elevId+"','"+bokId+"','"+datum+"')");
				}
				else {
					System.out.println("bok finns inte");
					response.sendRedirect("index.jsp");
				}
			}
			else if(request.getParameter("submit").equals("låna cd")) {
				String elevId=request.getParameter("elevId");
				String cdId=request.getParameter("cdId");
				String datum=getTime();
				
				
				
				Object[][] lånadecds=db.getData("lånadecds where cdId="+cdId);
				if(lånadecds.length>0) {
					System.out.println("cdn är redan lånad");
					response.sendRedirect("index.jsp");
				}
				
				
				
				Object[][] cd=db.getData("cd where cdId="+cdId);
				if(cd.length>0) {
					
					db.execute("insert into lånadecds(elevId,datum,cdId) values('"+elevId+"','"+datum+"','"+cdId+"')");
				}
				else {
					System.out.println("cd finns inte");
					response.sendRedirect("index.jsp");
				}
			}
			else if(request.getParameter("submit").equals("låna dvd")) {
				String elevId=request.getParameter("elevId");
				String dvdId=request.getParameter("dvdId");
				String datum=getTime();
				
				
				
				Object[][] lånadecds=db.getData("lånadedvds where dvdId="+dvdId);
				if(lånadecds.length>0) {
					System.out.println("dvdn är redan lånad");
					response.sendRedirect("index.jsp");
				}
				
				
				
				
				Object[][] dvd=db.getData("dvd where dvdId="+dvdId);
				if(dvd.length>0) {
					db.execute("insert into lånadedvds(elevId,datum,dvdId) values('"+elevId+"','"+datum+"','"+dvdId+"')");
				}
				else {
					System.out.println("dvd finns inte");
					response.sendRedirect("index.jsp");
				}
			}
		}
		else {
			System.out.println("personnummer finns inte");
			response.sendRedirect("index.jsp");
		}
		
		
		doGet(request, response);
	}
	
	
	
	public static String getTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		String time=dtf.format(now);  
		return time;
	}
	

}
