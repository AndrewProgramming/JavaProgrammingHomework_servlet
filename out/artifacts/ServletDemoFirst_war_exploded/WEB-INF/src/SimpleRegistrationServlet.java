import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleRegistrationServlet extends HttpServlet {

  // Use a prepared statement to store a student into the database
  private PreparedStatement pstmt;

  /**
   * Initialize variables
   */
  public void init() throws ServletException {
    initializeJdbc();
  }

  /**
   * Process the HTTP Post request
   */
  public void doPost(HttpServletRequest request, HttpServletResponse
      response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // Obtain parameters from the client
    String lastName = request.getParameter("lastName");
    String firstName = request.getParameter("firstName");
    String mi = request.getParameter("mi");
    String phone = request.getParameter("telephone");
    String email = request.getParameter("email");
    String address = request.getParameter("street");
    String city = request.getParameter("city");
    String state = request.getParameter("state");
    String zip = request.getParameter("zip");

    try {
      if (lastName.length() == 0 || firstName.length() == 0) {
        out.println("Last Name and First Name are required");
      } else {
        storeStudent(lastName, firstName, mi, phone, email,
            address, city, state, zip);

        out.println(firstName + " " + lastName +
            " is now registered in the database");
      }
    } catch (Exception ex) {
      out.println("Error: " + ex.getMessage());
    } finally {
      out.close(); // Close stream
    }
  }

  /**
   * Initialize database connection
   */
  private void initializeJdbc() {
    try {
      // Load the JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded");

      // Establish a connection
      Connection conn = DriverManager.getConnection
          ("jdbc:mysql://localhost:3307/servletdemodb", "root", "my-secret-pw");
      System.out.println("Database connected");

      // Create a Statement
      pstmt = conn.prepareStatement("insert into Address " +
          "(lastName, firstName, mi, telephone, email, street, city, "
          + "state, zip) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Store a student record to the database
   */
  private void storeStudent(String lastName, String firstName,
      String mi, String phone, String email, String address,
      String city, String state, String zip) throws SQLException {
    pstmt.setString(1, lastName);
    pstmt.setString(2, firstName);
    pstmt.setString(3, mi);
    pstmt.setString(4, phone);
    pstmt.setString(5, email);
    pstmt.setString(6, address);
    pstmt.setString(7, city);
    pstmt.setString(8, state);
    pstmt.setString(9, zip);
    pstmt.executeUpdate();
  }
}