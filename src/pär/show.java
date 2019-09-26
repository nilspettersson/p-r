package p�r;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		PrintWriter out=response.getWriter();
		database db=new database("localhost", "root", "", "p�r");
		
		if(request.getParameter("submit").equals("elever")) {
			Object[][] elever=db.getData("elev");
			for(int i=0;i<elever.length;i++) {
					out.print(elever[i][2]+" ");
					out.print(elever[i][3]);
					out.println("");
					
			}
		}
		
		//visar alla b�ker
		if(request.getParameter("submit").equals("bok")) {
			Object[][] b�ker=db.getData("bok");
			for(int i=0;i<b�ker.length;i++) {
					out.print("title: "+b�ker[i][2]+"   ");
					out.print("f�rfattare: "+b�ker[i][3]+" ");
					out.print(b�ker[i][4]);
					out.println("");
					
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
					out.println("");
					
			}
		}
		
		//visar alla filmer
		if(request.getParameter("submit").equals("dvd")) {
			Object[][] dvds=db.getData("dvd");
			for(int i=0;i<dvds.length;i++) {
					out.print("title: "+dvds[i][2]+"   ");
					out.print("regiss�r: "+dvds[i][3]+" ");
					out.print(dvds[i][4]);
					out.println("");
					
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
					out.print(i+" title: "+bok[0][2]);
					out.println("    l�nad av: "+elev[0][2]+" "+elev[0][3]);
					out.println();
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
					out.print("title: "+cd[0][2]);
					out.println("    l�nad av: "+elev[0][2]+" "+elev[0][3]);
					out.println();
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
					out.print("title: "+bok[0][2]);
					out.println("    l�nad av: "+elev[0][2]+" "+elev[0][3]);
					out.println();
				}
				
				
			}
			
			
		}
		
		
		
		
		doGet(request, response);
	}

}
