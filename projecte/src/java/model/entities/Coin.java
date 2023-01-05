package model.entities;

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
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.Date;

@Entity
@NamedQuery(
            name="getCoinFromId",
            query="SELECT c FROM Coin c WHERE c.id = :idSent"
    )
@XmlRootElement
public class Coin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="Coin_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Coin_Gen") 
    private Integer id;
    private String name;
    private String description;
    private Float lastQuotation;
    private Date currentDate;
   
    @OneToMany(mappedBy = "coin")
    private Collection<Purchase> purchases;

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

    @Override
    public String toString() {
        return "Coin{" + "name=" + name + ", description=" + description + ", lastQuotation=" + lastQuotation + ", currentDate=" + currentDate + '}';
    }
    
}