package model.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@NamedQuery(
            name="getPurchaseFromCoinId",
            query="SELECT p FROM Purchase p WHERE p.coin.id = :coin_id ORDER BY p.id DESC"
    )
@XmlRootElement
public class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "Purchase_Gen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Purchase_Gen")
    private int id;
    private float amount;
    private Date date;
    @ManyToOne
    private Coin coin;
    @ManyToOne
    private Client client;
    
    public Purchase() { }
    public Purchase(int id, Date date, float amount, Client clientWithoutPasswd, Coin coin) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.client = clientWithoutPasswd;
        this.coin = coin;
    }
    
    public Purchase(int id, float tradeAmount, Date currentDate) {
        this.id = id;
        this.date = currentDate;
        this.amount = tradeAmount;
    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public Coin getCoin() {
        return coin;
    }

    public Client getClient() {
        return client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Purchase{" + "id=" + id + ", amount=" + amount + ", date=" + date + ", coin=" + coin + ", client=" + client + '}';
    }
    
}