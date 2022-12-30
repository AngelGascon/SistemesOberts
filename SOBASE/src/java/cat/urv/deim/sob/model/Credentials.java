/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.urv.deim.sob.model;

/**
 *
 * @author angel
 */
public class Credentials {
    
    private Long id;
    private Client client;
    private String password;

    public Credentials() {
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
