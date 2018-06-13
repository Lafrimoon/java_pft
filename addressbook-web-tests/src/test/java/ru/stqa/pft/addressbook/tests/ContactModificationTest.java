package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModificationFromTable() {
        int index = 2;

        app.getNavigationHelper().goToPageHome();
        if (! app.getContactHelper().isThereAContact())
        {
            app.getNavigationHelper().goToPageNewContact();
            app.getContactHelper().createContact(new ContactData("testname", "testmiddle", "testlastname", "testaddress", "111-11-11", "test1"), true);
            app.getNavigationHelper().goToPageHome();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().goToEditContactFromMainTable(before.size() - index);
        ContactData contact = new ContactData(before.get(before.size() - index).getId(), "TESTNAME", "TESTMIDDLE", "TESTLASTNAME", "TESTADDRESS", "222-22-22", null);
        app.getContactHelper().fillFormContact(contact, false);
        app.getContactHelper().initUpdateContact();
        app.getNavigationHelper().goToPageHome();

        List<ContactData> after = app.getContactHelper().getContactList();

        before.remove(before.size() - index);
        before.add(contact);

        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);


    }

    @Test
    public void testContactModificationFromContactPage() {
        int index = 1;

        app.getNavigationHelper().goToPageHome();
        if (! app.getContactHelper().isThereAContact())
        {
            app.getNavigationHelper().goToPageNewContact();
            app.getContactHelper().createContact(new ContactData("testname", "testmiddle", "testlastname", "testaddress", "111-11-11", "test1"), true);
            app.getNavigationHelper().goToPageHome();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().goToViewContact(before.size() - index);
        app.getContactHelper().goToEditContactFromContactPage();
        ContactData contact = new ContactData(before.get(before.size() - index).getId(), "TestName", "TestMiddle", "TestLastname", "TestAddress", "333-33-33", null);
        app.getContactHelper().fillFormContact(contact, false);
        app.getContactHelper().initUpdateContact();
        app.getNavigationHelper().goToPageHome();

        List<ContactData> after = app.getContactHelper().getContactList();

        before.remove(before.size() - index);
        before.add(contact);

        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
