package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeleteTest extends TestBase{
    @Test
    public void testGroupDelete() {
        app.getNavigationHelper().goToPageGroups();
        if (! app.getGroupHelper().isThereAGroup())
        {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToPageGroups();
    }

}
