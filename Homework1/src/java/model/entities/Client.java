package model.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NamedQuery(
            name="getClientFromCredentials",
            query="SELECT c FROM Client c WHERE c.email LIKE :mail AND c.password LIKE :pass"
    )
@NamedQuery(
            name="findUser", 
            query="SELECT c FROM Client c WHERE c.email = :email"
    )
@XmlRootElement
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="Client_Gen", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Client_Gen")
    private Integer id;
    private String email;
    private String name;
    private String password;
    private String phone;
    
    @ManyToMany(mappedBy = "clients")
    final private Collection<Coin> coins;
    @OneToMany(mappedBy = "client")
    final private Collection<Purchase> purchases;
    
    public Client(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.purchases = new ArrayList<>();
        this.coins = new ArrayList<>();
    }
    
    public Client() {
        this.purchases = new ArrayList<>();
        this.coins = new ArrayList<>();
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

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}