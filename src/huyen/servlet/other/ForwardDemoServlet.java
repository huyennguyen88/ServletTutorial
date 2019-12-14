package huyen.servlet.other;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import huyen.beans.Constants;
@WebServlet("/other/forwardDemo")
public class ForwardDemoServlet extends HttpServlet {
	 // Request:
    // http://localhost:8080/ServletTutorial/other/forwardDemo?forward=true
	private static final long serialVersionUID = 1L;
    public ForwardDemoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = request.getParameter("forward");
		if("true".equals(forward)) {
			System.out.println("Forward to ShowMeServlet");
			request.setAttribute(Constants.ATTRIBUTE_USER_NAME_KEY, "Hi, I'm Tom come from Walt Disney !");
		RequestDispatcher dis = request.getServletContext().getRequestDispatcher("/showMe");
		dis.forward(request, response);
		return;
		}
		ServletOutputStream out = response.getOutputStream();
		out.println("<h3>Text of ForwardDemoServlet</h3>");
		out.println("-servletpath"+request.getServletPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
