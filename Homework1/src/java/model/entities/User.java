package model.entities;

import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
//import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@XmlRootElement
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "User_Gen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Gen")
    private int id;
    @Column(unique=true)
    private String email;
    private String name;
    private String password;
    private String phone;
    @ManyToMany(mappedBy = "users")
    final private Collection<Coin> coins;
    @OneToMany(mappedBy = "user")
    final private Collection<Purchase> purchases;
    
    public User() {
        this.purchases = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public User(String name, String mail, String password, String phone) {
        this.name = name;
        this.email = mail;
        this.password = password;
        this.phone = phone;
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

    public Collection<Coin> getCoins() {
        return coins;
    }

    public Collection<Purchase> getPurchases() {
        return purchases;
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

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
    }

    public void addCoin(Coin coin) {
        this.coins.add(coin);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", phone=" + phone + ", coins=" + coins + ", purchases=" + purchases + '}';
    }
    
}