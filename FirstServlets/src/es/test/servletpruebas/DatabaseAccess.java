package es.test.servletpruebas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DatabaseAccess
 */
@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/test") // resource injection the resources to database
	private DataSource dataSource;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseAccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // Set response content type
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      String title = "Database Result";
	      
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	      
	      out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor = \"#f0f0f0\">\n" +
	         "<h1 align = \"center\">" + title + "</h1>\n");
	      
	      
	      Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;

			try {
				myConn = dataSource.getConnection();

				String sql = "select * from employees;";

				myStmt = myConn.createStatement();

				myRs = myStmt.executeQuery(sql);

				while (myRs.next()) {
					int id = myRs.getInt("id");
					int age = myRs.getInt("age");
					String first = myRs.getString("first");
					String last = myRs.getString("last");
					
					out.println("ID: " + id );
		            out.println(", Age: " + age );
		            out.println(", First: " + first );
		            out.println(", Last: " + last );
		            out.println("<br>");
					
					
					
					//System.out.println(email);
				}
				out.println("</body></html>");
					myRs.close();
					myStmt.close();
					myConn.close();
					
			} catch (Exception exc) {
				exc.printStackTrace();
				out.println(exc.getMessage());
			}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
