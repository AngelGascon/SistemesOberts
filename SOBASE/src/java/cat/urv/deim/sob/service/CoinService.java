package cat.urv.deim.sob.service;

import cat.urv.deim.sob.model.Coin;
import cat.urv.deim.sob.model.Purchase;
import cat.urv.deim.sob.model.User;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import java.util.List;
        
public class CoinService {
    private WebTarget webTarget;
    private jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/sob_grup_12/rest/api/v1/";
    private final String credentials = "c29iOnNvYgo=";
    
    public CoinService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }
    
    public List<Coin> findAll(String order){
       WebTarget resource = webTarget.path("coin").queryParam("order", order);
       Response response = resource.request(MediaType.APPLICATION_JSON).get();
        
       return (response.getStatus() == 200) ? response.readEntity(new GenericType<List<Coin>>() {}) : null;
    }
    
    public Coin getCoin(String id){
        WebTarget resource = webTarget.path("coin").path(id);
        Response response = resource.request(MediaType.APPLICATION_JSON).get();
        return (response.getStatus() == 200) ? response.readEntity(Coin.class) : null;
    }
    
    public Purchase getPurchase(String id){
        WebTarget resource = webTarget.path("coin").path(id).path("purchase");
        Response response = resource.request(MediaType.APPLICATION_JSON).get();
        return (response.getStatus() == 200) ? response.readEntity(Purchase.class) : null;
    }
	
    public boolean addUser(User user) {
       Response response = webTarget.request(MediaType.APPLICATION_JSON)
               .post(Entity.entity(user, MediaType.APPLICATION_JSON), 
                    Response.class);
     return response.getStatus() == 201;
    }

}
