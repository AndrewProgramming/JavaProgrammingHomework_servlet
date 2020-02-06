import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 获取cookie
public class Exercise_09 extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html";
  /**Initialize global variables*/
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }
  /**Process the HTTP Get request*/
  public void doGet(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Exercise37_11</title></head>");
    out.println("<body>");

    out.println("Here are the cookies from your browser<p>");
    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; i++)
      out.println(cookies[i].getName() + "'s value is " +
        cookies[i].getValue() + "<br>");
    out.println("</body></html>");
  }

  /**Clean up resources*/
  public void destroy() {
  }
}
