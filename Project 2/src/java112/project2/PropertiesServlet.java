package java112.project2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This is the Properties Servlet for Project 2.
 * Written based on the example from the Trivial Servlet written by Eric Knapp
 *
 * Things to change for the project
 * 1.) The properties servlet must be in table layout
 *
 * @author Sean Fiscus
 */
@WebServlet(
        name = "propertiesServlet",
        urlPatterns = { "/properties" }
)

public class PropertiesServlet extends HttpServlet {

    private Properties properties;

    public void init() throws ServletException {
        properties = new Properties();
        loadProperties();
    }

    /**
     * Loads the properties file for the project.
     */
    private void loadProperties() {
        try {
            properties.load(this.getClass().getResourceAsStream("/project2.properties"));
        } catch (IOException ioexception) {
            System.out.println("IO Error reading in preference file.");
            ioexception.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error reading in preference file.");
            exception.printStackTrace();
        }

        System.out.println(properties.getProperty("author"));

        Set<String> propertyNames = properties.stringPropertyNames();
        
        for (String key: propertyNames) {
            String value = properties.getProperty(key);
            System.out.println(key + " => " + value);
        }        

    }

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
        out.print("<HEAD><TITLE>Project 2 Properties Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Project 2 Properties Servlet by Sean Fiscus</h1>");

        // 1.) Create table layout for project 2 servlet
        out.println("<table BORDER=1 table-layout:fixed CELLPADDING=10 CELLSPACING=1 WIDTH=100% >");
        
        out.print("<tr>");
        out.print("<th>Author's Name </th>");
        out.print("<th>Author's Email </th>");
        out.print("<th>Course Title </th>");
        out.print("<th>Course Meeting Times </th>");
        out.print("<th>Course Instructor </th>");
        out.print("<th>Description </th>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>" + properties.getProperty("author") + "</td>");
        out.print("<td>" + properties.getProperty("author.email.address") + "</td>");
        out.print("<td>" + properties.getProperty("course.title") + "</td>");
        out.print("<td>" + properties.getProperty("course.meeting.times") + "</td>");
        out.print("<td>" + properties.getProperty("course.instructor") + "</td>");
        out.print("<td>" + properties.getProperty("project.description") + "</td>");
        out.print("</tr>");

        out.print("</table>");
        out.print("<br><a href= /java112>Go Back Home</a></br>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}



        /**
         * What I had previously that wasn't correct
         * out.print("<HTML>");
         * out.print("<HEAD><TITLE>Project 2 Properties Servlet</TITLE></HEAD>");
         * out.print("<BODY>");
         * out.print("<h1>Project 2 Properties Servlet</h1>");
         * out.print("<p class='meta'>Posted by Sean Fiscus</p>");
         * out.print("<div class='entry'>");
         * out.print("<ul><li>Author's Name: " + properties.getProperty("author") + "<br />");
         * out.print("<li>Author's Email: " + properties.getProperty("author.email.address") + "</li>");
         * out.print("<li>Course Title: " + properties.getProperty("course.title") + "</li>");
         * out.print("<li>Course Meeting Times: " + properties.getProperty("course.meeting.times") + "</li>");
         * out.print("<li>Course Instructor: " + properties.getProperty("course.instructor") + "</li></ul>");
         * out.print("<p>Description: " + properties.getProperty("project.description") + "</p>");
         * out.print("</div>");
         * out.print("<a href= /java112>Go Back Home</a>");
         * out.print("</BODY>");
         * out.print("</HTML>");
         * out.close();
         */

