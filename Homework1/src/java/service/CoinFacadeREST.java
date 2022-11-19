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
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.ArrayList;
import model.entities.Coin;

@Stateless
@Path("coin")
public class CoinFacadeREST extends AbstractFacade<Coin> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public CoinFacadeREST() {
        super(Coin.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Coin entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Coin entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Secured
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Long id) {
        return Response.ok().entity(super.find(id)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findAll(@QueryParam("order") String order) {
        // https://www.baeldung.com/hibernate-criteria-queries
        List<Coin> listResult = new ArrayList<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Coin> cq = cb.createQuery(Coin.class);
        Root<Coin> root = cq.from(Coin.class);
        
        if(order == null)
            order = "desc";
        
        if(order.equals("asc")){
            listResult = em.createQuery(cq.select(root).orderBy(cb.asc(root.get("lastQuotation")))).getResultList();
        }else if(order.equals("desc")){
            listResult = em.createQuery(cq.select(root).orderBy(cb.desc(root.get("lastQuotation")))).getResultList();
        }
        //tot ok
        if(listResult != null)
            return Response.ok(listResult).build();
        //error
        return Response.status(Status.BAD_REQUEST).entity("You should use asc or desc").build();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coin> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
