package br.com.secoti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet(name = "report", urlPatterns = { "/report" })
public class ReportServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ReportServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isDevelopment = request.getParameter("DEVELOPMENT");
		if(isDevelopment != null && !isDevelopment.trim().equals("") && isDevelopment.equalsIgnoreCase("true")) {
			
		} else {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}