package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification()
    {
        app.getNavigationHelper().goToPageGroups();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillFormGroup(new GroupData("TEST 1", "TEST 1", "TEST1"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToPageGroups();

    }
}
