/*
 * Exercise37_13.java
 *
 * Created on April 26, 2007, 2:24 PM
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 投票程序
public class Exercise_11 extends HttpServlet {
  private PreparedStatement pstmtIncreaseYes, pstmtIncreaseNo;
  private Connection conn;
  private Statement statement;
  
  /** Initialize variables */
  public void init() throws ServletException {
    initializeJdbc();
  }
  
  /** Initialize database connection */
  private void initializeJdbc() {
    try {
      // Explicitly load a MySQL driver
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded");
      
      // Establish a connection
      conn = DriverManager.getConnection
        ("jdbc:mysql://localhost/javabook" , "scott", "tiger");
      
      // Create a Statement
      pstmtIncreaseYes = conn.prepareStatement(
        "update Poll set yesCount = yesCount + 1");
      pstmtIncreaseNo = conn.prepareStatement(
        "update Poll set noCount = noCount + 1 ");
      
      statement = conn.createStatement();   
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    String yesOrNo = request.getParameter("yesorno");
    try {
      if (yesOrNo.equals("Yes"))
        pstmtIncreaseYes.executeUpdate();
      // statement.executeUpdate("update Poll set yesCount = yesCount + 1");
      else
        pstmtIncreaseNo.executeUpdate();
      //statement.executeUpdate("update Poll set noCount = noCount + 1");
      
      ResultSet result = statement.executeQuery("select yesCount from Poll");
      result.next();
      out.println("The current Yes count is " + result.getInt(1) + "<br>");
      
      result = statement.executeQuery("select noCount from Poll");
      result.next();
      out.println("The current No count is " + result.getInt(1));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
