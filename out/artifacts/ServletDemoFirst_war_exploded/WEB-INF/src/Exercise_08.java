import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//使用cookie
public class Exercise_08 extends HttpServlet {
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
    out.println("<head><title>Exercise37_10</title></head>");
    out.println("<body>");

    Cookie cookieColor = new Cookie("color", "red");
    cookieColor.setMaxAge(2*24*60*60);
    response.addCookie(cookieColor);
    Cookie cookieRadius = new Cookie("radius", "5.5");
    cookieRadius.setMaxAge(2*24*60*60);
    response.addCookie(cookieRadius);
    Cookie cookieCount = new Cookie("count", "2");
    cookieRadius.setMaxAge(0);
    response.addCookie(cookieCount);

    out.println("<p>The cookies have been added to your browser.</p>");
    out.println("</body></html>");
  }
  /**Clean up resources*/
  public void destroy() {
  }
}
