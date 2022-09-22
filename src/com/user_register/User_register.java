package com.user_register;

import javax.swing.JPasswordField;

public class User_register {

    private String user;
    private String password;
    private String name;
    private String last_name;
    private char sex;
    private String email;
    private String birthday;
    private String registerdate;


    public User_register() {
    }

    public User_register(String user, String name, String last_name, char sex, String email, String birthday,String registerdate, String password) {
        this.user = user;
        this.name = name;
        this.last_name = last_name;
        this.sex = sex;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
        this.registerdate = registerdate;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getUser() {
        return user;
    }
    
    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerDate) {
        this.registerdate = registerDate;
    }


    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}
