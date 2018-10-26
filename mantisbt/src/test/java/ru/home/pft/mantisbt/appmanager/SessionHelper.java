package ru.home.pft.mantisbt.appmanager;

import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {

  public SessionHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl"));
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.xpath("//input[@value='Login']"));
  }
}
