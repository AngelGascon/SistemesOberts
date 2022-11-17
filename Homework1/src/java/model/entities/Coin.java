package model.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
//import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@XmlRootElement
public class Coin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="Coin_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Coin_Gen") 
    private int id;
    private String name;
    private String description;
    private Float lastQuotation;
    private Date currentDate;
    
    @ManyToMany
    private Collection<User> users;
    @OneToOne(mappedBy = "coin")
    private Purchase purchase;

    public Coin() {
        
    }

    public Coin(String name, String description, float lastQuotation, Date currentDate) {
        this.name = name;
        this.description = description;
        this.lastQuotation = lastQuotation;
        this.currentDate = currentDate;
        this.users = new ArrayList<>();
    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getLastQuotation() {
        return lastQuotation;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLastQuotation(Float lastQuotation) {
        this.lastQuotation = lastQuotation;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "Coin{" + "id=" + id + ", name=" + name + ", description=" + description + ", lastQuotation=" + lastQuotation + ", currentDate=" + currentDate + ", users=" + users + ", purchase=" + purchase + '}';
    }
    
}