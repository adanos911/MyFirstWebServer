package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class AllRequestsServlet extends HttpServlet{

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

        PrintWriter pw = response.getWriter();
        pw.println(request.getParameter("key"));
    }

}
