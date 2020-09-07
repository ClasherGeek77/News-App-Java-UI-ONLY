package model;

import lombok.Getter;

public class Login
{
    @Getter private String username;
    @Getter private String password;

    public Login()
    {
        username = null;
        password = null;
    }

    public Login(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
}
