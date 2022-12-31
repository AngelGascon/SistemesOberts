package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.User;
import cat.urv.deim.sob.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;

public class loginCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = new User();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
     
        String view = "views/loginView.jsp";
        //Checks nulls
        if (username != null && password != null && email != null) {
            //Checks empty strings
            if(username.isEmpty() || password.isEmpty() || email.isEmpty()){
                request.setAttribute("message", "Some fields are missing is empty.");
            }else{
                //
                UserService us = new UserService();
                boolean authRes = us.loginUser(username, password);
                if (authRes) {
                    view = "views/loginSuccessView.jsp";
                    user.setAuth(true);
                    request.setAttribute("currentUser", user);
                    request.setAttribute("message", "tot ok");
                }else{
                    request.setAttribute("message", "user or password incorrect.");
                }
                //
            }
        }
        //request.setAttribute("cryptoId", Integer.valueOf(cryptoId));
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}