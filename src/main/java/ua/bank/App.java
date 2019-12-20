package ua.bank;

import ua.bank.dao.UserDao;
import ua.bank.daoimpl.UserDaoImpl;
import ua.bank.entity.Account;
import ua.bank.entity.User;

import java.util.List;

public class App {

    private static UserDao userDao = UserDaoImpl.getInstance();
    public static void main(String[] args) {
        List<User> users = userDao.getUser();
        for (User s : users){
            System.out.println(s);
        }

    }
}
