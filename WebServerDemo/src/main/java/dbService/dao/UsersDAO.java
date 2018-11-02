package dbService.dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session=session;
    }

    public UsersDataSet getOnId(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class,id);
    }

    public UsersDataSet getUserOnLogin(String login) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return (UsersDataSet) criteria.add(Restrictions.eq("login",login)).uniqueResult();
    }

    public UsersDataSet getUserOnPass(String password) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return (UsersDataSet) criteria.add(Restrictions.eq("password",password)).uniqueResult();
    }

    public long insertUser(String login,String password) throws HibernateException {
        return (long) session.save(new UsersDataSet(login,password));
    }
}
