package es.test.servletpruebas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendEmail() {
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
		// Recipient's email ID needs to be mentioned.


		String to = "ratchetmdt@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "@hotmail.com";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		// Properties props = System.getProperties();

		Properties props = new Properties();

		// Setup mail server
		// properties.setProperty("smtp.gmail.com", host);
		  props.setProperty("mail.transport.protocol", "smtp");
		    props.setProperty("mail.host", "smtp.live.com");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.auth", "true");
		// Get the default Session object.
		// Session session = Session.getDefaultInstance(properties);
		System.out.println("hereantes de Session");

		// handler proxy
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "yourpass");
			}
		});

		System.out.println("here1");
		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");
			
			// Now set the actual message
			message.setText("This is actual message");
			
			// Send message

			Transport.send(message);
			String title = "Send Email";
			String res = "Sent message successfully....";
			String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

			out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
					+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n"
					+ "<p align = \"center\">" + res + "</p>\n" + "</body></html>");
		} catch (MessagingException mex) {
			System.out.println("error");
			mex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
