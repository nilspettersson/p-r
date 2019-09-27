package pär;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class show
 */
@WebServlet("/show")
public class show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		PrintWriter out=response.getWriter();
		database db=new database("localhost", "root", "", "pär");
		
		//visar alla elever
		if(request.getParameter("submit").equals("elever")) {
			Object[][] elever=db.getData("elev");
			for(int i=0;i<elever.length;i++) {
					out.print(elever[i][2]+" ");
					out.print(elever[i][3]+"<br>  ");
					//out.print( "personnummer: "+elever[i][1]);
					out.println("<br>");
					out.println("<br>");
			}
		}
		
		//visar alla böker
		if(request.getParameter("submit").equals("bok")) {
			Object[][] böker=db.getData("bok");
			for(int i=0;i<böker.length;i++) {
					out.print("title: "+böker[i][2]+"<br>   ");
					out.print("författare: "+böker[i][3]+" ");
					out.print(böker[i][4]);
					out.println("<br>");
					out.println("<br>");
					
			}
		}
		
		//visar all cds
		if(request.getParameter("submit").equals("cd")) {
			Object[][] cds=db.getData("cd");
			for(int i=0;i<cds.length;i++) {
					out.print("title: "+cds[i][2]+"   ");
					out.print("författare: "+cds[i][3]+" ");
					out.print(cds[i][4]+"    ");
					out.print("uppläsare: "+cds[i][5]+" ");
					out.print(cds[i][6]);
					out.println("<br>");
					out.println("<br>");
					
			}
		}
		
		//visar alla filmer
		if(request.getParameter("submit").equals("dvd")) {
			Object[][] dvds=db.getData("dvd");
			for(int i=0;i<dvds.length;i++) {
					out.print("title: "+dvds[i][2]+"   ");
					out.print("regissör: "+dvds[i][3]+" ");
					out.print(dvds[i][4]);
					out.println("<br>");
					out.println("<br>");
					
			}
		}
		
		
		
		if(request.getParameter("submit").equals("lånadeBöker")) {
			//Object[][] bok=db.getData("bok");
			//Object[][] elev=db.getData("elev");
			Object[][] lånadeBoker=db.getData("lånadeBoker");
			
			
			for(int i=0;i<lånadeBoker.length;i++) {
				Object[][] elev=db.getData("elev where personNummer="+lånadeBoker[i][1]);
				Object[][] bok=db.getData("bok where bokId="+lånadeBoker[i][2]);
				if(elev.length>0) {
					String end=getDate(lånadeBoker[i][3].toString(), 7*3);
					String current=getTime();
					
					
					out.print("title: "+bok[0][2]);
					out.println("<br>    lånad av: "+elev[0][2]+" "+elev[0][3]);
					out.println("<br>        lämnas in senast: "+end);
					if(late(current, end)) {
						out.print("<p style='color:red;'>denna bok är inte inlämnad i tid!</p><br>");
					}
					out.println("<br>");
					out.println("<br>");
				}
				
				
			}
			
			
		}
		if(request.getParameter("submit").equals("lånadeCds")) {
			//Object[][] bok=db.getData("bok");
			//Object[][] elev=db.getData("elev");
			Object[][] lånadeBoker=db.getData("lånadecds");
			
			
			for(int i=0;i<lånadeBoker.length;i++) {
				Object[][] elev=db.getData("elev where personNummer="+lånadeBoker[i][1]);
				Object[][] cd=db.getData("cd where cdId="+lånadeBoker[i][3]);
				if(elev.length>0) {
					String end=getDate(lånadeBoker[i][2].toString(), 7*3);
					String current=getTime();
					
					out.print("title: "+cd[0][2]);
					out.println("<br>    lånad av: "+elev[0][2]+" "+elev[0][3]);
					out.println("<br>        lämnas in senast: "+end);
					if(late(current, end)) {
						out.print("<p style='color:red;'>denna cd är inte inlämnad i tid!</p><br>");
					}
					out.println("<br>");
					out.println("<br>");
				}
				
				
			}
			
			
		}
		if(request.getParameter("submit").equals("lånadeDvds")) {
			//Object[][] bok=db.getData("bok");
			//Object[][] elev=db.getData("elev");
			Object[][] lånadeBoker=db.getData("lånadedvds");
			
			
			for(int i=0;i<lånadeBoker.length;i++) {
				Object[][] elev=db.getData("elev where personNummer="+lånadeBoker[i][1]);
				Object[][] bok=db.getData("dvd where dvdId="+lånadeBoker[i][3]);
				if(elev.length>0) {
					String end=getDate(lånadeBoker[i][2].toString(), 7);
					String current=getTime();
					
					out.print("title: "+bok[0][2]);
					out.println("<br>    lånad av: "+elev[0][2]+" "+elev[0][3]);
					out.println("<br>        lämnas in senast: "+end);
					if(late(current, end)) {
						out.print("<p style='color:red;'>denna dvd är inte inlämnad i tid!</p><br>");
					}
					out.println("<br>");
					out.println("<br>");
				}
				
				
			}
			
			
		}
		
		
		out.print("<form action='index.jsp'>"
				+ "<input type='submit' value='go back'>"
				+ "</form>");
		
		doGet(request, response);
	}
	
	
	
	public String getDate(String date,int addDays) {
		String dt = date;  // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.add(Calendar.DATE, addDays);  // number of days to add
		dt = sdf.format(c.getTime());
		
		return dt;
		
	}
	
	public boolean late(String current,String end) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar currentCalender = Calendar.getInstance();
		try {
			currentCalender.setTime(sdf.parse(current));
		
		
		Calendar endCalender = Calendar.getInstance();
		
			endCalender.setTime(sdf.parse(end));
		
		
		 if(currentCalender.after(endCalender)){
	           return true;
	     }
		 
		 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		 
	}
	
	
	public static String getTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		String time=dtf.format(now);  
		return time;
	}
	
	

}
