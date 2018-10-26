package ru.home.pft.mantisbt.appmanager;

import org.openqa.selenium.By;

public class UserManagmentHelper extends HelperBase {
  public UserManagmentHelper(ApplicationManager app) {
    super(app);
  }

  public void reset(String username) {
    click(By.linkText(username));
    click(By.xpath("//input[3]"));
  }

  public void confirmade(String conformationLink, String password) {
    wd.get(conformationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='Update User']"));
  }
}
