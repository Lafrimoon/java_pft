package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTest extends TestBase {

    //TODO: добавить проверку наличия удаляемых элементов

    @Test
    public void testContactDelete() {
        app.getNavigationHelper().goToPageHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().initDeleteContactFromMainTable();
        app.getContactHelper().acceptDialogContactDelete();
        app.getNavigationHelper().goToPageHome();
    }

    @Test
    public void testContactDeleteFromContactPage() {
        app.getNavigationHelper().goToPageHome();
        app.getContactHelper().goToViewContact();
        app.getContactHelper().goToEditContactFromContactPage();
        app.getContactHelper().initDeleteFromContactPage();
        //TODO: не открылось окно подтвеждения удаления
        app.getNavigationHelper().goToPageHome();

    }

}
