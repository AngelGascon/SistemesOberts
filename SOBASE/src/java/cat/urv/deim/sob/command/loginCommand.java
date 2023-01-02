package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.User;
import cat.urv.deim.sob.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import cat.urv.deim.sob.model.Client;
import cat.urv.deim.sob.model.Credentials;

public class loginCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        HttpSession sesion = request.getSession(true);
        String view = "views/loginView.jsp";
        //Checks nulls
        if (username != null && password != null) {
            //Checks empty strings
            if(username.isEmpty() || password.isEmpty()){
                request.setAttribute("message", "Some fields are missing is empty.");
            }else{
                //
                UserService us = new UserService();
                Client client = us.loginUser(username, password);
                if (client != null) {
                    view = "views/loginSuccessView.jsp";
                    sesion.setAttribute("client", client);
                    client.setAuth(true);
                    
                    Credentials cred = new Credentials();
                    cred.setPassword(password);
                    
                    client.setPassword(cred);
                    request.setAttribute("message", "tot ok");
                }else{
                    request.setAttribute("message", "user or password incorrect.");
                }
                //
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}