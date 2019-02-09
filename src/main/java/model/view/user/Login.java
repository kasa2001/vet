package model.view.user;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Login {

    @NotNull
    @Length(min = 2, max = 255)
    private String name;

    @NotNull
    @Length(min = 2, max = 255)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
