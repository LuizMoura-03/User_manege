package br.com.zup.user_manager.user_manager.mpdels;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @UuidGenerator
    private String uuid;
    private String userName;
    private String password;

   public UserModel() {}

    public UserModel(String uuid, String userName, String password) {
        this.uuid = uuid;
        this.userName = userName;
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
