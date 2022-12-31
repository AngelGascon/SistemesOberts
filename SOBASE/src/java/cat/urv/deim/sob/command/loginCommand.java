package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Coin;
import cat.urv.deim.sob.model.User;
import cat.urv.deim.sob.service.CoinService;
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
        String email = request.getParameter("user.email");
        String password = request.getParameter("user.password");
        //String cryptoId = request.getParameter("id");
        /*
        user.setPassword(password);
        user.setUsername(username);
        user.setEmail(email);*/
     
        String view = "views/loginView.jsp";
        if (username != null) {
            request.setAttribute("message", "tot ok");
        }else{
            request.setAttribute("message", "Some fields are missing.");
        }
        
    //}
        //request.setAttribute("cryptoId", Integer.valueOf(cryptoId));
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}