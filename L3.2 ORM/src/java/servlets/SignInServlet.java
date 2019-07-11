package servlets;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SignInServlet extends HttpServlet {

    private final DBService dbService;

    public SignInServlet(DBService dbService) {
        this.dbService = dbService;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            UsersDataSet user = dbService.getUser(login);

            if(login != null /*&& password != null*/) {
                if (user == null || !user.getLogin().equals(login) /*|| !user.getPass().equals(password)*/) {
                    response.getWriter().println("Unauthorized");
                } else {
                    response.getWriter().println("Authorized: " + login);
                    response.setStatus(HttpServletResponse.SC_OK);
                }
            } else {
                response.getWriter().println("Unauthorized - null");
            }
        } catch (DBException e) {
            e.printStackTrace();
        }
    }


}
