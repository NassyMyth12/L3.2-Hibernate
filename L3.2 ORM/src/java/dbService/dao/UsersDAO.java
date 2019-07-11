package dbService.dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet getUser(String login) throws HibernateException {
        Query query = session.createQuery("from UsersDataSet where login = :paramLogin");
        query.setParameter("paramLogin", login);
        return (UsersDataSet) query.uniqueResult();

        //return (UsersDataSet) session.get(UsersDataSet.class, login);
    }

    public String insertUser(String login, String password) throws HibernateException {

        /*Query query = session.createQuery ("insert into UsersDataSet (login, password) " +
               "select 'User1' from UsersDataSet");
        query.executeUpdate();
        return login;*/
        UsersDataSet user = new UsersDataSet(login, password);
        Long id = (Long) session.save(user);
        return id.toString();

        //return (String) session.save(new UsersDataSet(login, password));
    }


}
