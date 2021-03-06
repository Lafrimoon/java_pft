package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test(enabled = false)
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().goToPageNewContact();
        ContactData contact = new ContactData("testname", "testmiddle", "testlastname", "testaddress", "111-11-11", "test1");
        app.getContactHelper().createContact(contact, true);
        app.goTo().goToPageHome();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);

        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }


}
