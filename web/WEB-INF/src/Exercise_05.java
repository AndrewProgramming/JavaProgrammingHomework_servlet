import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//（计算贷款）
public class Exercise_05 extends HttpServlet {

  /**
   * Process the HTTP Get request
   */
  public void doGet(HttpServletRequest request, HttpServletResponse
      response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // Obtain parameters from the client
    double loanAmount =
        Double.parseDouble(request.getParameter("loanAmount"));
    double annualInterestRate = Double.parseDouble
        (request.getParameter("annualInterestRate"));
    int numOfYears = Integer.parseInt(request.getParameter("numOfYears"));

    Loan loan = new Loan(annualInterestRate, numOfYears, loanAmount);

    out.println("Loan Amount: " + loanAmount + "<br>");
    out.println("Annual Interest Rate: " + annualInterestRate + "<br>");
    out.println("Number of Years: " + numOfYears + "<br>");
    out.println("<font color=\"#FF0000\">");
    out.println("Monthly Payment: " + loan.monthlyPayment() + "<br>");
    out.println("Total Payment: " + loan.totalPayment() + "<br>");
    out.println("</font>");
  }
}