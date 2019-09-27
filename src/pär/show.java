package p�r;

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
		database db=new database("localhost", "root", "", "p�r");
		
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
		
		//visar alla b�ker
		if(request.getParameter("submit").equals("bok")) {
			Object[][] b�ker=db.getData("bok");
			for(int i=0;i<b�ker.length;i++) {
					out.print("title: "+b�ker[i][2]+"<br>   ");
					out.print("f�rfattare: "+b�ker[i][3]+" ");
					out.print(b�ker[i][4]);
					out.println("<br>");
					out.println("<br>");
					
			}
		}
		
		//visar all cds
		if(request.getParameter("submit").equals("cd")) {
			Object[][] cds=db.getData("cd");
			for(int i=0;i<cds.length;i++) {
					out.print("title: "+cds[i][2]+"   ");
					out.print("f�rfattare: "+cds[i][3]+" ");
					out.print(cds[i][4]+"    ");
					out.print("uppl�sare: "+cds[i][5]+" ");
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
					out.print("regiss�r: "+dvds[i][3]+" ");
					out.print(dvds[i][4]);
					out.println("<br>");
					out.println("<br>");
					
			}
		}
		
		
		
		if(request.getParameter("submit").equals("l�nadeB�ker")) {
			//Object[][] bok=db.getData("bok");
			//Object[][] elev=db.getData("elev");
			Object[][] l�nadeBoker=db.getData("l�nadeBoker");
			
			
			for(int i=0;i<l�nadeBoker.length;i++) {
				Object[][] elev=db.getData("elev where personNummer="+l�nadeBoker[i][1]);
				Object[][] bok=db.getData("bok where bokId="+l�nadeBoker[i][2]);
				if(elev.length>0) {
					String end=getDate(l�nadeBoker[i][3].toString(), 7*3);
					String current=getTime();
					
					
					out.print("title: "+bok[0][2]);
					out.println("<br>    l�nad av: "+elev[0][2]+" "+elev[0][3]);
					out.println("<br>        l�mnas in senast: "+end);
					if(late(current, end)) {
						out.print("<p style='color:red;'>denna bok �r inte inl�mnad i tid!</p><br>");
					}
					out.println("<br>");
					out.println("<br>");
				}
				
				
			}
			
			
		}
		if(request.getParameter("submit").equals("l�nadeCds")) {
			//Object[][] bok=db.getData("bok");
			//Object[][] elev=db.getData("elev");
			Object[][] l�nadeBoker=db.getData("l�nadecds");
			
			
			for(int i=0;i<l�nadeBoker.length;i++) {
				Object[][] elev=db.getData("elev where personNummer="+l�nadeBoker[i][1]);
				Object[][] cd=db.getData("cd where cdId="+l�nadeBoker[i][3]);
				if(elev.length>0) {
					String end=getDate(l�nadeBoker[i][2].toString(), 7*3);
					String current=getTime();
					
					out.print("title: "+cd[0][2]);
					out.println("<br>    l�nad av: "+elev[0][2]+" "+elev[0][3]);
					out.println("<br>        l�mnas in senast: "+end);
					if(late(current, end)) {
						out.print("<p style='color:red;'>denna cd �r inte inl�mnad i tid!</p><br>");
					}
					out.println("<br>");
					out.println("<br>");
				}
				
				
			}
			
			
		}
		if(request.getParameter("submit").equals("l�nadeDvds")) {
			//Object[][] bok=db.getData("bok");
			//Object[][] elev=db.getData("elev");
			Object[][] l�nadeBoker=db.getData("l�nadedvds");
			
			
			for(int i=0;i<l�nadeBoker.length;i++) {
				Object[][] elev=db.getData("elev where personNummer="+l�nadeBoker[i][1]);
				Object[][] bok=db.getData("dvd where dvdId="+l�nadeBoker[i][3]);
				if(elev.length>0) {
					String end=getDate(l�nadeBoker[i][2].toString(), 7);
					String current=getTime();
					
					out.print("title: "+bok[0][2]);
					out.println("<br>    l�nad av: "+elev[0][2]+" "+elev[0][3]);
					out.println("<br>        l�mnas in senast: "+end);
					if(late(current, end)) {
						out.print("<p style='color:red;'>denna dvd �r inte inl�mnad i tid!</p><br>");
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
