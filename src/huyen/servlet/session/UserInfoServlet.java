package huyen.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import huyen.beans.Constants;
import huyen.beans.UserInfo;
@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserInfoServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		UserInfo loginedInfo = (UserInfo) ses.getAttribute(Constants.SESSION_USER_KEY);
		if(loginedInfo ==null) {
			response.sendRedirect(this.getServletContext().getContextPath()+"/login");
			return;
		}
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
        out.println("<head><title>Session example</title></head>");
 
        out.println("<body>");
 
        out.println("<h3>User Info:</h3>");
 
        out.println("<p>User Name:" + loginedInfo.getUserName() + "</p>");
        out.println("<p>Country:" + loginedInfo.getCountry() + "</p>");
        out.println("<p>Post:" + loginedInfo.getPost() + "</p>");
        out.println("</body>");
        out.println("<html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
