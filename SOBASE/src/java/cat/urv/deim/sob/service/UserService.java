package cat.urv.deim.sob.service;

import cat.urv.deim.sob.model.Client;
import cat.urv.deim.sob.model.User;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.client.Entity;
        
public class UserService {
    private WebTarget webTarget;
    private jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/sob_grup_12/rest/api/v1/";
    
    public UserService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }
    
    public Client loginUser(String username, String password){
        
        //Codif BASE64 TODO
        
        Response response = webTarget.path("credentials").path(username).path(password)
                .request(MediaType.APPLICATION_JSON)
                .get();
        
        
        return (response.getStatus() == 200) ? response.readEntity(Client.class) : null;
    }
    
    public User findUserByEmail(User user){
        String email = user.getEmail();
        Response response = webTarget.path("user").path(email)
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (response.getStatus() == 200) {
            return response.readEntity(User.class);
        }
        return null;
    }
	
    public boolean addUser(User user) {
       Response response = webTarget.path("user").request(MediaType.APPLICATION_JSON)
               .post(Entity.entity(user, MediaType.APPLICATION_JSON), 
                    Response.class);
     return response.getStatus() == 201;
    }

}
