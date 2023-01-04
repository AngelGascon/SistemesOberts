package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Client;
import cat.urv.deim.sob.model.Coin;
import cat.urv.deim.sob.model.Purchase;
import cat.urv.deim.sob.service.CoinService;
import cat.urv.deim.sob.service.PurchaseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.util.Base64;

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
        
        String coinId = request.getParameter("id");
        String amount = request.getParameter("amount");
        
        CoinService cs = new CoinService();
        Coin coin = cs.getCoin(coinId);
        request.setAttribute("coin", coin);
        
        HttpSession sesion = request.getSession(true);
        Client client = (Client) sesion.getAttribute("client");

        String view = "views/buyCoinView.jsp";
        //Checks null
        if(amount != null){
            //Checks empty string
            if(!amount.isEmpty()){
                //Send auth
                String credentials = client.getEmail() + ":" + client.getPassword().getPassword();
                credentials = Base64.getEncoder().encodeToString(credentials.getBytes());
                
                PurchaseService ps = new PurchaseService();
                Purchase purchase = ps.createOrder(coinId, amount, credentials);
                request.setAttribute("purchase", purchase);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}