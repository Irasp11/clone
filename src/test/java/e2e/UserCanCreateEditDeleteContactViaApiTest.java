package e2e;

import api.contact.Contact;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserCanCreateEditDeleteContactViaApiTest {
    Contact contact;
    @Test
    public void userCanCreateEditDeleteContactViaApiTest(){
        contact = new Contact();
        // create new contact TODO: POST
        JsonPath createdContact = contact.createContact(201).jsonPath();
        int id = createdContact.getInt("id");
        // get data for created contact TODO: GET
        JsonPath expectedCreatedContact = contact.getContact(200, id).jsonPath();
        // check
        List<String> listPaths = new ArrayList<>();
        listPaths.add("firstName");
        listPaths.add("lastName");
        listPaths.add("description");

        for (String path: listPaths) {
            String actual = createdContact.getString(path);
            String expected = expectedCreatedContact.getString(path);
            Assert.assertEquals(actual ,expected, "Actual parameter is not equal expected");
        }

        // edit created contact TODO: PUT
        contact.editContact(200,id);
        // get data for edited contact TODO: GET
        JsonPath editedContact = contact.getContact(200, id).jsonPath();
        LinkedHashMap<String, String> objectEditedData = new LinkedHashMap<>();
        // "String (key) String (value) key = actual result, getter = value
        objectEditedData.put(editedContact.getString("firstName"), contact.dataForEditContact(id).getFirstName());
        objectEditedData.put("lastName", contact.dataForEditContact(id).getLastName());
        objectEditedData.put("description", contact.dataForEditContact(id).getDescription());
        // Upstairs row is like {"firstName: Irasp"} usw

        for (Map.Entry<String, String>object:
             objectEditedData.entrySet()) {
            String actualResult = object.getKey();
            String expectedResult = object.getValue();
            Assert.assertEquals(actualResult, expectedResult, actualResult + "not equal" + expectedResult);
        }

//        JsonPath actualEditedContact = contact.getContact(200, id).jsonPath();
//        Assert.assertEquals(actualEditedContact.getString("firstName"),contact.dataForEditContact(id).getFirstName());
//        Assert.assertEquals(actualEditedContact.getString("lastName"),contact.dataForEditContact(id).getLastName());
//        Assert.assertEquals(actualEditedContact.getString("description"),contact.dataForEditContact(id).getDescription());


        // delete edited contact TODO: DELETE
        contact.deleteContact(200,id);
        // get error message (not existing in DB) TODO: GET
        JsonPath actualDeletedContact = contact.getContact(500, id).jsonPath();
        Assert.assertEquals(actualDeletedContact.getString("message"),"Error! This contact doesn't exist in our DB");


    }
}
