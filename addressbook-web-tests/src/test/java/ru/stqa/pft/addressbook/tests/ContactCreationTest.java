package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToPageNewContact();
        app.getContactHelper().createContact(new ContactData("testname", "testmiddle", "testlastname", "testaddress", "111-11-11", "test1"), true);
        app.getNavigationHelper().goToPageHome();
    }


}
