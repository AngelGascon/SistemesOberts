package service;

import authn.Credentials;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import authn.Secured;
import jakarta.ws.rs.core.Response;
import model.entities.Client;

@Stateless
@Path("credentials")
public class CredentialsFacadeREST extends AbstractFacade<Credentials> {

    @PersistenceContext(unitName = "sob_grup_12PU")
    private EntityManager em;

    public CredentialsFacadeREST() {
        super(Credentials.class);
    }
    
    @GET
    @Path("{username}/{password}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response checkAuthentication(@PathParam("username") String username,
            @PathParam("password") String password) {
        
        //Decode Base64 TODO
        
        Credentials credentials = (Credentials) em.createNamedQuery("Credentials.findByCustomer")
                .setParameter("username", username).setParameter("password", password)
                .getSingleResult();
        return Response.ok().entity(credentials).build();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}