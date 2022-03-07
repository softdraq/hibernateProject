package persistence;

import com.mysql.cj.Session;
import model.UserData;
import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import util.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static util.DBUtil.getEntityManager;

public class RepositoryUserData {

    private EntityManager em;

    public RepositoryUserData() {

        this.em = DBUtil.getEntityManager();

    }

    public void createNewAccount(UserData userData) {

        this.em.getTransaction().begin();
        this.em.persist(userData);
        this.em.getTransaction().commit();

    }

    public List<UserData> getAllAccounts() {

        this.em = getEntityManager();
        String sqlQuery = "select * from onlinestore.userdata";
        Query q = this.em.createNativeQuery(sqlQuery, UserData.class);
        List<UserData> result = q.getResultList();
        return result;

    }

    public int getCountOfAccount() {

        List<UserData> users = this.getAllAccounts();
        int count = users.size();
        return count;

    }

    public int getNumberOfUsers() {

        String sqlQuery = "select userDataId from userdata";
        Query q = this.em.createNativeQuery(sqlQuery, UserData.class);
        List<UserData> userData = q.getResultList();
        return userData.size();

    }

    public boolean login(UserData user) {

        boolean returnValue = false;
        List<UserData> userData = em.createQuery("SELECT user from User user where user.userName = ?1")
                .setParameter(1, user.getUsername())
                .getResultList();



        return returnValue;
    }

}