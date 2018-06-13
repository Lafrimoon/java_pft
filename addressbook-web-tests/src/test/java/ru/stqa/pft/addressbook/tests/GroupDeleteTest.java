package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions()
    {
        app.getNavigationHelper().goToPageGroups();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }

    }

    @Test
    public void testGroupDelete() {
        List<GroupData> before = app.getGroupHelper().getGroupList();
//        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToPageGroups();
        List<GroupData> after = app.getGroupHelper().getGroupList();
//        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }

}
