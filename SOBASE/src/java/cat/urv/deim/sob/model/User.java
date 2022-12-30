package cat.urv.deim.sob.model;

public class User {
    private String username;
    private String password;
    private String email;
    private boolean auth;

    public User() {}
   
    public String getUsername() {
        return username;
    }
    public String getPassword() {
            return password;
    }
    public String getEmail() {
        return email;
    }
    public boolean isAuth() {
        return auth;
    } 
    public void setUsername(String username) {
            this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }    
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAuth(boolean auth) {
        this.auth = auth;
    }
}
