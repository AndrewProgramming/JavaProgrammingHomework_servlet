
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet {

  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("init method is called...");
  }


  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.service(req, resp);
    System.out.println("service method is called...");
  }

  @Override
  public void destroy() {
    super.destroy();
    System.out.println("destroy method is called...");
  }

  /** Handle the HTTP GET method.
   * @param request servlet request
   * @param response servlet response
   */


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {

    response.setContentType("text/html");
    java.io.PrintWriter out = response.getWriter();
    // output your page here
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("Hello, Java Servlets");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
