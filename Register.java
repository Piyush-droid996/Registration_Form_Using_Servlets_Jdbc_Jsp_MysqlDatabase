package registrationFormUsingServlet_Jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")  // Annotation to define the URL pattern for this servlet
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;  // Unique identifier for Serializable class

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set the response content type to HTML
        resp.setContentType("text/html;charset=UTF-8");
        // Get the writer to write response data
        PrintWriter out = resp.getWriter();

        // Retrieve form parameters from the request
        String myname = req.getParameter("user");
        String myLname = req.getParameter("lname");
        String myemail = req.getParameter("email");
        String mypass = req.getParameter("pass");
        String mycnf = req.getParameter("cnf");

        Connection con = null;  // Declare connection object
        PreparedStatement ps = null;  // Declare prepared statement object

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo", "root", "root");

            // Create a SQL query to insert user data into the 'register' table
            ps = con.prepareStatement("INSERT INTO register (user, lname, email, pass, cnf) VALUES (?, ?, ?, ?, ?)");
            // Set parameters for the SQL query
            ps.setString(1, myname);
            ps.setString(2, myLname);
            ps.setString(3, myemail);
            ps.setString(4, mypass);
            ps.setString(5, mycnf);

            // Execute the query and get the number of affected rows
            int count = ps.executeUpdate();

            // Check if the user was registered successfully
            if (count > 0) {
                // If yes, display success message
                out.print("<h3>User registered successfully</h3>");
                // Include the Register.jsp page in the response
                RequestDispatcher rd = req.getRequestDispatcher("/Register.jsp");
                rd.include(req, resp);
            } else {
                // If not, display error message
                out.print("<h3 style='color:red'>User not registered successfully</h3>");
                // Include the Register.jsp page in the response
                RequestDispatcher rd = req.getRequestDispatcher("/Register.jsp");
                rd.include(req, resp);
            }
        } catch (Exception e) {
            // Print stack trace for any exceptions
            e.printStackTrace();
            // Display error message with exception details
            out.print("<h3 style='color:red'>Exception occurred: " + e.getMessage() + "</h3>");
            // Include the Register.jsp page in the response
            RequestDispatcher rd = req.getRequestDispatcher("/Register.jsp");
            rd.include(req, resp);
        } finally {
            // Close the PreparedStatement and Connection objects to free resources
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
//Package Declaration: The package registrationFormUsingServlet_Jsp contains the servlet class.
//Imports: Necessary classes for JDBC, Servlet, and IO operations are imported.
//Servlet Annotation: @WebServlet("/regForm") defines the URL pattern for accessing this servlet.
//Class Declaration: Register class extends HttpServlet to handle HTTP requests.
//doPost Method: Handles POST requests sent to this servlet.
//Response Content Type: Sets the response type to HTML.
//Form Parameters: Retrieves form parameters sent with the request.
//Database Connection: Establishes a connection to the MySQL database using JDBC.
//SQL Query: Prepares an SQL query to insert form data into the register table.
//Set Parameters: Sets the values of the parameters in the SQL query.
//Execute Query: Executes the SQL query and checks the result.
//Response Handling: If the user is registered successfully, it shows a success message; otherwise, it shows an error message.
//Exception Handling: Catches and handles exceptions that might occur during database operations.
//Resource Cleanup: Ensures that database resources are properly closed in the finally block.




