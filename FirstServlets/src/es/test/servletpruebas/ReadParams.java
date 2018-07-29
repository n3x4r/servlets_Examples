package es.test.servletpruebas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadParams
 */
@WebServlet("/ReadParams")
public class ReadParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadParams() {
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
	      String title = "Reading All Form Parameters";
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

	      out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor = \"#f0f0f0\">\n" +
	         "<h1 align = \"center\">" + title + "</h1>\n" +
	         "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
	         "<tr bgcolor = \"#949494\">\n" +
	            "<th>Param Name</th>" +
	            "<th>Param Value(s)</th>\n" +
	         "</tr>\n"
	      );

	      Enumeration<String> paramNames = request.getParameterNames();
	  
	      while(paramNames.hasMoreElements()) {
	         String paramName = paramNames.nextElement();
	         out.print("<tr><td>" + paramName + "</td>\n<td>");
	         String[] paramValues = request.getParameterValues(paramName);

	         // Read single valued data
	         if (paramValues.length == 1) {
	            String paramValue = paramValues[0];
	            if (paramValue.length() == 0)
	               out.println("<i>No Value</i>");
	               else
	               out.println(paramValue);
	         } else {
	            // Read multiple valued data
	            out.println("<ul>");

	            for(int i = 0; i < paramValues.length; i++) {
	               out.println("<li>" + paramValues[i]);
	            }
	            out.println("</ul>");
	         }
	      }
	      out.println("</tr>\n</table>\n");
	      out.println("<p>" + request.getProtocol() + " </p>");
	      out.println("<p>" + request.getLocalAddr() + " </p>");
	      out.println("</body></html>");
	   }
	   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
