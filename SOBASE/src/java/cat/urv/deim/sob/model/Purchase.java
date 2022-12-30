/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.urv.deim.sob.model;

import java.util.Date;

/**
 *
 * @author angel
 */
public class Purchase {
    private int id;
    private float amount;
    private Date date;
    private Coin coin;
    private Client client;

    public Purchase() {
    }

    public Purchase(int id, float amount, Date date, Coin coin, Client client) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.coin = coin;
        this.client = client;
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
    
}
