package rd.tutorial.ph.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Raslan Rauff
 */
public class UserAuth implements Serializable{
    private String username;
    private String passwordHash;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserAuth other = (UserAuth) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.passwordHash, other.passwordHash)) {
            return false;
        }
        return true;
    }

    public UserAuth(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }
    
    public UserAuth(){
        this.username = "";
        this.passwordHash = "";
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
