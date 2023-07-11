package e2e;

import api.contact.Contact;
import e2e.pages.ContactPage;
import e2e.pages.LoginPage;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class CreatContactViaApiEditContactViaUiTest extends TestBase {

    Contact contact;
    LoginPage loginPage;
    ContactPage contactPage;

    @Test
    public void creatContactViaApiEditContactViaUiTest() {
        contact = new Contact();
        JsonPath createdContact = contact.createContact(201).jsonPath();
        int id = createdContact.getInt("id");
        logger.info(String.valueOf(id));
//        logger.info(String.valueOf(visibleStatus));  еще один после boolean когда допишу код

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login();
        loginPage.confirmSuccessfulLogin();

        contactPage = new ContactPage(app.driver);
        contactPage.waitForLoading();
        contactPage.openContactById(String.valueOf(id));
    }
}
