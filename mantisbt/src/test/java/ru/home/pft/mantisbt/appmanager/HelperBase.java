package ru.home.pft.mantisbt.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelperBase  {

  protected ApplicationManager app;
  protected WebDriver wd;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public HelperBase(ApplicationManager app) {
    this.app = app;
    wd = app.getDriver();
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if(text != null) {
      String existingText =  wd.findElement(locator).getAttribute("value");
      if(!text.equals(existingText)){
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  protected void attach(By locator, File file) {
    if (file != null) {
      wd.findElement(locator).sendKeys(file.getAbsolutePath()); //адрес приводится к абсолютному
    }
  }

  protected void select(By locator, String text) {
    wd.findElement(locator).click();
    new Select(wd.findElement(locator)).selectByVisibleText(text);
    wd.findElement(locator).click();
  }

  public String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public boolean isElementPresent(By locator) {
    try{
      wd.findElement(locator);
      return true;
    }catch (NoSuchElementException ex) {
      return false;
    }
  }

  public int getHour() {
    DateFormat dateFormat = new SimpleDateFormat("HH");
    Date date = new Date();
    return Integer.parseInt(dateFormat.format(date));
  }

  public int getDayOfWeek() {
    Calendar c = Calendar.getInstance();
    return c.get(Calendar.DAY_OF_WEEK);
  }

}
