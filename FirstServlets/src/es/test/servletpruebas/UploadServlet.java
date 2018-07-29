package es.test.servletpruebas;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;


/**
 * Servlet implementation class UploadServlet
 */
//@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 50 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	public void init() {
		// Get the file location where it would be stored.
		filePath = getServletContext().getInitParameter("file-upload");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Check that we have a file upload request
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		
		

		if (!isMultipart) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>");
			out.println("</body>");
			out.println("</html>");
			return;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("c:\\temp"));
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);
		
		try {
			// Parse the request to get file items.
			List<FileItem>  fileItems = upload.parseRequest(new ServletRequestContext(request));
			
			//List<FileItem> fileItems = upload.parseRequest(request.getServletContext());
			// Process the uploaded file items
			Iterator i = fileItems.iterator();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					System.out.println("Mejor");
					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) {
						System.out.println("Mejor1");
						file = new File("c:\\temp"+fileName.substring(fileName.lastIndexOf("\\")));
					} else {
						System.out.println("Mejor2");
						file = new File("c:\\temp"+ fileName.substring(fileName.lastIndexOf("\\") + 1));
					}
					System.out.println(filePath);
					System.out.println(fieldName);
					System.out.println(fileName);
					System.out.println(fileName.substring(fileName.lastIndexOf("\\") + 1));
					
				
					System.out.println("Mejor3");
					fi.write(file);
					
					System.out.println("Mejor4");
					out.println("Uploaded Filename: " + fileName + "<br>");
					System.out.println("Mejor5");
				}
			}
			out.println("</body>");
			out.println("</html>");
			System.out.println("Mejor12");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	

}
