package main;

import accounts.*;
import dbService.executor.DBService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;
import servlets.SignInServlet;
import servlets.SignUpServlet;

public class Main {

    public static void main(String[] args) throws Exception {

        DBService dbService = new DBService();

        AccountService accountService = new AccountService(dbService);

        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();
        SignUpServlet signUpServlet = new SignUpServlet(accountService);
        SignInServlet signInServlet = new SignInServlet(accountService);


        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(allRequestsServlet), "/mirror");
        contextHandler.addServlet(new ServletHolder(signUpServlet),"/signup");
        contextHandler.addServlet(new ServletHolder(signInServlet),"/signin");

        Server server = new Server(8080);
        server.setHandler(contextHandler);
        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
