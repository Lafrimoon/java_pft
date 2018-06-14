package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeleteTest extends TestBase {

    @Test(enabled = false)
    public void testContactDelete() {
        app.goTo().goToPageHome();
        if (! app.getContactHelper().isThereAContact())
        {
            app.goTo().goToPageNewContact();
            app.getContactHelper().createContact(new ContactData("testname", "testmiddle", "testlastname", "testaddress", "111-11-11", "test1"), true);
            app.goTo().goToPageHome();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initDeleteContactFromMainTable();
        app.getContactHelper().acceptDialogContactDelete();
        app.goTo().goToPageHome();
        List<ContactData> after = app.getContactHelper().getContactList();

        before.remove(before.size() - 1);

        Assert.assertEquals(before.size(), after.size());
    }

    @Test(enabled = false)
    public void testContactDeleteFromContactPage() {
        int index = 1;
        app.goTo().goToPageHome();
        if (! app.getContactHelper().isThereAContact())
        {
            app.goTo().goToPageNewContact();
            app.getContactHelper().createContact(new ContactData("testname", "testmiddle", "testlastname", "testaddress", "111-11-11", "test1"), true);
            app.goTo().goToPageHome();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().goToViewContact(before.size() - index);
        app.getContactHelper().goToEditContactFromContactPage();
        app.getContactHelper().initDeleteFromContactPage();
        //TODO: не открылось окно подтвеждения удаления
        app.goTo().goToPageHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        before.remove(before.size() - 1);

        Assert.assertEquals(before.size(), after.size());

    }

}
