package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeleteTest extends TestBase {

    @Test
    public void testContactDelete() {
        app.getNavigationHelper().goToPageHome();
        if (! app.getContactHelper().isThereAContact())
        {
            app.getNavigationHelper().goToPageNewContact();
            app.getContactHelper().createContact(new ContactData("testname", "testmiddle", "testlastname", "testaddress", "111-11-11", "test1"), true);
            app.getNavigationHelper().goToPageHome();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initDeleteContactFromMainTable();
        app.getContactHelper().acceptDialogContactDelete();
        app.getNavigationHelper().goToPageHome();
    }

    @Test
    public void testContactDeleteFromContactPage() {
        app.getNavigationHelper().goToPageHome();
        if (! app.getContactHelper().isThereAContact())
        {
            app.getNavigationHelper().goToPageNewContact();
            app.getContactHelper().createContact(new ContactData("testname", "testmiddle", "testlastname", "testaddress", "111-11-11", "test1"), true);
            app.getNavigationHelper().goToPageHome();
        }
        app.getContactHelper().goToViewContact();
        app.getContactHelper().goToEditContactFromContactPage();
        app.getContactHelper().initDeleteFromContactPage();
        //TODO: не открылось окно подтвеждения удаления
        app.getNavigationHelper().goToPageHome();

    }

}
