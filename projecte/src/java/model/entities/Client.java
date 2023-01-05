package model.entities;

import authn.Credentials;
import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NamedQuery(
            name="findClient", 
            query="SELECT c FROM Client c WHERE c.email = :email"
    )
@XmlRootElement
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="Client_Gen", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Client_Gen")
    private Integer id;
    
    @Column(unique=true)
    @NotNull(message="Email has to be set.")
    private String email;
    
    //Names can be repeated
    private String name;
    
    @OneToOne(mappedBy="client")
    private Credentials password;
    
    @Column(unique=true)
    @NotNull(message="Phone has to be set.")
    private String phone;
    
    @OneToMany(mappedBy = "client")
    final private Collection<Purchase> purchases;
    
    public Client() {
        this.purchases = new ArrayList<>();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}