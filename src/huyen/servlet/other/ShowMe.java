package huyen.servlet.other;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import huyen.beans.Constants;
@WebServlet("/showMe")
public class ShowMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowMe() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<h1>Show me page</h1>");
		
		out.println("<h2>"+request.getAttribute(Constants.ATTRIBUTE_USER_NAME_KEY) +"</h2>");
		out.println("</html");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
