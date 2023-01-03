package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Coin;
import cat.urv.deim.sob.model.Purchase;
import cat.urv.deim.sob.service.CoinService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author angel
 */
public class coinBuyCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String view = "views/buyCoinView.jsp";
        /*
        String coinId = request.getParameter("id");
        
        HttpSession sesion = request.getSession(true);
        String goBack = request.getRequestURL().toString()+"?id="+coinId;
        sesion.setAttribute("goBack", goBack);
        
        CoinService cs = new CoinService();
        
        Coin coin = cs.getCoin(coinId);
        request.setAttribute("coin", coin);
        
        Purchase purchase = cs.getPurchase(coinId); 
        if (purchase != null)
            request.setAttribute("purchase", purchase);
        
        request.setAttribute("coinId", coinId);
        */
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}