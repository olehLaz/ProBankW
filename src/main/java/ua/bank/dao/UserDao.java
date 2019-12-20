package ua.bank.dao;

import ua.bank.entity.Account;
import ua.bank.entity.User;

import java.util.List;

public abstract interface UserDao {
    //выбрать всех
    List<User> getUser();
    //выбрать по id
    User getUser(Integer id);

    //выбрать по login
    User getThisUser(String login);

    //добавить
    void addUser(User user);
    //изменить
    void  updateUser(User user, Account account);
    //удалить

}
