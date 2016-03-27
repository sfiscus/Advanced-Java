package java112.project2;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This servlet is being created for Project 2. This servlet will have these elements:
 * The servlet will generate HTML output that contains your name and the course your are taking.
 * The generated output will contain an image tag. Find an appropriate image somewhere and put it into the projects/public_html/images directory. The correct way to create the tag will be discussed in class.
 * The generated output will contain a link back to the home page
 * Written based on the example from the Trivial Servlet written by Eric Knapp
 *
 * @author Sean Fiscus
 */
@WebServlet(
        name = "firstServlet",
        urlPatterns = { "/first" }
)

public class First112Servlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Project 2 Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Project 2 Servlet</h1>");
        out.print("<p class='meta'>Posted by Sean Fiscus</p>");
        out.print("<img src='./images/DSC_5601.JPG' alt='Just me' height='700' width='500'><br />");
        out.print("<p>My name is Sean Fiscus and this is my java servlet for Project 2. Pretty fancy well at least it will be</p>");
        out.print("<a href= /java112>Go Back Home</a>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}