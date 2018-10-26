package ru.home.pft.mantisbt.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {
  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void manageUser(){
    click(By.linkText("Manage Users"));
  }
}
