package e2e;

import api.contact.Contact;
import api.email.Email;
import io.restassured.path.json.JsonPath;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserCanWorkWithEmailInNewContact {
    Contact contact;
    Email email;

    @Test
    public void userCanWorkWithEmailInNewContact() throws JSONException {
        contact = new Contact();
        JsonPath createdContact = contact.createContact(201).jsonPath();
        int contactId = createdContact.getInt("id");

//        email = new Email();
//        email.createEmail(201, contactId);
//        JsonPath createdEmail = email.getEmail(200, contactId).jsonPath();
//        int emailId = createdEmail.getInt("[0].id");
//        String email = createdEmail.getString("[0].email");
//
//        JSONObject actualEmailJson = new JSONObject();
//        actualEmailJson.put("id", emailId);
//        actualEmailJson.put("email", createdEmailString);
//        actualEmailJson.put("contactId", contactId);
//
//        String actualJson = actualEmailJson.toString();
//        String expectedJson = "{\n" +
//                "        \"id\": " + emailId + ",\n" +
//                "        \"email\": "+dataForCreatedEmail(contactId).getEmail() + ",\n" +
//                "        \"contactId\": " + contactId + "\n" +
//                "    }";
//        JSONAssert.assertEquals(actualJson, expectedJson, JSONCompareMode.STRICT);
//
//        int id = emailId;
//
//        email.editEmail(200, id, contactId);
//        JsonPath editedEmail = email.getEmail(200, id).jsonPath();
//        LinkedHashMap<String, String> objectEditedEmail = new LinkedHashMap<>();
//        objectEditedEmail.put(editedEmail.getString("email"), email.dataForEditEmail(id, contactId).getEmail());
//
//
//        for (Map.Entry<String, String> object : objectEditedEmail.entrySet()) {
//            String actualResult = object.getKey();
//            String expectedResult = object.getValue();
//            Assert.assertEquals(actualResult, expectedResult, actualResult + "not equal" + expectedResult);
//        }
//
//
//        email.deleteEmail(200, id);
//        JsonPath actualDeleteEmail = email.getEmail(500, id).jsonPath();
//        Assert.assertEquals(actualDeleteEmail.getString("message"), "Error! This email doesn't exist in our DB");

    }
}