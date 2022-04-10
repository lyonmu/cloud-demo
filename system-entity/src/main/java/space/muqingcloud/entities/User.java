package space.muqingcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private String email;
    private Date update_date;
    private Date create_date;

    public User(String name, String password, String email, Date update_date, Date create_date) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.update_date = update_date;
        this.create_date = create_date;
    }

    public User(Long id, String name, String password, String email, Date update_date, Date create_date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.update_date = update_date;
        this.create_date = create_date;
    }

    public User() {
    }
}
