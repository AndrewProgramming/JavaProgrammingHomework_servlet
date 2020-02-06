import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//编写一个Servlet来显示乘法表格，如下图所示
public class Exercise_02 extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html";
  /**Process the HTTP Get request*/
  public void doGet(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Exercise37_02</title></head>");
    out.println("<body>");
    out.println("<table border=\"1\">");
    out.println("<tr><th colspan=\"10\">Multiplication Table</th></tr>");
    out.println("<tr>");
    out.println("<td width=\"50\" height=\"17\"></td>");
    for (int j = 1; j <= 9; j++)
      out.println("<td width=\"50\" height=\"17\">" + j + "</td>");
    out.println("</tr>");

    for (int i = 1; i <= 9; i++) {
      out.println("<tr>");
      out.println("<td width=\"50\" height=\"17\">" + i + "</td>");
      for (int j = 1; j <= 9; j++) {
      // Display the product and align properly
        out.println("<td width=\"50\" height=\"17\">" + i * j + "</td>");
      }
      out.println("<tr>");
    }
    out.println("</table>");
    out.println("</body></html>");
  }
}