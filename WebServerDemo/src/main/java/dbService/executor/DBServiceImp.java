package dbService.executor;

import dbService.DBService;
import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Configuration;
import java.sql.SQLException;



public class DBServiceImp implements DBService {

    private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "update";

    private final SessionFactory sessionFactory;

    public DBServiceImp() {
        Configuration configuration = getMySqlConfiguration();
        sessionFactory = createSessionFactory(configuration);
    }

    private Configuration getMySqlConfiguration() {
        Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(UsersDataSet.class);

        configuration.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/db_example");
        configuration.setProperty("hibernate.connection.username","root");
        configuration.setProperty("hibernate.connection.password","root");
        configuration.setProperty("hibernate.show_sql",hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto",hibernate_hbm2ddl_auto);

        return configuration;
    }

    public void addUser(String login, String password) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            UsersDAO usersDAO = new UsersDAO(session);
            usersDAO.insertUser(login,password);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public UsersDataSet getUser(String login) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            UsersDAO usersDAO = new UsersDAO(session);
            UsersDataSet user= usersDAO.getUserOnLogin(login);
            transaction.commit();
            session.close();
            return user;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

}
