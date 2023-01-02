/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.urv.deim.sob.model;

/**
 *
 * @author angel
 */
public class Client {
    private String name;
    private Credentials password;
    private boolean auth;
    private String phone;
    private String email;

    public Client() {
    }

    public String getName() {
        return name;
    }

    public Credentials getPassword() {
        return password;
    }

    public boolean isAuth() {
        return auth;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(Credentials password) {
        this.password = password;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
