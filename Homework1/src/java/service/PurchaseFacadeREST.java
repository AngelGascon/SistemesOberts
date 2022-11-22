package service;

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
import com.sun.xml.messaging.saaj.util.Base64;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.util.Date;
import model.entities.Purchase;
import java.util.StringTokenizer;
import model.entities.Client;
import model.entities.Coin;

@Stateless
@Path("purchase")
public class PurchaseFacadeREST extends AbstractFacade<Purchase> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public PurchaseFacadeREST() {
        super(Purchase.class);
    }

    @POST
    @Secured
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response create(@HeaderParam("Authorization") String auth, @QueryParam("coin") Integer coinId, Purchase purchase) {
        //@QueryParam("coin") int coin, @QueryParam("amount") float amount, @HeaderParam("Authorization") String auth
        //password:angelgascmail@gmail.com == cGFzc3dvcmQ6YW5nZWxnYXNjbWFpbEBnbWFpbC5jb20=
        String decode = Base64.base64Decode(auth.replace("Basic ", ""));
        StringTokenizer tokenizer = new StringTokenizer(decode, ":");
        String password = tokenizer.nextToken();
        String mail = tokenizer.nextToken();
        //Build Purchase = Client(mail, pass) + amount + coin(id)
        //https://tomee.apache.org/jakartaee-10.0/javadoc/index.html?jakarta/persistence/NamedQuery.html
        Client client = (Client) em.createNamedQuery("getClientFromCredentials")
                .setParameter("mail", mail)
                .setParameter("pass", password)
                .getSingleResult();
        Coin coin = (Coin) em.createNamedQuery("getCoinFromId")
                .setParameter("idSent", coinId)
                .getSingleResult();
        
        Date currentDate = new Date();
        float tradeAmount = coin.getLastQuotation()*purchase.getAmount();
        
        purchase.setAmount(tradeAmount);
        purchase.setDate(currentDate);
        purchase.setClient(client);
        purchase.setCoin(coin);
        
        super.create(purchase);
        
        return Response.ok(new Purchase(purchase.getId(), tradeAmount, currentDate)).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") int id, Purchase entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        super.remove(super.find(id));
    }

    @GET
    @Secured
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") int id) {
        Purchase order = super.find(id);
        
        Client client = super.find(id).getClient();
        Client noPassword = new Client(client.getId(), client.getName(), client.getEmail(), client.getPhone());
        Purchase noPasswordPurchase = new Purchase(order.getId(), order.getDate(), order.getAmount(), noPassword, order.getCoin());
        
        return Response.ok(noPasswordPurchase).build();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Purchase> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Purchase> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}