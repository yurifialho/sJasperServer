package br.com.secoti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.secoti.util.PropUtil;

/**
 * 
 * @author Yuri Fialho
 * @since 28/02/2014
 * 
 */
@WebServlet(name = "report", urlPatterns = { "/report" })
public class ReportServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static String isDevelopment = PropUtil.get("development-on"); 
	
    public ReportServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Pega do request o flag de desenvolvimento
		String developmentFlag = request.getParameter(PropUtil.get("development-flag"));
		
		if(isDevelopment == null || isDevelopment.trim().equals("")) {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Development mode is not seted");
			return;
		}
		
		if(developmentFlag == null || developmentFlag.trim().equals("")) {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Development mode key is not seted");
			return;
		}
		//Verifica se a operação é permitida
		if(isDevelopment.equals("true") && developmentFlag.equalsIgnoreCase("true")) {
			
		} else {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}