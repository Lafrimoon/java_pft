package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModificationFromTable() {
        app.getNavigationHelper().goToPageHome();
        if (! app.getContactHelper().isThereAContact())
        {
            app.getNavigationHelper().goToPageNewContact();
            app.getContactHelper().createContact(new ContactData("testname", "testmiddle", "testlastname", "testaddress", "111-11-11", "test1"), true);
            app.getNavigationHelper().goToPageHome();
        }
        app.getContactHelper().goToEditContactFromMainTable();
        app.getContactHelper().fillFormContact(new ContactData("TESTNAME", "TESTMIDDLE", "TESTLASTNAME", "TESTADDRESS", "222-22-22", null), false);
        app.getContactHelper().initUpdateContact();
        app.getNavigationHelper().goToPageHome();

    }

    @Test
    public void testContactModificationFromContactPage() {
        app.getNavigationHelper().goToPageHome();
        if (! app.getContactHelper().isThereAContact())
        {
            app.getNavigationHelper().goToPageNewContact();
            app.getContactHelper().createContact(new ContactData("testname", "testmiddle", "testlastname", "testaddress", "111-11-11", "test1"), true);
            app.getNavigationHelper().goToPageHome();
        }
        app.getContactHelper().goToViewContact();
        app.getContactHelper().goToEditContactFromContactPage();
        app.getContactHelper().fillFormContact(new ContactData("TestName", "TestMiddle", "TestLastname", "TestAddress", "333-33-33", null), false);
        app.getContactHelper().initUpdateContact();
        app.getNavigationHelper().goToPageHome();

    }
}
