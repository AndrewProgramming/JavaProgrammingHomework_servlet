import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//（计算税）
public class Exercise_04 extends HttpServlet {
  /** Process the HTTP Get request */
  public void doGet(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    request.getSession();
    // Obtain parameters from the client
    double taxableIncome =
      Double.parseDouble(request.getParameter("taxableIncome"));
    int filingStatus = Integer.parseInt(request.getParameter("filingStatus"));

    out.println("Taxable Income: " + taxableIncome + "<br>");
    out.println("Filing Status: " + filingStatus + "<br>");
    out.println("<font color=\"#FF0000\">");
    out.println("Tax: " + ComputeTax.computeTax(filingStatus, taxableIncome));
    out.println("</font>");

    out.close();
  }
}
