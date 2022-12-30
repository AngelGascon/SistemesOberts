package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Coin;
import cat.urv.deim.sob.service.CoinService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import java.util.List;

public class coinInfoCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String cryptoId = request.getParameter("id");
        String userAuth = request.getParameter("userAuth");
        
        String view = "views/detailedCoin.jsp";
        
        CoinService cs = new CoinService();
 
        //Order order = cs.getOrder(cryptoId); 
        
        //if (order == null) {
            Coin coin = cs.getCoin(cryptoId);
            request.setAttribute("coin", coin);
        //} else {
            //request.setAttribute("order", order);
        //}
        
        request.setAttribute("cryptoId", cryptoId);
        request.setAttribute("userAuth", userAuth);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
        
        
    }
}
