/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.urv.deim.sob.service;
/**
 *
 * @author angel
 */
import cat.urv.deim.sob.model.Purchase;
import jakarta.json.Json;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class PurchaseService {
    private WebTarget webTarget;
    private jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/sob_grup_12/rest/api/v1/";
    
    public PurchaseService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("purchase");
    }
    
    public Purchase createOrder(String coinId, String amount, String credentials) {
        WebTarget resource = webTarget.queryParam("coin", coinId);
        String purchase = Json.createObjectBuilder()
                .add("amount", amount)
                .build()
                .toString();
        
        Response response = resource.request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Basic " + credentials)
                .post(Entity.entity(purchase, MediaType.APPLICATION_JSON), Response.class);
        return (response.getStatus() == 200) ? response.readEntity(Purchase.class) : null;
    }
    
    public Purchase findPurchase(String id, String credentials) {
        WebTarget resource = webTarget.path(id);
        Response response = resource.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, "Basic " + credentials).get();
        return (response.getStatus() == 200) ? response.readEntity(Purchase.class) : null;
    }
}
