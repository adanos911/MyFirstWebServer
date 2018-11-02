package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import accounts.*;
import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSet;
import dbService.executor.DBException;

public class SignUpServlet extends HttpServlet{

    private AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService=accountService;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        //UserProfile userProfile = new UserProfile(login,password);

        accountService.addNewUser(login,password);

        //accountService.addNewUser(userProfile);

    }

}
