package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Coin;
import cat.urv.deim.sob.service.CoinService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class listCoinsCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession(true);
        String goBack = request.getRequestURL().toString();
        sesion.setAttribute("goBack", goBack);
        
        String order = request.getParameter("order");
        if (order == null) 
            order = "desc";

        CoinService cs = new CoinService();
        List <Coin> list = cs.findAll(order);
        request.setAttribute("coinList", list);
        
        String view = "views/listCoinsView.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
