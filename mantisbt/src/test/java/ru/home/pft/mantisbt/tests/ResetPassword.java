package ru.home.pft.mantisbt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.home.pft.mantisbt.model.MailMessage;
import ru.lanwen.verbalregex.VerbalExpression;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPassword extends TestBase {

  @BeforeMethod
  public void startMaiServer() {
    app.mail().start();
  }

    @Test
  public void testResetPassword() throws IOException {
    String username = "resetpassword";
    String email = "resetpassword@localhost.localdomain";
    String newPassword = "resetpassword";
    app.session().login("administrator","root");
    app.goTo().manageUser();
    app.user().reset(username);
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String conformationLink = findeConformationLink(mailMessages, email);
    app.user().confirmade(conformationLink, newPassword);
    assertTrue(app.newSession().login(username, newPassword));
  }

  private String findeConformationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findAny().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
