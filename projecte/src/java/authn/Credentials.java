package authn;
import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import model.entities.Client;

@Entity
@NamedQuery(name="Credentials.findByClient", 
            query="SELECT c FROM Credentials c WHERE c.client.id = :cid")
@XmlRootElement
public class Credentials implements Serializable { 
    @Id
    @SequenceGenerator(name="Credentials_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Credentials_Gen") 
    private Long id;

    @OneToOne
    private Client client;
    @NotNull(message="Password can't be null")
    private String password;
    
    public Credentials(){
        
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
