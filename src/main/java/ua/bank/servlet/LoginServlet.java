package ua.bank.servlet;

import ua.bank.entity.Login;

import ua.bank.dao.UserDao;
import ua.bank.daoimpl.UserDaoImpl;
import ua.bank.entity.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/login")

public class LoginServlet extends HttpServlet {
    private Login loginCheck = new Login();
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        //Проверяем совпадает логин и пароль с данными с бд, результать вносим в пересенную
        boolean checkActivity = loginCheck.checkActivity(login, password);

        if (checkActivity){
            //добавляем пользователя который сейчас находится в программе
            userDao.getThisUser(login);
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", login);

            request.setAttribute("login", login);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/main.jsp");
            dispatcher.forward(request, response);
        }

        if (!checkActivity) {
            request.setAttribute("check", checkActivity);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String logOut = request.getParameter("log");
        HttpSession session = request.getSession(false);

        if ("exit".equals(logOut) && (session != null))
            session.removeAttribute("user_login");

        response.sendRedirect("index.html");
    }

}
