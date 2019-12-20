package ua.bank.daoimpl;

import ua.bank.process.EMFProvider;
import ua.bank.dao.UserDao;
import ua.bank.entity.Account;
import ua.bank.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final UserDao instance = new UserDaoImpl();
    private EntityManagerFactory emf = EMFProvider.getInstance().getEmf();

    private UserDaoImpl() {
    }

    public static UserDao getInstance() {
        return instance;
    }

    @Override
    public List<User> getUser() {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createQuery("FROM User", User.class).getResultList();
        em.close();
        return users;
    }

    @Override
    public User getUser(Integer id) {
        EntityManager em = emf.createEntityManager();
        User user = em.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.accounts WHERE u.id = " + id, User.class).getSingleResult();
        em.close();
        return user;
    }

    @Override
    public User getThisUser(String login) {
        EntityManager em = emf.createEntityManager();
        User user = em.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.accounts WHERE u.login = '"+login+"'", User.class).getSingleResult();
        em.close();
        return user;
    }

    @Override
    public synchronized void addUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            List<User> users = em.createQuery("FROM User u WHERE u.firstName = '"+user.getFirstName()+
              "'AND u.lastName = '" + user.getLastName() + "'", User.class).getResultList();
            if(users.size() == 0){
                em.persist(user);
            }
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    @Override
    public synchronized void updateUser(User user, Account account) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            user.addAccount(account);
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }
}

