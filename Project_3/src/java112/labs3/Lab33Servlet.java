package java112.project3;
import java.io.*; 
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

 
@WebServlet(
    name = "Lab33Servlet", 
    urlPatterns = { "/Lab33Servlet", "/Lab33" } 
)
	
/**
* The First112Servlet class is described above and is a descendant of HttpServlet
*/
public class Lab33Servlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  //there is also a doPost() method you can use, we'll learn that later
            throws ServletException, IOException {
       
        Map map = new HashMap();
        
        map.put("number", 1);
        map.put("text", "This is some sample text.");
        map.put("html", "<h2>This an h2</h2>");
        map.put("aDate", new Date());
        
        request.setAttribute("map", map);
        
        String url = "/lab33.jsp";
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        
        dispatcher.forward(request, response);
        
    }

}
