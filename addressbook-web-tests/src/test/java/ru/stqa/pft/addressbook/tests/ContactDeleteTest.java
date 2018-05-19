package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTest extends TestBase {

    @Test
    public void testContactDelete() {
        app.getContactHelper().selectContact();
        app.getContactHelper().initDeleteContact();
        app.getContactHelper().acceptDialogContactDelete();
        app.getNavigationHelper().goToPageHome();
    }
}
