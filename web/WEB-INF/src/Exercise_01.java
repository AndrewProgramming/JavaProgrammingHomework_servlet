import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 编写一个servlet，用一个表格，显示从0到10的阶乘。
public class Exercise_01 extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html";
  /**Process the HTTP Get request*/
  public void doGet(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Exercise37_01</title></head>");
    out.println("<body>");
    out.println("<table border=\"1\">");
    out.println("<tr>");
    out.println("<td>Number</td>");
    out.println("<td>Factorial</td>");
    out.println("</tr>");
    for (int i = 0; i <= 10; i++) {
      out.println("<tr>");
      out.println("<td>" + i + "</td>");
      out.println("<td>" + computeFactorial(i) + "</td>");
      out.println("</tr>");
    }

    out.println("</body></html>");
  }

  private long computeFactorial(int n) {
    if (n == 0)
      return 1;
    else
      return n*computeFactorial(n - 1);
  }
}