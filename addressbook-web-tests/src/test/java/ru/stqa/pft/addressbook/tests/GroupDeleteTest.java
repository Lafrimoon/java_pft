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
        app.goTo().pageGroups();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }

    }

    @Test
    public void testGroupDelete() {
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
//        int before = app.group().getGroupCount();
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before, after);

    }



}
