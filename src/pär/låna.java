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
				
				Object[][] bok=db.getData("bok where bokId="+bokId);
				if(bok.length>0) {
					db.execute("insert into lånadeboker(elevId,bokId,datum) values('"+elevId+"','"+bokId+"','"+datum+"')");
				}
			}
			else if(request.getParameter("submit").equals("låna cd")) {
				String elevId=request.getParameter("elevId");
				String cdId=request.getParameter("bokId");
				String datum=getTime();
				
				Object[][] cd=db.getData("bok where bokId="+cdId);
				if(cd.length>0) {
					db.execute("insert into lånadecds(elevId,bokId,datum) values('"+elevId+"','"+datum+"','"+cdId+"')");
				}
			}
			else if(request.getParameter("submit").equals("låna dvd")) {
				String elevId=request.getParameter("elevId");
				String dvdId=request.getParameter("bokId");
				String datum=getTime();
				
				Object[][] dvd=db.getData("bok where bokId="+dvdId);
				if(dvd.length>0) {
					db.execute("insert into lånadedvds(elevId,bokId,datum) values('"+elevId+"','"+datum+"','"+dvdId+"')");
				}
			}
		}
		else {
			System.out.println("personnummer not found");
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
