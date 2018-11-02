package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import accounts.*;
import dbService.executor.DBException;

public class SignInServlet extends HttpServlet {

    private AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService=accountService;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        PrintWriter pw = response.getWriter();

        if (accountService.getUserByLogin(login).getPassword().equals(password)) {
            pw.println("Authorized: " + login);
        } else {
            pw.println("Unauthorized");
        }
        pw.close();
    }
}
