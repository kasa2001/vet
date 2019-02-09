package model.view.home;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Registry {

    @NotNull
    @Length(min = 2, max = 255)
    private String name;

    @NotNull
    @Length(min = 2, max = 255)
    private String password;

    @NotNull
    @Length(min = 2, max = 255)
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
