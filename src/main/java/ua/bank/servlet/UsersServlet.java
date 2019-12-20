package ua.bank.servlet;

import ua.bank.dao.UserDao;
import ua.bank.daoimpl.UserDaoImpl;
import ua.bank.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "UsersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    private UserDao dao = UserDaoImpl.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");

        dao.addUser(new User(login, password, firstName, lastName, phone));
        response.sendRedirect("/login");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        request.setAttribute("users", dao.getUser());
        System.out.println("-----------1--------------");
        for(User s : dao.getUser())
            System.out.println(s.toString());
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}
