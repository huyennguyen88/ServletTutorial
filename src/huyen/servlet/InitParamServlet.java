package huyen.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/InitParamServlet")
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String email1;
    public InitParamServlet() {
        super();

    }
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.email1 = config.getInitParameter("emailSupport1");

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email2 = this.getServletConfig().getInitParameter("emailSupport2");
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
        out.println("<head><title>Init Param</title></head>");
 
        out.println("<body>");
        out.println("<h3>Init Param</h3>");
        out.println("<p>emailSupport1 = " + this.email1 + "</p>");
        out.println("<p>emailSupport2 = " + email2 + "</p>");
        out.println("</body>");
        out.println("<html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
