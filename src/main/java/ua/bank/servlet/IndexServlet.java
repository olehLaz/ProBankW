package ua.bank.servlet;

import ua.bank.process.EMFProvider;
import ua.bank.dao.AccountDao;
import ua.bank.dao.UserDao;
import ua.bank.daoimpl.AccountDaoImpl;
import ua.bank.daoimpl.UserDaoImpl;
import ua.bank.entity.Account;
import ua.bank.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "IndexServlet", urlPatterns = "/reg")
public class IndexServlet extends HttpServlet {
    private EMFProvider emfProvider = EMFProvider.getInstance();
    private UserDao userDao = UserDaoImpl.getInstance();
    private AccountDao accountDao = AccountDaoImpl.getInstance();
  //  private FinanceOperations fo = FinanceOperations.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        request.setAttribute("users", userDao.getUser());
        if (request.getParameter("userid") != null && !request.getParameter("userid").equals("")) {
            Integer id = Integer.valueOf(request.getParameter("userid"));
            User user = userDao.getUser(id);
            request.setAttribute("accounts", user.getAccounts());
           // request.setAttribute("balance", fo.overallBalance(id));
        }
        if (request.getParameter("account") != null && !request.getParameter("account").equals("")) {
            Integer id = Integer.valueOf(request.getParameter("account"));
            Account account = accountDao.getAccount(id);
            request.setAttribute("transactions", account.getTransactions());
        }
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
    @Override
    public void destroy() {
        emfProvider.close();
    }
}
