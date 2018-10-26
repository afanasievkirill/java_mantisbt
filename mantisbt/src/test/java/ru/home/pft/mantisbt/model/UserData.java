package ru.home.pft.mantisbt.model;

public class UserData {

  private int id;
  private String username;
  private String email;
  private String password;

  public int getId() {
    return id;
  }

  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public UserData withUsername(String username) {
    this.username = username;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserData withEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword(){
    return password;
  }

  public UserData withPassword(String password){
    this.password = password;
    return this;
  }
}
