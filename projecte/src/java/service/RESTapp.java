package service;

import authn.RESTRequestFilter;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@jakarta.ws.rs.ApplicationPath("/rest/api/v1/")
public class RESTapp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(AbstractFacade.class);
        classes.add(CoinFacadeREST.class);
        classes.add(ClientFacadeREST.class);
        classes.add(PurchaseFacadeREST.class);
        classes.add(CredentialsFacadeREST.class);
        classes.add(RESTRequestFilter.class);
        return classes;
    }
}
