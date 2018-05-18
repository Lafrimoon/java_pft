package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase{
    @Test
    public void testGroupDelete() {
        app.getNavigationHelper().goToPageGroups();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToPageGroups();
    }

}
