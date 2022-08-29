package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.validation.UniqueUserEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserLoginDto {

    private String email;
    private String password;

    public UserLoginDto() {
    }

    @NotEmpty(message = "User email should be provided.")
    @Email(message = "User email should be valid.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    @NotEmpty
    @Size(min = 5)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginDto{" +
                "email='" + email + '\'' +
                ", password='" + (password != null ? "[PROVIDED]" : null) + '\'' +
                '}';
    }
}
